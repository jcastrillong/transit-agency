/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Pc
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {

    //Atributos
    @Id
    private long identificacion;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private Genero genero;

    //Constructor vacio
    public Persona() {
    }

    //Constructor
    public Persona(long identificacion, String nombre, String apellido, Genero genero) throws ExceptionInInitializerError {

        //Verificacion de valores válidos
        if (identificacion <= 0) {
            throw new ExceptionInInitializerError("El nuemero de identificacion es incorrecto");
        }
        if (nombre == null || "".equals(nombre.trim())) {
            throw new ExceptionInInitializerError("No fue ingresado el nombre de la persona");
        }
        if (apellido == null || "".equals((apellido.trim()))) {
            throw new ExceptionInInitializerError("No fue ingresado el apellido de la persona");
        }
        if (genero == null) {
            throw new ExceptionInInitializerError("No fue ingresado el género de la persona");
        }

        //Inicializar 
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    //Métodos de acceso
    public long getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setIdentificacion(long identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Identificación: " + identificacion + " - " + "Nombre: " + nombre + " " + apellido;
    }
    
}
