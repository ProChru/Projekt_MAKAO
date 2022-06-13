package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.Socket.*;
import java.util.Scanner;
import java.net.ServerSocket.*;


class Server {

    static ServerSocket serverSocket;
    static Socket client = null;
    static String command;
    static String message;
    static Scanner scanner;
    static Scanner sendMessage;
    static int port;
    static int ip;
    static boolean isToSend = false;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        sendMessage = new Scanner(System.in);

        //EnterPortAndIp();
        CreateSocket();
        SendToClient();
    }

    static void CreateSocket() {
        try {
            serverSocket = new ServerSocket(port);
            client = serverSocket.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    static void SendToClient() {
        try {
            while (true) {
                PrintWriter out = null;
                out = new PrintWriter(client.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

                String a = in.readLine();
                System.out.println("wiadomosc: " + a);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void EnterPort() {
        scanner = new Scanner(System.in);

        System.out.print("Podaj nr portu: ");
        port = scanner.nextInt();
    }
}

