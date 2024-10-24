package csc305.complexnumber;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class ComplexNumberOperationsController {
    @javafx.fxml.FXML
    private Label addToPairArrayStatusLabel;

    @javafx.fxml.FXML
    private ComboBox<String> operationsCombobox;

    @javafx.fxml.FXML
    private TextField imaginaryNumberInputField;

    @javafx.fxml.FXML
    private TextField realNumberInputField;

    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    private Label remainingPairLabel;

    private int counter = 0;

    private ComplexNumberOperationsModel complexNumberOperationsModel;

    public int getCounter() {
        return counter;
    }

    public void setCounter() {
        this.counter++;
    }

    public void clearCounter() {
        this.counter = 0;
    }

    @javafx.fxml.FXML
    public void initialize() {
        complexNumberOperationsModel = new ComplexNumberOperationsModel();
        operationsCombobox.getItems().addAll("Show All", "Add", "Subtract");
    }

    @javafx.fxml.FXML
    public void onAddToPairArrayButtonClick(ActionEvent actionEvent) {
        if (getCounter() >= 10) {
            remainingPairLabel.setStyle("-fx-text-fill: red");
            remainingPairLabel.setText("Maximum limit reached");
            return;
        }

        double realNumber = Double.parseDouble(realNumberInputField.getText());
        double imaginaryNumber = Double.parseDouble(imaginaryNumberInputField.getText());

        complexNumberOperationsModel.setRealArray(getCounter(), realNumber);
        complexNumberOperationsModel.setImaginaryArray(getCounter(), imaginaryNumber);

        setCounter();

        addToPairArrayStatusLabel.setText("Added pair to array!");

        realNumberInputField.clear();
        imaginaryNumberInputField.clear();

        remainingPairLabel.setText(String.valueOf(10 - getCounter()) + " / " + "10" + " Remaining! ");
    }

    @javafx.fxml.FXML
    public void onShowResultButtonClick(ActionEvent actionEvent) {
        double realNumberSum = 0;
        double imaginaryNumberSum = 0;

        StringBuilder resultString = new StringBuilder();
        String selectedOperation = operationsCombobox.getSelectionModel().getSelectedItem();

        if (selectedOperation == null || selectedOperation.isEmpty()) {
            resultLabel.setText("No operation selected!");
            return;
        }

        addToPairArrayStatusLabel.setText("");

        switch (selectedOperation) {
            case "Show All":
                for (int i = 0; i < getCounter(); i++) {
                    resultString.append(complexNumberOperationsModel.getRealArray()[i]).append("+").append(complexNumberOperationsModel.getImaginaryArray()[i]).append("i").append("\n");
                }

                resultLabel.setText(resultString.toString());
                break;
            case "Add":
                for (int i = 0; i < getCounter(); i++) {
                    realNumberSum += complexNumberOperationsModel.getRealArray()[i];
                    imaginaryNumberSum += complexNumberOperationsModel.getImaginaryArray()[i];
                }

                resultLabel.setText(realNumberSum + "+" + imaginaryNumberSum + "i");
                break;
            case "Subtract":
                for (int i = 0; i < getCounter(); i++) {
                    realNumberSum -= complexNumberOperationsModel.getRealArray()[i];
                    imaginaryNumberSum -= complexNumberOperationsModel.getImaginaryArray()[i];
                }

                resultLabel.setText(realNumberSum + "" + imaginaryNumberSum + "i");
                break;
            default:
                break;

        }
    }

    @javafx.fxml.FXML
    public void onClearArrayButtonClick(ActionEvent actionEvent) {
        for (int i = 0; i < getCounter(); i++) {
            complexNumberOperationsModel.getRealArray()[i] = 0;
        }

        clearCounter();
        resultLabel.setText("");
        addToPairArrayStatusLabel.setText("Array cleared!");
        remainingPairLabel.setText(String.valueOf(getCounter()) + " / " + "10" + " Remaining! ");
    }

    @javafx.fxml.FXML
    public void onFocusButtonClicked(Event event) {
        addToPairArrayStatusLabel.setText("");
    }
}