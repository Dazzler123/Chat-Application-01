package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;

public class ClientFormOneController {
    public AnchorPane anchorPane;
    public AnchorPane emojisPane;
    public Label lblUsername;
    public TextArea txtMsgArea;
    public TextField txtTypeMessage;
    public ImageView sendMessageIcon;

    final int PORT = 1232;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String message = "";


    public void initialize() {

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
        txtMsgArea.appendText("You : " + typedMessage + "\n");

        //clear text
        txtTypeMessage.clear();
    }

    public void emojiIcon(MouseEvent mouseEvent) {
    }

    public void cameraIcon(MouseEvent mouseEvent) throws FileNotFoundException {
//        ImageInput input = dataOutputStream.writeUTF();
//        OutputStream outputStream = socket.getOutputStream();
//        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
//
//        ImageInput input1 = new ImageInput();

        Stage stage = (Stage) anchorPane.getScene().getWindow();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an image to send");
        File imageChoosed = fileChooser.showOpenDialog(stage);

//        FileInputStream inputstream = new FileInputStream(imageChoosed);
//        Image image = new Image(inputstream);

//        ImageIO.write()

//      //Loading image from URL
//        Image image = new Image(new FileInputStream("url for the image));
//
//        String you = "You : ";
//        ImageView imageView = new ImageView(imageChoosed);
//        flow.getChildren().addAll(you, imageChoosed);
    }

    public void btnLogout(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void smileyOne(MouseEvent mouseEvent) {
    }

    public void smileyTwo(MouseEvent mouseEvent) {
    }

    public void smileyThree(MouseEvent mouseEvent) {
    }

    public void smileyFour(MouseEvent mouseEvent) {
    }
}
