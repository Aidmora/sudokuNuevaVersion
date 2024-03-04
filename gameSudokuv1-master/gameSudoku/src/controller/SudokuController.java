package controller;

import BusinessLogic.entities.NodoLs;
import BusinessLogic.entities.SudokuGrid;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import player.Jugador;
import java.util.Timer;
import java.util.TimerTask;


import java.io.IOException;
public class SudokuController {
    public SudokuGrid sudokuGrid;
    private Jugador jugador;

    @FXML
    private TextField txtVidas;
    @FXML
    private TextField txtTimer;
    private Timer timer;
    private int segundos = 0;
    @FXML
    private GridPane sudokuGridPane;
    private VBox[][] vbox;
    @FXML
    private VBox vboxPrueba, vboxPrueba2,vboxPrueba3,vboxPrueba4,vboxPrueba5,vboxPrueba6,vboxPrueba7,vboxPrueba8,vboxPrueba9
                , vboxPrueba1,vboxPrueba12,vboxPrueba13,vboxPrueba14,vboxPrueba15,vboxPrueba16,vboxPrueba17,vboxPrueba18,vboxPrueba19
                ,vboxPrueba20,vboxPrueba21,vboxPrueba22,vboxPrueba23,vboxPrueba24,vboxPrueba25,vboxPrueba26,vboxPrueba27,vboxPrueba28
                ,vboxPrueba30,vboxPrueba31,vboxPrueba32,vboxPrueba33,vboxPrueba34,vboxPrueba35,vboxPrueba36,vboxPrueba37,vboxPrueba38
                ,vboxPrueba40,vboxPrueba41,vboxPrueba42,vboxPrueba43,vboxPrueba44,vboxPrueba45,vboxPrueba46,vboxPrueba47,vboxPrueba48
                ,vboxPrueba50,vboxPrueba51,vboxPrueba52,vboxPrueba53,vboxPrueba54,vboxPrueba55,vboxPrueba56,vboxPrueba57,vboxPrueba58
                ,vboxPrueba60,vboxPrueba61,vboxPrueba62,vboxPrueba63,vboxPrueba64,vboxPrueba65,vboxPrueba66,vboxPrueba67,vboxPrueba68
                ,vboxPrueba70,vboxPrueba71,vboxPrueba72,vboxPrueba73,vboxPrueba74,vboxPrueba75,vboxPrueba76,vboxPrueba77,vboxPrueba78
                ,vboxPrueba80,vboxPrueba81,vboxPrueba82,vboxPrueba83,vboxPrueba84,vboxPrueba85,vboxPrueba86,vboxPrueba87,vboxPrueba88;
    public SudokuController(){
         sudokuGrid= new SudokuGrid();

    }
    public void initialize() {
        // Player
        jugador = new Jugador("RicardoDaniel",10);

        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                segundos++;
                txtTimer.setText("Tiempo: " + segundos + " segundos");
            }
        }, 0, 1000); // 1000ms = 1 segundo



            inicializarEstructuras();
            sudokuGrid = sudokuGrid.createSudokuGrid();
            NodoLs[] cuadricula = sudokuGrid.getCuadricula();
             // Generar la cuadrícula de VBox con un bucle
                for (int row = 0; row < 9; row++) {
                    NodoLs actual = cuadricula[row];
                    for (int col = 0; col < 9; col++) {
                        VBox vBox = new VBox();
                        vbox[row][col] = vBox;
                        fila0Sudoku(row, col, actual);
                        fila1Sudoku(row, col, actual);
                        fila2Sudoku(row, col, actual);
                        fila3Sudoku(row, col, actual);
                        fila4Sudoku(row, col, actual);
                        fila5Sudoku(row, col, actual);
                        fila6Sudoku(row, col, actual);
                        fila7Sudoku(row, col, actual);
                        fila8Sudoku(row, col, actual);
                        actual = actual.getLIGA();
                    }
            }

    }

    private void fila0Sudoku(int row, int col, NodoLs actual) {
            if (row == 0 && col == 0) {
                TextField textField = (TextField) vboxPrueba.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudokuuu no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 1) {
                TextField textField = (TextField) vboxPrueba2.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba2.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba2.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 2) {
                TextField textField = (TextField) vboxPrueba3.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba3.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba3.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 3) {
                TextField textField = (TextField) vboxPrueba4.getChildren().get(0);
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba4.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba4.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 4) {
                TextField textField = (TextField) vboxPrueba5.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        actual.setINFO(textField.getText().toString());
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba5.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba5.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 5) {
                TextField textField = (TextField) vboxPrueba6.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba6.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba6.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 6) {
                TextField textField = (TextField) vboxPrueba7.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba7.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba7.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            } else if (row == 0 && col == 7) {
                TextField textField = (TextField) vboxPrueba8.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba8.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba8.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });

                }
            } else if (row == 0 && col == 8) {
                TextField textField = (TextField) vboxPrueba9.getChildren().get(0);
                textField.setText(actual.getINFO().toString());
                textField.getStyleClass().add("text-field-custom");
                if (!(actual.getINFO().toString().equals(""))) {
                    textField.setEditable(false);
                } else if (actual.getINFO().toString().equals("")) {
                    textField.textProperty().addListener((observable, oldValue, newValue) -> {
                        verificarLetras(actual, newValue, textField);
                        boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                        boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                        boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                        if (verificar == true && verificar2 == true && verificar3 == true) {
                            System.out.println("Sudoku valido ");
                            textField.setText(actual.getINFO().toString());
                            textField.getStyleClass().add("text-field-custom");
                            System.out.println("Nuevo valor ingresado en fila:  " + row + "y columna: " + col + " el valor de: " + newValue);
                            if (!textField.getText().toString().equals("")) {
                                vboxPrueba9.setStyle("-fx-background-color: #EEF500;");
                            }
                        } else if (verificar == false || verificar2 == false || verificar3 == false) {
                            vboxPrueba9.setStyle("-fx-background-color: #900C3F;");
                            actual.setINFO("");
                            System.out.println("Sudoku no  valido ");
                            int valVidas = jugador.intentoIncorrecto();
                            actualizadorDeVidas(valVidas,textField);
                        }
                    });
                }
            }
    }

    private static void verificarLetras(NodoLs actual, String newValue, TextField textField) {
        if (newValue.matches("[1-9]")) {
            actual.setINFO(newValue);
            actual.setINFO(textField.getText().toString());

        } else {
            System.out.println("Valor no aceptado");
        }
    }

    private void fila1Sudoku(int row, int col, NodoLs actual) {
        if (row ==1 && col ==0){
            TextField textField= (TextField) vboxPrueba1.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba1.setStyle("-fx-background-color: #7BF700 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba1.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==1){
            TextField textField= (TextField) vboxPrueba12.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba12.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba12.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==2){
            TextField textField= (TextField) vboxPrueba13.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba13.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba13.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }

                });
            }
        }else if(row ==1 && col ==3){
            TextField textField= (TextField) vboxPrueba14.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba14.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba14.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==4){
            TextField textField= (TextField) vboxPrueba15.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba15.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba15.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==5){
            TextField textField= (TextField) vboxPrueba16.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba16.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba16.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==6){
            TextField textField= (TextField) vboxPrueba17.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba17.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba17.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==1 && col ==7){
            TextField textField= (TextField) vboxPrueba18.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba18.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba18.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==1 && col ==8){
            TextField textField= (TextField) vboxPrueba19.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba19.setStyle("-fx-background-color: #7BF700;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba19.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila2Sudoku(int row, int col, NodoLs actual) {
        if (row ==2 && col ==0){
            TextField textField= (TextField) vboxPrueba20.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba20.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba20.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==1){
            TextField textField= (TextField) vboxPrueba21.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba21.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba21.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==2){
            TextField textField= (TextField) vboxPrueba22.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba22.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba22.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==3){
            TextField textField= (TextField) vboxPrueba23.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar== true && verificar2==true  && verificar3== true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba23.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba23.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==4){
            TextField textField= (TextField) vboxPrueba24.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true ){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba24.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar==false  || verificar2== false || verificar3 == false ){
                        vboxPrueba24.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==5){
            TextField textField= (TextField) vboxPrueba25.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true ){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba25.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba25.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==6){
            TextField textField= (TextField) vboxPrueba26.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true ){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba26.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba26.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==2 && col ==7){
            TextField textField= (TextField) vboxPrueba27.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba27.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba27.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==2 && col ==8){
            TextField textField= (TextField) vboxPrueba28.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba28.setStyle("-fx-background-color: #F79200 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba28.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila3Sudoku(int row, int col, NodoLs actual) {
        if (row ==3 && col ==0){
            TextField textField= (TextField) vboxPrueba30.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba30.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba30.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==1){
            TextField textField= (TextField) vboxPrueba31.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba31.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba31.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==2){
            TextField textField= (TextField) vboxPrueba32.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba32.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba32.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==3){
            TextField textField= (TextField) vboxPrueba33.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba33.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba33.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==4){
            TextField textField= (TextField) vboxPrueba34.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba34.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba34.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==5){
            TextField textField= (TextField) vboxPrueba35.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba35.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba35.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==6){
            TextField textField= (TextField) vboxPrueba36.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba36.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba36.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==3 && col ==7){
            TextField textField= (TextField) vboxPrueba37.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba37.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba37.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==3 && col ==8){
            TextField textField= (TextField) vboxPrueba38.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba38.setStyle("-fx-background-color: #00F7E8 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba38.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila4Sudoku(int row, int col, NodoLs actual) {
        if (row ==4 && col ==0){
            TextField textField= (TextField) vboxPrueba40.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba40.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba40.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==1){
            TextField textField= (TextField) vboxPrueba41.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba41.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba41.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==2){
            TextField textField= (TextField) vboxPrueba42.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba42.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba42.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==3){
            TextField textField= (TextField) vboxPrueba43.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba43.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba43.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row == 4 && col ==4){
            TextField textField= (TextField) vboxPrueba44.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba44.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba44.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==5){
            TextField textField= (TextField) vboxPrueba45.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba45.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba45.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==6){
            TextField textField= (TextField) vboxPrueba46.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba46.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba46.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==4 && col ==7){
            TextField textField= (TextField) vboxPrueba47.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba47.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba47.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==4 && col ==8){
            TextField textField= (TextField) vboxPrueba48.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba48.setStyle("-fx-background-color: #D100F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba48.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila5Sudoku(int row, int col, NodoLs actual) {
        if (row ==5 && col ==0){
            TextField textField= (TextField) vboxPrueba50.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba50.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba50.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==1){
            TextField textField= (TextField) vboxPrueba51.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba51.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba51.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==2){
            TextField textField= (TextField) vboxPrueba52.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba52.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba52.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==3){
            TextField textField= (TextField) vboxPrueba53.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba53.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba53.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row == 5 && col ==4){
            TextField textField= (TextField) vboxPrueba54.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba54.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba54.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==5){
            TextField textField= (TextField) vboxPrueba55.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba55.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba55.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==6){
            TextField textField= (TextField) vboxPrueba56.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba56.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba56.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==5 && col ==7){
            TextField textField= (TextField) vboxPrueba57.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba57.setStyle("-fx-background-color:#7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba57.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==5 && col ==8){
            TextField textField= (TextField) vboxPrueba58.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba58.setStyle("-fx-background-color: #7800F7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba58.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila6Sudoku(int row, int col, NodoLs actual) {
        if (row ==6 && col ==0){
            TextField textField= (TextField) vboxPrueba60.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba60.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba61.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==1){
            TextField textField= (TextField) vboxPrueba61.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba61.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba61.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==2){
            TextField textField= (TextField) vboxPrueba62.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba62.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba62.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==3){
            TextField textField= (TextField) vboxPrueba63.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba63.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba63.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row == 6 && col ==4){
            TextField textField= (TextField) vboxPrueba64.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba64.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba64.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==5){
            TextField textField= (TextField) vboxPrueba65.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba65.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba65.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==6){
            TextField textField= (TextField) vboxPrueba66.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba66.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba66.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==6 && col ==7){
            TextField textField= (TextField) vboxPrueba67.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba67.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba67.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==6 && col ==8){
            TextField textField= (TextField) vboxPrueba68.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba68.setStyle("-fx-background-color: #000BF7 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba68.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    private void fila7Sudoku(int row, int col, NodoLs actual) {
        if (row ==7 && col ==0){
            TextField textField= (TextField) vboxPrueba70.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba70.setStyle("-fx-background-color:#7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba70.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==1){
            TextField textField= (TextField) vboxPrueba71.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba71.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba71.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==2){
            TextField textField= (TextField) vboxPrueba72.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba72.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba72.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==3){
            TextField textField= (TextField) vboxPrueba73.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba73.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba73.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row == 7 && col ==4){
            TextField textField= (TextField) vboxPrueba74.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba74.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba74.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==5){
            TextField textField= (TextField) vboxPrueba75.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba75.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba75.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==6){
            TextField textField= (TextField) vboxPrueba76.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba76.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba76.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==7 && col ==7){
            TextField textField= (TextField) vboxPrueba77.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba77.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba77.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==7 && col ==8){
            TextField textField= (TextField) vboxPrueba78.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba78.setStyle("-fx-background-color: #7B4906 ;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba78.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }

                });
            }
        }
    }
    private void fila8Sudoku(int row, int col, NodoLs actual)  {
        if (row ==8 && col ==0){
            TextField textField= (TextField) vboxPrueba80.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba80.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba80.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==1){
            TextField textField= (TextField) vboxPrueba81.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba81.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba81.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==2){
            TextField textField= (TextField) vboxPrueba82.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba82.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba82.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==3){
            TextField textField= (TextField) vboxPrueba83.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba83.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba83.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row == 8 && col ==4){
            TextField textField= (TextField) vboxPrueba84.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba84.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba84.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==5){
            TextField textField= (TextField) vboxPrueba85.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba85.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba85.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==6){
            TextField textField= (TextField) vboxPrueba86.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba86.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba86.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }else if(row ==8 && col ==7){
            TextField textField= (TextField) vboxPrueba87.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba87.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba87.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });

            }
        }else if(row ==8 && col ==8){
            TextField textField= (TextField) vboxPrueba88.getChildren().get(0);
            textField.setText(actual.getINFO().toString());
            textField.getStyleClass().add("text-field-custom");
            if (!(actual.getINFO().toString().equals(""))){
                textField.setEditable(false);
            }else if (actual.getINFO().toString().equals("")){
                textField.textProperty().addListener((observable, oldValue, newValue) -> {
                    verificarLetras(actual, newValue, textField);
                    boolean verificar = sudokuGrid.validarSudokuFila(sudokuGrid);
                    boolean verificar2 = sudokuGrid.validarSudokuColumna(sudokuGrid);
                    boolean verificar3 = sudokuGrid.validarMatriz(sudokuGrid);
                    if (verificar==true  && verificar2== true  && verificar3==true){
                        System.out.println("Sudoku valido ");
                        textField.setText(actual.getINFO().toString());
                        textField.getStyleClass().add("text-field-custom");
                        System.out.println("Nuevo valor ingresado en fila:  "+ row+ "y columna: "+col +" el valor de: "+ newValue);
                        if(!textField.getText().toString().equals("")){
                            vboxPrueba88.setStyle("-fx-background-color: #000000;");
                        }
                    }else if (verificar== false || verificar2 == false || verificar3== false){
                        vboxPrueba88.setStyle("-fx-background-color: #900C3F;");
                        actual.setINFO("");
                        System.out.println("Sudoku no  valido ");
                        int valVidas = jugador.intentoIncorrecto();
                        actualizadorDeVidas(valVidas,textField);
                    }
                });
            }
        }
    }
    public void inicializarEstructuras() {
        vbox = new VBox[9][9];
        sudokuGridPane= new GridPane();
    }
    private void actualizadorDeVidas(int valVidas, TextField textField) {
        txtVidas.setText("Número de vidas: "+valVidas);
        if(valVidas==1){
            txtVidas.setText("Ultima vida!!");
        }
        if(valVidas==0){
            int tiempoFinal = this.segundos;
            System.out.println("El tiempo total fue: " + tiempoFinal);
            timer.cancel();
            try {
                lanzarInterface();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Stage sta = (Stage) textField.getScene().getWindow();
            sta.close();
        }
    }

    private void lanzarInterface() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/gameOverInterface.fxml"));
        Scene scene = new Scene(root, 413, 254);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("");
        stage.setResizable(false);
        stage.show();
    }

}
