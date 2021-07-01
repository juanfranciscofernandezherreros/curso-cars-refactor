package com.fernandez.cars.service;

import com.fernandez.cars.dto.CarDTO;

import java.util.List;

public interface CarService {

    CarDTO createOrUpdateCar(CarDTO carDTO);

    List<CarDTO> findAllCars();

    CarDTO findCarById(Long carId);

    void deleteCarById(Long carId);
}
