package com.fernandez.cars.dto;

import com.fernandez.cars.validation.ValidStr;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
public class CarDTO {

    private Long id;

    @NotBlank
    @ValidStr
    private String marca;

    @NotBlank
    private String modelo;

    private int totalPlaces;
}
