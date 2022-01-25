/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
/**
 *
 * @author Pc
 */
@Entity
@NamedQueries({@NamedQuery(name = "agente.buscarporplaca" , query = "SELECT a FROM Agente a WHERE a.numeroPlaca = :placa")})
public class Agente extends Persona {

    //Atributos
    @Column(nullable = false)
    private short numeroPlaca;

    //Constructor vacio
    public Agente() {
    }

    //Constructor
    public Agente(short numeroPlaca, long identificacion, String nombre, String apellido, Genero genero) throws ExceptionInInitializerError {
        super(identificacion, nombre, apellido, genero);

        if (numeroPlaca <= 0) {
            throw new ExceptionInInitializerError("El número de placa debe ser mayor a 0");
        }

        this.numeroPlaca = numeroPlaca;
    }

    //Métodos de acceso
    public short getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(short numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    @Override
    public String toString() {
        return getNombre() + " " + getApellido() + " - " + numeroPlaca;
    }

}
