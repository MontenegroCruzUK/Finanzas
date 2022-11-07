/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author montenegro
 */
public class MainController implements Initializable {

    @FXML
    private Button btn_Informe;
    @FXML
    private Button btn_Ingreso;
    @FXML
    private Button btn_GastosFijos;
    @FXML
    private Button btn_Compras;
    @FXML
    private Button btn_Ocio;
    @FXML
    private Button btn_GastosExtra;
    @FXML
    private Button btn_Configuracion;
    @FXML
    private StackPane stackPnl_ContentArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        mostrarPane("/views/InformeView.fxml");
    }

    @FXML
    private void IrAPane(ActionEvent event) {

        if (event.getSource().equals(this.btn_Informe)) {
            mostrarPane("/views/InformeView.fxml");
        } else if (event.getSource().equals(this.btn_Ingreso)) {
            mostrarPane("/views/IngresosView.fxml");

        } else if (event.getSource().equals(this.btn_GastosFijos)) {
            mostrarPane("/views/GastosFijosView.fxml");

        } else if (event.getSource().equals(this.btn_Compras)) {
            mostrarPane("/views/ComprasView.fxml");

        } else if (event.getSource().equals(this.btn_Ocio)) {
            mostrarPane("/views/OcioView.fxml");

        } else if (event.getSource().equals(this.btn_GastosExtra)) {
            mostrarPane("/views/GastosExtrasView.fxml");

        } else if (event.getSource().equals(this.btn_Configuracion)) {
            mostrarPane("/views/ConfiguracionView.fxml");

        }
    }

    private void mostrarPane(String url) {
        try {
            Pane fxml = FXMLLoader.load(getClass().getResource(url));
            stackPnl_ContentArea.getChildren().removeAll();
            stackPnl_ContentArea.getChildren().setAll(fxml);
        } catch (IOException e) {
            System.out.println("No se puede cargar la ventana\n" + e.toString());
        }

    }

}
