package BusinessLogic.entities;
public class SudokuGrid {
    private NodoLs[] cuadricula;
    private NodoLs verificarNod;

    public SudokuGrid() {
        cuadricula = new NodoLs[9];
        for (int i = 0; i < 9; i++) {
            cuadricula[i] = new NodoLs(); // Crea una nueva fila
        }
    }

    public void inicializarCuadricula(String[][] valores) {
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                actual.setINFO(valores[i][j]);
                if (j < 8) {
                    NodoLs Q = new NodoLs();
                    actual.setLIGA(Q);
                    Q.setLIGA(null); // Avanza al siguiente nodo
                    actual = actual.getLIGA();
                }
            }
        }
    }

    public NodoLs[] getCuadricula() {
        return cuadricula;
    }

    public SudokuGrid createSudokuGrid() {
        String[][] valores = {
                { "5", "3", "", "", "7", "", "", "", "" },
                { "6", "", "", "1", "9", "5", "", "", "" },
                { "", "9", "8", "", "", "", "", "6", "" },
                { "8", "", "", "", "6", "", "", "", "3" },
                { "4", "", "", "8", "", "3", "", "", "1" },
                { "7", "", "", "", "2", "", "", "", "6" },
                { "", "6", "", "", "", "", "2", "8", "" },
                { "", "", "", "4", "1", "9", "", "", "5" },
                { "", "", "", "", "8", "", "", "7", "9" }
        };

        SudokuGrid sudokuGrid = new SudokuGrid();
        sudokuGrid.inicializarCuadricula(valores);
        return sudokuGrid;
    }

    public void imprimirSudokuGrid(SudokuGrid sudokuGrid) {
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                System.out.print(actual.getINFO() + " ");
                actual = actual.getLIGA();
            }
            System.out.println();
        }
    }

    public boolean validarSudokuFila(SudokuGrid sudokuGrid) {
        boolean bandera = true;
        int contador;
        String valorSiguiente;
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();
        for (int i = 0; i < 9; i++) {
            NodoLs actual = cuadricula[i];
            for (int j = 0; j < 9; j++) {
                System.out.print(actual.getINFO() + " ");
                if (!(actual.getINFO().equals(""))) {
                    contador = 0;
                    NodoLs actual2 = cuadricula[i];
                    for (int j2 = 0; j2 < 9; j2++) {
                        if (!(actual2.getINFO().equals(""))) {
                            valorSiguiente = actual2.getINFO();
                            System.out.println(valorSiguiente);
                            if (actual.getINFO().toString().equals(valorSiguiente)) {
                                contador = contador + 1;
                            }
                        }
                        actual2 = actual2.getLIGA();
                    }
                    if (contador > 1) {
                        bandera = false;
                        return bandera;
                    } else if (contador == 1) {
                        bandera = true;
                    }
                }
                actual = actual.getLIGA();
            }
            System.out.println();
        }
        return bandera;
    }

    public boolean validarSudokuColumna(SudokuGrid sudokuGrid) {
        boolean bandera = true;
        int contadorComp, posicion;
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();
        posicion = 0;
        NodoLs actual = cuadricula[0];
        for (int i = 0; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (!(actual.getINFO().equals(""))) {
                    contadorComp = 0;
                    for (int k = 0; k < 9; k++) {
                        int mover = 0;
                        NodoLs nodoSig = cuadricula[k];
                        while (mover < posicion) {
                            nodoSig = nodoSig.getLIGA();
                            mover++;
                        }
                        if (actual.getINFO().equals(nodoSig.getINFO())) {
                            contadorComp++;
                        }

                    }

                    if (contadorComp > 1) {
                        bandera = false;
                        return bandera;
                    }

                }
                actual = cuadricula[j];
                int siguiente = 0;
                while (siguiente < posicion) {
                    actual = actual.getLIGA();
                    siguiente++;
                }

            }
            posicion++;

            actual = cuadricula[0];
            int siguiente = 0;
            while (siguiente < posicion) {
                actual = actual.getLIGA();
                siguiente++;
            }

        }

        return bandera;
    }
    public boolean validarMatriz(SudokuGrid sudokuGrid) {
        boolean bandera = true;
        int contadorComp1, contadorComp2, contadorComp3, valorReferencia;
        NodoLs[] cuadricula = sudokuGrid.getCuadricula();


        valorReferencia = 0;
        while (valorReferencia < 9) {

            // Comparacion primera columna de matrices
            for (int i = valorReferencia; i < (valorReferencia + 3); i++) {
                NodoLs nodoActual = cuadricula[i];
                for (int j = 0; j < 3; j++) {
                    if (!(nodoActual.getINFO().equals(""))) {
                        contadorComp1 = 0;
                        for (int k = valorReferencia; k < (valorReferencia + 3); k++) {
                            NodoLs actual2 = cuadricula[k];
                            for (int l = 0; l < 3; l++) {
                                if (nodoActual.getINFO().equals(actual2.getINFO())) {
                                    contadorComp1 += 1;
                                }
                                actual2 = actual2.getLIGA();
                            }
                        }

                        if (contadorComp1 > 1) {
                            bandera = false;
                            return bandera;
                        }
                    }
                    nodoActual = nodoActual.getLIGA();
                }
            }

            // Comparacion segunda columna de matrices
            for (int i = valorReferencia; i < (valorReferencia + 3); i++) {
                NodoLs nodoReferencia = cuadricula[i];
                //Iterando hacia cuadriculas interiores
                for (int j = 0; j < 3; j++) {
                    nodoReferencia = nodoReferencia.getLIGA();
                }

                for (int j = 0; j < 3; j++) {
                    if (!(nodoReferencia.getINFO().equals(""))) {
                        contadorComp2 = 0;
                        for (int k = valorReferencia; k < (valorReferencia + 3); k++) {
                            NodoLs actual = cuadricula[k];
                            int posicion = 0;
                            while (posicion < 3) {
                                actual = actual.getLIGA();
                                posicion++;
                            }
                            for (int l = 0; l < 3; l++) {
                                if (nodoReferencia.getINFO().equals(actual.getINFO())) {
                                    contadorComp2 += 1;
                                }
                                actual = actual.getLIGA();
                            }
                        }

                        if (contadorComp2 > 1) {
                            bandera = false;
                            return bandera;
                        }

                    }
                    nodoReferencia = nodoReferencia.getLIGA();
                }

            }

            // Comparacion tercera columna de matrices
            for (int i = valorReferencia; i < (valorReferencia + 3); i++) {
                NodoLs nodoReferencia = cuadricula[i];
                //Iterando hacia cuadriculas interiores
                for (int j = 0; j < 6; j++) {
                    nodoReferencia = nodoReferencia.getLIGA();
                }

                for (int j = 0; j < 3; j++) {
                    if (!(nodoReferencia.getINFO().equals(""))) {
                        contadorComp3 = 0;
                        for (int k = valorReferencia; k < (valorReferencia + 3); k++) {
                            NodoLs actual = cuadricula[k];
                            int posicion = 0;
                            while (posicion < 6) {
                                actual = actual.getLIGA();
                                posicion++;
                            }
                            for (int l = 0; l < 3; l++) {
                                if (nodoReferencia.getINFO().equals(actual.getINFO())) {
                                    contadorComp3 += 1;
                                }
                                actual = actual.getLIGA();
                            }
                        }

                        if (contadorComp3 > 1) {
                            bandera = false;
                            return bandera;
                        }

                    }
                    nodoReferencia = nodoReferencia.getLIGA();
                }

            }


            valorReferencia += 3;
        }


        return bandera;
    }
}
