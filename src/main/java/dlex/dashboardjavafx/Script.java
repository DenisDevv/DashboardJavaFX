package dlex.dashboardjavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Script {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label message;
    @FXML
    private CategoryAxis grafico;
    @FXML
    private NumberAxis graficoNum;
    @FXML
    private LineChart<String, Number> lineChart;
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1024, 768);
        stage.setResizable(false);
        stage.setTitle("DASHBOARD | Dashboard Aziendale");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    protected void graficoFunz() {
        grafico.setLabel("Mesi");
        graficoNum.setLabel("Vendite");
        lineChart.setTitle("Vendite Mensili");
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Vendite");
        series.getData().add(new XYChart.Data<>("Gennaio", 1000));
        series.getData().add(new XYChart.Data<>("Febbraio", 2000));
        series.getData().add(new XYChart.Data<>("Marzo", 3000));
        series.getData().add(new XYChart.Data<>("Aprile", 4000));
        series.getData().add(new XYChart.Data<>("Maggio", 1000));
        series.getData().add(new XYChart.Data<>("Giugno", 6000));
        series.getData().add(new XYChart.Data<>("Luglio", 5000));
        series.getData().add(new XYChart.Data<>("Agosto", 8000));
        series.getData().add(new XYChart.Data<>("Settembre", 9000));
        lineChart.getData().add(series);
    }
    @FXML
    protected void dipendenti(){
        System.out.println("Dipendenti");
    }
    @FXML
    protected void home(){
        System.out.println("Home");
        graficoFunz();
    }
    @FXML
    protected void regAtt(){
        System.out.println("RegAtt");
    }
}