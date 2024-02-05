package org.example.repository;

import org.example.model.Car;

import java.util.List;

public interface ICarRepository {
    boolean createCar(Car car);
    Car getCar(Integer id);
    List<Car> getAllCars();
    Car deleteById(Integer id);

}
