package com.fernandez.cars.service;
import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.exception.EntityNotFoundException;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.repository.CarRepository;
import com.fernandez.cars.utils.ObjectMapperUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    
    private final CarRepository carRepository;

    @Override
    public List<CarDTO> findAllCars() {
        log.info("CarServiceImpl[findAllCars]");
        return ObjectMapperUtils.mapAll(carRepository.findAll(), CarDTO.class);
    }

    @Override
    public CarDTO findCarById(Long carId) {
        log.info("CarServiceImpl[findCarById]", carId);
        Optional<Car> car = carRepository.findById(carId);
        if(!Optional.empty().isPresent()){
            throw new EntityNotFoundException(Car.class, "id", carId.toString());
        }
        return ObjectMapperUtils.map(car,CarDTO.class);
    }

    @Override
    public CarDTO createOrUpdateCar(CarDTO carDTO) {
        log.info("CarServiceImpl[createOrUpdateCar]" , carDTO);
        return ObjectMapperUtils.map(carRepository.save(ObjectMapperUtils.map(carDTO,Car.class)),CarDTO.class);
    }

    @Override
    public void deleteCarById(Long carId) {
        log.info("CarServiceImpl[deleteCarById]", carId);
        Optional<Car> car = carRepository.findById(carId);
        if(!Optional.empty().isPresent()){
            throw new EntityNotFoundException(Car.class, "id", carId.toString());
        }
        carRepository.deleteById(carId);
    }
}
