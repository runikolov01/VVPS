package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Клас за обработка на данните:
// - четене от файла
// - принтиране на резултата

public class Data {

    public static double[][] readDataFromFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int numRows = 0;
            int numColumns = 0;

            // Calculate the number of rows and the maximum number of columns
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                if (line.length > numColumns) {
                    numColumns = line.length;
                }
                numRows++;
            }
            scanner.close();

            // Initialize the array with the correct size
            double[][] data = new double[numRows][numColumns];

            // Read data from the file again and populate the array
            scanner = new Scanner(file);
            int row = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().trim().split("\\s+");
                if (line.length != numColumns) {
                    System.out.println("Mismatch in the number of columns in row " + (row + 1));
                    return new double[0][0];
                }
                for (int i = 0; i < numColumns; i++) {
                    data[row][i] = Double.parseDouble(line[i]);
                }
                row++;
            }

            scanner.close();
            return data;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            return new double[0][0];
        }
    }


    // Константи за очакваните стойности на бета
    private static final String[] EXPECTED_BETA_FIRST_TABLE = {"0,56646", "0,06533", "0,00872", "0,15105"};
    private static final String[] EXPECTED_BETA_SECOND_TABLE = {"6,7013", "0,0784", "0,0150", "0,2461"};

    // Методи за принтиране със или без очаквани стойности
    public static void printResults(String filePath, double[] beta) {
        String[] expectedBeta = filePath.contains("firstTable") ? EXPECTED_BETA_FIRST_TABLE : EXPECTED_BETA_SECOND_TABLE;
        if (filePath.contains("firstTable") || filePath.contains("secondTable")) {
            successfulPrintPatternWithExpectedValues();
            for (int i = 0; i < beta.length; i++) {
                if (filePath.contains("firstTable")) {
                    System.out.println("    β" + i + "     |    " + expectedBeta[i] + "     |" + String.format("   %.5f", beta[i]));
                } else if (filePath.contains("secondTable")) {
                    System.out.println("    β" + i + "     |    " + expectedBeta[i] + "     |" + String.format("   %.4f", beta[i]));
                }
            }
        } else {
            successfulPrintPatternWITHOUTExpectedValues();
            for (int i = 0; i < beta.length; i++) {
                System.out.println("    β" + i + "     |" + String.format("   %.4f", beta[i]));
            }
        }
        System.out.println("-------------------------------------------------");
    }

    // Метод за успешен принт с очаквани стойности
    private static void successfulPrintPatternWithExpectedValues() {
        System.out.println("-------------------------------------------------");
        System.out.println("Parameter: | Expected Value | Actual Value");
        System.out.println("-------------------------------------------------");
    }

    // Метод за успешен принт без очаквани стойности
    private static void successfulPrintPatternWITHOUTExpectedValues() {
        System.out.println("---------------------------");
        System.out.println("Parameter: | Actual Value");
        System.out.println("---------------------------");
    }
}
