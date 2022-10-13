package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import db.ManagerDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Manager;
import static javafx.scene.paint.Color.RED;


import java.io.IOException;

public class LoginFormController {

    public JFXTextField txtUserName;
    public JFXPasswordField pwdPassword;
    public AnchorPane ParkingContext;
    public AnchorPane tempParkingContext;

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) txtUserName.getScene().getWindow();
        stage.close();

    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        boolean bool = true;

        for (Manager data : ManagerDatabase.managerTable) {
            if (data.getUserName().equals(txtUserName.getText()) && data.getPassword().equals(pwdPassword.getText())) {
                bool = false;
                Stage stage = (Stage) tempParkingContext.getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/VehicleForm.fxml"))));
                stage.centerOnScreen();

                Stage stage1 = (Stage) txtUserName.getScene().getWindow();
                stage1.close();
            }
        }
        if (bool) {

            txtUserName.setUnFocusColor(RED);
            pwdPassword.setUnFocusColor(RED);

            txtUserName.setFocusColor(RED);
            pwdPassword.setFocusColor(RED);
        }
    }

    public void getContext(AnchorPane anchorPane) {
        tempParkingContext = anchorPane;
    }
}
