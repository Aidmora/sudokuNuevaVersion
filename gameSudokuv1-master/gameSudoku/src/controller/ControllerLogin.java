package controller;
import BusinessLogic.entities.ColaSimple;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerLogin {

    @FXML
    private Button buttonIngresar;

    @FXML
    private AnchorPane radioContrasenia;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtnombreUsuario;
    public ColaSimple colaSimple, colasimpleLogin;

    @FXML
    void IngresarSistema(ActionEvent event) throws IOException {
        String nombreUsuario= txtnombreUsuario.getText();
        String contrasenia= txtContrasenia.getText();
        System.out.println(contrasenia+""+nombreUsuario);
        // Verificar las credenciales
        if (verificarCredenciales(nombreUsuario, contrasenia)) {
            System.out.println("Inicio de sesión exitoso para el usuario: " + nombreUsuario);int numeroLineas= contarLineas("registrosUsuarios.txt");
            System.out.println("El numero de lineas es: "+numeroLineas+"");
            colaSimple = new ColaSimple(numeroLineas);
            insertarDatoCola(colaSimple);
            System.out.println(colaSimple.toString());
            Stage sta = (Stage) this.buttonIngresar.getScene().getWindow();
            sta.close();
            System.out.println(colaSimple.toString());
            // Abre nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homeInterface.fxml"));
            Parent root = loader.load();

            // Obtener una referencia al controlador ControllerHome
            ControllerHome controllerHome = loader.getController();

            // Pasar la cola simple al controlador ControllerHome
            controllerHome.setColaSimple(colaSimple, nombreUsuario);

            // Configurar y mostrar la ventana
            Scene scene = new Scene(root, 740, 530);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("");
            stage.setResizable(false);
            stage.show();
        } else {
            System.out.println("Credenciales incorrectas. No se pudo iniciar sesión.");
        }



    }

    @FXML
    void registrarUsuario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/registerInterface.fxml"));
        Scene scene = new Scene(root, 250, 399);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Register");
        stage.setResizable(false);
        stage.showAndWait();
    }
    private boolean verificarCredenciales(String nombreUsuario, String contrasenia) {
        String nombreArchivo = "registrosUsuarios.txt";
        System.out.println("entro al metodo... ");
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("entro al while.. ");
                String[] campos = linea.split(","); // Suponemos que los campos están separados por coma

                if (campos[0].trim().equals(nombreUsuario) && campos[1].trim().equals(contrasenia)) {
                    System.out.println(campos[0].toString());
                    System.out.println(campos[1].toString());
                    return true; // Credenciales correctas
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de registros: " + e.getMessage());
        }
        return false; // No se encontraron credenciales coincidentes
    }
    public static int contarLineas(String nombreArchivo) {
        int contador = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            while (reader.readLine() != null) {
                contador++;
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contador;
    }
    private static void insertarDatoCola(ColaSimple colaSimple) {
        String nombreArchivo = "registrosUsuarios.txt";
        System.out.println("entro al metodo... ");
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("entro al while.. ");
                String[] campos = linea.split(","); // Suponemos que los campos están separados por coma
                colaSimple.InsertarCola(campos[0].toString());
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de registros: " + e.getMessage());
        }
        System.out.println(colaSimple.toString()); ;
    }

}
