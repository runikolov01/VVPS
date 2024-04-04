package tests;

import main.java.Data;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class DataOutputTest {
    @Test
    public void testPrintResults_FirstTable() {
        // Arrange
        String filePath = "C:\\Users\\Public\\Documents\\firstTable.txt";
        double[] beta = {0.56646, 0.06533, 0.00872, 0.15105};
        String expectedOutput = """
                -------------------------------------------------
                Parameter: | Expected Value | Actual Value
                -------------------------------------------------
                    β0     |    0,56646     |   0,56646
                    β1     |    0,06533     |   0,06533
                    β2     |    0,00872     |   0,00872
                    β3     |    0,15105     |   0,15105
                -------------------------------------------------""".replaceAll("\\R", "\n"); // Normalize line separators

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Data.printResults(filePath, beta);
        String actualOutput = outputStream.toString().replaceAll("\\R", "\n").trim(); // Normalize line separators

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testPrintResults_SecondTable() {
        // Arrange
        String filePath = "C:\\Users\\Public\\Documents\\secondTable.txt";
        double[] beta = {6.7013, 0.0784, 0.0150, 0.2461};
        String expectedOutput = """
            -------------------------------------------------
            Parameter: | Expected Value | Actual Value
            -------------------------------------------------
                β0     |    6,7013     |   6,7013
                β1     |    0,0784     |   0,0784
                β2     |    0,0150     |   0,0150
                β3     |    0,2461     |   0,2461
            -------------------------------------------------""".replaceAll("\\R", "\n").trim(); // Normalize line separators

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        Data.printResults(filePath, beta);
        String actualOutput = outputStream.toString().replaceAll("\\R", "\n").trim(); // Normalize line separators

        // Assert
        assertEquals(expectedOutput, actualOutput);
    }
}