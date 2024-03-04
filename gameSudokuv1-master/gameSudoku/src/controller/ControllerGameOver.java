package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.io.IOException;

public class ControllerGameOver {

    @FXML
    private Button buttonRegresar;

    @FXML
    void regresarHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/homeInterface.fxml"));
        Scene scene = new Scene(root, 740, 530);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("");
        stage.setResizable(false);
        stage.show();

        Stage sta = (Stage) this.buttonRegresar.getScene().getWindow();
        sta.close();
    }

}
