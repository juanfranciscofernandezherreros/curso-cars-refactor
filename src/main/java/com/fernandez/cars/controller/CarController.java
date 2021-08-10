package com.fernandez.cars.controller;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<List<CarDTO>> findAllCars() {
        log.info("CarsController[findAllCars]");
        return ResponseEntity.ok(carService.findAllCars());
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
