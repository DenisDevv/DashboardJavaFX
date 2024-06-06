package dlex.dashboardjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label message;
    @FXML
    protected void login() {
        if (username.getText().equals("denis") && password.getText().equals("denis1234")) {
            try {
                dashboard();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            message.setText("Credenziali errate");
        }
    }
    public void dashboard() throws IOException {
        ((Stage)username.getScene().getWindow()).close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 550);
        stage.setResizable(false);
        stage.setTitle("DASHBOARD | Dashboard Aziendale");
        stage.setScene(scene);
        stage.show();
    }
}