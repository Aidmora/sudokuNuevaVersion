package BusinessLogic.entities;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ARIEL
 */
public class ArbolBB {
    // Atributos del arbol ABB
    private Nodo2 raiz;

    // Constructores
    public ArbolBB() {
        super();
        this.raiz = null;
    }

    // getter y setter
    public Nodo2 getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo2 raiz) {
        this.raiz = raiz;
    }

    /**
     * insertarNodo: Este método permite insertar un nodo en el arbol ABB
     *
     * @param valorInsertar: tipo entero
     */
    public void insertarNodo(int valorInsertar) {
        if (this.raiz == null) {
            this.raiz = new Nodo2(valorInsertar);
        } else {
            this.raiz.insertar(valorInsertar);
        }
    }

    /**
     * buscarABB: Este método permite buscar una clave, dentro de un arbol.
     *
     * @param clave: tipo entero
     */
    /**
     * recorridoInorden: Esta funcion implementa a un ayudanteInorden, que ejecutara
     * el algoritmo correspondiente al recorridoInorden.
     */
    public List<Integer> recorridoInorden() {
        List<Integer> valoresInorden = new ArrayList<>();
        ayudanteInorden(this.raiz, valoresInorden);
        return valoresInorden;
    }

    private void ayudanteInorden(Nodo2 nodo, List<Integer> valores) {
        if (nodo == null) {
            return;
        }
        ayudanteInorden(nodo.getIZQ(), valores);
        valores.add(nodo.getInfo());
        ayudanteInorden(nodo.getDER(), valores);
    }


}

