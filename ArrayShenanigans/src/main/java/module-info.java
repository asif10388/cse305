module csc305.arrayshenanigans {
    requires javafx.controls;
    requires javafx.fxml;


    opens csc305.arrayshenanigans to javafx.fxml;
    exports csc305.arrayshenanigans;
}