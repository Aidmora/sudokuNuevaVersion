package BusinessLogic.entities;

public class ColaSimple {
    // Atributos
    private String cola1[]; // arreglo unidimensional
    private int frente = -1; // variable auxialiar frente, permite eliminar elementos a partir de su
    // posición.
    private int FIN = -1; // variable auxiliar fin, permite la inserción de elementos a partir de su
    // posición.

    // constructor por defecto
    public ColaSimple() {
        super();
    }

    public int getFIN() {
        return FIN;
    }
    // Constructor para inicializar el arreglo unidimensioonal "cola1"
    public ColaSimple(int dimension) {
        this.cola1 = new String[dimension];
    }

    // Método para devolver la cola (arreglo)
    public String[] getCola() {
        return cola1;
    }

    // Metodo para asignar un arreglo al atributo "cola1"
    public void setCola(String[] cola) {
        this.cola1 = cola;
    }

    // Metodo para insertar elementos en una cola
    public void InsertarCola(String nombre) {
        // condición para evaluar si la cola esta llena
        if (this.cola1.length == this.FIN + 1) {
        } else {
            this.FIN = this.FIN + 1; // aumento de la posición "FIN"
            this.cola1[this.FIN] = nombre; // inserción de dato en la cola
            // Condición para verificar la existencia de un solo elemento
            if (this.FIN == 0) {
                this.frente = 0;
            }
        }
    }

    // Método para mostrar como salida, los datos que conforman al arreglo
    public String toString() {
        String salida = "";
        for (int i = 0; i < this.cola1.length; i++) {
            salida += this.cola1[i] + "|";
        }
        return salida;
    }
    public String busquedaDatoCola(ColaSimple colaSimple, String nombreUsuario) {
        // Recorre la cola desde el frente hasta el fin
        for (int i = 0; i <= colaSimple.getFIN(); i++) {
            // Compara el nombre de usuario con el elemento actual de la cola
            if (colaSimple.getCola()[i].equals(nombreUsuario)) {
                return nombreUsuario;
            }
        }
        // Si no se encuentra el nombre de usuario en la cola
        return "No hay nombre de usuario";
    }

}
