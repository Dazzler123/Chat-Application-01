package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ClientFormOneController {
    public Label lblUsername;
    public TextArea txtMsgArea;
    public TextField txtTypeMessage;

    final int PORT = 1232;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String message = "";

    public void initialize(){

        new Thread(() -> {
            try {
                socket = new Socket("localhost", PORT);

                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                //get messages & print
                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    txtMsgArea.appendText(message + "\n");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public void sendMessageIcon(MouseEvent mouseEvent) throws IOException {
        String typedMessage = txtTypeMessage.getText().trim();

        //send message
        dataOutputStream.writeUTF(typedMessage);
        dataOutputStream.flush();

        //show sent message
        txtMsgArea.appendText("You : " + typedMessage+"\n");

        //clear text
        txtTypeMessage.clear();
    }

    public void emojiIcon(MouseEvent mouseEvent) {
    }

    public void cameraIcon(MouseEvent mouseEvent) {
    }

    public void btnLogout(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
}