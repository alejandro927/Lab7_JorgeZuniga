/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class AministrarCompiladores {
    private ArrayList<Compiladores> ListaCompiladores = new ArrayList();
    private File archivo = null;
    
    public AministrarCompiladores(String path) {
        archivo = new File(path);
    }

    public ArrayList<Compiladores> getListaCompiladores() {
        return ListaCompiladores;
    }

    public void setListaCompiladores(ArrayList<Compiladores> ListaCompiladores) {
        this.ListaCompiladores = ListaCompiladores;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setCompiladores(Compiladores a){
        ListaCompiladores.add(a);
    }
    
    
    public void cargarArchivo() {
        try {            
            ListaCompiladores = new ArrayList();
            Compiladores temp;
            if (archivo.exists()) {
                FileInputStream entrada= new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Compiladores) objeto.readObject()) != null) {
                        ListaCompiladores.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Compiladores t : ListaCompiladores) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
