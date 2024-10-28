module csc305.courseregistration {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.courseregistration to javafx.fxml;
    exports csc305.courseregistration;
}