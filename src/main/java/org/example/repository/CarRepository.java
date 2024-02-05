package org.example.repository;

import org.example.connectionPostgres.IPostgresDB;
import org.example.model.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;

public class CarRepository implements ICarRepository {
    private final IPostgresDB db;

    public CarRepository(IPostgresDB db) {
        this.db = db;
    }

    @Override
    public boolean createCar(Car car) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "INSERT INTO cars( carName, year, enginePower, price) VALUES ( ?, ?, ?, ?)";
            PreparedStatement st = con.prepareStatement(sql);

          ;
            st.setString(1, car.getCarName());
            st.setInt(2, car.getYear());
            st.setInt(3, car.getEnginePower());
            st.setInt(4, car.getPrice());

            st.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return false;

    }

    @Override
    public Car getCar(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id, carName, year, enginePower, price FROM cars WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Car(rs.getInt("id"),
                        rs.getString("carName"),
                        rs.getInt("year"),
                        rs.getInt("enginePower"),
                        rs.getInt("price"));
            }
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }

        return null;
    }

    @Override
    public List<Car> getAllCars() {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "SELECT id, carname, year, enginepower, price FROM cars";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                Car car = new Car(rs.getInt("id"),
                        rs.getString("carName"),
                        rs.getInt("year"),
                        rs.getInt("enginePower"),
                        rs.getInt("price"));

                cars.add(car);
            }

            return cars;
        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Car deleteById(Integer id) {
        Connection con = null;

        try {
            con = db.getConnection();
            String sql = "DELETE FROM cars WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);


            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return new Car(rs.getInt("id"),
                        rs.getString("carName"),
                        rs.getInt("year"),
                        rs.getInt("enginePower"),
                        rs.getInt("price"));
            }

        } catch (SQLException e) {
            System.out.println("sql error: " + e.getMessage());
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                System.out.println("sql error: " + e.getMessage());
            }
        }
        return null;
    }
}
