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

public class ClientFormController {

    static String username;
    public Label lblUsername;
    public TextArea txtMsgArea;
    public TextField txtTypeMessage;

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String usrname;

//    final int PORT = 5000;
//    Socket socket;
//    DataInputStream dataInputStream;
//    DataOutputStream dataOutputStream;

//    String message = "";

    public ClientFormController(Socket socket, String usrname){
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.usrname = usrname;
        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void initialize(){
        //set username
        lblUsername.setText(username);

//        new Thread(() -> {
//            try {
//                socket = new Socket("localhost", PORT);
//
//                dataOutputStream = new DataOutputStream(socket.getOutputStream());
//                dataInputStream = new DataInputStream(socket.getInputStream());
//
//                while (!message.equals("exit")) {
//                    message = dataInputStream.readUTF();
//                    txtMsgArea.appendText("\nServer : " + message);
//                }
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }).start();

    }

    public void btnLogout(ActionEvent actionEvent) {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }

    public void sendMessageIcon(MouseEvent mouseEvent) throws IOException {
//        dataOutputStream.writeUTF(txtTypeMessage.getText().trim());
//        dataOutputStream.flush();
        try {
            bufferedWriter.write(usrname);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            while (socket.isConnected()){
                String typedMessage = txtTypeMessage.getText().trim();
                bufferedWriter.write(username + ": " + typedMessage);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void emojiIcon(MouseEvent mouseEvent) {
    }

    public void cameraIcon(MouseEvent mouseEvent) {
    }
}
