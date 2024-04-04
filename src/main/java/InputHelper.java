package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int readValidInput(Scanner scanner, String message) {
        int input;
        System.out.print(message);
        while (!scanner.hasNextInt() || (input = scanner.nextInt()) < 2) {
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer number.");
                scanner.next();
            } else {
                System.out.println("Please enter an integer number 2 or bigger.");
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
