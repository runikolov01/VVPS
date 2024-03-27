package main.java;

//Този клас имплементира алгоритъма за множествена линейна регресия.
public class MultipleRegression {
    public final double[] beta;

    public MultipleRegression(double[] beta) {
        this.beta = beta;
    }

    //Алгоритъма на Гаус за намиране на коефициентите на регресията:
    // Този метод решава регресионните уравнения.
    // Той изчислява матриците на коефициентите и константите от предоставените данни
    // и след това извиква метода за решаване, за да намери бета стойностите.
    public void solveEquations(double[][] data) {
        double[][] coefficients = new double[4][4];
        double[] constants = new double[4];

        for (double[] datum : data) {
            double w = datum[0];
            double x = datum[1];
            double y = datum[2];
            double z = datum[3];

            coefficients[0][0] += 1;
            coefficients[0][1] += w;
            coefficients[0][2] += x;
            coefficients[0][3] += y;
            coefficients[1][0] += w;
            coefficients[1][1] += Math.pow(w, 2);
            coefficients[1][2] += w * x;
            coefficients[1][3] += w * y;
            coefficients[2][0] += x;
            coefficients[2][1] += w * x;
            coefficients[2][2] += Math.pow(x, 2);
            coefficients[2][3] += x * y;
            coefficients[3][0] += y;
            coefficients[3][1] += w * y;
            coefficients[3][2] += x * y;
            coefficients[3][3] += Math.pow(y, 2);

            constants[0] += z;
            constants[1] += w * z;
            constants[2] += x * z;
            constants[3] += y * z;
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