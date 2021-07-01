package com.fernandez.cars.service;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {

    @InjectMocks
    private CarServiceImpl carServiceImpl;

    @Mock
    private CarRepository carRepository;

    @Mock
    private ModelMapper modelMapper;

    @Test
    public void findAllCar() {
        when(carRepository.findAll()).thenReturn(getListCar());
        carServiceImpl.findAllCars();
        verify(carRepository,times(1)).findAll();
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    public void findCarById() {
        when(carRepository.getById(1L)).thenReturn(getCar(1L,"Marcas","Modelos",5));
        carServiceImpl.findCarById(1L);
        verify(carRepository,times(1)).getById(1L);
        verifyNoMoreInteractions(carRepository);
    }

    @Test
    public void deleteCarById() {
        doNothing().when(carRepository).deleteById(Mockito.any());
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

    private List<Car> getListCar(){
        List<Car> carList = new ArrayList<>();
        carList.add(getCar(1L,"Marcas","Modelos",5));
        return  carList;
    }

    private CarDTO getCarDTO(Long id,String marcas,String modelos,int totalPlaces) {
        CarDTO carDTO = new CarDTO();
        carDTO.setId(id);
        carDTO.setMarca(marcas);
        carDTO.setModelo(modelos);
        carDTO.setTotalPlaces(totalPlaces);
        return carDTO;
    }

    private Car getCar(Long id,String marcas,String modelos,int totalPlaces) {
        Car car = new Car();
        car.setId(id);
        car.setMarca(marcas);
        car.setModelo(modelos);
        car.setTotalPlaces(totalPlaces);
        return car;
    }
}
