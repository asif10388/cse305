package csc305.productcart;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProductCartController
{
    @javafx.fxml.FXML
    private ComboBox<Integer> productQuanityCombobox;
    @javafx.fxml.FXML
    private ComboBox<String> productMaterialCombobox;
    @javafx.fxml.FXML
    private TextField productIDInput;
    @javafx.fxml.FXML
    private DatePicker productDeliveryDatePicker;
    @javafx.fxml.FXML
    private TableColumn<ProductModel, Integer> productIDColumn;
    @javafx.fxml.FXML
    private TableColumn<ProductModel, String> productNameColumn;
    @javafx.fxml.FXML
    private TableColumn<ProductModel, Integer> productQuantityColumn;
    @javafx.fxml.FXML
    private TextField productNameInput;
    @javafx.fxml.FXML
    private TableView<ProductModel> productDetailsTable;
    @javafx.fxml.FXML
    private TableColumn<ProductModel, String> productMaterialColumn;

    private ArrayList<ProductModel> items;

    @javafx.fxml.FXML
    public void initialize() {
        items = new ArrayList<>();

        productQuanityCombobox.getItems().addAll(1,2,3,4,5);
        productMaterialCombobox.getItems().addAll("Wood", "Board", "Metal", "Cloth", "Other");

        productIDColumn.setCellValueFactory(new PropertyValueFactory<>("productID"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("productName"));
        productQuantityColumn.setCellValueFactory(new PropertyValueFactory<>("productQuantity"));
        productMaterialColumn.setCellValueFactory(new PropertyValueFactory<>("productMaterial"));
    }

    @javafx.fxml.FXML
    public void onAddProductButtonClick(ActionEvent actionEvent) {
        if( productNameInput.getText().isEmpty() || productQuanityCombobox.getValue() == null || productIDInput.getText().isEmpty() || productMaterialCombobox.getValue().isEmpty() ||  productDeliveryDatePicker.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("All fields must be filled");
            alert.showAndWait();

            return;
        }

        String productName = productNameInput.getText();
        int productQuantity = productQuanityCombobox.getValue();
        int productID;

        String productMaterial = productMaterialCombobox.getValue();
        LocalDate productDeliveryDate = productDeliveryDatePicker.getValue();

        try {
            productID = Integer.parseInt(productIDInput.getText());
        } catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Product ID");
            alert.showAndWait();
            return;
        }

        for(ProductModel product: items){
            if(product.getProductID() == productID){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Duplicate Product ID");
                alert.showAndWait();

                return;
            }
        }

        if(productDeliveryDate.isBefore(LocalDate.now())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Delivery Date is before current date");
            alert.showAndWait();

            return;
        }


        ProductModel newProduct = new ProductModel(
                productID,
                productName,
                productQuantity,
                productMaterial,
                productDeliveryDate
        );

        items.add(newProduct);

        System.out.println(newProduct.toString());

        ObservableList<ProductModel> tableList = FXCollections.observableArrayList(items);
        productDetailsTable.setItems(tableList);

    }
}