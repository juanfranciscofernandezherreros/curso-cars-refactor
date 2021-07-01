package com.fernandez.cars.service;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.repository.CarRepository;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;

public class CarServiceTest {

    @InjectMocks
    private CarServiceImpl carServiceImpl;

    @Mock
    private CarRepository carRepository;

    @Mock
    private ModelMapper modelMapper;

}
