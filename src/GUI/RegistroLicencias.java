package GUI;

import Modelo.*;
import Excepciones.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class RegistroLicencias extends javax.swing.JInternalFrame {

    private OrganismoTransito orgTrans;
    private Persona persona = null;
    private List<Licencia> lista;

    public RegistroLicencias(OrganismoTransito orgTrans) {
        this.orgTrans = orgTrans;

        initComponents();

        TextPrompt placeHolderVencimiento = new TextPrompt("dd/mm/aaaa", this.txtVencimiento);
        placeHolderVencimiento.changeAlpha(0.75f);
        placeHolderVencimiento.changeStyle(Font.ITALIC);

        this.btnBuscar.setToolTipText("Buscar");
        this.btnBuscar.addActionListener(new BuscarListener());
        this.comboBoxGenero.setModel(new ModeloComboBoxGenero());
        this.comboBoxCategoria.setModel(new ModeloComboBoxCategoria());
        this.tablaLicenciasVigentes.setModel(new LicenciaVigenteTableModel());
        this.btnGuardar.addActionListener(new GuardarLicenciaListener());
        this.tablaLicenciasVigentes.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int seleccion = tablaLicenciasVigentes.getSelectedRow();
                if (!(seleccion < 0)) {
                    Licencia l = lista.get(seleccion);

                    comboBoxCategoria.setSelectedItem(l.getCategoria());
                    comboBoxCategoria.setEnabled(false);

                    comboBoxCategoria.updateUI();
                }
            }
        });
        this.btnCancelar.addActionListener(new CancelarListener());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelPersona = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        comboBoxGenero = new javax.swing.JComboBox<>();
        txtApellido = new javax.swing.JTextField();
        panelLicenciasVigentes = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLicenciasVigentes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        panelNuevaLicencia = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        comboBoxCategoria = new javax.swing.JComboBox<>();
        txtVencimiento = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("REGISTRO DE LICENCIAS DE TRÁNSITO");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Persona");

        panelPersona.setBackground(new java.awt.Color(153, 153, 153));
        panelPersona.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Indentificación: ");

        txtIdentificacion.setToolTipText("");

        btnBuscar.setText("...");

        jLabel4.setText("Nombre(s):");

        jLabel5.setText("Apellido(s):");

        jLabel6.setText("Género:");

        javax.swing.GroupLayout panelPersonaLayout = new javax.swing.GroupLayout(panelPersona);
        panelPersona.setLayout(panelPersonaLayout);
        panelPersonaLayout.setHorizontalGroup(
            panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPersonaLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar))
                    .addGroup(panelPersonaLayout.createSequentialGroup()
                        .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre)
                            .addComponent(txtApellido)
                            .addComponent(comboBoxGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelPersonaLayout.setVerticalGroup(
            panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPersonaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPersonaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboBoxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLicenciasVigentes.setBackground(new java.awt.Color(153, 153, 153));
        panelLicenciasVigentes.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tablaLicenciasVigentes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaLicenciasVigentes.getTableHeader().setResizingAllowed(false);
        tablaLicenciasVigentes.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaLicenciasVigentes);

        javax.swing.GroupLayout panelLicenciasVigentesLayout = new javax.swing.GroupLayout(panelLicenciasVigentes);
        panelLicenciasVigentes.setLayout(panelLicenciasVigentesLayout);
        panelLicenciasVigentesLayout.setHorizontalGroup(
            panelLicenciasVigentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLicenciasVigentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelLicenciasVigentesLayout.setVerticalGroup(
            panelLicenciasVigentesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLicenciasVigentesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Licencia(s) Vigente(s)");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nueva Licencia o Renovación");

        panelNuevaLicencia.setBackground(new java.awt.Color(204, 204, 204));
        panelNuevaLicencia.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setText("Categoría:");

        jLabel10.setText("Vencimiento");

        javax.swing.GroupLayout panelNuevaLicenciaLayout = new javax.swing.GroupLayout(panelNuevaLicencia);
        panelNuevaLicencia.setLayout(panelNuevaLicenciaLayout);
        panelNuevaLicenciaLayout.setHorizontalGroup(
            panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtVencimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                    .addComponent(comboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNuevaLicenciaLayout.setVerticalGroup(
            panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNuevaLicenciaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(comboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelNuevaLicenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVencimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelNuevaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 112, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelLicenciasVigentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(10, 10, 10))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelLicenciasVigentes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelPersona, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelNuevaLicencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<Categoria> comboBoxCategoria;
    private javax.swing.JComboBox<Genero> comboBoxGenero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelLicenciasVigentes;
    private javax.swing.JPanel panelNuevaLicencia;
    private javax.swing.JPanel panelPersona;
    private javax.swing.JTable tablaLicenciasVigentes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtVencimiento;
    // End of variables declaration//GEN-END:variables

    public class CancelarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            persona = null;

            txtNombre.setEditable(true);
            txtApellido.setEditable(true);
            comboBoxCategoria.setEnabled(true);
            comboBoxGenero.setEnabled(true);

            txtNombre.setText("");
            txtApellido.setText("");
            txtVencimiento.setText("");

            comboBoxCategoria.setSelectedItem(null);
            comboBoxGenero.setSelectedItem(null);
            tablaLicenciasVigentes.clearSelection();

            comboBoxCategoria.updateUI();
            comboBoxGenero.updateUI();
            tablaLicenciasVigentes.updateUI();
        }

    }

    public class BuscarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                long numIdentificacion = Long.parseLong(txtIdentificacion.getText());
                persona = orgTrans.buscarPersona(numIdentificacion);

                txtNombre.setText(persona.getNombre());
                txtApellido.setText(persona.getApellido());
                comboBoxGenero.setSelectedItem(persona.getGenero());
                comboBoxCategoria.setSelectedIndex(-1);

                txtNombre.setEditable(false);
                txtApellido.setEditable(false);
                comboBoxGenero.setEnabled(false);
                comboBoxCategoria.setEnabled(true);

                comboBoxGenero.updateUI();

                tablaLicenciasVigentes.updateUI();
                tablaLicenciasVigentes.clearSelection();
            } catch (ExcepcionObjetoNoEncontrado ex) {
                JOptionPane.showMessageDialog(RegistroLicencias.this, ex.getMessage());

                persona = null;

                btnCancelar.doClick();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(RegistroLicencias.this, ex.getMessage());
            }
        }

    }

    public class GuardarLicenciaListener implements ActionListener {

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Categoria categoria = (Categoria) comboBoxCategoria.getSelectedItem();
                if (persona == null) {
                    long identificacion = Long.parseLong(txtIdentificacion.getText());
                    String nombre = txtNombre.getText().trim();
                    String apellido = txtApellido.getText().trim();
                    Genero genero = (Genero) comboBoxGenero.getSelectedItem();

                    Persona nuevaPersona = new Persona(identificacion, nombre, apellido, genero);

                    Date fechaExpiracion = formato.parse(txtVencimiento.getText().trim());

                    Licencia nuevaLicencia = new Licencia(nuevaPersona, categoria, fechaExpiracion);

                    orgTrans.añadirLicencia(nuevaLicencia);

                    JOptionPane.showMessageDialog(RegistroLicencias.this, "Se registró la licencia exitosamente");

                    btnCancelar.doClick();
                    btnBuscar.doClick();
                } else {
                    int seleccion = tablaLicenciasVigentes.getSelectedRow();
                    if (seleccion >= 0) {
                        Licencia licencia = lista.get(seleccion);
                        //Categoria categoria = (Categoria) comboBoxCategoria.getSelectedItem();

                        orgTrans.verificarLicencia(lista, categoria);

                        Date fechaVencimiento = formato.parse(txtVencimiento.getText().trim());

                        licencia.setFechaExpiracion(fechaVencimiento);
                        orgTrans.getLicenciaJpaController().edit(licencia);

                        JOptionPane.showMessageDialog(RegistroLicencias.this, "Se renovó la licencia exitosamente");

                        txtVencimiento.setText("");

                        comboBoxCategoria.updateUI();
                        tablaLicenciasVigentes.updateUI();
                    } else {
                        Date fechaVencimiento = formato.parse(txtVencimiento.getText().trim());

                        orgTrans.verificarLicencia(lista, categoria);

                        Licencia nuevaLicencia = new Licencia(persona, categoria, fechaVencimiento);

                        orgTrans.añadirLicencia(nuevaLicencia);

                        tablaLicenciasVigentes.updateUI();

                        JOptionPane.showMessageDialog(RegistroLicencias.this, "Se expidió la nueva licencia exitosamente");

                        txtVencimiento.setText("");
                        comboBoxCategoria.setSelectedItem(null);
                        comboBoxCategoria.updateUI();
                    }
                }
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(RegistroLicencias.this, ex.getMessage());
                tablaLicenciasVigentes.clearSelection();
                comboBoxCategoria.setEnabled(true);
                tablaLicenciasVigentes.updateUI();
            } catch (ExceptionInInitializerError ex) {
                JOptionPane.showMessageDialog(RegistroLicencias.this, ex.getMessage());
            } catch (ParseException ex) {
                Logger.getLogger(RegistroLicencias.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(RegistroLicencias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public class ModeloComboBoxCategoria implements ComboBoxModel<Categoria> {

        private Object seleccion;

        @Override
        public void setSelectedItem(Object anItem) {
            this.seleccion = anItem;
        }

        @Override
        public Object getSelectedItem() {
            return this.seleccion;
        }

        @Override
        public int getSize() {
            return Categoria.values().length;
        }

        @Override
        public Categoria getElementAt(int index) {
            Categoria[] categoria = Categoria.values();
            return categoria[index];
        }

        @Override
        public void addListDataListener(ListDataListener l) {}
        @Override
        public void removeListDataListener(ListDataListener l) {}

    }

    public class ModeloComboBoxGenero implements ComboBoxModel<Genero> {

        private Object seleccion;

        @Override
        public void setSelectedItem(Object anItem) {
            this.seleccion = anItem;
        }

        @Override
        public Object getSelectedItem() {
            return this.seleccion;
        }

        @Override
        public int getSize() {
            return Genero.values().length;
        }

        @Override
        public Genero getElementAt(int index) {
            Genero[] genero = Genero.values();
            return genero[index];
        }

        @Override
        public void addListDataListener(ListDataListener l) {}
        @Override
        public void removeListDataListener(ListDataListener l) {}

    }

    public class LicenciaVigenteTableModel implements TableModel {

        private String[] nombreColum = {"Categoría", "Fecha de Vencimiento"};
        private Class[] claseColum = {Enum.class, Object.class};

        @Override
        public int getRowCount() {
            if (orgTrans == null) {
                return 0;
            }
            lista = orgTrans.buscarLicencia(persona);
            return lista.size();
        }

        @Override
        public int getColumnCount() {
            return nombreColum.length;
        }

        @Override
        public String getColumnName(int columnIndex) {
            return nombreColum[columnIndex];
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return claseColum[columnIndex];
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Licencia licencia = lista.get(rowIndex);
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            switch (columnIndex) {
                case 0:
                    return licencia.getCategoria();
                case 1:
                    return formato.format(licencia.getFechaExpiracion());
            }

            return "";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {}
        @Override
        public void addTableModelListener(TableModelListener l) {}
        @Override
        public void removeTableModelListener(TableModelListener l) {}

    }
}
