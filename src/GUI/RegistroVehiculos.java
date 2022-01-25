package GUI;

import Modelo.OrganismoTransito;
import Modelo.TextPrompt;
import Modelo.Vehiculo;
import Excepciones.ExcepcionObjetoExistente;
import Excepciones.ExcepcionObjetoNoEncontrado;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;

public class RegistroVehiculos extends javax.swing.JInternalFrame {

    private OrganismoTransito orgTrans;

    public RegistroVehiculos(OrganismoTransito orgTrans) {
        this.orgTrans = orgTrans;

        initComponents();
        
        TextPrompt placeHolderPlaca = new TextPrompt("ABC-123", this.txtPlaca);
        placeHolderPlaca.changeAlpha(0.75f);
        placeHolderPlaca.changeStyle(Font.ITALIC);

        this.comboBoxMarca.setModel(new manejadorJComboBoxMarca());
        this.btnRegistrar.addActionListener(new manejadorRegistrar());
        this.btnCancelar.addActionListener(new manejadorCancelar());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        comboBoxMarca = new javax.swing.JComboBox<>();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE VEHÍCULOS");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Placa :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Marca :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Modelo :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Color : ");

        btnRegistrar.setText("Registrar");

        btnCancelar.setText("Cancelar");

        txtModelo.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtColor)
                                    .addComponent(txtModelo)
                                    .addComponent(comboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPlaca))))
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> comboBoxMarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtPlaca;
    // End of variables declaration//GEN-END:variables

    public class manejadorJComboBoxMarca implements ComboBoxModel<String> {

        private Object seleccionado;
        private List<String> listaMarcas = Arrays.asList("Mazda", "Toyota", "Hyundai", "Chevrolet", "Mercedes", "Kia", "Volkswagen");

        @Override
        public void setSelectedItem(Object anItem) {
            this.seleccionado = anItem;
        }

        @Override
        public Object getSelectedItem() {
            return seleccionado;
        }

        @Override
        public int getSize() {
            return this.listaMarcas.size();
        }

        @Override
        public String getElementAt(int index) {
            return this.listaMarcas.get(index);
        }

        @Override
        public void addListDataListener(ListDataListener l) {
        }

        @Override
        public void removeListDataListener(ListDataListener l) {
        }

    }

    public class manejadorRegistrar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String placa = txtPlaca.getText();
                String color = txtColor.getText();
                Short modelo = Short.parseShort(txtModelo.getText());
                String marca = (String) comboBoxMarca.getSelectedItem();

                Vehiculo vehiculo = new Vehiculo(placa, modelo, color, marca);

                orgTrans.añadirVehiculo(vehiculo);

                JOptionPane.showMessageDialog(RegistroVehiculos.this, "El vehiculo fue registrado");

                btnCancelar.doClick();
            } catch (ExcepcionObjetoExistente ex) {
                JOptionPane.showMessageDialog(RegistroVehiculos.this, ex.getMessage());
            } catch (ExceptionInInitializerError ex) {
                JOptionPane.showMessageDialog(RegistroVehiculos.this, ex.getMessage());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegistroVehiculos.this, "Ingresó letras en campos numéricos");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(RegistroVehiculos.this, "Sucedio un error inesperado",
                        "ERROR..", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public class manejadorCancelar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            txtPlaca.setText("");
            txtColor.setText("");
            txtModelo.setText("0");
            comboBoxMarca.setSelectedItem(null);
            comboBoxMarca.updateUI();
        }
    }

}
