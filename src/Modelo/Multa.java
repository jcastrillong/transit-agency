package Modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@Entity
public class Multa implements Serializable {

    //Atributos propios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;

    @Column(nullable = false)
    private int valor;
    //Relaciones de asociacion uno a uno
    @OneToOne
    private Agente agente;
    @OneToOne
    private Vehiculo vehiculo;
    @OneToOne
    private Persona persona;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMulta;
    //Relaciones de asociacion uno a muchos
    @OneToMany
    private List<MotivoMulta> listaMotivoMultas;

    //Contructor vacio
    public Multa() {
        this.valor = 0;
        this.agente = null;
        this.fechaMulta = null;
        this.persona = null;
        this.vehiculo = null;
        this.listaMotivoMultas = new LinkedList<>();
    }

    //Constructor
    public Multa(int valor, Agente agente, Vehiculo vehiculo, Persona persona, Date fechaMulta) throws ExceptionInInitializerError {

        //Verificacion de valores válidos
        if (valor <= 0) {
            throw new ExceptionInInitializerError("El valor de la multa debe ser mayor a cero(0)");
        }
        if (agente == null) {
            throw new ExceptionInInitializerError("No fue ingresado el agente");
        }
        if (vehiculo == null) {
            throw new ExceptionInInitializerError("No fue ingresado el vehiculo");
        }
        if (persona == null) {
            throw new ExceptionInInitializerError("No fue ingresada la persona");
        }
        if (fechaMulta == null) {
            throw new ExceptionInInitializerError("No fue ingresada la fecha de la multa");
        }

        //Inicializar
        this.valor = valor;
        this.agente = agente;
        this.vehiculo = vehiculo;
        this.persona = persona;
        this.fechaMulta = fechaMulta;
        this.listaMotivoMultas = new LinkedList<>();
    }

    //Métodos de acceso
    public int getValor() {
        return valor;
    }

    public Agente getAgente() {
        return agente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Persona getPersona() {
        return persona;
    }

    public Date getFechaMulta() {
        return fechaMulta;
    }

    public List<MotivoMulta> getListaMotivoMultas() {
        return listaMotivoMultas;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setFechaMulta(Date fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public void setListaMotivoMultas(List<MotivoMulta> listaMotivoMultas) {
        this.listaMotivoMultas = listaMotivoMultas;
    }

    //Métodos que agregan y eliminan elmentos de una lista
    public void añadirMotivoMulta(MotivoMulta motMulta) {
        this.listaMotivoMultas.add(motMulta);
    }

    public void eliminarMotivoMulta(short codigo) {
        for (MotivoMulta motM : this.listaMotivoMultas) {
            if (codigo == motM.getCodigo()) {
                this.listaMotivoMultas.remove(motM);
            }
        }
    }

    //Calcular el valor total de la multa
    public int calcularValorMulta() {
        int valorTotal = 0;
        for (int i = 0; i < listaMotivoMultas.size(); i++) {
            valorTotal += listaMotivoMultas.get(i).getValor();
        }
        return valorTotal;
    }

    public String mostrarListaMotivosMulta() {
        String lista = "";
        for (int i = 0; i < listaMotivoMultas.size(); i++) {
            lista += listaMotivoMultas.get(i).getDescripcion() + "\n";
        }
        return lista;
    }
}
