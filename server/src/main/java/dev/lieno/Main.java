package dev.lieno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started.");

        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Listening on 0.0.0.0:" + ss.getLocalPort());

        Socket s = ss.accept();
        System.out.println("Client connected.");

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);


        String text;
        do {
            text = in.readLine();

            if(text != "!") 
                out.println(text.toUpperCase());
        } while(text != "!");
        

        System.out.println("Client disconnected.");
    }
}