package controller;

import BusinessLogic.entities.ColaSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerGameOver {

    @FXML
    private Button buttonCerrar;
    public ColaSimple colaSimple;


    @FXML
    void cerrar(ActionEvent event) throws IOException {
        Stage sta = (Stage) this.buttonCerrar.getScene().getWindow();
        sta.close();
    }
}
