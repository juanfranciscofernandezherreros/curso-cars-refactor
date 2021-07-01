package com.fernandez.cars.service;
import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    
    private final CarRepository carRepository;

    private final  ModelMapper modelMapper;

    @Override
    public List<CarDTO> findAllCars() {
        log.info("CarServiceImpl[findAllCars]");
        return carRepository.findAll()
                .stream()
                .map(car -> modelMapper.map(car,CarDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CarDTO findCarById(Long carId) {
        log.info("CarServiceImpl[findCarById]");
        Car carFounded = carRepository.getById(carId);
        CarDTO carDTO = modelMapper.map(carFounded,CarDTO.class);
        return carDTO;
    }

    @Override
    public CarDTO createOrUpdateCar(CarDTO carDTO) {
        log.info("CarServiceImpl[createOrUpdateCar]");
        Car carCreated = carRepository.save(modelMapper.map(carDTO,Car.class));
        return modelMapper.map(carCreated,CarDTO.class);
    }

    @Override
    public void deleteCarById(Long carId) {
        log.info("CarServiceImpl[deleteCarById]");
        carRepository.deleteById(carId);
    }
}
