package com.app.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDto {
    private String username;
    private String password;
    private Integer level;
}
