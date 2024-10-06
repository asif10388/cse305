package com.csc305.arithmeticoperation;

import javafx.scene.control.TextField;

public class InputField{
    private String inputError;
    private double inputValue;
    private final TextField inputField;

    InputField(TextField inputField) {
        this.inputField = inputField;
    }

    public double getInputValue() {
        return inputValue;
    }

    public String getInputError() {
        return inputError;
    }

    public void setNumber(double localConvertedNumber){
        this.inputValue = localConvertedNumber;
    }

    public void setError(String error){
        this.inputError = error ;
    }

    public void convertToDouble() {
       String inputValue = this.inputField.getText();

        try {
            double convertedNumber =  Double.parseDouble(inputValue);
            this.setNumber(convertedNumber);
        }catch (NumberFormatException e){
            this.inputField.setText("");
            this.inputField.requestFocus();
            this.setError("Input is not valid");
            this.inputField.setStyle("-fx-border-color: red");
        }

    }

}
