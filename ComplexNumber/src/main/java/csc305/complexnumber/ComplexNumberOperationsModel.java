package csc305.complexnumber;

public class ComplexNumberOperationsModel {
    private double real, imaginary;
    private final double[] realArray = new double[10];
    private final double[] imaginaryArray = new double[10];

    public ComplexNumberOperationsModel() {}

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public double[] getRealArray() {
        return realArray;
    }

    public void setRealArray(int realArrayIndex, double realArrayValue) {
        this.realArray[realArrayIndex] = realArrayValue;
    }

    public double[] getImaginaryArray() {
        return imaginaryArray;
    }

    public void setImaginaryArray(int imaginaryArrayIndex, double imaginaryArrayValue) {
        this.imaginaryArray[imaginaryArrayIndex] = imaginaryArrayValue;
    }

    @Override
    public String toString() {
        return  real + "+" + imaginary + "i";
    }
}
