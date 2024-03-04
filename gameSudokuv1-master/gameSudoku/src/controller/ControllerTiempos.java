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
    private TextField puntuacion1,puntuacion2,puntuacion3,puntuacion4,puntuacion5;

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
        int tamanoLista= listaTiempos.size();
        if (tamanoLista ==1 ){
            String salida= listaTiempos.get(0).toString() + " segundos";
            puntuacion1.setText(salida);
        }else if (tamanoLista==2){
            String salida1= listaTiempos.get(0).toString() + " segundos";
            String salida2= listaTiempos.get(1).toString()+ " segundos";
            puntuacion1.setText(salida1 + "\n");
            puntuacion2.setText(salida2 + "\n");
        }else if (tamanoLista==3){
            String salida1= listaTiempos.get(0).toString()+ " segundos";
            String salida2= listaTiempos.get(1).toString()+ " segundos";
            String salida3= listaTiempos.get(2).toString()+ " segundos";
            puntuacion1.setText(salida1 + "\n");
            puntuacion2.setText(salida2 + "\n");
            puntuacion3.setText(salida3 + "\n");
        }else if (tamanoLista==4){
            String salida1= listaTiempos.get(0).toString()+ " segundos";
            String salida2= listaTiempos.get(1).toString()+ " segundos";
            String salida3= listaTiempos.get(2).toString()+ " segundos";
            String salida4= listaTiempos.get(3).toString()+ " segundos";
            puntuacion1.setText(salida1 + "\n");
            puntuacion2.setText(salida2 + "\n");
            puntuacion3.setText(salida3 + "\n");
            puntuacion4.setText(salida4 + "\n");
        }else if (tamanoLista>=5){
            String salida1= listaTiempos.get(0).toString()+ " segundos";
            String salida2= listaTiempos.get(1).toString()+ " segundos";
            String salida3= listaTiempos.get(2).toString()+ " segundos";
            String salida4= listaTiempos.get(3).toString()+ " segundos";
            String salida5= listaTiempos.get(4).toString()+ " segundos";
            puntuacion1.setText(salida1 + "\n");
            puntuacion2.setText(salida2 + "\n");
            puntuacion3.setText(salida3 + "\n");
            puntuacion4.setText(salida4 + "\n");
            puntuacion4.setText(salida5+ "\n");
        }

    }




}
