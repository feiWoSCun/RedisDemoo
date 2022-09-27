package com.userservice.domain.model.entity;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Data
public class Des {
    @NotNull
    int id;
    @NotEmpty
    String description;
}
