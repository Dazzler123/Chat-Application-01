package util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static DataOutputStream dataOutputStreamOne;
    static DataInputStream dataInputStreamOne;

    static DataOutputStream dataOutputStreamTwo;
    static DataInputStream dataInputStreamTwo;

    static DataOutputStream dataOutputStreamThree;
    static DataInputStream dataInputStreamThree;


    private static void closeConnection(DataOutputStream outputStream, DataInputStream inputStream, Socket socket, ServerSocket serverSocket) throws IOException {
        //close streams
        outputStream.close();
        inputStream.close();

        socket.close();
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("========= Server Started =========");

        //============================CLIENT 1====================================
        new Thread(() -> {
            String message = "";

            try {
                ServerSocket serverSocket = new ServerSocket(1232);
                Socket accept = serverSocket.accept();
                System.out.println("Client 1 Connected.");
                dataOutputStreamOne = new DataOutputStream(accept.getOutputStream());
                dataInputStreamOne = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStreamOne.readUTF();
                    System.out.println("Client 1 : " + message);

                    //send message to other clients
                    dataOutputStreamTwo.writeUTF("Dazzler : " + message);
                    dataOutputStreamThree.writeUTF("Dazzler : " + message);
                }

                //alert
                if (message.equals("exit")) {
                    System.out.println("Client 1 left the chat");

                    //notify other clients
                    dataOutputStreamTwo.writeUTF("Dazzler left the chat");
                    dataOutputStreamThree.writeUTF("Dazzler left the chat");

                    //close connections
//                    closeConnection(dataOutputStreamOne, dataInputStreamOne, accept, serverSocket);
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
                dataOutputStreamTwo = new DataOutputStream(accept.getOutputStream());
                dataInputStreamTwo = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStreamTwo.readUTF();
                    System.out.println("Client 2 : " + message);

                    //send message to other clients
                    dataOutputStreamOne.writeUTF("Peter : " + message);
                    dataOutputStreamThree.writeUTF("Peter : " + message);
                }

                //alert
                if (message.equals("exit")) {
                    System.out.println("Client 2 left the chat");

                    //notify other clients
                    dataOutputStreamOne.writeUTF("Peter left the chat");
                    dataOutputStreamThree.writeUTF("Peter left the chat");

                    //close connections
//                    closeConnection(dataOutputStreamTwo, dataInputStreamTwo, accept, serverSocket);
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
                System.out.println("Client 3 Connected.");
                dataOutputStreamThree = new DataOutputStream(accept.getOutputStream());
                dataInputStreamThree = new DataInputStream(accept.getInputStream());

                //read message & print
                while (!message.equals("exit")) {
                    message = dataInputStreamThree.readUTF();
                    System.out.println("Client 3 : " + message);

                    //send message to other clients
                    dataOutputStreamOne.writeUTF("Marky : " + message);
                    dataOutputStreamTwo.writeUTF("Marky : " + message);
                }

                //alert
                if (message.equals("exit")) {
                    System.out.println("Client 3 left the chat");

                    //notify other clients
                    dataOutputStreamOne.writeUTF("Marky left the chat");
                    dataOutputStreamTwo.writeUTF("Marky left the chat");

                    //close connection
//                    closeConnection(dataOutputStreamThree, dataInputStreamThree, accept, serverSocket);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
