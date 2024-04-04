package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int getInputInteger(Scanner scanner, String message) {
        boolean isValidInput = false;
        int input = 0;

        while (!isValidInput) {
            try {
                System.out.print(message);
                input = scanner.nextInt();
                if (input < 2) {
                    System.out.println("Please enter an integer number 2 or bigger.");
                } else {
                    isValidInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }

        return input;
    }

    public static String getInputString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next();
    }
}
