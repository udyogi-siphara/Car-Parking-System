package controller;

import db.DriverDatabase;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Driver;

public class AddDriverFormController {
    public TextField txtName;
    public TextField txtNic;
    public TextField txtLicenseNo;
    public TextArea txtAddress;
    public TextField txtConNo;

    public void btnAddDriverOnAction(ActionEvent actionEvent) {
        if(!txtName.getText().equals("") && !txtNic.getText().equals("") && !txtLicenseNo.getText().equals("")&& !txtAddress.getText().equals("") && !txtConNo.getText().equals("")){
            DriverDatabase.driverTable.add(new Driver(txtName.getText(), txtNic.getText(), txtLicenseNo.getText(), txtAddress.getText(), txtConNo.getText()));

            txtName.setText("");
            txtNic.setText("");
            txtLicenseNo.setText("");
            txtAddress.setText("");
            txtConNo.setText("");

            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Now,Driver Added", ButtonType.OK);
            alert.setTitle("Add Driver");
            alert.setHeaderText("Successful");
            alert.show();
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please! Enter All Details", ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Un Successful");
            alert.show();
        }
    }
}
