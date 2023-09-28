package com.carShow.binaryMotor.repository;


import com.carShow.binaryMotor.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
//    Car findCarByMake(String make);
//    List<Car> findCarsByColor(String color);
//    List<Car> findCarsByMakeAndModel(String make, String model);
//
//    List<Car> findCarsByMakeOrderByYearAsc(String make, int year);
}
