package csc305.shoppingcart;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class ShoppingCartController
{
    @javafx.fxml.FXML
    private Label unitPriceLabel;
    @javafx.fxml.FXML
    private Label predefinedVATLabel;
    @javafx.fxml.FXML
    private ComboBox<String> quanityDropdown;
    @javafx.fxml.FXML
    private TextField maxUnitCostInput;
    @javafx.fxml.FXML
    private Label showTotalVATAmountTextarea;
    @javafx.fxml.FXML
    private Label cartDetailsTextArea;
    @javafx.fxml.FXML
    private ComboBox<String> vatToConsiderDropdown;
    @javafx.fxml.FXML
    private ComboBox<String> productDropdown;

    private ArrayList<CartItemModel> cartItems;
    private ArrayList<ProductModel> products;

    @javafx.fxml.FXML
    public void initialize() {
        this.cartItems = new ArrayList<CartItemModel>();
        this.products  = new ArrayList<ProductModel>();

        ProductModel almondMilk = new ProductModel(
                "Almond Milk",
                34.44,
                5
        );

        ProductModel honeyNuts = new ProductModel(
                "Honey Nuts",
                69.99,
                8
        );

        ProductModel mangoJuice = new ProductModel(
                "Mango Juice",
                20.00,
                1
        );

        ProductModel cornDog = new ProductModel(
                "Corn Dog",
                10.00,
                10
        );

        ProductModel bibimbap = new ProductModel(
                "Bibimbap ",
                50.00,
                15
        );

        ProductModel tesla = new ProductModel(
                "Tesla",
                200.00,
                15
        );

        ProductModel eldenRing = new ProductModel(
                "Elden Ring",
                49.99,
                5
        );

        ProductModel jigsawPuzzle = new ProductModel(
                "Jigsaw Puzzle",
                34.44,
                5
        );

        ProductModel parrot = new ProductModel(
                "Parrot",
                25,
                5
        );

        ProductModel printer = new ProductModel(
                "Printer",
                70,
                5
        );

        this.products.add(almondMilk);
        this.products.add(honeyNuts);
        this.products.add(mangoJuice);
        this.products.add(cornDog);
        this.products.add(bibimbap);
        this.products.add(tesla);
        this.products.add(eldenRing);
        this.products.add(jigsawPuzzle);
        this.products.add(parrot);
        this.products.add(printer);

        for(ProductModel product : this.products) {
            productDropdown.getItems().add(product.getProductName());
        }

        for(int i = 0; i < 15; i++) {
            quanityDropdown.getItems().add(String.valueOf(i + 1));
        }

        for(int i = 0; i < 15; i++) {
            vatToConsiderDropdown.getItems().add(String.valueOf(i + 1));
        }

    }

    @javafx.fxml.FXML
    public void onCheckoutButtonClick(ActionEvent actionEvent) {
        String resultString = "";

        for(CartItemModel cartItem : this.cartItems) {
            double totalAmount = (cartItem.getPrice() * cartItem.getQuantity()) + (cartItem.getPrice() * ((double) cartItem.getVatRate() / 10));
            resultString += "\n" + "Product: " + cartItem.getProductName() + ", Unit Price: " + cartItem.getPrice() + ", Quantity: " + cartItem.getQuantity() + ", VAT Amount: " + cartItem.getVatRate() + ", Total Amount: " + String.valueOf(totalAmount)  + "\n";
        }

        cartDetailsTextArea.setText(resultString);
    }

    @javafx.fxml.FXML
    public void onAddProductToCartButtonClick(ActionEvent actionEvent) {
        String productName = productDropdown.getValue();
        int quantity = Integer.parseInt(quanityDropdown.getValue());

        for(ProductModel product : this.products) {
            if(product.getProductName().equals(productName)) {
               CartItemModel newCartItem = new CartItemModel(
                       product.getProductName(),
                       product.getPrice(),
                       quantity,
                       product.getVatRate()
               );

               System.out.println(product.getProductName() + " Model created!");

                if(!this.cartItems.isEmpty()){
                    for (CartItemModel cartItem : this.cartItems) {
                        if(cartItem.getProductName().equals(productName)) {
                            cartItem.setQuantity(quantity);
                            break;
                        }else{
                            this.cartItems.add(newCartItem);
                            break;
                        }
                    }
                }else{
                    this.cartItems.add(newCartItem);
                    break;
                }
            }
        }


    }

    @javafx.fxml.FXML
    public void onShowTotalVATAmountButtonClick(ActionEvent actionEvent) {
        int matchVATAmount = Integer.parseInt(vatToConsiderDropdown.getValue());
        double maxUnitPrice =   Double.parseDouble(maxUnitCostInput.getText());

        double totalVATAmount = 0;

        for(CartItemModel cartItem : this.cartItems) {
            if(cartItem.getPrice() <= maxUnitPrice && cartItem.getVatRate() == matchVATAmount) {
                totalVATAmount += cartItem.getVatRate();
            }
        }

        showTotalVATAmountTextarea.setText("The total VAT amount paid for the products meeting search criteria is" + String.valueOf(totalVATAmount));

    }

    @javafx.fxml.FXML
    public void onSelectProduct(ActionEvent actionEvent) {
        String productName = productDropdown.getValue();

        for(ProductModel product : this.products) {
            if(product.getProductName().equals(productName)) {
                unitPriceLabel.setText(String.valueOf(product.getPrice()));
                predefinedVATLabel.setText(String.valueOf(product.getVatRate()));
                break;
            }
        }
    }
}