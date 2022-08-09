package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("========= Server Started =========");

        //============================CLIENT 1====================================
        new Thread(() -> {
            String message = "";

            try {
                ServerSocket serverSocket = new ServerSocket(1232);
                Socket accept = serverSocket.accept();
                System.out.println("Client 1 Connected.");
                DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    System.out.println("Client 1 : " + message);
                }

                //alert
                if(message.equals("exit")){
                    System.out.println("Client 1 left the chat");
                    //close connections
                    serverSocket.close();
                    accept.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        //============================CLIENT 2====================================
        new Thread(() -> {
            String message = "";

            try {
                ServerSocket serverSocket = new ServerSocket(1231);
                Socket accept = serverSocket.accept();
                System.out.println("Client 2 Connected.");
                DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    System.out.println("Client 2 : " + message);
                }

                //alert
                if(message.equals("exit")){
                    System.out.println("Client 2 left the chat");
                    //close connections
                    serverSocket.close();
                    accept.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        //============================CLIENT 3====================================
        new Thread(() -> {
            String message = "";

            try {
                ServerSocket serverSocket = new ServerSocket(1230);
                Socket accept = serverSocket.accept();
                System.out.println("Client 3 Connected");
                DataOutputStream dataOutputStream = new DataOutputStream(accept.getOutputStream());
                DataInputStream dataInputStream = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStream.readUTF();
                    System.out.println("Client 3 : " + message);
                }

                //alert
                if(message.equals("exit")){
                    System.out.println("Client 3 left the chat");
                    //close connection
                    serverSocket.close();
                    accept.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
