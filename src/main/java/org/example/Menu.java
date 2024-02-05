package org.example;

import org.example.controller.CarController;
import org.example.model.Car;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private final CarController carController;
    private final Scanner scanner;

    public Menu(CarController carController) {
        this.carController = carController;
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all cars");
            System.out.println("2. Get car by id");
            System.out.println("3. Create car");
            System.out.println("4. Delete car by id");
            System.out.println("0. Exit");
            System.out.println();
            try {
                System.out.print("Enter option (1-4): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllCarsMenu();
                } else if (option == 2) {
                    getCarByIdMenu();
                } else if (option == 3) {
                    createCarMenu();
                } else if (option == 4) {
                    deleteCarMenu();
                }
                else{
                        break;
                    }
                } catch(InputMismatchException e){
                    System.out.println("Input must be integer: " + e);
                    scanner.nextLine(); // to ignore incorrect input
                }
            catch(Exception e){
                    System.out.println(e.getMessage());
                }

                System.out.println("*************************");
            }
        }

        public void getAllCarsMenu () {
            String response = carController.getAllCars();
            System.out.println(response);
        }

        public void getCarByIdMenu () {
            System.out.println("Please enter id");

            Integer id = scanner.nextInt();
            String response = carController.getCar(id);
            System.out.println(response);
        }

        public void createCarMenu () {
            System.out.println("Please enter car name:");
            String carName = scanner.next();
            System.out.println("Please enter year");
            Integer year = scanner.nextInt();
            System.out.println("Please enter engine power:");
            Integer enginePower = scanner.nextInt();

            System.out.println("Please enter price:");
            Integer price = scanner.nextInt();

            String response = carController.createCar(carName, year, enginePower, price);
            System.out.println(response);
        }
        public void deleteCarMenu () {
            System.out.println("Please enter id");

            Integer id = scanner.nextInt();
            carController.deleteById(id);
//            String response = carController.deleteById(id);
//            System.out.println(response);
        }

}
