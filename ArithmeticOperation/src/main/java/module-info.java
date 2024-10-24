module com.csc305.arithmeticoperation {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.csc305.arithmeticoperation to javafx.fxml;
    exports com.csc305.arithmeticoperation;
}
