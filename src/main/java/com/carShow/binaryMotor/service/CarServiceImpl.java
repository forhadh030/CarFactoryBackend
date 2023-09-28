package com.carShow.binaryMotor.service;

import com.carShow.binaryMotor.entity.Car;
import com.carShow.binaryMotor.exception.ResourceNotFoundException;
import com.carShow.binaryMotor.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getCars() {
        return (List<Car>) carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

        if(optionalCar.isPresent()) {
            return optionalCar.get();
        } else {
            throw new ResourceNotFoundException("Car with id " + id + " does not exist.");
        }
    }

    @Override
    public Car addCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car updateCar(Long id, Car car) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()) {
            optionalCar.get().setMake(car.getMake());
            optionalCar.get().setModel(car.getModel());
            optionalCar.get().setColor(car.getColor());
            optionalCar.get().setPrice(car.getPrice());
            optionalCar.get().setYear(car.getYear());
            optionalCar.get().setOwner(car.getOwner());
            optionalCar.get().setRegistrationNumber(car.getRegistrationNumber());
            carRepository.save(optionalCar.get());
            return optionalCar.get();
        } else {
            throw new ResourceNotFoundException("The car with id: " + id + " does not exist in the database.");
        }
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);
        if(optionalCar.isPresent()) {
            carRepository.deleteById(id);
            System.out.println("The car with id " + id + " has been deleted successfully");
        } else {
            throw new ResourceNotFoundException("The car with id " + id + " does not exist in the database");
        }
    }
}
