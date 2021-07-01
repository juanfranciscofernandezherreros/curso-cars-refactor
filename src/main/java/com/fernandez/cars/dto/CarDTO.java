package com.fernandez.cars.dto;

import lombok.Data;

@Data
public class CarDTO {

    private Long id;

    private String name;

    private String marca;

    private String modelo;

    private int totalPlaces;
}
