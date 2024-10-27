module com.csc305.bookborrowmanager {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.csc305.bookborrowmanager to javafx.fxml;
    exports com.csc305.bookborrowmanager;
}