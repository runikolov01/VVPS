package tests;

import main.java.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberOfInputVariablesTest {
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    @Test
    public void testMessageWhenTextIsEntered() {
        String input = "abc\n4\nC:\\Users\\Public\\Documents\\firstTable.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String expectedOutput = """
                Please enter the integer number of independent variables (must be at least 2): Invalid input. Please enter an integer number.
                Please enter the integer number of independent variables (must be at least 2): Please enter the path to the data file: -------------------------------------------------
                Parameter: | Expected Value | Actual Value
                -------------------------------------------------
                    β0     |    0,56646     |   0,56646
                    β1     |    0,06533     |   0,06533
                    β2     |    0,00872     |   0,00872
                    β3     |    0,15105     |   0,15105
                -------------------------------------------------
                """;
        String actualOutput = outContent.toString().replace(System.lineSeparator(), "\n");
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testMessageWhenNumberIsBelow2() {
        String input = "1\n4\nC:\\Users\\Public\\Documents\\firstTable.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Main.main(new String[]{});

        String expectedOutput = """
                Please enter the integer number of independent variables (must be at least 2): Please enter an integer number 2 or bigger.
                Please enter the integer number of independent variables (must be at least 2): Please enter the path to the data file: -------------------------------------------------
                Parameter: | Expected Value | Actual Value
                -------------------------------------------------
                    β0     |    0,56646     |   0,56646
                    β1     |    0,06533     |   0,06533
                    β2     |    0,00872     |   0,00872
                    β3     |    0,15105     |   0,15105
                -------------------------------------------------
                """;

        // Replace system-specific line separator with a consistent line separator
        String expectedOutputNormalized = expectedOutput.replace(System.lineSeparator(), "\n");
        String actualOutputNormalized = outContent.toString().replace(System.lineSeparator(), "\n");

        assertEquals(expectedOutputNormalized, actualOutputNormalized);
    }


    @Test
    public void testMessageWhenNumberIs2OrMore() {
        String input = "4\nC:\\Users\\Public\\Documents\\firstTable.txt\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Main.main(new String[]{});

        String expectedOutput = """
                Please enter the integer number of independent variables (must be at least 2): Please enter the path to the data file: -------------------------------------------------
                Parameter: | Expected Value | Actual Value
                -------------------------------------------------
                    β0     |    0,56646     |   0,56646
                    β1     |    0,06533     |   0,06533
                    β2     |    0,00872     |   0,00872
                    β3     |    0,15105     |   0,15105
                -------------------------------------------------
                """;
        String actualOutput = outContent.toString().replace(System.lineSeparator(), "\n");
        assertEquals(expectedOutput, actualOutput);
    }
}