package BusinessLogic.entities;

import player.Jugador;

public class Pila {
    private Jugador [] Pila1;
    private int TOPE;
    private int MAX;

    public Pila(int MAX) {
        this.TOPE = 0;
        this.MAX = MAX;
        this.Pila1  = new Jugador[this.MAX+1];
    }

    public Jugador[] getPila1() {
        return Pila1;
    }

    public void insertarPila(Jugador jugador){
        this.TOPE++;
        this.Pila1[this.TOPE] = jugador;
    }

    public int buscarUsuario(String nombreUsuario){
        int n = -1;
        for(int i = 0; i<Pila1.length;i++){
            if(Pila1[i].getNombreUsuario().equals(nombreUsuario)){
                n = i;
                break;
            }
        }
        return n;
    }
}
