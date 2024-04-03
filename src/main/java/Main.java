package main.java;

import java.util.Scanner;

import static main.java.Data.printResults;
import static main.java.Data.readDataFromFile;
import static main.java.InputHelper.getInputInteger;
import static main.java.InputHelper.getInputString;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numVariables = getInputInteger(scanner, "Please, enter the number of independent variables (must be at least 2): ", 2);
        String filePath = getInputString(scanner, "Please, enter the path to the data file: ");

        try {
            double[][] values = readDataFromFile(filePath, numVariables);
            double[] beta = new double[numVariables];
            MultipleRegression regression = new MultipleRegression(beta);
            regression.solveEquations(values);

            printResults(filePath, beta);
        } catch (ArrayIndexOutOfBoundsException e) {
            ExceptionHandler.handleArrayIndexOutOfBoundsException();
        }

        scanner.close();
    }
}