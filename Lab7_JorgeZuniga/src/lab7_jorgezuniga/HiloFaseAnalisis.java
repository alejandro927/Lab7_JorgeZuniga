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
    private int Puntos = 0;
    private int FPuntos;
    private int FaltaEtapa;
    private JProgressBar ProgressBar;
    private int lexico;
    private int semantico;
    private int sintactico;
    private String nombre;

    public HiloFaseAnalisis(String nombre,JProgressBar ProgressBar, boolean vivo, int lexico, int sintactico, int semantico, JTable tabla) {
        this.ProgressBar = ProgressBar;
        this.vivo = vivo;
        this.tabla = tabla;
        this.lexico = lexico;
        this.sintactico = sintactico;
        this.semantico = semantico;
        this.nombre = nombre;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getFPuntos() {
        return FPuntos;
    }

    public void setFPuntos(int FPuntos) {
        this.FPuntos = FPuntos;
    }

    public int getFaltaEtapa() {
        return FaltaEtapa;
    }

    public void setFaltaEtapa(int FaltaEtapa) {
        this.FaltaEtapa = FaltaEtapa;
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
                ProgressBar.setValue(ProgressBar.getValue() + 50);

                if (lexico < 300) {
                    error = "Error en lexico";
                    FaltaEtapa = 300 - lexico;
                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (lexico >= 300) {

                    Puntos = Puntos + 15;
                    System.out.println("sumo15=" + Puntos);

                }
                if (sintactico < 300) {

                    System.out.println("Error en Sintactico");
                    error = "Error en Sintactico";
                    FaltaEtapa = 300 - sintactico;

                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (sintactico >= 300) {
                    Puntos = Puntos + 15;
                    System.out.println("sumo(2)15=" + Puntos);

                }
                if (semantico < 800) {
                    error = "Error en Semantico";
                    System.out.println("Error en Semantico");
                    FaltaEtapa = 800 - semantico;

                    Object row[] = {error + FaltaEtapa};
                    DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                    m.addRow(row);
                    tabla.setModel(m);

                } else if (semantico >= 800) {
                    Puntos = Puntos + 20;
                    System.out.println("sumo20=" + Puntos);
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
