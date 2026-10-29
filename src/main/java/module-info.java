module com.example.ode_06 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ode_06 to javafx.fxml;
    exports com.example.ode_06;
}