package main.java;

import java.util.Scanner;

import static main.java.Data.printResults;
import static main.java.Data.readDataFromFile;
import static main.java.InputHelper.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVariables = readValidInput(scanner, "Please enter the integer number of independent variables (must be at least 2): ");

        String filePath = getInputString(scanner, "Please enter the path to the data file: ");
        double[][] values = readDataFromFile(filePath);
        double[] beta = new double[numVariables];

        if (values.length == 0) {
            return;
        }

        int columnsNumber = values[0].length;

        if (columnsNumber != numVariables) {
            System.out.println("The number of columns in the file does not match the specified number of independent variables.");
            return;
        }

        MultipleRegression regression = new MultipleRegression(beta);
        regression.solveEquations(values);

        printResults(filePath, beta);
        scanner.close();
    }
}