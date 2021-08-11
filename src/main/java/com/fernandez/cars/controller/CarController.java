package com.fernandez.cars.controller;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Controller
@RestController
@Slf4j
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/car")
    public ResponseEntity<CarDTO> saveCar(@Valid @RequestBody CarDTO carDTO) {
        log.info("CarsController[saveCard]");
        return ResponseEntity.ok(carService.createOrUpdateCar(carDTO));
    }

    @PutMapping("/car")
    public ResponseEntity<CarDTO> updateCar(@RequestBody CarDTO carDTO) {
        log.info("CarsController[updateCar]");
        return ResponseEntity.ok(carService.createOrUpdateCar(carDTO));
    }

    @GetMapping("/cars")
    public ResponseEntity<Page<CarDTO>> findAllCars(Pageable pageable) {
        log.info("CarsController[findAllCars]");
        return ResponseEntity.ok(carService.findAllCars(pageable));
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<CarDTO> findCarById(@PathVariable("carId") Long carId) {
        log.info("CarsController[findCarById]");
        return ResponseEntity.ok(carService.findCarById(carId));
    }

    @DeleteMapping("/car/{carId}")
    public void deleteCarById(@PathVariable("carId") Long carId) {
        log.info("CarsController[deleteCarById]");
        carService.deleteCarById(carId);
    }    
    
}
