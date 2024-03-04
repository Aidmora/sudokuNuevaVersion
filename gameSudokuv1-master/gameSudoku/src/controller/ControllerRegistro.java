package controller;

import BusinessLogic.entities.ColaSimple;
import BusinessLogic.entities.Pila;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.*;

public class ControllerRegistro {

    @FXML
    private Button btnRegistrar;

    @FXML
    private TextField txtApellido;

    @FXML
    private PasswordField txtContrasenia;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtNombreUsuario;
    private Pila pila;
    public static ColaSimple colaSimple;
    @FXML
    void registrarUsuario(ActionEvent event) {
        String nombre, apellido, nombreUsuario, contrasenia;
        nombre = txtNombre.getText();
        apellido = txtApellido.getText();
        contrasenia = txtContrasenia.getText();
        nombreUsuario = txtNombreUsuario.getText();
        guardarRegistro("registrosUsuarios.txt",nombreUsuario+","+contrasenia);

    }
    public static void guardarRegistro(String nombreArchivo, String registro) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true));
            writer.write(registro);
            writer.newLine();
            writer.close();
            System.out.println("Registro guardado exitosamente en " + nombreArchivo);
            int numeroLineas= contarLineas("registrosUsuarios.txt");
            System.out.println("El numero de lineas es: "+numeroLineas+"");
            colaSimple = new ColaSimple(numeroLineas);
            insertarDatoCola(colaSimple);

        } catch (IOException e) {
            System.err.println("Error al guardar el registro: " + e.getMessage());
        }
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
