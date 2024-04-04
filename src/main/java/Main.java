package main.java;

import java.util.Scanner;

import static main.java.Data.printResults;
import static main.java.Data.readDataFromFile;
import static main.java.InputHelper.getInputInteger;
import static main.java.InputHelper.getInputString;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVariables = getInputInteger(scanner, "Please, enter the number of independent variables (must be at least 2): ");
        String filePath = getInputString(scanner, "Please, enter the path to the data file: ");
        double[][] values = readDataFromFile(filePath);
        double[] beta = new double[numVariables];

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