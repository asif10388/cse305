module csc305.internshipproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.internshipproject to javafx.fxml;
    exports csc305.internshipproject;
}