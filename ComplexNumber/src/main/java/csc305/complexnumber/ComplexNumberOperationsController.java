package csc305.complexnumber;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.Arrays;

public class ComplexNumberOperationsController
{
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
    public void initialize() {
        operationsCombobox.getItems().addAll("Show all", "Add", "Subtract", "Multiply", "Divide");
    }

    @javafx.fxml.FXML
    public void onAddToPairArrayButtonClick(ActionEvent actionEvent) {
        int index = 0;
        ComplexNumberOperationsModel complexNumberOperationsModel = new ComplexNumberOperationsModel();

        double realNumber = Double.parseDouble(realNumberInputField.getText());
        double imaginaryNumber = Double.parseDouble(imaginaryNumberInputField.getText());

        complexNumberOperationsModel.setRealArray(index, realNumber);
        complexNumberOperationsModel.setImaginaryArray(index, imaginaryNumber);

        index = index + 1;

        System.out.println(Arrays.toString(complexNumberOperationsModel.getRealArray()));
        System.out.println(Arrays.toString(complexNumberOperationsModel.getImaginaryArray()));
    }

    @javafx.fxml.FXML
    public void onShowResultButtonClick(ActionEvent actionEvent) {
    }
}