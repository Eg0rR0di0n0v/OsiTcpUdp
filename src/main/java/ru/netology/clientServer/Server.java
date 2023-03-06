package ru.netology.clientServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String... args) {

        try (ServerSocket server = new ServerSocket(ServerConfig.PORT)) {
            System.out.println("Сервер запущен");

//             while(true){

            try (Socket client = server.accept();
                 PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {

                while (true) {
                    System.out.println("Подключен клиент " + client.getPort());

                    Scanner scanner = new Scanner(System.in);
                    writer.println("Game Towns");
                    writer.println(scanner.nextLine());

                    writer.println("Hi from server");

                    System.out.println(reader.readLine());
                }
            }
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
