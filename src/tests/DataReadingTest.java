package tests;

import main.java.Data;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataReadingTest {

    @Test
    public void testReadDataFromFile_FileFound() {
        // Arrange
        String filePath = "C:\\Users\\Public\\Documents\\firstTable.txt";
        double[][] expectedData = {
                {345, 65, 23, 31.4},
                {168, 18, 18, 14.6},
                {94, 0, 0, 6.4},
                {187, 185, 98, 28.3},
                {621, 87, 10, 42.1},
                {255, 0, 0, 15.3}
        };

        // Act
        double[][] actualData = Data.readDataFromFile(filePath);

        // Assert
        assertArrayEquals(expectedData, actualData);
    }

    @Test
    public void testReadDataFromFile_FileNotFound() {
        // Arrange
        String filePath = "C:\\Users\\Public\\Documents\\notFound.txt";
        double[][] expectedData = new double[0][0];

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Act
        double[][] actualData = Data.readDataFromFile(filePath);
        String consoleOutput = outputStream.toString().trim();

        // Assert
        assertArrayEquals(expectedData, actualData);
        assertEquals("File not found: " + filePath, consoleOutput);
    }
}