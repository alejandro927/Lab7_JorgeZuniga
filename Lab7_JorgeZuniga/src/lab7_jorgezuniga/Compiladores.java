/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.io.Serializable;
import javax.swing.JTable;

/**
 *
 * @author Alejandro
 */
public class Compiladores implements Serializable {

    private String nombreCompilador;
    private String nombreCreador;
    private int Lexico;
    private int Sintactico;
    private int Semantico;
    private int Intermedio;
    private int optimizador;
    private int generador;
    private JTable Simbolos;
    
    private static final long SerialVersionUID = 777L;

    public Compiladores() {
    }

    public Compiladores(String nombreCompilador, String nombreCreador, int Lexico, int Sintactico, int Semantico, int Intermedio, int optimizador, int generador,JTable Simbolos) {
        this.nombreCompilador = nombreCompilador;
        this.nombreCreador = nombreCreador;
        this.Lexico = Lexico;
        this.Sintactico = Sintactico;
        this.Semantico = Semantico;
        this.Intermedio = Intermedio;
        this.optimizador = optimizador;
        this.generador = generador;
        this.Simbolos = Simbolos;
    }

    public JTable getSimbolos() {
        return Simbolos;
    }

    public void setSimbolos(JTable Simbolos) {
        this.Simbolos = Simbolos;
    }
    
    public String getNombreCompilador() {
        return nombreCompilador;
    }

    public void setNombreCompilador(String nombreCompilador) {
        this.nombreCompilador = nombreCompilador;
    }

    public String getNombreCreador() {
        return nombreCreador;
    }

    public void setNombreCreador(String nombreCreador) {
        this.nombreCreador = nombreCreador;
    }

    public int getLexico() {
        return Lexico;
    }

    public void setLexico(int Lexico) {
        this.Lexico = Lexico;
    }

    public int getSintactico() {
        return Sintactico;
    }

    public void setSintactico(int Sintactico) {
        this.Sintactico = Sintactico;
    }

    public int getSemantico() {
        return Semantico;
    }

    public void setSemantico(int Semantico) {
        this.Semantico = Semantico;
    }

    public int getIntermedio() {
        return Intermedio;
    }

    public void setIntermedio(int Intermedio) {
        this.Intermedio = Intermedio;
    }

    public int getOptimizador() {
        return optimizador;
    }

    public void setOptimizador(int optimizador) {
        this.optimizador = optimizador;
    }

    public int getGenerador() {
        return generador;
    }

    public void setGenerador(int generador) {
        this.generador = generador;
    }

    @Override
    public String toString() {
        return "Nombre Compilador=" + nombreCompilador + ", Nombre Creador=" + nombreCreador;
    }

}
