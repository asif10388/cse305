module csc305.mobileinventory {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.mobileinventory to javafx.fxml;
    exports csc305.mobileinventory;
}