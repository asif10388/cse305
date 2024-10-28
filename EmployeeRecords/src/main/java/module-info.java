module com.csc305.employeerecords {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.csc305.employeerecords to javafx.fxml;
    exports com.csc305.employeerecords;
}