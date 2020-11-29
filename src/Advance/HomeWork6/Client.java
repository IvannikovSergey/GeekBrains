package Advance.HomeWork6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        ClientController client = new ClientController();
        System.out.println("Клиент стартовал. Подключение к localhost: 9999");

        new Thread() {
            public void run() {
                try {
                    client.readMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    client.sendMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class ClientController {
    Socket socket = null;
    BufferedReader in = null;
    PrintWriter out= null;
    BufferedReader console = null;
    String userMSG, serverMSG;

    public ClientController() throws IOException {
        socket = new Socket("localhost",9999);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMSG() throws IOException {
        while (true) {
            if ((userMSG = console.readLine()) != null) {
                out.println(userMSG);
                if (userMSG.equalsIgnoreCase("exit")) break;
            }
        }
    }

    void readMSG() throws IOException {
        while (true) {
            if ((serverMSG = in.readLine()) != null){
                System.out.println(serverMSG);
            }
        }
    }
}
