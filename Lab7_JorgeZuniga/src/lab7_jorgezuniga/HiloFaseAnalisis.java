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

/**
 *
 * @author Alejandro
 */
public class HiloFaseAnalisis  extends Thread{
    private boolean vivo;
    private Compiladores compi;
    private JTable tabla;

    public HiloFaseAnalisis(boolean vivo, Compiladores compi, JTable tabla) {
        this.vivo = vivo;
        this.compi = compi;
        this.tabla = tabla;
    }

    @Override
    public void run() {
        //suciedad 5: 8s 
        //suciedad 4: 6s
        //suciedad 3: 4s
        int time=5;
        if (vivo) {
            
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
