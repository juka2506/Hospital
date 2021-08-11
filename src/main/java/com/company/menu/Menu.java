package com.company.menu;

import com.company.controllers.HospitalController;

import java.util.Scanner;

public class Menu {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do now? ");
        System.out.println("1. Add new doctor");
        System.out.println("2. Add new patient");
        System.out.println("3. Add new drug");
        System.out.println("4. Assign drug to the patient");
        System.out.println("5. Set diagnosis");
        System.out.println("6. Delete doctor");
        System.out.println("7. Delete patient");
        System.out.println("8. Delete drug");

        System.out.println("Select an option: ");
        int option = scanner.nextInt();

        switch (option) {
            case 1 -> HospitalController.addNewDoctor();
            case 2 -> HospitalController.addNewPatient();
            case 3 -> HospitalController.addNewDrug();
            case 4 -> HospitalController.assignDrug();
            case 5 -> HospitalController.setDiagnosis();
            case 6 -> HospitalController.deleteDoctor();
            case 7 -> HospitalController.deletePatient();
            case 8 -> HospitalController.deleteDrug();
            default -> System.out.println("Invalid option selected");
        }
    }

}
