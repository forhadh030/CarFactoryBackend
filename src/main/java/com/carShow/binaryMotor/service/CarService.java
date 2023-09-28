package com.carShow.binaryMotor.service;

import com.carShow.binaryMotor.entity.Car;
import java.util.List;

public interface CarService {
    List<Car> getCars();

    Car getCarById(Long id);

    Car addCar(Car car);
    Car updateCar(Long id, Car car);
    void deleteCar(Long id);
}