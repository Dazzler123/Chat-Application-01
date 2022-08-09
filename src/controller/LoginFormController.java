package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.UINavigation;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUsername;

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        //load client 1
        if (txtUsername.getText().equals("Dazzler")) {
            //load client ui
            UINavigation.loadUI("ClientForm1", txtUsername.getText());

            //clear text
            txtUsername.clear();
        }


        //load client 2
        if (txtUsername.getText().equals("Peter")) {
            //load client ui
            UINavigation.loadUI("ClientForm2", txtUsername.getText());

            //clear text
            txtUsername.clear();
        }

        //load client 3
        if (txtUsername.getText().equals("Marky")) {
            //load client ui
            UINavigation.loadUI("ClientForm3", txtUsername.getText());

            //clear text
            txtUsername.clear();
        }

    }
}
