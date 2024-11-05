package csc305.mobileinventory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class InventoryController
{
    @javafx.fxml.FXML
    private DatePicker releaseDatePicker;
    @javafx.fxml.FXML
    private TextField sellingPriceInput;
    @javafx.fxml.FXML
    private TextField modelNameInput;
    @javafx.fxml.FXML
    private TextField manufacturingCostInput;
    @javafx.fxml.FXML
    private ComboBox<String> deviceTypeCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> brandNameCombobox;

    private ArrayList<MobileDevice> devices;
    @javafx.fxml.FXML
    private Label deviceAddResultLabel;
    @javafx.fxml.FXML
    private TableView<MobileDevice> deviceInfoTable;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, String> brandNameColumn;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, String> modelNameColumn;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, String> deviceTypeColumn;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, String> releaseDateColumn;
    @javafx.fxml.FXML
    private TextField maximumPriceInput;
    @javafx.fxml.FXML
    private ComboBox<String> searchBrandCombobox;
    @javafx.fxml.FXML
    private Label mostProfitableDeviceResultLabel;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, Double> manufacturingCostColumn;
    @javafx.fxml.FXML
    private TableColumn<MobileDevice, Double> sellingPriceColumn;

    @javafx.fxml.FXML
    public void initialize() {
        this.devices = new ArrayList<MobileDevice>();

        deviceTypeCombobox.getItems().addAll("Standard", "Compact", "Tablet");
        brandNameCombobox.getItems().setAll("Apple", "Google", "Oppo", "Samsung", "Xiaomi");
        searchBrandCombobox.getItems().setAll("Apple", "Google", "Oppo", "Samsung", "Xiaomi");

        brandNameColumn.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        modelNameColumn.setCellValueFactory(new PropertyValueFactory<>("modelName"));
        deviceTypeColumn.setCellValueFactory(new PropertyValueFactory<>("deviceType"));
        releaseDateColumn.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        sellingPriceColumn.setCellValueFactory(new PropertyValueFactory<>("sellingPrice"));
        manufacturingCostColumn.setCellValueFactory(new PropertyValueFactory<>("manufacturingCost"));
    }

    @javafx.fxml.FXML
    public void onAddDeviceToInventoryButtonClick(ActionEvent actionEvent) {
        String modelName = modelNameInput.getText();
        String sellingPriceFromInput = sellingPriceInput.getText();
        String manufacturingCostFromInput = manufacturingCostInput.getText();

        String brandName = brandNameCombobox.getValue();
        String deviceType = deviceTypeCombobox.getValue();
        LocalDate releaseDate = releaseDatePicker.getValue();

        double parsedSellingPrice = 0.0;
        double parsedManufacturingCost = 0.0;

        ObservableList<MobileDevice> tableData = FXCollections.observableArrayList();

        if(modelName == null || modelName.isEmpty()) {
            deviceAddResultLabel.setText("Device model cannot be empty");
            return;
        }


        if(brandName == null || brandName.isEmpty()) {
            deviceAddResultLabel.setText("Brand cannot be empty");
            return;
        }

        if(deviceType == null || deviceType.isEmpty()) {
            deviceAddResultLabel.setText("Device type cannot be empty");
            return;
        }

        if(releaseDate == null) {
            deviceAddResultLabel.setText("Release date cannot be empty");
            return;
        }

        if(manufacturingCostFromInput == null || manufacturingCostFromInput.isEmpty()) {
            deviceAddResultLabel.setText("Manufacturing cost cannot be empty");
            return;
        }

        try{
            double parsedDouble = Double.parseDouble(manufacturingCostFromInput);
            parsedManufacturingCost += parsedDouble;
        } catch (NumberFormatException e){
            deviceAddResultLabel.setText("Invalid manufacturing cost");
            return;
        }

        if(sellingPriceFromInput == null || sellingPriceFromInput.isEmpty()) {
            deviceAddResultLabel.setText("Selling price cannot be empty");
            return;
        }

        try{
            double parsedDouble = Double.parseDouble(sellingPriceFromInput);
            parsedSellingPrice += parsedDouble;
        } catch (NumberFormatException e){
            deviceAddResultLabel.setText("Invalid selling price");
            return;
        }

        for(MobileDevice device : devices) {
            if(device.getModelName().equals(modelName)) {
                deviceAddResultLabel.setText("Device already exists");
                return;
            }
        }

        MobileDevice newMobileDevice = new MobileDevice(
                modelName,
                brandName,
                deviceType,
                releaseDate,
                parsedManufacturingCost,
                parsedSellingPrice
        );

        this.devices.add(newMobileDevice);

        tableData.addAll(devices);
        deviceInfoTable.setItems(tableData);
        deviceAddResultLabel.setText("Device added: " + newMobileDevice.getModelName());

        modelNameInput.clear();
        sellingPriceInput.clear();
        manufacturingCostInput.clear();
        brandNameCombobox.setValue(null);
        releaseDatePicker.setValue(null);
        deviceTypeCombobox.setValue(null);

    }

    @javafx.fxml.FXML
    public void onFindMostProfitableDeviceButtonClick(ActionEvent actionEvent) {
        double mostProfitableDevicePrice = 0;
        String mostProfitableDeviceModelName = "";

        for (MobileDevice device : devices) {
            if(device.getSellingPrice() - device.getManufacturingCost() > mostProfitableDevicePrice) {
                mostProfitableDevicePrice = device.getSellingPrice() - device.getManufacturingCost();
                mostProfitableDeviceModelName = device.getModelName();
            }
        }

        mostProfitableDeviceResultLabel.setText("Most profitable device : " + mostProfitableDeviceModelName + " Price: " + mostProfitableDevicePrice);
    }

    @javafx.fxml.FXML
    public void onResetFilterButtonClick(ActionEvent actionEvent) {
        ObservableList<MobileDevice> tableData = FXCollections.observableArrayList();

        tableData.addAll(devices);
        deviceInfoTable.setItems(tableData);
    }

    @javafx.fxml.FXML
    public void onFilterButtonClick(ActionEvent actionEvent) {
        String searchBrand = searchBrandCombobox.getValue();
        String maxSellingPriceFromInput = maximumPriceInput.getText();

        double parsedSellingPrice = 0.0;

        ObservableList<MobileDevice> tableData = FXCollections.observableArrayList();

        if(searchBrand == null || searchBrand.isEmpty()) {
            deviceAddResultLabel.setText("Search Brand cannot be empty");
            return;
        }

        if(maxSellingPriceFromInput == null || maxSellingPriceFromInput.isEmpty()) {
            deviceAddResultLabel.setText("Selling price cannot be empty");
            return;
        }

        try{
            double parsedDouble = Double.parseDouble(maxSellingPriceFromInput);
            parsedSellingPrice += parsedDouble;
        } catch (NumberFormatException e){
            deviceAddResultLabel.setText("Invalid selling price");
            return;
        }

        for (MobileDevice device : devices) {
            if(device.getBrandName().equals(searchBrand) && device.getSellingPrice() <= parsedSellingPrice) {
                tableData.add(device);
            }
        }

        deviceInfoTable.setItems(tableData);
    }
}