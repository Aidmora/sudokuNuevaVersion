package controller;

import BusinessLogic.entities.ArbolBB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ControllerTiempos {
    private ArbolBB arbolBB;

    public ControllerTiempos (){
        inicializarRecursos();
        mostrarArbol();
        generarArbol();
    }
    private void generarArbol() {
        arbolBB.recorridoInorden();
    }

    private void inicializarRecursos() {
        arbolBB= new ArbolBB();
    }
    private boolean mostrarArbol() {
        String nombreArchivo = "registrosTiempos.txt";
        System.out.println("entro al metodo... ");
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("entro al while.. ");
                String[] campos = linea.split(","); // Suponemos que los campos están separados por coma
                int valorTiempo= Integer.parseInt(campos[0]);
                arbolBB.insertarNodo(valorTiempo);

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de registros: " + e.getMessage());
        }
        return false; // No se encontraron credenciales coincidentes
    }

}
