package com.team4.model;


public class Car {
    private String name;
    private String platNumber;
    private int bookPricePerDay;
    private CarStatus carStatus = CarStatus.AVAILABLE;

    // Getter
    public String getName() {
        return name;
    }
    public String getPlatNumber() {
        return platNumber;
    }
    public int getBookPricePerDay() {
        return bookPricePerDay;
    }
    public CarStatus getCarStatus() {
        return carStatus;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
    public void setPlatNumber(String platNumber) {
        this.platNumber = platNumber;
    }
    public void setBookPricePerDay(int bookPricePerDay) {
        this.bookPricePerDay = bookPricePerDay;
    }
    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

}
