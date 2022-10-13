package db;

import model.Bus;
import model.Lorry;
import model.Van;
import model.Vehicle;

public class VehicleDatabase {
    public static Vehicle[] vehicleTable = new Vehicle[14];

    static {
        vehicleTable[0]=new Van("KA-4563", "Van", 1000, 7);
        vehicleTable[1]=new Van("58-3567", "Van", 1500, 4);
        vehicleTable[2]=new Bus("NA-3434", "Bus",3500,60);
        vehicleTable[3]=new Van("GF-4358", "Van", 800, 4);
        vehicleTable[4]=new Van("CCB-3568", "Van", 1800, 8);
        vehicleTable[5]=new Van("LM-6679", "Van", 1500, 4);
        vehicleTable[6]=new Lorry("KB-3668", "Lorry", 2500, 2);

    }

}
