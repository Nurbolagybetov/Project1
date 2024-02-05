package org.example.model;

public class Car {
    private Integer id;
    private String carName;
    private Integer year;
    private Integer enginePower;
    private Integer price;

    public Car(String carName, Integer year, Integer enginePower, Integer price) {
        setCarName(carName);
        setYear(year);
        setEnginePower(enginePower);
        setPrice(price);
    }

    public Car(Integer id, String carName, Integer year, Integer enginePower, Integer price) {
        this(carName, year, enginePower, price);
        setId(id);
    }


    public Car() {
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", year=" + year +
                ", enginePower=" + enginePower +
                ", price=" + price +
                '}';
    }
}
