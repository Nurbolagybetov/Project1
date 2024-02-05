package org.example;

import org.example.connectionPostgres.IPostgresDB;
import org.example.connectionPostgres.PostgresDB;
import org.example.controller.CarController;
import org.example.repository.CarRepository;
import org.example.repository.ICarRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        IPostgresDB conn = new PostgresDB();
        ICarRepository repository = new CarRepository(conn);
        CarController controller = new CarController(repository);
        Menu menu = new Menu(controller);
        menu.start();
    }
}
