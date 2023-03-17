module com.example.examen_practic {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.examen_practic to javafx.fxml;
    opens com.example.examen_practic.domain to javafx.fxml,javafx.base;
    exports com.example.examen_practic;
}