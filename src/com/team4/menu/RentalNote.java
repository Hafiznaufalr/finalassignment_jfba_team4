package com.team4.menu;

import com.team4.Main;
import com.team4.model.Car;
import com.team4.model.CarStatus;
import com.team4.model.Rental;
import com.team4.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RentalNote {
    public static void inputRental(ArrayList<Car> cars, ArrayList<Rental> rentals) {
        final long DAY_IN_MILLIS = 1000 * 60 * 60 * 24;

        Rental rental = new Rental();
        Car car = new Car();

        List<Car> filteredCars = cars
                .stream()
                .filter(car1 -> car1.getCarStatus() != CarStatus.BOOKED)
                .collect(Collectors.toList());


        for (int index = 0; index < filteredCars.size(); index++) {
            int num = index + 1;
            System.out.println("|=======================================|");
            System.out.println("|                   " + num + "                   |");
            System.out.println("|=======================================|");
            System.out.println("+ Nama mobil   : " + cars.get(index).getName());
            System.out.println("+ Plat nomor   : " + cars.get(index).getPlatNumber());
            System.out.println("+ Harga rental : " + "Rp. " + cars.get(index).getBookPricePerDay());
            System.out.println("+ Status       : " + cars.get(index).getCarStatus());
        }

        try {
            if (!filteredCars.isEmpty()) {
                System.out.println("\n|=======================================|");
                System.out.println("|            Tambah Rental              |");
                System.out.println("|=======================================|");

                System.out.print("Pilih Mobil (nomor): ");
                Scanner numberCarScanner = new Scanner(System.in);
                int numberCar = numberCarScanner.nextInt();

                System.out.print("Tanggal Rental: ");
                Scanner startDateRentalScanner = new Scanner(System.in);
                String rawStartDate = startDateRentalScanner.next();

                System.out.print("Tanggal Pengembalian: ");
                Scanner endDateRentalScanner = new Scanner(System.in);
                String rawEndDate = endDateRentalScanner.next();

                int diffInDays = (int) ((Objects.requireNonNull(Utils.getDate(rawEndDate)).getTime() - Objects.requireNonNull(Utils.getDate(rawStartDate)).getTime()) / DAY_IN_MILLIS);

                if (numberCar < 1 || numberCar > filteredCars.size()) {
                    System.out.println("Mobil tidak tersedia");
                    afterInputRentalCondition();
                    return;
                }

                if (diffInDays == 0) {
                    System.out.println("Hari tidak boleh sama");
                } else if (diffInDays < 0) {
                    System.out.println("Tanggal rental tidak boleh lebih besar dari tanggal pengembalian");
                } else {
                    car = filteredCars.get(numberCar -= 1);
                    car.setCarStatus(CarStatus.BOOKED);
                    rental.setRentalCar(car);

                    rental.setStartRentalDate(Utils.formatDate(rawStartDate));
                    rental.setEndRentalDate(Utils.formatDate(rawEndDate));
                    rental.setTotal(car.getBookPricePerDay() * diffInDays);

                    System.out.printf("Total Bayar Rp. %d", car.getBookPricePerDay() * diffInDays);
                    System.out.println();

                    rentals.add(rental);
                }
                afterInputRentalCondition();

            } else {
                System.out.println("Data mobil tidak tersedia");
                dataNotFoundCondition();
            }
        } catch (Exception ex) {
            System.out.println("\nInvalid date!\n");
            afterInputRentalCondition();
        }


    }

    private static void dataNotFoundCondition() {
        Main main = new Main();
        main.backToMainMenu();
    }

    private static void afterInputRentalCondition() {
        Scanner input = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Ingin input data lagi? (y/n): ");
        if (input.next().equals("y")) {
            main.callInputRental();
        } else {
            main.backToMainMenu();
        }
    }

    public static void showListRental(ArrayList<Rental> rentals) {
        if (!rentals.isEmpty()) {
            for (int index = 0; index < rentals.size(); index++) {
                int num = index + 1;
                System.out.println("|=======================================|");
                System.out.println("|                   " + num + "                   |");
                System.out.println("|=======================================|");
                System.out.println("+ Nama mobil           : " + rentals.get(index).getRentalCar().getName());
                System.out.println("+ Plat nomor           : " + rentals.get(index).getRentalCar().getPlatNumber());
                System.out.println("+ Harga rental         : " + "Rp. " +rentals.get(index).getRentalCar().getBookPricePerDay());
                System.out.println("+ Status               : " + rentals.get(index).getRentalCar().getCarStatus());
                System.out.println("+ Tanggal Rental       : " + rentals.get(index).getStartRentalDate());
                System.out.println("+ Tanggal Pengembalian : " + rentals.get(index).getEndRentalDate());
                System.out.println("+ Total biaya rental   : " + "Rp. " +rentals.get(index).getTotal());
            }
        } else {
            System.out.println("Data belum ada");
        }
        afterShowListRental();
    }

    private static void afterShowListRental() {
        Scanner input = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Ingin lihat data lagi? (y/n): ");
        if (input.next().equals("y")) {
            main.callShowRental();
        } else {
            main.backToMainMenu();
        }
    }
}
