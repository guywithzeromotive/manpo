module com.zero.manpo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;

    opens com.zero.manpo to javafx.fxml;
    exports com.zero.manpo;
}