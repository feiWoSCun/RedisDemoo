package com.userservice.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.userservice.domain.model.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper extends BaseMapper {
    User selectUserById(@Param("id") int id);
}
