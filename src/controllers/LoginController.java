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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Login;
import models.LoginDado;

/**
 * FXML Controller class
 *
 * @author montenegro
 */
public class LoginController implements Initializable {

    Login login = new Login();
    LoginDado loginDado = new LoginDado();
    @FXML
    private TextField txt_CorreoUno;
    @FXML
    private CheckBox checkB_RecuerdameUno;
    @FXML
    private TextField txt_CorreoDos;
    @FXML
    private PasswordField txt_PassworUno1;
    @FXML
    private Label lb_NombreUno;
    @FXML
    private Label lb_NombreDos;
    @FXML
    private Button btn_Entrar;

    public LoginController() {
    }

    @FXML
    private PasswordField txt_PassworUno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void modificar(MouseEvent event) {
        System.out.println("Estamos trabajando en ello");
    }

    @FXML
    private void ingresar(ActionEvent event) {
        System.out.println("Abriendo el boton entrar ");

        String correo = this.txt_CorreoUno.getText();
        String password = String.valueOf(this.txt_PassworUno.getText());

        if (!"".equals(correo) || !"".equals(password)) {
            login = loginDado.setLogin(correo, password);
            if (login.getCorreo() != null && login.getPassword() != null) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/MainView.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    Stage myStage = (Stage) this.btn_Entrar.getScene().getWindow();
                    myStage.close();

                } catch (IOException ex) {
                    System.out.println("Error en el lanzador de la ventana " + ex.toString());
                }

            } else {
                System.out.println("Error en la base de datos");
            }
        } else {
            System.out.println("Error Los campos no coinciden");
        }

        System.out.println("Cerrando el boton entrar ");
    }

}
