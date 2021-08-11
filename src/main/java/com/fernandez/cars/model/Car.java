package com.fernandez.cars.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String marca;

    @NotNull
    private String modelo;

    @NotNull
    private int totalPlaces;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                totalPlaces == car.totalPlaces &&
                Objects.equals(marca, car.marca) &&
                Objects.equals(modelo, car.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, totalPlaces);
    }

}

