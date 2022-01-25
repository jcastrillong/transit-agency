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

/**
 *
 * @author Pc
 */
@Entity
public class MotivoMulta implements Serializable {

    //Atributos
    @Id
    private short codigo;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private int valor;

    //Constructor vacio
    public MotivoMulta() {
    }

    //Constructor
    public MotivoMulta(short codigo, String descripcion, int valor) throws ExceptionInInitializerError {

        //Verificacion de valores válidos
        if (codigo <= 0) {
            throw new ExceptionInInitializerError("El codigo es incorrecto, debe ser mayor a 0");
        }
        if (descripcion == null || "".equals(descripcion.trim())) {
            throw new ExceptionInInitializerError("La descripcion de la multa no fue ingresada");
        }
        if (valor <= 0) {
            throw new ExceptionInInitializerError("El valor de la Mmulta debe ser mayor a cero(0)");
        }

        //Inicializar
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    //Métodos de acceso
    public short getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setCodigo(short codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
