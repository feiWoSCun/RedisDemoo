package com.userservice.controller;

import com.userservice.domain.model.AjaxResult;
import com.userservice.domain.model.entity.Description;
import com.userservice.domain.service.DescripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
public class descriptionController {
    @Autowired
    private StringRedisTemplate redisTemplate;
   @Autowired
   DescripService descripServiceImpl;
    @RequestMapping("/dolike/{id}")
    public AjaxResult doLike(@RequestParam("id") int id, int userId) {
        String s = descripServiceImpl.addLike(id, userId);
        return AjaxResult.success(s);
    }
    @RequestMapping("/range")
    public AjaxResult rangeLikes(){
        List<Description> range = descripServiceImpl.range();
        return AjaxResult.success("成功",range);
    }
}
