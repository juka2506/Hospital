package com.company;

import com.company.controllers.HospitalController;
import com.company.dbhelper.DbConnection;

public class Main {

    public static void main(String[] args) {
        //DbConnection.getConnection();
        //HospitalController.addNewDoctor();
        //HospitalController.addNewPatient();
        //HospitalController.addNewDrug();
        //HospitalController.deleteDrug();
        HospitalController.assignDrug();

    }
}
