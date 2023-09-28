package com.carShow.binaryMotor.web;

import com.carShow.binaryMotor.entity.Car;
import com.carShow.binaryMotor.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.OK);
    }

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        return new ResponseEntity<>(carService.addCar(car), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        Car updateCar = carService.updateCar(id, car);
        return new ResponseEntity<>(updateCar, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}