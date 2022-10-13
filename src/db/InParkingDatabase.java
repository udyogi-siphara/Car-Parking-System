package db;

import model.Parking;

import java.util.ArrayList;

public class InParkingDatabase {
    public static ArrayList<Parking> parkingTable =  new ArrayList<Parking>();

    static {
        parkingTable.add(new Parking("58-3567", "Van", "1", "01/08/2021  05:20"));
        parkingTable.add(new Parking("GF-4358", "Van", "2", "28/10/2021  17:05"));
        parkingTable.add(new Parking("KB-3668", "Lorry", "5", "09/12/2021  13:15"));
    }
}
