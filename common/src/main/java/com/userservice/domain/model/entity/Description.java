package com.userservice.domain.model.entity;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Description {
    @NotNull
    int contentId;
    @NotEmpty
    String description;
    @NotNull
    @Min(value = 0, message = "最少点赞数不能小于0！")
    String likeNumber;
}
