package db;

import model.Manager;

import java.util.ArrayList;

public class ManagerDatabase {
    public static ArrayList<Manager> managerTable = new ArrayList<Manager>();

    static {
        managerTable.add(new Manager("usra","123"));
    }
}
