package com.ClassExercise.Datagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6969;
        try (Socket socket= new Socket(host, port)){
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Successfully connected to server. Enter your message and write EXIT when you're done goofing around");
            Scanner sc = new Scanner(System.in);

            String line = null;

            while (!"EXIT".equals(line)){
                line = sc.nextLine();
                output.println(line);
                output.flush();
                System.out.println("Echo from server: " + input.readLine());
            }

    sc.close();
        } catch (IOException ie){
            System.out.println("Server not running. Please ensure server is running.");
            ie.printStackTrace();
        }
    }
}
