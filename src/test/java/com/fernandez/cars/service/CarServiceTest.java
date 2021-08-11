package com.fernandez.cars.service;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.repository.CarRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarServiceImpl carServiceImpl;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        carServiceImpl = new CarServiceImpl(carRepository);
    }

    @Test
    public void getsPagedCar() {
        int pageNumber = 0;
        int pageSize = 1;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Car> travellerPage = new PageImpl<>(Collections.singletonList(getCar(1L,"Marcas","Modelos",5)));
        when(carRepository.findAll(pageable)).thenReturn(travellerPage);
        carRepository.findAll(pageable);
        verify(carRepository,times(1)).findAll(pageable);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    public void findAllCarsWithPagination() {
        Page<Car> page = new PageImpl<Car>(
                IntStream.range(1, 10)
                        .mapToObj(i -> getCar(1L,"Marcas","Modelos",5))
                        .collect(Collectors.toList()));

        when(carRepository.findAll(any(Pageable.class))).thenReturn(page);
    }

    @Test
    public void findCarById() {
        when(carRepository.findById(1L)).thenReturn(getOptionalCar(1L,"Marcas","Modelos",5));
        carServiceImpl.findCarById(1L);
        verify(carRepository,times(1)).findById(1L);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    public void deleteCarById() {
        when(carRepository.findById(1L)).thenReturn(getOptionalCar(1L,"Marcas","Modelos",5));
        carServiceImpl.deleteCarById(1L);
        verify(carRepository,times(1)).deleteById(1L);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    public void createOrUpdateCar() {
        when(carRepository.save(Mockito.any())).thenReturn(getCar(1L,"Marcas","Modelos",5));
        carServiceImpl.createOrUpdateCar(getCarDTO(1L,"Marcas","Modelos",5));
        verify(carRepository,times(1)).save(Mockito.any());
        verifyNoMoreInteractions(carRepository);
    }

    private CarDTO getCarDTO(Long id,String marcas,String modelos,int totalPlaces) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(id);
        carDTO.setMarca(marcas);
        carDTO.setModelo(modelos);
        carDTO.setTotalPlaces(totalPlaces);
        return carDTO;
    }

    private Optional<Car> getOptionalCar(Long id,String marcas, String modelos, int totalPlaces){
        return Optional.of(getCar(id,marcas,modelos,totalPlaces));
    }

    private Car getCar(Long id, String marcas, String modelos, int totalPlaces) {
        Car car = new Car();
        car.setId(id);
        car.setMarca(marcas);
        car.setModelo(modelos);
        car.setTotalPlaces(totalPlaces);
        return car;
    }
}
