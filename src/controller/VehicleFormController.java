package controller;

import db.InParkingDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Parking;
import view.tm.ParkingTM;

import java.io.IOException;

public class VehicleFormController {

    public ComboBox<String>cmbInParking;
    public TableView<ParkingTM>tblVehicle;
    public TableColumn colNum;
    public TableColumn colType;
    public TableColumn colSlot;
    public TableColumn colTime;
    public AnchorPane ParkingContext;

    public void initialize(){
        ObservableList<String> obList = FXCollections.observableArrayList();
        obList.add("In Parking");
        obList.add("On Delivery");
        cmbInParking.setItems(obList);

        cmbInParking.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals("In Parking")) {
                Stage stage = (Stage) ParkingContext.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/VehicleForm.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.centerOnScreen();
            }else if(newValue.equals("On Delivery")){
                Stage stage = (Stage) ParkingContext.getScene().getWindow();
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/DriverForm.fxml"))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stage.centerOnScreen();
            }
        });
        colNum.setCellValueFactory(new PropertyValueFactory("vehiNo"));
        colType.setCellValueFactory(new PropertyValueFactory("vehiType"));
        colSlot.setCellValueFactory(new PropertyValueFactory("parkSlot"));
        colTime.setCellValueFactory(new PropertyValueFactory("parkTime"));


        loadAllVehicle();
    }

    private void loadAllVehicle() {
        ObservableList<ParkingTM> obList = FXCollections.observableArrayList();

        for ( Parking p : InParkingDatabase.parkingTable){

            ParkingTM tm = new ParkingTM(p.getVehiNo(),p.getVehiType(),p.getParkSlot(),p.getParkTime());
            obList.add(tm);
        }
        tblVehicle.setItems(obList);
    }

    public void btnAddVehiOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddVehicleForm.fxml"));
        Parent parent = loader.load();


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add Vehicle");
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();
    }

    public void btnAddDriverOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/AddDriverForm.fxml"));
        Parent parent = loader.load();


        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Add Driver");
        stage.setScene(new Scene(parent));
        stage.show();
        stage.centerOnScreen();
    }

    public void btnLogoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ParkingContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/ParkingForm.fxml"))));
        stage.centerOnScreen();
    }
}
