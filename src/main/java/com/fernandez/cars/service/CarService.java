package com.fernandez.cars.service;

import com.fernandez.cars.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CarService {

    CarDTO createOrUpdateCar(CarDTO carDTO);

    Page<CarDTO> findAllCars(Pageable pageable);

    CarDTO findCarById(Long carId);

    void deleteCarById(Long carId);
}
