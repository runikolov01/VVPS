package main.java;

import java.util.Arrays;

//Този клас имплементира алгоритъма за множествена линейна регресия.
public class MultipleRegression {
    public final double[] beta;
    private int numVariables;
    private int numIndVariables;

    public MultipleRegression(double[] beta) {
        this.beta = beta;
    }

    // Алгоритъма на Гаус за намиране на коефициентите на регресията:
    // Този метод решава регресионните уравнения.
    // Той изчислява матриците на коефициентите и константите от предоставените данни
    // и след това извиква метода за решаване, за да намери бета стойностите.
    public void solveEquations(double[][] data) {
        int numIndVariables = data[0].length - 1;
        double[][] coefficients = new double[numIndVariables + 1][numIndVariables + 1];
        double[] constants = new double[numIndVariables + 1];

        for (double[] datum : data) {
            double[] variables = Arrays.copyOf(datum, numIndVariables); // Extract independent variables
            double dependentVariable = datum[numIndVariables]; // Extract dependent variable

            // Populate coefficients and constants
            for (int i = 0; i <= numIndVariables; i++) {
                for (int j = 0; j <= numIndVariables; j++) {
                    if (i == 0 && j == 0) {
                        coefficients[i][j] += 1;
                    } else if (i == 0) {
                        coefficients[i][j] += variables[j - 1];
                    } else if (j == 0) {
                        coefficients[i][j] += variables[i - 1];
                    } else {
                        coefficients[i][j] += variables[i - 1] * variables[j - 1];
                    }
                }
                constants[i] += (i == 0) ? dependentVariable : variables[i - 1] * dependentVariable;
            }
        }

        solve(coefficients, constants);
    }


    // Решаване на системата от линейни уравнения чрез елиминиране на Гаус за намиране на бета стойностите.

    public void solve(double[][] coefficients, double[] constants) {
        int n = constants.length;
//Взимайки матрицата на коефициентите и вектора на константите на системата, той извършва последователни операции за трансформация
// на матрицата към горно триъгълна форма, като използва коефициенти, за да превърне всеки елемент под главния диагонал в нула.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = coefficients[j][i] / coefficients[i][i];
                constants[j] -= factor * constants[i];
                for (int k = i; k < n; k++) {
                    coefficients[j][k] -= factor * coefficients[i][k];
                }
            }
        }

// След това извършва обратното изчисление, за да намери стойностите на променливите.
        for (int i = n - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < n; j++) {
                sum += coefficients[i][j] * beta[j];
            }
            beta[i] = (constants[i] - sum) / coefficients[i][i];
        }
    }
}
