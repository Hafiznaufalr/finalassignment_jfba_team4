package com.team4;

import com.team4.callback.MenuCallback;
import com.team4.menu.AddCar;
import com.team4.menu.AvailabilityCar;
import com.team4.menu.RentalNote;
import com.team4.model.Car;
import com.team4.model.Rental;

import java.util.ArrayList;
import java.util.Scanner;

public class Main implements MenuCallback {
    static ArrayList<Car> cars = new ArrayList<>();
    static ArrayList<Rental> rentals = new ArrayList<>();

    public static void main(String[] args) {
        showMenu();
    }

    private static void showMenu() {
        System.out.println("\n|=======================================|");
        System.out.println("|            Admin Rentalmo             |");
        System.out.println("|=======================================|");
        System.out.println("1. Tambah Mobil");
        System.out.println("2. Ketersediaan Mobil");
        System.out.println("3. Pencatatan Rental");
        System.out.println("4. Keluar");

        Scanner inputMenu = new Scanner(System.in);
        System.out.print("Pilih Menu: ");
        selectedMenu(inputMenu.next());
    }

    private static void selectedMenu(String menu) {
        switch (menu) {
            case "1":
                AddCar.addNewCar(cars);
                break;
            case "2":
                AvailabilityCar.showCars(cars);
                break;
            case "3":
                getRentalMenu("0");
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("Menu tidak ditemukan");
        }
    }

    private static void getRentalMenu(String param) {
        String menu = "0";

        if (param.equals("0")) {
            Scanner input = new Scanner(System.in);

            System.out.println("1. Tambah Pesanan Rental");
            System.out.println("2. Lihat Pesanan Rental");
            System.out.print("Pilih menu: ");
            menu = input.next();
        } else if (param.equals("1")) {
            menu = "1";
        } else menu = "2";

        switch (menu) {
            case "1":
                RentalNote.inputRental(cars, rentals);
                break;
            case "2":
                RentalNote.showListRental(rentals);
                break;
            default:
                System.out.println("Menu tidak ditemukan");
        }
    }

    @Override
    public void backToMainMenu() {
        showMenu();
    }

    @Override
    public void callAddCar() {
        selectedMenu("1");
    }

    @Override
    public void callAvailabilityCar() {
        selectedMenu("2");
    }

    @Override
    public void callInputRental() {
        getRentalMenu("1");
    }

    @Override
    public void callShowRental() {
        getRentalMenu("2");
    }
}
