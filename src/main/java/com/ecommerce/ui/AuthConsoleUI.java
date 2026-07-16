package com.ecommerce.ui;

import java.util.Scanner;

import com.ecommerce.service.UserLogin;
import com.ecommerce.service.UserSignUp;
import com.ecommerce.serviceimpl.ProductServiceImpl;

public class AuthConsoleUI {

    private final Scanner scanner;

    public AuthConsoleUI(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Entry gatekeeper loop. Forces user to log in or register before continuing.
     * @return a valid logged-in customer ID, or -1 if exiting application.
     */
    public int showAuthMenu() {
        while (true) {
            System.out.println("\n--- CUSTOMER PORTAL ---");
            System.out.println("1. Login (Existing Customer)");
            System.out.println("2. Register (New Customer)");
            System.out.println("3. Exit Application");
            System.out.print("Enter your choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    int loginId = handleLogin();
                    if (loginId != -1) return loginId; // Pass verified ID upward
                    break;
                case 2:
                    handleRegistration();
                    break;
                case 3:
                    System.out.println("Exiting Application. Goodbye!");
                    return -1;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private int handleLogin() {
        System.out.println("\n--- CUSTOMER LOGIN ---");
        scanner.nextLine();
        
        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        UserLogin userLogin = new UserLogin();
        boolean auth = userLogin.logIn(email, password);
        
//        int inputId = getIntInput();

        // TODO: Link with your actual UserService / CustomerDAO later:
        // boolean exists = userService.validateUserExists(inputId);
        
        if (auth) {
            System.out.println("✔ Login Successful! Welcome back.");
            ProductServiceImpl productService = new ProductServiceImpl();
            productService.test();
            return 1;
        } else {
            System.out.println("❌ Invalid Customer ID. Please enter a positive number.");
            return -1;
        }
    }

    private void handleRegistration() {
        System.out.println("\n--- NEW CUSTOMER REGISTRATION ---");
        scanner.nextLine(); // Clear the scanner buffer line leftover from getIntInput

        System.out.print("Enter Username: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email Address: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();
        
        System.out.print("Enter Role: ");
        String role = scanner.nextLine();

        // TODO: Call your actual database save logic later:
        // int newId = userService.registerCustomer(name, email, password);
        UserSignUp user = new UserSignUp();
        user.signUp(name, email, password, role);
        
        System.out.println("\n✔ Account Created Successfully!");
//        System.out.println("👉 Your assigned Customer ID is: " + simulatedId);
//        System.out.println("Please use this Customer ID to Log In.");
    }

    private int getIntInput() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid choice. Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        return value;
    }
}