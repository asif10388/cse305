package com.csc305.midterm_2110182_7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class PathologyController
{
    @javafx.fxml.FXML
    private TableColumn<TableInfo, Integer> doctorIdColumn;
    @javafx.fxml.FXML
    private TextField testPriceInput;
    @javafx.fxml.FXML
    private TableColumn<TableInfo, Integer> testIdColumn;
    @javafx.fxml.FXML
    private TableColumn<TableInfo, Integer> patientIdColumn;
    @javafx.fxml.FXML
    private ComboBox<Integer> patientIdCombobox;
    @javafx.fxml.FXML
    private TableView<TableInfo> pathologyInfoTable;
    @javafx.fxml.FXML
    private TextField billIdInput;
    @javafx.fxml.FXML
    private TableColumn<TableInfo, LocalDate> testDateColumn;
    @javafx.fxml.FXML
    private DatePicker testDatePicker;
    @javafx.fxml.FXML
    private ComboBox<Integer> testIdCombobox;
    @javafx.fxml.FXML
    private ComboBox<Integer> doctorIdCombobox;
    @javafx.fxml.FXML
    private Label onShowMatchCountResultLabel;

    private ArrayList<PathologyBill> pathologyBills;

    private ArrayList<Integer> controllerTestIdList = new ArrayList<>();
    private ArrayList<Float> controllerTestPriceList = new ArrayList<>();
    @javafx.fxml.FXML
    private Label testAddResultLabel;
    @javafx.fxml.FXML
    private ComboBox<Integer> selectDoctorIdCombobox;
    @javafx.fxml.FXML
    private Label testAddResultLabel11;
    @javafx.fxml.FXML
    private Label testAddResultLabel1;
    @javafx.fxml.FXML
    private TextField minimumBIllAmountInput;

    @javafx.fxml.FXML
    public void initialize() {
        this.pathologyBills = new ArrayList<>();

        doctorIdColumn.setCellValueFactory(new PropertyValueFactory<>("doctorId"));
        testIdColumn.setCellValueFactory(new PropertyValueFactory<>("testId"));
        patientIdColumn.setCellValueFactory(new PropertyValueFactory<>("patientId"));
        testDateColumn.setCellValueFactory(new PropertyValueFactory<>("testDate"));

        patientIdCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        selectDoctorIdCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        doctorIdCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        testIdCombobox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }

    @javafx.fxml.FXML
    public void onSearchAndLoadTableButtonClick(ActionEvent actionEvent) {
        int selectedDoctorId = selectDoctorIdCombobox.getValue();
        float minimumPrice = Float.parseFloat(minimumBIllAmountInput.getText());
        ObservableList<TableInfo> tableData = FXCollections.observableArrayList();

        ArrayList<TableInfo> tableDataArray = new ArrayList<>();

        for (PathologyBill bill : pathologyBills) {
            if (bill.getDoctorId() == selectedDoctorId && bill.getTotalBillCost() >= minimumPrice) {
//                tableData.add(bill);

                for(Integer testId : bill.getTestIdList()) {
                    TableInfo newTableColumn = new TableInfo(
                            testId,
                            bill.getPatientId(),
                            bill.getDoctorId(),
                            bill.getTestDate()
                    );

                    tableDataArray.add(newTableColumn);
                }
            }
        }

        tableData.addAll(tableDataArray);
        pathologyInfoTable.setItems(tableData);

    }

    @javafx.fxml.FXML
    public void onAddTestButtonClick(ActionEvent actionEvent) {
        if(testIdCombobox.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding test!");
            alert.setHeaderText(null);

            alert.setContentText("Please select a test id!");
            alert.showAndWait();

            return;
        };

        if(String.valueOf(testPriceInput.getText()).isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding test!");
            alert.setHeaderText(null);

            alert.setContentText("You must add a price for the test!");
            alert.showAndWait();

            return;
        }

        int testId = testIdCombobox.getValue();
        float testPrice = Float.parseFloat(testPriceInput.getText());
        if(testPrice <= 100){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error adding test!");
        alert.setHeaderText(null);

        alert.setContentText("Price must be higher than 100!");
        alert.showAndWait();

        return;
        }

        if(testId >= 1 && testId <= 10){
            controllerTestIdList.add(testId);
            controllerTestPriceList.add(testPrice);

            testAddResultLabel.setText("Test added!");

            testPriceInput.clear();
            testIdCombobox.setValue(null);
        }
    }

    @javafx.fxml.FXML
    public void onShowMatchCountFromTableButtonClick(ActionEvent actionEvent) {
        onShowMatchCountResultLabel.setText(String.valueOf(pathologyInfoTable.getItems().size()));
    }

    @javafx.fxml.FXML
    public void onAddBillButtonClick(ActionEvent actionEvent) {
        int billId = Integer.parseInt(billIdInput.getText());
        int doctorId = doctorIdCombobox.getValue();
        int patientId = patientIdCombobox.getValue();
        LocalDate testDate = testDatePicker.getValue();

        if(controllerTestIdList.isEmpty() || controllerTestPriceList.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error adding bill!");
            alert.setHeaderText(null);

            alert.setContentText("You must add at least one test");
            alert.showAndWait();
            return;
        }

        PathologyBill newBill = new PathologyBill(
                billId,
                patientId,
                doctorId,
                testDate,
                controllerTestIdList,
                controllerTestPriceList
        );

        pathologyBills.add(newBill);

        billIdInput.clear();
        testIdCombobox.setValue(null);
        doctorIdCombobox.setValue(null);
        patientIdCombobox.setValue(null);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("New bill added!");
        alert.setHeaderText(null);

        alert.setContentText(newBill.toString());
        alert.showAndWait();
    }
}


