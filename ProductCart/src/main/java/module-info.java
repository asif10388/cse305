module csc305.productcart {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.productcart to javafx.fxml;
    exports csc305.productcart;
}