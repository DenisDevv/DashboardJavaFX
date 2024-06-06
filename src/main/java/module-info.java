module dlex.dashboardjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires eu.hansolo.tilesfx;

    opens dlex.dashboardjavafx to javafx.fxml;
    exports dlex.dashboardjavafx;
}