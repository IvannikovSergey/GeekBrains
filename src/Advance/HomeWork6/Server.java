package Advance.HomeWork6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerController server = new ServerController();
        server.start();
        server.catchClient();

        new Thread() {
            public void run() {
                while (true) {
                    String message = null;
                    try {
                        message = server.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (message != null) {
                        try {
                            server.sendMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();


        new Thread() {
            public void run() {
                try {
                    server.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}

class ServerController {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(9999);
        } catch (IOException e) {
            System.out.println("Не могу открыть порт 9999");
            System.exit(1);
        }
        System.out.print("Сервер запустился. Ожидание клиента...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент присоединился");
        } catch (IOException e) {
            System.out.println("Can't accept");
            System.exit(1);
        }

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        System.out.println("Ожидание сообщения...");
    }

    void sendMessage(String msg) throws IOException {
        if (msg.equalsIgnoreCase("exit")) close();
        out.println("Ответ сервера ::: " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}
