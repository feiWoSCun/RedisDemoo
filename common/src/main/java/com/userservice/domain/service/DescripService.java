package com.userservice.domain.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.userservice.domain.model.entity.Description;

import java.util.List;

public interface DescripService extends IService {
    public String addLike(Integer desId, Integer userId);
    //排行榜
    public List<Description> range();
}
