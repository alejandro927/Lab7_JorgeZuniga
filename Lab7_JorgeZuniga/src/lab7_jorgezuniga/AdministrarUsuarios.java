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
public class AdministrarUsuarios {
    private ArrayList<UsuariosAlumnos> ListaUsuarios = new ArrayList();
    private File archivo = null;
    
    public AdministrarUsuarios(String path) {
        archivo = new File(path);
    }

    public ArrayList<UsuariosAlumnos> getListaPeliculas() {
        return ListaUsuarios;
    }

    public void setListaUsuariosAlumnos(ArrayList<UsuariosAlumnos> ListaUsuariosAlumnos) {
        this.ListaUsuarios = ListaUsuariosAlumnos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }
    
    public void setUsuarioAlumno(UsuariosAlumnos a){
        ListaUsuarios.add(a);
    }
    
    
    public void cargarArchivo() {
        try {            
            ListaUsuarios = new ArrayList();
            UsuariosAlumnos temp;
            if (archivo.exists()) {
                FileInputStream entrada= new FileInputStream(archivo);
                ObjectInputStream objeto = new ObjectInputStream(entrada);
                try {
                    while ((temp = (UsuariosAlumnos) objeto.readObject()) != null) {
                        ListaUsuarios.add(temp);
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
            for (UsuariosAlumnos t : ListaUsuarios) {
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
