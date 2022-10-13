package controller;

import db.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import model.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


public class ParkingFormController {

    public ComboBox<String> cmbSelectVeh;
    public TextField txtVehiTyp;
    public ComboBox<String> cmbDriver;
    public AnchorPane ParkingContext;
    public Label lblVehiType;
    public Label lblSlotNo;
    public Button btnPark;
    public Button btnDelivery;
    public Label lblDate;
    public Label lblTime;

    public void initialize() {
        ObservableList<String> vNum = FXCollections.observableArrayList();

        for (Vehicle v : VehicleDatabase.vehicleTable) {
            if (v != null) {
                vNum.add(v.getNum());
            }
        }
        cmbSelectVeh.setItems(vNum);

        ObservableList<String> dName = FXCollections.observableArrayList();

        for (Driver d : DriverDatabase.driverTable) {
            dName.add(d.getName());
        }
        cmbDriver.setItems(dName);

        cmbSelectVeh.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            for (Vehicle v : VehicleDatabase.vehicleTable) {
                if (v != null) {
                    if (newValue.equals(v.getNum())) {
                        lblVehiType.setText(v.getType());

                        boolean noPark = true;
                        boolean noDelivery = true;
                        for (Parking p : InParkingDatabase.parkingTable) {
                            if (p.getVehiNo().equals(v.getNum())) {
                                noPark = false;
                                break;
                            }
                        }
                        for (Delivery d : OnDeliveryDatabase.deliveryTable) {
                            if (d.getVehicleNo().equals(v.getNum())) {
                                noDelivery = false;
                                break;
                            }
                        }
                        if (noPark) {
                            searchSlot();
                            btnPark.setDisable(false);
                            btnDelivery.setDisable(true);

                        }
                        if (noDelivery) {
                            lblSlotNo.setText("0");
                            btnPark.setDisable(true);
                            btnDelivery.setDisable(false);

                        }
                    }
                }
            }
        });
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            LocalDate currentDate = LocalDate.now();
            lblTime.setText(currentTime.getHour() + ":" + currentTime.getMinute() + ":" + currentTime.getSecond());
            lblDate.setText(currentDate.getDayOfMonth() + "-" + currentDate.getMonthValue() + "-" + currentDate.getYear());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

    }


    public void btnParkOnAction(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm");
        Date date = new Date();
        if (!cmbSelectVeh.getSelectionModel().isEmpty() && !lblVehiType.getText().equals("")) {

            InParkingDatabase.parkingTable.add(new Parking(cmbSelectVeh.getSelectionModel().getSelectedItem(), lblVehiType.getText(), lblSlotNo.getText(), formatter.format(date)));


            for (Delivery d : OnDeliveryDatabase.deliveryTable) {

                if (d.getVehicleNo().equalsIgnoreCase(cmbSelectVeh.getSelectionModel().getSelectedItem()) && d.getVehicleType().equalsIgnoreCase(lblVehiType.getText())) {
                    OnDeliveryDatabase.deliveryTable.remove(d);
                    break;
                }
            }
            lblSlotNo.setText("");
            lblVehiType.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "You can park now.", ButtonType.OK);
            alert.setTitle("Parking");
            alert.setHeaderText("Successful");
            alert.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle number not selected yet!", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();


        }

    }

    public void btnDeliveryOnAction(ActionEvent actionEvent) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm");
        Date date = new Date();

        if (!cmbDriver.getSelectionModel().isEmpty() && !lblVehiType.getText().equals("") && !cmbSelectVeh.getSelectionModel().isEmpty()) {
            boolean notExists = true;
            for(Delivery d : OnDeliveryDatabase.deliveryTable){
                if(cmbDriver.getSelectionModel().getSelectedItem().equals(d.getDriverName())){
                    notExists = false;
                }
            }
            if(notExists) {
                OnDeliveryDatabase.deliveryTable.add(new Delivery(cmbSelectVeh.getSelectionModel().getSelectedItem(), lblVehiType.getText(), cmbDriver.getSelectionModel().getSelectedItem(), formatter.format(date)));
                for (Parking p : InParkingDatabase.parkingTable) {

                    if (p.getVehiNo().equalsIgnoreCase(cmbSelectVeh.getSelectionModel().getSelectedItem()) && p.getVehiType().equalsIgnoreCase(lblVehiType.getText())) {
                        InParkingDatabase.parkingTable.remove(p);
                        break;
                    }
                }
                lblSlotNo.setText("");
                lblVehiType.setText("");

                Alert alert = new Alert(Alert.AlertType.INFORMATION, "You can leave now.", ButtonType.OK);
                alert.setTitle("Delivery");
                alert.setHeaderText("Successful");
                alert.show();
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR, "He engaged in delivery already!", ButtonType.OK);
                alert.setTitle("Error");
                alert.setHeaderText("Un Successful");
                alert.show();
            }

        }
        if (cmbDriver.getSelectionModel().isEmpty() && cmbSelectVeh.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Anything,Not Selected Yet!", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();
        } else if (cmbDriver.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Driver Not Selected Yet!", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();


        } else if (cmbSelectVeh.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vehicle Number Not Selected Yet!", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();
        }
    }


    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LoginForm.fxml"));
        Parent parent = loader.load();

        LoginFormController controller = loader.getController();
        controller.getContext(ParkingContext);


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Login");
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();


    }

    public void searchSlot() {
        if (lblVehiType.getText().equals("Van")) {
            for (int i = 0; i < Slots.van.length; i++) {
                boolean yes = true;

                for (Parking p : InParkingDatabase.parkingTable) {
                    if (p.getParkSlot().equals(String.valueOf(Slots.van[i]))) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    lblSlotNo.setText(String.valueOf(Slots.van[i]));
                    return;
                }
            }
        } else if (lblVehiType.getText().equals("Lorry")) {
            for (int i = 0; i < Slots.lorry.length; i++) {
                boolean yes = true;

                for (Parking p : InParkingDatabase.parkingTable) {
                    if (p.getParkSlot().equals(String.valueOf(Slots.lorry[i]))) {
                        yes = false;
                        break;
                    }
                }
                if (yes) {
                    lblSlotNo.setText(String.valueOf(Slots.lorry[i]));
                    return;
                }
            }

        } else if (lblVehiType.getText().equals("Bus")) {
            lblSlotNo.setText("14");
        }
    }
}
