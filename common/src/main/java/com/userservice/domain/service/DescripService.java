package com.userservice.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

public interface DescripService extends IService {
    public String addLike(Integer desId, Integer userId);
    //排行榜
    public Set<String> range();
}
