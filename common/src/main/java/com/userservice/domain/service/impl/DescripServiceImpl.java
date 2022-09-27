package com.userservice.domain.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.userservice.domain.constants.DescriptionStatus;
import com.userservice.domain.mapper.DescriptionMapper;
import com.userservice.domain.mapper.UserMapper;
import com.userservice.domain.service.DescripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class DescripServiceImpl extends ServiceImpl implements DescripService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    DescriptionMapper descriptionmapper;
    @Autowired
    UserMapper userMapper;

    /**
     * @param userId,文章对应的id
     * @param userId，假设得到了当前登录的用户Id
     */
    public String addLike(Integer desId, Integer userId) {
        //得到des
        String des= JSON.toJSONString(descriptionmapper.getDesById(desId));
        //设置用户key
        String userKey = "likeDes" + desId;
        //文章的key
        String desKey = "desLike" ;
        //判断用户是否点赞
        Double score = stringRedisTemplate.opsForZSet().score(userKey, userId.toString());
        //文章的点赞数
        Double likes = stringRedisTemplate.opsForZSet().score(desKey, des);
        System.out.println(likes);
        if (score == null) {
            //点赞
            int i = descriptionmapper.addLike(desId);
            //如果添加成功
            if (i >= 1) {
                //添加到redis，用于记录点赞，根据用户时间排序
                stringRedisTemplate.opsForZSet().add(userKey, userId.toString(), System.currentTimeMillis());
                //添加到redis，记录文章的点赞数量
                if(likes==null) {
                    stringRedisTemplate.opsForZSet().add(desKey, des, 1);
                    System.out.println(stringRedisTemplate.opsForZSet().score(desKey, des));
                }
                else
                    stringRedisTemplate.opsForZSet().add(desKey, des,  likes+1);
            }


        } else {
            //如果点赞了就取消点赞
            stringRedisTemplate.opsForZSet().remove(userKey, userId.toString());
            //文章的点赞数减一
            stringRedisTemplate.opsForZSet().add(desKey,des,likes-1);
            descriptionmapper.deleteLike(desId);
        }
        return DescriptionStatus.SUCCESS;
    }

    @Override
    public Set<String> range() {
        Set<String> desLike = stringRedisTemplate.opsForZSet().range("desLike", 0, 10);
        return desLike;
    }
}
