package Principal;

import Modelo.OrganismoTransito;
import Excepciones.*;
import GUI.VentanaPrincipal;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionInInitializerError, ExcepcionObjetoExistente, Exception {
            OrganismoTransito oT = new OrganismoTransito();

            new VentanaPrincipal(oT).setVisible(true);
    }

}
