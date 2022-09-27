package com.userservice.controller;

import com.userservice.domain.model.AjaxResult;
import com.userservice.domain.model.entity.Des;
import com.userservice.domain.model.entity.Description;
import com.userservice.domain.service.DescripService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/like")
public class descriptionController {
    @Autowired
    private StringRedisTemplate redisTemplate;
   @Autowired
   DescripService descripServiceImpl;
    @RequestMapping("/dolike/{id}/{userId}")
    public String doLike(@PathVariable("id") int id, @PathVariable("userId") int userId) {
        String s = descripServiceImpl.addLike(id, userId);
        return s;
    }
    @RequestMapping("/range")
    public AjaxResult rangeLikes(){
        Set<String> range = descripServiceImpl.range();
        return AjaxResult.success("成功",range);
    }
    @RequestMapping("/do/{id}")
    public String string(@PathVariable("id") int id){
        return "hello";
    }
}
