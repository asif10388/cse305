package com.csc305.employeerecords;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeViewController
{
    @javafx.fxml.FXML
    private TextField employeeSalaryInput;
    @javafx.fxml.FXML
    private TableColumn<EmployeeEntityModel, String> empNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> employeeDropdown;
    @javafx.fxml.FXML
    private TableColumn<EmployeeEntityModel, String> empIDColumn;
    @javafx.fxml.FXML
    private TableColumn<EmployeeEntityModel, String> empDesignationColumn;
    @javafx.fxml.FXML
    private TableColumn<EmployeeEntityModel, Double> empSalaryColumn;
    @javafx.fxml.FXML
    private TextField salarySearchInput;
    @javafx.fxml.FXML
    private TableView<EmployeeEntityModel> employeeRecordTable;
    @javafx.fxml.FXML
    private TableColumn<EmployeeEntityModel, LocalDate> empDoJColumn;
    @javafx.fxml.FXML
    private DatePicker employeeDoJInput;
    @javafx.fxml.FXML
    private DatePicker employeeDoBInput;
    @javafx.fxml.FXML
    private TextField employeeNameInput;
    @javafx.fxml.FXML
    private TextField employeeIdInput;
    @javafx.fxml.FXML
    private ComboBox<String> employeeDesignationDropdown;

    private ArrayList<EmployeeEntityModel> employees;

    @javafx.fxml.FXML
    public void initialize() {
        empNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));
        empIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeId"));
        empDesignationColumn.setCellValueFactory(new PropertyValueFactory<>("employeeDesignation"));
        empSalaryColumn.setCellValueFactory(new PropertyValueFactory<>("employeeSalary"));
        empDoJColumn.setCellValueFactory(new PropertyValueFactory<>("employeeDoJ"));

        this.employees = new ArrayList<EmployeeEntityModel>();

        employeeDesignationDropdown.getItems().addAll("IT", "Finance", "Sales");
    }

    @javafx.fxml.FXML
    public void onSaveEmployeeButtonClick(ActionEvent actionEvent) {
        String employeeId = employeeIdInput.getText();
        String employeeName = employeeNameInput.getText();
        double employeeSalary = Double.parseDouble(employeeSalaryInput.getText());
        String employeeDesignation = employeeDesignationDropdown.getValue();
        LocalDate employeeDoB = employeeDoBInput.getValue();
        LocalDate employeeDoJ = employeeDoJInput.getValue();

        EmployeeEntityModel newEmployee = new EmployeeEntityModel(
                employeeId,
                employeeName,
                employeeSalary,
                employeeDesignation,
                employeeDoB,
                employeeDoJ
        );

        this.employees.add(newEmployee);
        employeeDropdown.getItems().add(employeeName);

        employeeIdInput.clear();
        employeeNameInput.clear();
        employeeSalaryInput.clear();
        employeeDoBInput.setValue(null);
        employeeDoJInput.setValue(null);
        employeeDesignationDropdown.setValue(null);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New Employee");
        alert.setHeaderText(null);
        alert.setContentText("New Employee: " + newEmployee.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onShowButtonClick(ActionEvent actionEvent) {
        StringBuilder resultString = new StringBuilder();
        String employeeToFind = employeeDropdown.getValue();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("New Employee");
        alert.setHeaderText(null);

        for(EmployeeEntityModel employee : employees) {
            if(employee.getEmployeeName().equals(employeeToFind)) {
                resultString.append(employee.toString()).append("\n");
            }
        }

        alert.setContentText(String.valueOf(resultString));
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onLoadEmployeeButtonClick(ActionEvent actionEvent) {
        double salarySearch = Double.parseDouble(salarySearchInput.getText());
        ObservableList<EmployeeEntityModel> employeeList = FXCollections.observableArrayList();

        for (EmployeeEntityModel employee : employees) {
            if(employee.getEmployeeSalary() == salarySearch) {
                employeeList.add(employee);
            }
        }

        employeeRecordTable.setItems(employeeList);
    }
}