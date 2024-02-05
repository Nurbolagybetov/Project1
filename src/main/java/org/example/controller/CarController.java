package org.example.controller;


import org.example.model.Car;
import org.example.repository.ICarRepository;

import java.util.List;

public class CarController {
    private final ICarRepository repository;


    public CarController(ICarRepository repository) {
        this.repository = repository;
    }

    public String createCar(String carName, Integer year, Integer enginePower, Integer price) {
        Car car = new Car(carName, year, enginePower, price);
        boolean created = repository.createCar(car);
        return (created ? "Car was created!" : "Car creation was failed!");
    }

    public String getCar(Integer id) {
        Car car = repository.getCar(id);

        return (car == null ? "Car was not found!" : car.toString());
    }

    public String getAllCars() {
        List<Car> cars = repository.getAllCars();

        StringBuilder response = new StringBuilder();
        for (Car car: cars) {
            response.append(car.toString()).append("\n");
        }

        return response.toString();
    }

    public void deleteById(Integer id) {
        Car car = repository.deleteById(id);
//        return (car == null ? "Car was not found!" : "Успешно удален");
    }
}
