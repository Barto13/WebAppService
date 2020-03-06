package com.app.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ProductDto {
    private String name;
    private String description;
    private double price;
    private String expiration;
}
