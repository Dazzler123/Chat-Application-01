package util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//    public static void main(String[] args) {
//        final int PORT = 5000;
//        try {
//            //create server socket
//            ServerSocket serverSocket = new ServerSocket(PORT);
//            System.out.println("Server is running in port : " + PORT);
//
//            //waiting for a client
//            Socket localSocket = serverSocket.accept();
//            System.out.println("Client Accepted");
//
//            DataOutputStream dataOutputStream = new DataOutputStream(localSocket.getOutputStream());
//
//            DataInputStream dataInputStream = new DataInputStream(localSocket.getInputStream());
//
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//
//            String message = "", reply = "";
//
//            while (!message.equals("finish")) {
//                message = dataInputStream.readUTF();
//                System.out.println(message);
//                reply = bufferedReader.readLine();
//                dataOutputStream.writeUTF(reply);
//                dataOutputStream.flush();
//            }
//
//            dataInputStream.close();
//            dataOutputStream.close();
//            bufferedReader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("A new Client has connected");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();
            }

        }catch(IOException e){

        }
    }

    public void closeServerSocket(){
        try{
            if(serverSocket != null) {
                serverSocket.close();
            }
        }catch(IOException e){
          e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        Server server = new Server(serverSocket);
        server.startServer();
    }

}
