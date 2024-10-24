module csc305.complexnumber {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.complexnumber to javafx.fxml;
    exports csc305.complexnumber;
}