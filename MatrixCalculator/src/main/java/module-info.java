module csc305.matrixcalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.matrixcalculator to javafx.fxml;
    exports csc305.matrixcalculator;
}