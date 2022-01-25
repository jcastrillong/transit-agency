package Modelo;

import Excepciones.ExcepcionObjetoExistente;
import Excepciones.ExcepcionObjetoNoEncontrado;
import Persistencia.AgenteJpaController;
import Persistencia.LicenciaJpaController;
import Persistencia.MotivoMultaJpaController;
import Persistencia.MultaJpaController;
import Persistencia.PersonaJpaController;
import Persistencia.VehiculoJpaController;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

/**
 *
 * @author Pc
 */
public class OrganismoTransito {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("Castrillon-Sanchez-RoseroPU");
    private AgenteJpaController agenteJpaController = new AgenteJpaController(factory);
    private LicenciaJpaController licenciaJpaController = new LicenciaJpaController(factory);
    private MotivoMultaJpaController motivoMultaJpaController = new MotivoMultaJpaController(factory);
    private MultaJpaController multaJpaController = new MultaJpaController(factory);
    private PersonaJpaController personaJpaController = new PersonaJpaController(factory);
    private VehiculoJpaController vehiculoJpaController = new VehiculoJpaController(factory);

    //Relaciones de asociacion uno a muchos
//    private List<Licencia> listadoLicencias;
//    private List<Agente> listadoAgentes;
//    private List<MotivoMulta> listaMotivoMultas;
//    private List<Multa> listadoMultas;
//    private List<Vehiculo> listadoVehiculos;
    //Constructor
    public OrganismoTransito() {
        //Inicializar

//        this.listadoLicencias = new LinkedList<>();
//        this.listadoAgentes = new LinkedList<>();
//        this.listaMotivoMultas = new LinkedList<>();
//        this.listadoMultas = new LinkedList<>();
//        this.listadoVehiculos = new LinkedList<>();
    }

    //Métodos de acceso
    public List<MotivoMulta> getListaMotivoMultas() {
        //return listaMotivoMultas;
        return motivoMultaJpaController.findMotivoMultaEntities();
    }

    public List<Multa> getListadoMultas() {
//        return listadoMultas;
        return multaJpaController.findMultaEntities();
    }

    public List<Licencia> getListadoLicencias() {
//        return listadoLicencias;
        return licenciaJpaController.findLicenciaEntities();
    }

    public AgenteJpaController getAgenteJpaController() {
        return agenteJpaController;
    }

    public LicenciaJpaController getLicenciaJpaController() {
        return licenciaJpaController;
    }

    public MotivoMultaJpaController getMotivoMultaJpaController() {
        return motivoMultaJpaController;
    }

    public MultaJpaController getMultaJpaController() {
        return multaJpaController;
    }

    public PersonaJpaController getPersonaJpaController() {
        return personaJpaController;
    }

    public VehiculoJpaController getVehiculoJpaController() {
        return vehiculoJpaController;
    }

    //Métodos para añadir y eliminar elementos de una lista
    //Licencia
    public void añadirLicencia(Licencia licencia) {
        //this.listadoLicencias.add(licencia);
        this.licenciaJpaController.create(licencia);
    }

    public void eliminarLicencia(Licencia licencia) throws NonexistentEntityException {
//        this.listadoLicencias.remove(licencia);
        this.licenciaJpaController.destroy(licencia.getPk());
    }

    //Agente
    public void añadirAgente(Agente agente) throws Exception {
//        this.listadoAgentes.add(agente);
        this.agenteJpaController.create(agente);
    }

    public void eliminarAgente(Agente agente) throws NonexistentEntityException {
//        this.listadoAgentes.remove(agente);
        this.agenteJpaController.destroy(agente.getIdentificacion());
    }

    //MotivoMulta
    public void añadirMotMulta(MotivoMulta motMulta) throws Exception {
//        this.listaMotivoMultas.add(motMulta);
        this.motivoMultaJpaController.create(motMulta);
    }

    public void eliminarMotMulta(MotivoMulta motMulta) throws NonexistentEntityException {
//        this.listaMotivoMultas.remove(motMulta);
        this.motivoMultaJpaController.destroy(motMulta.getCodigo());
    }

    //Vehiculo
    public void añadirVehiculo(Vehiculo vehiculo) throws ExcepcionObjetoExistente, Exception {
//        if (this.listadoVehiculos.contains(vehiculo)) {
//            throw new ExcepcionObjetoExistente("El vehiculo ya se encuentra registrado");
//        }
//
//        this.listadoVehiculos.add(vehiculo);
        this.vehiculoJpaController.create(vehiculo);
    }

    public void eliminarVehiculo(Vehiculo vehiculo) throws NonexistentEntityException {
//        this.listadoVehiculos.remove(vehiculo);
        this.vehiculoJpaController.destroy(vehiculo.getPlaca());
    }

    //Multa
    public void añadirMulta(Multa multa) {
//        this.listadoMultas.add(multa);
        this.multaJpaController.create(multa);
    }

