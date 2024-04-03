package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static int getInputInteger(Scanner scanner, String message, int min) {
        while (true) {
            try {
                System.out.print(message);
                int input = scanner.nextInt();
                if (input < min) {
                    System.out.println("Please enter an integer number " + min + " or bigger.");
                    continue;
                }
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // consume invalid input
            }
        }
    }

    public static String getInputString(Scanner scanner, String message) {
        System.out.print(message);
        return scanner.next();
    }
}
