package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import util.UINavigation;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUsername;

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        //load client 1
        if (txtUsername.getText().equals("Dazzler")) {
            //load client ui
            UINavigation.loadUI("ClientForm1", "Dazzler");

            //clear text
            txtUsername.clear();
        }

        //load client 2
        if (txtUsername.getText().equals("Peter")) {
            //load client ui
            UINavigation.loadUI("ClientForm2", "Peter");

            //clear text
            txtUsername.clear();
        }

        //load client 3
        if (txtUsername.getText().equals("Marky")) {
            //load client ui
            UINavigation.loadUI("ClientForm3", "Marky");

            //clear text
            txtUsername.clear();
        }

    }
}
