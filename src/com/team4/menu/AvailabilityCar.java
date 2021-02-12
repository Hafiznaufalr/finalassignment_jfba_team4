package com.team4.menu;

import com.team4.Main;
import com.team4.model.Car;

import java.util.ArrayList;
import java.util.Scanner;

public class AvailabilityCar {
    public static void showCars(ArrayList<Car> cars) {
        if (!cars.isEmpty()) {
            for (int index = 0; index < cars.size(); index++) {
                int num = index + 1;
                System.out.println("|=======================================|");
                System.out.println("|                   " + num + "                   |");
                System.out.println("|=======================================|");
                System.out.println("+ Nama mobil  : " + cars.get(index).getName());
                System.out.println("+ Plat nomor  : " + cars.get(index).getPlatNumber());
                System.out.println("+ Harga rental: " + "Rp. " + cars.get(index).getBookPricePerDay());
                System.out.println("+ Status      : " + cars.get(index).getCarStatus());
            }
        } else {
            System.out.println("Data Masih Kosong");
        }
        afterCondition();
    }

    private static void afterCondition() {
        Scanner input = new Scanner(System.in);
        Main main = new Main();

        System.out.print("Ingin melihat data lagi? (y/n): ");
        if (input.next().equals("y")) {
            main.callAvailabilityCar();
        } else {
            main.backToMainMenu();
        }
    }
}
