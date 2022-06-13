package sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.Socket.*;
import java.util.Scanner;

import java.net.ServerSocket.*;


class Client{

    static Socket client2;
    static Scanner scanner;
    static String ip;
    static String message;
    static String command;
    static int port;
    static  BufferedReader in = null;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        EnterIpAndPort();
        CreateSocket();

    }

    static void CreateSocket(){
        try{
            client2 =  new Socket(ip, port);
            MessageFromServer();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    static void EnterIpAndPort(){
        System.out.print("Podaj nr portu: ");
        port = scanner.nextInt();
    }

    static void StatusConnection (){
        if(client2.isConnected()){
            System.out.println("status polaczenia: " + client2.isConnected());
        }
    }

    static void MessageFromServer(){
        System.out.println("Wiadomosc z serwera: ");
        try{
            while(true){
                BufferedReader in = new BufferedReader(new InputStreamReader(client2.getInputStream()));
                PrintWriter out = new PrintWriter(client2.getOutputStream());
                DataOutputStream outData = new DataOutputStream(client2.getOutputStream());
                BufferedReader inServer = new BufferedReader(new InputStreamReader(System.in));

                while(true){
                    while(in.ready()){
                        System.out.println(in.readLine());
                    }
                }

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
