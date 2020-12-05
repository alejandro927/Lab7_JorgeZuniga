/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alejandro
 */
public class HiloFaseSintesis extends Thread{
    private boolean vivo;
    private JTable tabla;
    private String error;
    private int Puntos = 0;
    private int FPuntos;
    private int FaltaEtapa;
    private JProgressBar ProgressBar;
    private int intermedio;
    private int optimizador;
    private int generador;
    private String nombre;
    
   public HiloFaseSintesis(String nombre,JProgressBar ProgressBar, boolean vivo, int intermedio, int optimizador, int generadoor, JTable tabla) {
        this.ProgressBar = ProgressBar;
        this.vivo = vivo;
        this.tabla = tabla;
        this.intermedio = intermedio;
        this.optimizador = optimizador;
        this.generador = generador;
        this.nombre = nombre;
    }

    public void run() {
        
        while (ProgressBar.getValue() <= ProgressBar.getMaximum()-1) {
            if (vivo) {
                ProgressBar.setValue(ProgressBar.getValue() + 1);

                if (intermedio < 1200) {
                    error = "Error en lexico";
                    FaltaEtapa = 1200 - intermedio;
                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (intermedio >= 1200) {

                    Puntos = Puntos + 10;
                    System.out.println("sumo10=" + Puntos);

                }
                if (optimizador < 1200) {

                    System.out.println("Error en Sintactico");
                    error = "Error en Sintactico";
                    FaltaEtapa = 1200 - optimizador;

                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (optimizador >= 1200) {
                    Puntos = Puntos + 5;
                    System.out.println("sumo(2)15=" + Puntos);

                }
                if (generador < 500) {
                    error = "Error en Semantico";
                    System.out.println("Error en Semantico");
                    FaltaEtapa = 500 - generador;

                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (generador >= 500) {
                    Puntos = Puntos + 25;
                    System.out.println("sumo25=" + Puntos);
                }

            }
            FPuntos = Puntos;
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFaseAnalisis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        System.out.println("Fase Analisis terminada!");
        System.out.println("Los puntos son:" + (FPuntos - 110));
        AdministrarUsuarios ua = new AdministrarUsuarios("./UsuariosA.jz");
        for (int i = 0; i < ua.getListaUsuariosAlumnos().size(); i++) {
            if (ua.getListaUsuariosAlumnos().get(i).getNombre().equals(nombre)) {
                ua.getListaUsuariosAlumnos().get(i).setNota(FPuntos);
            }
        }
    }
    
}
