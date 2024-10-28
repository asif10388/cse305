module csc305.shoppingcart {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.shoppingcart to javafx.fxml;
    exports csc305.shoppingcart;
}