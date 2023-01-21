module com.example.wordgeneration {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.wordgeneration to javafx.fxml;
    exports com.example.wordgeneration;
}