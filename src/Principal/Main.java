package Principal;

import Modelo.Agente;
import Modelo.Categoria;
import Modelo.Genero;
import Modelo.Licencia;
import Modelo.MotivoMulta;
import Modelo.Multa;
import Modelo.OrganismoTransito;
import Modelo.Persona;
import Modelo.Vehiculo;
import Excepciones.ExcepcionObjetoExistente;
import GUI.VentanaPrincipal;
import java.util.Date;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionInInitializerError, ExcepcionObjetoExistente, Exception {
            Agente agente1 = new Agente((short)1111, 1006050765, "Pepito", "Perez", Genero.MASCULINO);
            Agente agente2 = new Agente((short)2222, 1010150273, "Vìctor Alfonso", "Sánchez", Genero.MASCULINO);
            Agente agente3 = new Agente((short)3333, 1168009001, "Maria Fernanda", "Gómez", Genero.FEMENINO);

            Vehiculo vehiculo1 = new Vehiculo("VPI-693", (short) 2008, "Azul", "Chevrolet");
            Vehiculo vehiculo2 = new Vehiculo("ZOO-290", (short) 2021, "Negro", "Kia");

            Persona persona1 = new Persona(11231232, "Jhonatan", "Castrillon", Genero.MASCULINO);
            Persona persona2 = new Persona(12696578, "Rosa Isabel", "Rosero", Genero.FEMENINO);
            
            Multa multa1 = new Multa(500000, agente1, vehiculo1, persona1, new Date("03/27/2002"));

            MotivoMulta motMulta1 = new MotivoMulta((short) 1, "Agarrarse de otro vehículo en movimiento.", 250000);
            MotivoMulta motMulta2 = new MotivoMulta((short) 2, "Transitar por andenes y demás lugares destinados al tránsito de peatones.", 200000);
            MotivoMulta motMulta3 = new MotivoMulta((short) 3, "No transitar por la derecha de la vía.", 50000);
            MotivoMulta motMulta4 = new MotivoMulta((short) 4, "Manejar con la licencia de conducción vencida.", 150000);
            MotivoMulta motMulta5 = new MotivoMulta((short) 5, "No detenerse ante una luz roja o amarilla de semáforo", 200000);
            MotivoMulta motMulta6 = new MotivoMulta((short) 6, "Estacionar un vehículo en los sitios prohibidos.", 180000);
            MotivoMulta motMulta7 = new MotivoMulta((short) 7, "Conducir un vehículo sin luces.", 190000);
            MotivoMulta motMulta8 = new MotivoMulta((short) 8, "Conducir un vehículo con vidrios polarizados sin permiso.", 220000);

            //Formato fecha (MM/dd/aa)
            Licencia licencia1 = new Licencia(persona1, Categoria.A1, new Date("07/12/2023"));
            Licencia licencia2 = new Licencia(persona2, Categoria.C1, new Date("05/25/2025"));

            OrganismoTransito oT = new OrganismoTransito();

//            multa1.añadirMotivoMulta(motMulta8);
//            multa1.añadirMotivoMulta(motMulta2);
//            multa1.añadirMotivoMulta(motMulta1);

//            oT.añadirAgente(agente1);
//            oT.añadirAgente(agente2);
//            oT.añadirAgente(agente3);
//            
//            oT.añadirMotMulta(motMulta1);
//            oT.añadirMotMulta(motMulta2);
//            oT.añadirMotMulta(motMulta3);
//            oT.añadirMotMulta(motMulta4);
//            oT.añadirMotMulta(motMulta5);
//            oT.añadirMotMulta(motMulta6);
//            oT.añadirMotMulta(motMulta7);
//            oT.añadirMotMulta(motMulta8);

//            oT.añadirMulta(multa1);
//
//            oT.añadirLicencia(licencia1);
//            oT.añadirLicencia(licencia2);
////         
//            oT.añadirVehiculo(vehiculo1);
//            oT.añadirVehiculo(vehiculo2);

            new VentanaPrincipal(oT).setVisible(true);
    }

}
