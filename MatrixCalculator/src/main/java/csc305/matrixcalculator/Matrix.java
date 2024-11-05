package csc305.matrixcalculator;

import java.util.Arrays;

public class Matrix {
    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public String toString() {
        return "Matrix{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }

    public Matrix addMatrix(Matrix matrix) {
        int[][] newMatrix = new int[matrix.getMatrix().length][matrix.getMatrix()[0].length];
        for (int i = 0; i < matrix.getMatrix().length; i++) {
            for (int j = 0; j < matrix.getMatrix()[0].length; j++) {
                newMatrix[i][j] = matrix.getMatrix()[i][j] + matrix.getMatrix()[i][j];
            }
        }

        return new Matrix(newMatrix);
    }
}
