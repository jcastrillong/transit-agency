package Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pc
 */
@Entity
public class Licencia implements Serializable {

    //Atributos propios
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pk;
    //Relaciones de asociacion uno a uno
    @OneToOne
    private Persona persona;
//    @OneToOne(cascade = CascadeType.ALL)
    @Column(nullable = false)
    private Categoria categoria;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaExpiracion;

    //Contructor vacio
    public Licencia() {
    }

    //Constructor
    public Licencia(Persona persona, Categoria categoria, Date fechaExpiracion) throws ExceptionInInitializerError {

        //Verificacion de valores válidos
        if (persona == null) {
            throw new ExceptionInInitializerError("No se ingresó una persona");
        }
        if (categoria == null) {
            throw new ExceptionInInitializerError("No se ingresó la categoría de la licencia");
        }
        if (fechaExpiracion == null) {
            throw new ExceptionInInitializerError("No se ingresó la fecha de expiracion de la licencia");
        }
        ZoneId timeZone = ZoneId.systemDefault();
        LocalDate fechaExpNueva = fechaExpiracion.toInstant().atZone(timeZone).toLocalDate();
        if (fechaExpNueva.getYear() <= LocalDateTime.now().getYear()) {
            throw new ExceptionInInitializerError("La fecha de expiración es menor o igual al año actual");
        }

        //Inicializar
        this.persona = persona;
        this.categoria = categoria;
        this.fechaExpiracion = fechaExpiracion;
    }

    //Métodos de acceso
    public Persona getPersona() {
        return persona;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

}
