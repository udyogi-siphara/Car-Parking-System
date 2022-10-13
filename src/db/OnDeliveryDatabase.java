package db;

import model.Delivery;

import java.util.ArrayList;

public class OnDeliveryDatabase {
    public static ArrayList<Delivery> deliveryTable = new ArrayList<Delivery>();

    static {
        deliveryTable.add(new Delivery("LM-6679", "Van", "Sumith Kumara", "05/08/2021  14:22"));
        deliveryTable.add(new Delivery("KA-4563", "Van", "Sumith Dissanayaka", "06/09/2021  15:45"));
        deliveryTable.add(new Delivery("NA-3434", "Bus","Awantha Fernando","12/11/2021  09:10"));
        deliveryTable.add(new Delivery("CCB-3568", "Van", "Sumanasiri Herath", "18/12/2021  07:25"));

    }
}
