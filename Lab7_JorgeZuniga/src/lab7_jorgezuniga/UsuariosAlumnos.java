/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab7_jorgezuniga;

import java.io.Serializable;

/**
 *
 * @author Alejandro
 */
public class UsuariosAlumnos implements Serializable{
    private String Nombre;
    private String Apellido;
    private String Usuario;
    private String Contrasena;
    private int nota;
    
    private static final long SerialVersionUID=777L;

    public UsuariosAlumnos() {
    }
    
    public UsuariosAlumnos(String Nombre, String Apellido, String Usuario, String Contrasena) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nombre=" + Nombre + ", Apellido=" + Apellido + ", Usuario=" + Usuario + ", Contrasena=" + Contrasena + ", nota=" + nota;
    }
}
