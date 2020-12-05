/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Alejandro
 */
public class HiloFaseSintesis {
    private boolean vivo;
    private Compiladores compi;
    private JTable tabla;
    private int Puntos;
    private int FaltaEtapa4;
    private int FaltaEtapa5;
    private int FaltaEtapa6;
    
    public HiloFaseSintesis(boolean vivo, Compiladores compi, JTable tabla) {
        this.vivo = vivo;
        this.compi = compi;
        this.tabla = tabla;
    }

    public void run() {
        //suciedad 5: 8s 
        //suciedad 4: 6s
        //suciedad 3: 4s
        int time=2;
        if (compi.getIntermedio()<1200) {
            System.out.println("Error en lexico");
            FaltaEtapa4=1200-compi.getIntermedio();
        }else if (compi.getIntermedio()>=1200) {
            Puntos=Puntos+10;
        }
        
        else if (compi.getOptimizador()<1200) {
            System.out.println("Error en Sintactico");
            FaltaEtapa5=1200-compi.getOptimizador();
        }else if (compi.getOptimizador()>=1200) {
            Puntos=Puntos+5;
            
        }else if (compi.getGenerador()<500) {
            System.out.println("Error en Semantico");
            FaltaEtapa6=500-compi.getGenerador();
        }else if (compi.getGenerador()>=500) {
            Puntos=Puntos+25;
        }
        
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloFaseAnalisis.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //((DefaultListModel)tabla.getModel()).removeElement(compi.getNombreCreador());
        
        //System.out.println("TERMINADO: "+compi.getNombreCreador());
        
    }
}
