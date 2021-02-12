package com.team4.menu;

import com.team4.Main;
import com.team4.model.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class AddCar {
    public static void addNewCar(ArrayList<Car> cars) {
        try {
            Car car = new Car();

            System.out.println("\n|=======================================|");
            System.out.println("|            Tambah Mobil               |");
            System.out.println("|=======================================|");

            System.out.print("Nama Mobil: ");
            Scanner carNameScanner = new Scanner(System.in);
            String carName = carNameScanner.next();

            System.out.print("Plat Mobil: ");
            Scanner platNumberCarScanner = new Scanner(System.in);
            String platNumberCar = platNumberCarScanner.next();

            System.out.print("harga rental per hari: ");
            Scanner rentalPricePerDayScanner = new Scanner(System.in);
            int rentalPricePerDay = rentalPricePerDayScanner.nextInt();

            car.setName(carName);
            car.setPlatNumber(platNumberCar);
            car.setBookPricePerDay(rentalPricePerDay);

            cars.add(car);

            System.out.println("Input berhasil");
            afterCondition();
        } catch (Exception ex) {
            System.out.println("Harga harus bertipe angka");
            afterCondition();
        }
    }

    private static void afterCondition() {
        Scanner input = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Ingin input lagi? (y/n): ");
        if (input.next().equals("y")) {
            main.callAddCar();
        } else {
            main.backToMainMenu();
        }
    }
}
