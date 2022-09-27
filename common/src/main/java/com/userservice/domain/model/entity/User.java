package com.userservice.domain.model.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
public class User {
    @NotBlank
    String username;
    @NotNull
    int id;

}
