package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ClientFormController {

    static String username;
    public Label lblUsername;
    public TextArea txtMsgArea;
    public TextField txtTypeMessage;

    public void initialize(){
        lblUsername.setText(username);
    }

    public void btnLogout(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void sendMessageIcon(MouseEvent mouseEvent) {
    }

    public void emojiIcon(MouseEvent mouseEvent) {
    }

    public void cameraIcon(MouseEvent mouseEvent) {
    }
}
