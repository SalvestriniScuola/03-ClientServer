package dev.lieno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("Client started.");

        Socket s = new Socket("127.0.0.1", 3000);
        System.out.println("Connected to server.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        
        Scanner scan = new Scanner(System.in);
        String text;
        do {
            text = scan.next();
            
            if(text == "exit")
                continue;

            out.println(text);
            System.out.println(in.readLine());

        } while(text != "exit");
        
        out.println("!");

        System.out.println("Disconnected!");

    }
}