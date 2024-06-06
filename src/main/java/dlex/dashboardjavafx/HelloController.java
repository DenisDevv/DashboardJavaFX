package dlex.dashboardjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label message;
    @FXML
    protected void login() {
        if (username.getText().equals("admin") && password.getText().equals("admin")) {
            message.setText("Login successful");
        } else {
            message.setText("Login failed");
        }
    }
}