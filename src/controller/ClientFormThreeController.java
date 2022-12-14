package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class ClientFormThreeController {
    public AnchorPane anchorPane;
    public AnchorPane emojisPane;
    public TextArea txtMsgArea;
    public TextField txtTypeMessage;
    public ImageView sendMessageIcon;
    public Label lblUsername;

    final int PORT = 1230;
    public static JFXButton logout;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String message = "";

    public void initialize() {
        //disable emoji tray at startup
        emojisPane.setVisible(false);

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
        //open emoji tray
        emojisPane.setVisible(true);
    }

    public void smileyOne(MouseEvent mouseEvent) {
        txtTypeMessage.appendText("\uD83D\uDE42");
    }

    public void smileyTwo(MouseEvent mouseEvent) {
        txtTypeMessage.appendText("\uD83D\uDE03");
    }

    public void smileyThree(MouseEvent mouseEvent) {
        txtTypeMessage.appendText("\uD83D\uDE05");
    }

    public void smileyFour(MouseEvent mouseEvent) {
        txtTypeMessage.appendText("\uD83D\uDE04");
    }

    public void cameraIcon(MouseEvent mouseEvent) {
//        ImageInput input = dataOutputStream.writeUTF();
//        OutputStream outputStream = socket.getOutputStream();
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
//
//        ImageInput input1 = new ImageInput();

        Stage stage = (Stage) anchorPane.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an image to send");
        File imageChoosed = fileChooser.showOpenDialog(stage);


//        String you = "You : ";
//        ImageView imageView = new ImageView(imageChoosed);
//        flow.getChildren().addAll(you, imageChoosed);
    }

    public void btnLogout(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

}
