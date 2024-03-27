package test;

import main.java.MultipleRegression;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MultipleRegressionTest {

    @Test
    public void testSolveEquations_FirstTable() {
        // Arrange
        double[][] data = {
                {345, 65, 23, 31.4},
                {168, 18, 18, 14.6},
                {94, 0, 0, 6.4},
                {187, 185, 98, 28.3},
                {621, 87, 10, 42.1},
                {255, 0, 0, 15.3}
        };
        double[] expectedBeta = {0.56646, 0.06533, 0.00872, 0.15105}; // Expected beta values from the firstTable

        MultipleRegression regression = new MultipleRegression(new double[4]);

        // Act
        regression.solveEquations(data);
        double[] actualBeta = regression.beta;

        // Assert
        assertArrayEquals(expectedBeta, actualBeta, 0.001); // Adjust tolerance as needed
    }

    @Test
    public void testSolveEquations_SecondTable() {
        // Arrange
        double[][] data = {
                {1142, 1060, 325, 201},
                {863, 995, 98, 98},
                {1065, 3205, 23, 162},
                {554, 120, 0, 54},
                {983, 2896, 120, 138},
                {256, 485, 88, 61}
        };
        double[] expectedBeta = {6.7013, 0.0784, 0.0150, 0.2461}; // Expected beta values from the secondTable

        MultipleRegression regression = new MultipleRegression(new double[4]);

        // Act
        regression.solveEquations(data);
        double[] actualBeta = regression.beta;

        // Assert
        assertArrayEquals(expectedBeta, actualBeta, 0.001); // Adjust tolerance as needed
    }
}