package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int readValidInput(Scanner scanner, String message) {
        int input;
        System.out.print(message);
        while (true) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer number.");
                scanner.nextLine();
            } else if ((input = scanner.nextInt()) < 2) {
                System.out.println("Please enter an integer number 2 or bigger.");
            } else {
                break; // Valid input received, exit the loop
            }
            System.out.print(message);
        }
        return input;
    }



    public static String getInputString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next();
    }
}
