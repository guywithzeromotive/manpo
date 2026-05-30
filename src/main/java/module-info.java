module com.zero.manpo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.zero.manpo to javafx.fxml;
    exports com.zero.manpo;
}