    public void eliminarMulta(Multa multa) throws NonexistentEntityException {
//        this.listadoMultas.remove(multa);
        this.multaJpaController.destroy(multa.getPk());
    }

    //Otros Métodos
    public Persona buscarPersona(long numIdentificacion) throws ExcepcionObjetoNoEncontrado {

//        for (int i = 0; i < listadoLicencias.size(); i++) {
//            if (numIdentificacion == (listadoLicencias.get(i).getPersona().getIdentificacion())) {
//                return listadoLicencias.get(i).getPersona();
//            }
//        }
//
//        throw new ExcepcionObjetoNoEncontrado("La persona no fue encontrada, por favor registrese");
        Persona persona = this.personaJpaController.findPersona(numIdentificacion);

        if (persona != null) {
            return persona;
        }

        throw new ExcepcionObjetoNoEncontrado("La persona no fue encontrada, por favor registrese");
    }

    public List<Licencia> buscarLicencia(Persona persona) {

//        List<Licencia> lista = new LinkedList<>();
//
//        if (persona == null) {
//            return lista;
//        }
//
//        for (Licencia l : listadoLicencias) {
//            if (persona.getIdentificacion() == l.getPersona().getIdentificacion()) {
//                lista.add(l);
//            }
//        }
//        return lista;
        List<Licencia> lista = new LinkedList<>();

        if (persona == null) {
            return lista;
        }

        for (Licencia l : getListadoLicencias()) {
            if (persona.getIdentificacion() == l.getPersona().getIdentificacion()) {
                lista.add(l);
            }
        }

        return lista;
    }

    public void verificarLicencia(List<Licencia> lista, Categoria c) throws IllegalArgumentException {
        for (Licencia l : lista) {
            if (l.getCategoria() == c && l.getFechaExpiracion().compareTo(new Date()) > 0) {
                throw new IllegalArgumentException("No puede registrar dos licencias de la misma categoría");
            } else if (l.getFechaExpiracion().compareTo(new Date()) > 0) {
                throw new IllegalArgumentException("Ya tiene una licencia vigente");
            }
        }
    }

    // Metodo que busca el vehiculo y arroja un excepción sí se encuentra otro con la misma placa
    public Vehiculo buscarVehiculo(String placa) throws ExcepcionObjetoNoEncontrado {
//        for (Vehiculo v : listadoVehiculos) {
//            if (placa.equalsIgnoreCase(v.getPlaca())) {
//                return v;
//            }
//        }
//        throw new ExcepcionObjetoNoEncontrado("El vehiculo no fue encontrado");
        Vehiculo vehiculo = vehiculoJpaController.findVehiculo(placa);

        if (vehiculo != null) {
            return vehiculo;
        }

        throw new ExcepcionObjetoNoEncontrado("El vehiculo no fue encontrado");
    }

    public Agente buscarAgente(short placa) throws ExcepcionObjetoNoEncontrado {
//        for (int i = 0; i < listadoAgentes.size(); i++) {
//            if (placa == listadoAgentes.get(i).getNumeroPlaca()) {
//                return listadoAgentes.get(i);
//            }
//        }
//        ExcepcionObjetoNoEncontrado exc = new ExcepcionObjetoNoEncontrado("El agente no se encontró");
//        throw exc;
        Agente agente = agenteJpaController.findAgentePorPlaca(placa);

        if (agente != null) {
            return agente;
        }

        throw new ExcepcionObjetoNoEncontrado("El agente no se encontró");
    }

    public Licencia buscarConductor(long identificacion) throws ExcepcionObjetoNoEncontrado {
//        for (int i = 0; i < listadoLicencias.size(); i++) {
//            if (identificacion == listadoLicencias.get(i).getPersona().getIdentificacion()) {
//                return listadoLicencias.get(i);
//            }
//        }
//        throw new ExcepcionObjetoNoEncontrado("El conductor no se encontró");
        for (Licencia l : getListadoLicencias()) {
            if (identificacion == l.getPersona().getIdentificacion()) {
                return l;
            }
        }

        throw new ExcepcionObjetoNoEncontrado("El conductor no se encontró");
    }

    public MotivoMulta buscarMotivoMulta(short codigo) throws ExcepcionObjetoNoEncontrado {
//        for (int i = 0; i < listaMotivoMultas.size(); i++) {
//            if (codigo == listaMotivoMultas.get(i).getCodigo()) {
//                return listaMotivoMultas.get(i);
//            }
//        }
//        throw new ExcepcionObjetoNoEncontrado("No se encontró una multa con este código");
        MotivoMulta motMulta = motivoMultaJpaController.findMotivoMulta(codigo);

        if (motMulta != null) {
            return motMulta;
        }

        throw new ExcepcionObjetoNoEncontrado("No se encontró una motivo de multa con este código");
    }
}
