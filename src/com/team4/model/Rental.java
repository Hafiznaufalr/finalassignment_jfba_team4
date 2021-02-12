package com.team4.model;

import java.util.Date;

public class Rental {
    private String startRentalDate;
    private String endRentalDate;
    private Car rentalCar;
    private int totalRental;

    // Getter
    public String getStartRentalDate() {
        return startRentalDate;
    }
    public String getEndRentalDate() {
        return endRentalDate;
    }
    public Car getRentalCar() {
        return rentalCar;
    }
    public int getTotal() {
        return totalRental;
    }

    // Setter
    public void setStartRentalDate(String startRentalDate) {
        this.startRentalDate = startRentalDate;
    }
    public void setEndRentalDate(String endRentalDate) {
        this.endRentalDate = endRentalDate;
    }
    public void setRentalCar(Car rentalCar) {
        this.rentalCar = rentalCar;
    }
    public void setTotal(int total) {
        this.totalRental = total;
    }

}
