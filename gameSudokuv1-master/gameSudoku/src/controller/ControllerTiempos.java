package controller;

import BusinessLogic.entities.ArbolBB;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerTiempos {
    private ArbolBB arbolBB;
    private List<Integer> listaTiempos;
    @FXML
    private TextField txtPuntuaciones1;

    public ControllerTiempos (){
        inicializarRecursos();
    }
    @FXML
    private void initialize() {
        mostrarArbol();
        generarArbol();
        separarYMostrarEnTextArea(listaTiempos);
    }
    private void generarArbol() {
        listaTiempos= arbolBB.recorridoInorden();
    }

    private void inicializarRecursos() {
        arbolBB= new ArbolBB();
        listaTiempos = new ArrayList<>();
    }
    private boolean mostrarArbol() {
        String nombreArchivo = "registrosTiempos.txt";
        File archivo = new File(nombreArchivo);

        // Verificar si el archivo existe
        if (!archivo.exists()) {
            System.out.println("El archivo " + nombreArchivo + " no existe.");
            return false;
        }
        // El archivo existe, proceder con la lectura
        System.out.println("Entro al metodo...");
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("Entro al while.. ");
                String[] campos = linea.split(","); // Suponemos que los campos están separados por coma
                int valorTiempo = Integer.parseInt(campos[0]);
                arbolBB.insertarNodo(valorTiempo);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de registros: " + e.getMessage());
            return false;
        }
        return true;
    }

    private void separarYMostrarEnTextArea(List<Integer> listaTiempos) {

        for (int i = 0; i < listaTiempos.size(); i++) {
            String salida= separarTextArea(listaTiempos.get(i).toString());
            txtPuntuaciones1.setText(salida + "\n");
        }
    }

    public String separarTextArea(String tiempo){
        String salida = tiempo + "segundos";
        txtPuntuaciones1.setText(salida + "\n");
        return salida;
    }


}
