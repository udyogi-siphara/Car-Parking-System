package controller;

import db.OnDeliveryDatabase;
import db.VehicleDatabase;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import model.*;


public class AddVehicleFormController {
    public TextField txtNumber;
    public TextField txtMax;
    public TextField txtNo;
    public ComboBox<String> cmbType;
    public AnchorPane ParkingContext;
    public Label lblNumber;
    public Label lblMax;
    public Label lblPassenger;


    public void initialize() {
        cmbType.getItems().add("Van");
        cmbType.getItems().add("Bus");
        cmbType.getItems().add("Lorry");
    }


    public void btnAddVehiOnAction(ActionEvent actionEvent) {
        int i = 0;
        for (Vehicle v : VehicleDatabase.vehicleTable) {
            if (v == null) {
                break;
            }
            i++;
        }
        if (!txtNumber.getText().equals("") && !txtMax.getText().equals("") && !txtNo.getText().equals("")) {
            if (cmbType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Van")) {
                int count = 0;
                for (Vehicle v : VehicleDatabase.vehicleTable) {
                    if (v == null) {
                        break;
                    }
                    if(v.getType().equals("Van")){
                        count++;
                    }
                }

                if (count < Slots.van.length) {

                    VehicleDatabase.vehicleTable[i] = new Van(txtNumber.getText(), "Van", Integer.parseInt(txtMax.getText()), Integer.parseInt(txtNo.getText()));
                    OnDeliveryDatabase.deliveryTable.add(new Delivery(txtNumber.getText(), "Van", "Recently Added", "Recently Added"));
                    txtNumber.setText("");
                    txtMax.setText("");
                    txtNo.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Now,Van Added", ButtonType.OK);
                    alert.setTitle("Add Vehicle");
                    alert.setHeaderText("Successful");
                    alert.show();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The van limit has been exceeded!", ButtonType.OK);
                    alert.setTitle("Error");
                    alert.setHeaderText("Un Successfull");
                    alert.show();
                }

            } else if (cmbType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Bus")) {

                int count = 0;
                for (Vehicle v : VehicleDatabase.vehicleTable) {
                    if (v == null) {
                        break;
                    }
                    if(v.getType().equals("Bus")){
                        count++;
                    }
                }

                if (count < Slots.bus.length) {

                    VehicleDatabase.vehicleTable[i] = new Bus(txtNumber.getText(), "Bus", Integer.parseInt(txtMax.getText()), Integer.parseInt(txtNo.getText()));
                    OnDeliveryDatabase.deliveryTable.add(new Delivery(txtNumber.getText(), "Bus", "Recently Added", "Recently Added"));
                    txtNumber.setText("");
                    txtMax.setText("");
                    txtNo.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Now,Bus Added", ButtonType.OK);
                    alert.setTitle("Add Vehicle");
                    alert.setHeaderText("Successful");
                    alert.show();

                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The bus limit has been exceeded!", ButtonType.OK);
                    alert.setTitle("Error");
                    alert.setHeaderText("Un Successfull");
                    alert.show();
                }

            } else if (cmbType.getSelectionModel().getSelectedItem().equalsIgnoreCase("Lorry")) {
                int count = 0;
                for (Vehicle v : VehicleDatabase.vehicleTable) {
                    if (v == null) {
                        break;
                    }
                    if(v.getType().equals("Lorry")){
                        count++;
                    }
                }

                if (count < Slots.lorry.length) {

                    VehicleDatabase.vehicleTable[i] = new Lorry(txtNumber.getText(), "Lorry", Integer.parseInt(txtMax.getText()), Integer.parseInt(txtNo.getText()));
                    OnDeliveryDatabase.deliveryTable.add(new Delivery(txtNumber.getText(), "Lorry", "Recently Added", "Recently Added"));
                    txtNumber.setText("");
                    txtMax.setText("");
                    txtNo.setText("");

                    Alert alert = new Alert(Alert.AlertType.INFORMATION, "Now,Lorry Added ", ButtonType.OK);
                    alert.setTitle("Add Vehicle");
                    alert.setHeaderText("Successful");
                    alert.show();


                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "The lorry limit has been exceeded!", ButtonType.OK);
                    alert.setTitle("Error");
                    alert.setHeaderText("Un Successfull");
                    alert.show();
                }
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please! Enter All Details", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();
        }
    }
}



