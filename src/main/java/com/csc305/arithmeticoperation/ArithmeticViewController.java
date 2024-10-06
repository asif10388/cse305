package com.csc305.arithmeticoperation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class ArithmeticViewController
{
    @FXML
    private Label resultLabel;

    @FXML
    private TextField numInput1;
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
    
    public boolean isValid(InputField inputField1, InputField inputField2, boolean checkboxError){
        boolean isValid = true;

        if(inputField1.getInputError() != null){
            numInput1Error.setText(inputField1.getInputError());
            isValid = false;
        }

        if(inputField2.getInputError() != null){
            numInput2Error.setText(inputField2.getInputError());
            isValid = false;
        }

        if(checkboxError){
            resultLabel.setText("Please select at least one operation");
            isValid = false;
        }
        
        return isValid;
    }

    @FXML
    public void computeResult(){
        InputField inputField1 = new InputField(numInput1);
        InputField inputField2 = new InputField(numInput2);

        inputField1.convertToDouble();
        inputField2.convertToDouble();
        
        boolean toAdd = checkboxAdd.isSelected();
        boolean toDivide = checkboxDivide.isSelected();
        boolean toSubtract = checkboxSubtract.isSelected();
        boolean toMultiply = checkboxMultiply.isSelected();
        boolean checkboxError = !toAdd && !toDivide && !toSubtract && !toMultiply;

        String resultString = "";

        if(!isValid(inputField1, inputField2, checkboxError)){
            return;
        }

        numInput1.setStyle("-fx-border-color: transparent");
        numInput2.setStyle("-fx-border-color: transparent");
        numInput1Error.setText("");
        numInput2Error.setText("");

        if(toAdd) {
            double additionResult = inputField1.getInputValue() + inputField2.getInputValue();
            resultString += String.format("Addition result: %.2f \n", additionResult);
        }

        if (toSubtract) {
            double subtractionResult = inputField1.getInputValue() - inputField2.getInputValue();
            resultString += String.format("Subtraction result: %.2f \n",subtractionResult);
        }

        if (toMultiply) {
            double multiplicationResult = inputField1.getInputValue() * inputField2.getInputValue();
            resultString += String.format("Multiplication result: %.2f \n", multiplicationResult);
        }

        if (toDivide) {
            double divisionResult = inputField1.getInputValue() / inputField2.getInputValue();
            resultString += String.format("Division result: %.2f \n",divisionResult);
        }

        resultLabel.setText(resultString);

    }
}