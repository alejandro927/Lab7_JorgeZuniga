/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JProgressBar;

/**
 *
 * @author Alejandro
 */
public class HiloFaseAnalisis extends Thread {

    private boolean vivo;
    private JTable tabla;
    private String error;
    private int Puntos;
    private int FaltaEtapa;
    private JProgressBar ProgressBar;
    private int lexico;
    private int sintactico;
    private int semantico;

    public HiloFaseAnalisis(JProgressBar ProgressBar, boolean vivo, int lexico, int sintactico, int semantico, JTable tabla) {
        this.ProgressBar = ProgressBar;
        this.vivo = vivo;
        this.tabla = tabla;
        this.lexico = lexico;
        this.lexico = sintactico;
        this.lexico = semantico;
    }
    
    public JProgressBar getProgressBar() {
        return ProgressBar;
    }

    public void setProgressBar(JProgressBar ProgressBar) {
        this.ProgressBar = ProgressBar;
    }

    @Override
    public void run() {
        //suciedad 5: 8s 
        //suciedad 4: 6s
        //suciedad 3: 4s
        while (ProgressBar.getValue() < ProgressBar.getMaximum()) {
            if (vivo) {
                ProgressBar.setValue(ProgressBar.getValue());
                int time = 5;
                if (lexico < 300) {
                    error = "Error en lexico";
                    FaltaEtapa = 300 - lexico;
                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);
                } else if (lexico >= 300) {
                    Puntos = Puntos + 15;
                } else if (sintactico < 300) {
                    System.out.println("Error en Sintactico");
                    error = "Error en Sintactico";
                    FaltaEtapa = 300 - sintactico;
                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);
                } else if (sintactico >= 300) {
                    Puntos = Puntos + 15;
                } else if (semantico < 800) {
                    error = "Error en Semantico";
                    System.out.println("Error en Semantico");
                    FaltaEtapa = 800 - semantico;
                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);
                } else if (semantico >= 800) {
                    Puntos = Puntos + 20;
                }

            }
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloFaseAnalisis.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //((DefaultListModel)tabla.getModel()).removeElement(compi.getNombreCreador());
        System.out.println("Fase Analisis terminada!");
    }
}
