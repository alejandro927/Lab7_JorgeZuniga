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
public class AdministrarSuper {
    private ArrayList<SuperUsuario> ListaSuperUsuario = new ArrayList();
    private File archivo = null;
    
    public AdministrarSuper(String path) {
        archivo = new File(path);
    }

    public ArrayList<SuperUsuario> getListaSuperUsuario() {
        return ListaSuperUsuario;
    }

    public void setListaSuperUsuario(ArrayList<SuperUsuario> ListaSuperUsuario) {
        this.ListaSuperUsuario = ListaSuperUsuario;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setSuperUsuario(SuperUsuario a){
        ListaSuperUsuario.add(a);
    }
    
    
    public void cargarArchivo() {
        try {            
            ListaSuperUsuario = new ArrayList();
            SuperUsuario temp;
            if (archivo.exists()) {
                FileInputStream entrada= new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (SuperUsuario) objeto.readObject()) != null) {
                        ListaSuperUsuario.add(temp);
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
            for (SuperUsuario t : ListaSuperUsuario) {
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
