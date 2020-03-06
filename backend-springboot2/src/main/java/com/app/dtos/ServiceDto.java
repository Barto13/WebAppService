package com.app.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ServiceDto {
    private String servicename;
    private String clientname;
    private String clientsurname;
    private String address;
    private String city;
    private int telephone;
    private String status;
}
