package dlex.dashboardjavafx;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class Script {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label message;
    @FXML
    private Label saldo;
    @FXML
    private TextField addQuantita;
    @FXML
    private TextField rimQuantita;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private Pane inputAggQuantita;
    @FXML
    private Pane inputRimQuantita;
    @FXML
    protected void loginMouse() {
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
    @FXML
    protected void login(KeyEvent event) {
        if (event.getCode().toString().equals("ENTER")) {
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
    }
    public void dashboard() throws IOException {
        ((Stage)username.getScene().getWindow()).close();
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setResizable(false);
        stage.setTitle("DASHBOARD | Dashboard Aziendale");
        stage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();
    }
    @FXML
    protected void dipendenti(){
        System.out.println("Dipendenti");
    }
    @FXML
    protected void home(){
        System.out.println("Home");
    }
    @FXML
    protected void regAtt(){
        System.out.println("RegAtt");
    }
    @FXML
    protected void aggiungiSaldo(){
        popIn(inputAggQuantita);
    }
    @FXML
    protected void rimuoviSaldo(){
        popIn(inputRimQuantita);
    }
    @FXML
    protected void aggiungiQuantita() {
        if (addQuantita.getText().isEmpty()) {
            close();
        } else {
            int saldoAttuale = Integer.parseInt(saldo.getText().substring(0, saldo.getText().length() - 1));
            int quantita = Integer.parseInt(addQuantita.getText());
            addQuantita.setText("");
            saldo.setText(saldoAttuale + quantita + "$");
            popOut(inputAggQuantita);
        }
    }
    @FXML
    protected void rimuoviQuantita() {
        if (rimQuantita.getText().isEmpty()) {
            close();
        } else {
            int saldoAttuale = Integer.parseInt(saldo.getText().substring(0, saldo.getText().length() - 1));
            int quantita = Integer.parseInt(rimQuantita.getText());
            rimQuantita.setText("");
            saldo.setText(saldoAttuale - quantita + "$");
            popOut(inputRimQuantita);
        }
    }
    @FXML
    protected void close() {
        popOut(inputRimQuantita);
        popOut(inputAggQuantita);
    }
    @FXML
    protected void closeKey(KeyEvent event) {
        if (event.getCode().toString().equals("ESCAPE")) {
            popOut(inputRimQuantita);
            popOut(inputAggQuantita);
        }
    }
    public void popIn(Pane pane) {
        pane.setVisible(true);
        ScaleTransition st = new ScaleTransition(Duration.millis(100), pane);
        st.setFromX(0);
        st.setFromY(0);
        st.setToX(1);
        st.setToY(1);
        st.play();
    }

    public void popOut(Pane pane) {
        ScaleTransition st = new ScaleTransition(Duration.millis(100), pane);
        st.setFromX(1);
        st.setFromY(1);
        st.setToX(0);
        st.setToY(0);
        st.setOnFinished(e -> pane.setVisible(false));
        st.play();
    }
}