package controller;

import BusinessLogic.entities.ColaSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerHome {
    private ColaSimple colaSimple;
    private String nombreUsuario2, usuarioEncontrado;
    @FXML
    private Button buttonJugar;

    @FXML
    private Button buttonReglas;
    @FXML
    private TextField nombreUsuario;

    @FXML
    private Button buttonSalir;
    public void setColaSimple(ColaSimple colaSimple, String nombreUsuarioI) {
        this.colaSimple = colaSimple;
        this.nombreUsuario2 = nombreUsuarioI;
        System.out.println(colaSimple.toString() + "Esto en el controller de home");
        usuarioEncontrado= encontrarUsuarioConectado(this.colaSimple, nombreUsuario2);
        System.out.println("El nombre encontrado es " + usuarioEncontrado);
        nombreUsuario.setText(usuarioEncontrado);
        nombreUsuario.setEditable(false);

    }
    public void inicializarRecursos(){

    }
    @FXML
    void jugar (ActionEvent event) throws IOException {
        // Agregar verificacion
        Stage sta = (Stage) this.buttonJugar.getScene().getWindow();
        sta.close();

        // Abre nueva ventana
        Parent root = FXMLLoader.load(getClass().getResource("/view/cuadriculaSudoku.fxml"));
        Scene scene = new Scene(root, 755, 600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Juego Sudoku");
        stage.setResizable(false);
        stage.show();


        /*
         * Utilizar Alert para confirmar la informacion ingresada con la base de datos
         */
    }

    @FXML
    void mostrarReglas(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/reglasInterface.fxml"));
        Scene scene = new Scene(root, 695, 488);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Reglas");
        stage.setResizable(false);
        stage.showAndWait();

    }

    @FXML
    void regresarLogin(ActionEvent event) throws IOException {
        Stage sta = (Stage) this.buttonSalir.getScene().getWindow();
        sta.close();

        Parent root = FXMLLoader.load(getClass().getResource("/view/loginInterface.fxml"));
        Scene scene = new Scene(root, 600, 400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("");
        stage.setResizable(false);
        stage.show();

    }
    public String encontrarUsuarioConectado(ColaSimple colaSimple, String nombreUsuario){
        String nombreEncontrado="";
        nombreEncontrado = colaSimple.busquedaDatoCola(colaSimple,nombreUsuario);
        return nombreEncontrado;
    }
}
