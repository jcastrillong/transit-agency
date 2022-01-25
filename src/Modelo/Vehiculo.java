/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Pc
 */
@Entity
public class Vehiculo implements Serializable {

    //Atributos
    @Id
    private String placa;
    @Column(nullable = false)
    private short modelo;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String marca;

    //Constructor vacio
    public Vehiculo() {
    }

    //Constructor
    public Vehiculo(String placa, short modelo, String color, String marca) throws ExceptionInInitializerError {
        //Verificacion de valores válidos
        if (placa == null || "".equals(placa.trim())) {
            throw new ExceptionInInitializerError("No se ingresó la placa del vehículo");
        }
        if (marca == null || "".equals(marca.trim())) {
            throw new ExceptionInInitializerError("No se ingresó la marca del vehículo");
        }
        if (modelo <= 0) {
            throw new ExceptionInInitializerError("El módelo del vehiculo es incorrecto");
        }
        if (color == null || "".equals(color.trim())) {
            throw new ExceptionInInitializerError("No se ingresó el color del vehículo");
        }
        //Inicializar
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.marca = marca;
    }

    //Métodos de acceso
    public String getPlaca() {
        return placa;
    }

    public short getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setModelo(short modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Placa: " + placa + " - " + "Modelo: " + modelo + " - " + "Color: " + color + " - " + "Marca: " + marca;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

}
