package com.company.controllers;

import com.company.dbhelper.DbConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class HospitalController {

    private static Scanner scanner = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewDoctor() {
        System.out.print("Enter the name of the doctor: ");
        String name = scanner.next();

        System.out.print("Enter the type of the doctor: ");
        String type = scanner.next();

        System.out.print("Enter the age of the doctor: ");
        int age = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO doctors(name, type, age)" +
                    " VALUES('" + name + "','" + type + "'," + age + ")");

            ps.execute();
            System.out.println("Successfully added new doctor " + name);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to add new doctor. Try again.");
            return false;
        }
    }

    public static boolean addNewPatient() {
        System.out.print("Enter the name of the patient: ");
        String name = scanner.next();

        System.out.print("Enter the age of the patient: ");
        int age = scanner.nextInt();

        System.out.print("Enter the diagnosis of the patient: ");
        String type = scanner.next();

        System.out.print("Enter the doctor id: ");
        int doctorId = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO patients(name, age, diagnosis, doctor_id)" +
                    " VALUES('" + name + "'," + age + ",'" + type + "'," + doctorId +")");

            ps.execute();
            System.out.println("Successfully added new patient " + name);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to add new patient. Try again.");
            return false;
        }
    }

    public static boolean addNewDrug() {
        System.out.print("Enter the name of the drug: ");
        String name = scanner.nextLine();

        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO drugs(name)" +
                    " VALUES('" + name + "')");

            ps.execute();
            System.out.println("Successfully added new drug " + name);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to add new drug. Try again.");
            return false;
        }
    }

    public static boolean assignDrug() {
        System.out.print("Enter the drug id: ");
        int drugId = scanner.nextInt();

        System.out.print("Enter the patient id: ");
        int patientId = scanner.nextInt();

        System.out.print("Enter the doctor id: ");
        int doctorId = scanner.nextInt();


        try {
            ps = DbConnection.getConnection().prepareStatement("UPDATE drugs" +
                    " SET patient_id = " + patientId + ", doctor_id = " + doctorId +
                    " WHERE id = " + drugId);

            ps.execute();
            ps = DbConnection.getConnection().prepareStatement("UPDATE patients" +
                    " SET drug_id = " + drugId +
                    " WHERE id = " + patientId);
            ps.execute();

            System.out.println("Doctor " + doctorId + " successfully assign drug " + drugId + " to the patient " + patientId);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to assign the drug. Try again.");
            return false;
        }
    }

    public static boolean setDiagnosis() {

        System.out.print("Enter the patient id: ");
        int patientId = scanner.nextInt();

        System.out.print("Enter the diagnosis for the patient " + patientId + ": ");
        String diagnosis = scanner.next();


        try {
            ps = DbConnection.getConnection().prepareStatement("UPDATE patients" +
                    " SET diagnosis = '" + diagnosis +
                    "' WHERE id = " + patientId);

            ps.execute();
            System.out.println("The diagnosis " + diagnosis + " for patient " + patientId + " is set.");
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to set the diagnosis. Try again.");
            return false;
        }
    }

    public static boolean deleteDoctor() {
        System.out.print("Enter the doctor's id: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM doctors " +
                    "WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully deleted doctor " + id);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to delete the doctor " + id + ". Try again.");
            return false;
        }
    }

    public static boolean deletePatient() {
        System.out.print("Enter the patient's id: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM patients " +
                    "WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully deleted patient " + id);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to delete the patient " + id + ". Try again.");
            return false;
        }
    }

    public static boolean deleteDrug() {
        System.out.print("Enter the drug's id: ");
        int id = scanner.nextInt();

        try {
            ps = DbConnection.getConnection().prepareStatement("DELETE FROM drugs " +
                    "WHERE id = " + id);
            ps.execute();
            System.out.println("Successfully deleted drug " + id);
            return true;
        } catch (SQLException e) {
            System.out.println("Failed to delete the drug " + id + ". Try again.");
            return false;
        }
    }

}
