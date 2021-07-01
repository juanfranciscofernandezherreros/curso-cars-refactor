package com.fernandez.cars.controller;

import com.fernandez.cars.dto.CarDTO;
import com.fernandez.cars.model.Car;
import com.fernandez.cars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Locale;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sun.plugin2.util.PojoUtil.toJson;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerTest {


    private MockMvc mockMvc;

    @InjectMocks
    private CarController controller;

    @Mock
    private CarService service;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers(new ViewResolver() {
                    @Override
                    public View resolveViewName(String viewName, Locale locale) throws Exception {
                        return new MappingJackson2JsonView();
                    }
                })
                .build();
    }

    @Test
    void getAllCars() throws Exception {
        this.mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andDo(print());
        verify(service,times(1)).findAllCars();
        verifyNoMoreInteractions(service);
    }

    @Test
    void getCarById() throws Exception {
        this.mockMvc.perform(get("/car/1"))
                .andExpect(status().isOk());
        verify(service,times(1)).findCarById(Mockito.any());
        verifyNoMoreInteractions(service);
    }

    @Test
    void deleteCarById() throws Exception {
        this.mockMvc.perform(delete("/car/1"))
                .andExpect(status().isOk());
    }

    @Test
    void createCar() throws Exception {
        CarDTO car = getNewCar();
        this.mockMvc.perform(post("/car")
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(car))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service,times(1)).createOrUpdateCar(car);
        verifyNoMoreInteractions(service);
    }

    @Test
    void updateCar() throws Exception {
        CarDTO car = getCarUpdated(1L);
        this.mockMvc.perform(put("/car")
                .accept(MediaType.APPLICATION_JSON)
                .content(toJson(car))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        verify(service,times(1)).createOrUpdateCar(car);
        verifyNoMoreInteractions(service);
    }

    private CarDTO getNewCar() {
        CarDTO car = new CarDTO();
        car.setName("Name1");
        car.setTotalPlaces(5);
        car.setModelo("Modelo");
        car.setMarca("Marca");
        return car;
    }

    private CarDTO getCarUpdated(Long carId) {
        CarDTO car = new CarDTO();
        car.setId(carId);
        car.setName("Name1");
        car.setTotalPlaces(5);
        car.setModelo("Modelo");
        car.setMarca("Marca");
        return car;
    }

}
