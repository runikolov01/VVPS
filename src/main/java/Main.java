package main.java;

import java.util.InputMismatchException;
import java.util.Scanner;

import static main.java.Data.printResults;
import static main.java.Data.readDataFromFile;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please, enter the number of independent variables (must be at least 2): ");
        while (true) {
            try {
                while (!scanner.hasNextInt()) {
                    System.out.println("You should write an integer number. Please, try again!");
                    System.out.print("Please, enter the integer number of independent variables (must be at least 2): ");
                    scanner.next(); // Consume the non-integer input
                }
                int numVariables = scanner.nextInt();
                while (numVariables < 2) {
                    System.out.print("Please, enter an integer number 2 or bigger: ");
                    numVariables = scanner.nextInt();
                }

                System.out.print("Please, enter the path to the data file: ");
                String filePath = scanner.next();

                // Perform additional validation for filePath if needed

                double[][] values = readDataFromFile(filePath, numVariables);

                double[] beta = new double[numVariables];
                MultipleRegression regression = new MultipleRegression(beta);

                regression.solveEquations(values);

                printResults(filePath, beta);
                break; // Exit loop if everything is successful
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid data.");
                System.out.print("Please, enter an integer number 2 or bigger: ");
                scanner.nextLine(); // Consume the invalid input
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("The number of columns in the file does not match the specified number of independent variables.");
                System.out.print("Please, enter the integer number of independent variables (must be at least 2): ");
            }
        }
        scanner.close();
    }
}