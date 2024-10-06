package com.csc305.arithmeticoperation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

class InputField{
    @FXML
    private Label resultLabel;

    private final String inputId;

    private String inputError1;
    private String inputError2;

    private double inputValue1;
    private double inputValue2;

    private final TextField inputField;

    InputField(TextField inputField, String inputId) {
        this.inputId = inputId;
        this.inputField = inputField;
    }

    public TextField getInputField() {
        return inputField;
    }

    public double getInputValue1() {
        return inputValue1;
    }

    public double getInputValue2() {
        return inputValue2;
    }

    public String getInputError1() {
        return inputError1;
    }

    public String getInputError2() {
        return inputError2;
    }

    public void setNumber(String localInputId, double localConvertedNumber){
        if(inputId.equals(localInputId)){
            this.inputValue1 = localConvertedNumber;
            return;
        }

        this.inputValue2 = localConvertedNumber;
    }

    public void setError(String localInputId){
        if(inputId.equals("numInput1")){
            this.inputError1 = "Input 1 is not valid";
            return;
        }

        this.inputError2 = "Input 2 is not valid";
    }

    public void convertToDouble() {
       String inputValue = this.inputField.getText();

        try {
            double convertedNumber =  Double.parseDouble(inputValue);
            this.setNumber("numInput1", convertedNumber);
        }catch (NumberFormatException e){
            this.setError("numInput1");
            this.inputField.setText("");
            this.inputField.requestFocus();
            this.inputField.setStyle("-fx-border-color: red");
        }

    }

}

public class ArithmeticViewController
{
    @FXML
    private Label resultLabel;
    @FXML
    private TextField numInput1;
    @FXML
    private Button computeButton;
    @FXML
    private TextField numInput2;
    @FXML
    private CheckBox checkboxAdd;
    @FXML
    private CheckBox checkboxDivide;
    @FXML
    private CheckBox checkboxSubtract;
    @FXML
    private CheckBox checkboxMultiply;
    @FXML
    private Label numInput2Error;
    @FXML
    private Label numInput1Error;

    @FXML
    public void computeResult(){
        InputField inputField1 = new InputField(numInput1,"numInput1");
        InputField inputField2 = new InputField(numInput2,"numInput2");

        inputField1.convertToDouble();
        inputField2.convertToDouble();

        System.out.println(inputField1.getInputValue1());
        System.out.println(inputField2.getInputValue2());

        System.out.println(inputField1.getInputError1());
        System.out.println(inputField2.getInputError2());

        boolean toAdd = checkboxAdd.isSelected();
        boolean toDivide = checkboxDivide.isSelected();
        boolean toSubtract = checkboxSubtract.isSelected();
        boolean toMultiply = checkboxMultiply.isSelected();

        String resultString = "";

        if(inputField1.getInputValue1() == 0 || inputField2.getInputValue2() == 0){
            resultLabel.setText("Please enter both numbers");
            return;
        }

        if(!toAdd && !toDivide && !toSubtract && !toMultiply){
            resultLabel.setText("Please select at least one operation");
            return;
        }

        numInput1.setStyle("-fx-border-color: transparent");
        numInput2.setStyle("-fx-border-color: transparent");

        if(toAdd) {
            double additionResult = inputField1.getInputValue1() + inputField2.getInputValue2();
            resultString += String.format("Addition result: %.2f \n", additionResult);
        }

        if (toSubtract) {
            double subtractionResult = inputField1.getInputValue1() - inputField2.getInputValue2();
            resultString += String.format("Subtraction result: %.2f \n",subtractionResult);
        }

        if (toDivide) {
            double divisionResult = inputField1.getInputValue1() / inputField2.getInputValue2();
            resultString += String.format("Division result: %.2f \n",divisionResult);
        }

        if (toMultiply) {
            double multiplicationResult = inputField1.getInputValue1() * inputField2.getInputValue2();
            resultString += String.format("Multiplication result: %.2f \n", multiplicationResult);
        }

        resultLabel.setText(resultString);

    }
}