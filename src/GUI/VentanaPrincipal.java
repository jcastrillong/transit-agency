package GUI;

import Modelo.OrganismoTransito;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends javax.swing.JFrame {

    private OrganismoTransito orgTran;

    public VentanaPrincipal(OrganismoTransito orgTran) {
        this.orgTran = orgTran;

        initComponents();

        this.menuMotivoMulta.addActionListener(new MostrarMotivosMulta());
        this.menuMultasImpuestas.addActionListener(new MostrarMultasImpuestas());
        this.menuRegistoLicencias.addActionListener(new MostrarRegistroLicencias());
        this.menuRegistroMultas.addActionListener(new MostrarRegistrarMulta());
        this.menuRegistrarVehiculos.addActionListener(new MostrarRegistrarVehiculo());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMotivoMulta = new javax.swing.JMenuItem();
        menuMultasImpuestas = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuRegistoLicencias = new javax.swing.JMenuItem();
        menuRegistroMultas = new javax.swing.JMenuItem();
        menuRegistrarVehiculos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPane1Layout = new javax.swing.GroupLayout(desktopPane1);
        desktopPane1.setLayout(desktopPane1Layout);
        desktopPane1Layout.setHorizontalGroup(
            desktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 789, Short.MAX_VALUE)
        );
        desktopPane1Layout.setVerticalGroup(
            desktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        getContentPane().add(desktopPane1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Mostrar");

        menuMotivoMulta.setText("Motivos Multa");
        jMenu1.add(menuMotivoMulta);

        menuMultasImpuestas.setText("Multas Impuestas");
        jMenu1.add(menuMultasImpuestas);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Registro");

        menuRegistoLicencias.setText("Registro Licencias");
        jMenu2.add(menuRegistoLicencias);

        menuRegistroMultas.setText("Registro Multas");
        jMenu2.add(menuRegistroMultas);

        menuRegistrarVehiculos.setText("Registrar Vehículos");
        jMenu2.add(menuRegistrarVehiculos);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem menuMotivoMulta;
    private javax.swing.JMenuItem menuMultasImpuestas;
    private javax.swing.JMenuItem menuRegistoLicencias;
    private javax.swing.JMenuItem menuRegistrarVehiculos;
    private javax.swing.JMenuItem menuRegistroMultas;
    // End of variables declaration//GEN-END:variables

    public class MostrarMotivosMulta implements ActionListener {

        private MotivosMulta ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Inicialización Lazy
            if (this.ui == null) {
                this.ui = new MotivosMulta(orgTran);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

    public class MostrarMultasImpuestas implements ActionListener {

        private MultasImpuestas ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Inicialización Lazy
            if (this.ui == null) {
                this.ui = new MultasImpuestas(orgTran);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

    public class MostrarRegistroLicencias implements ActionListener {

        private RegistroLicencias ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Inicialización Lazy
            if (this.ui == null) {
                this.ui = new RegistroLicencias(orgTran);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

    public class MostrarRegistrarMulta implements ActionListener {

        private RegistrarMultas ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Inicialización Lazy
            if (this.ui == null) {
                this.ui = new RegistrarMultas(orgTran);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

    public class MostrarRegistrarVehiculo implements ActionListener {

        private RegistroVehiculos ui = null;

        @Override
        public void actionPerformed(ActionEvent e) {
            //Inicialización Lazy
            if (this.ui == null) {
                this.ui = new RegistroVehiculos(orgTran);
                desktopPane1.add(ui);
            }
            ui.setVisible(true);
        }
    }

}
