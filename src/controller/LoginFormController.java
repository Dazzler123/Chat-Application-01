package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUsername;

    public void btnLogin(ActionEvent actionEvent) throws IOException {
        //load client 1
        if (txtUsername.getText().equals("Dasindu")) {
            //load client ui
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ClientForm.fxml"))));
            stage.setTitle(txtUsername.getText() + " - Group Member");
//        stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        }


        //load client 2
        if (txtUsername.getText().equals("Peter")) {
            //load client ui
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("../view/ClientForm2.fxml"))));
            stage.setTitle(txtUsername.getText() + " - Group Member");
            stage.show();
        }

    }
}
