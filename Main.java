/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.main;

/**
 *
 * @author Zaida
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login loginSystem = new Login();

        System.out.println("=== Registration ===");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell number: ");
        String cellnumber = scanner.nextLine();

        boolean registered = loginSystem.register(username, password, cellnumber);
        if (!registered) {
            System.out.println("Registration failed.");
            return;
        }

        System.out.println("\n=== Login ===");
        System.out.print("Enter username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String loginPassword = scanner.nextLine();

        if (loginSystem.login(loginUsername, loginPassword)) {
            System.out.println("Login successful!");
            System.out.println("Welcome, " + loginUsername + "!");

            // === Send and Store a Message ===
            System.out.println("\n=== Send a Message ===");
            System.out.print("Enter recipient cell number: ");
            String recipient = scanner.nextLine();

            System.out.print("Enter message content: ");
            String content = scanner.nextLine();

            Message msg = new Message(recipient, content);

            if (!msg.checkRecipientCell()) {
                System.out.println("Invalid recipient cell number.");
            } else {
                msg.storeMessage();
                System.out.println("Message sent and stored successfully!");
            }

            // === Show All Stored Messages ===
            System.out.println("\n=== All Messages ===");
            System.out.println(Message.toJSON());

        } else {
            System.out.println("Login failed.");
        }

        scanner.close();
    }
}


    
