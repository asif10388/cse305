module com.csc305.arithmeticoperation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.csc305.arithmeticoperation to javafx.fxml;
    exports com.csc305.arithmeticoperation;
}