package com.userservice.domain.mapper;

import com.userservice.domain.model.entity.Des;
import com.userservice.domain.model.entity.Description;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DescriptionMapper {
    int addLike(@Param("desId") int desId);
    int deleteLike (@Param("desId") int desId);
    int getLikesById(@Param("id") int id);

  Des getDesById(@Param("id") int id) ;
}
