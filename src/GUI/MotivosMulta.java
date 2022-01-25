package GUI;

import Modelo.MotivoMulta;
import Modelo.OrganismoTransito;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MotivosMulta extends javax.swing.JInternalFrame {

    private OrganismoTransito orgTran;

    public MotivosMulta(OrganismoTransito orgTran) {
        this.orgTran = orgTran;

        initComponents();

        this.tablaMotMulta.setModel(new MotivosMultaTableModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMotMulta = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MOTIVOS DE MULTA");

        tablaMotMulta.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMotMulta.getTableHeader().setResizingAllowed(false);
        tablaMotMulta.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaMotMulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMotMulta;
    // End of variables declaration//GEN-END:variables

    public class MotivosMultaTableModel implements TableModel {

        private String[] nombreColum = {"Código", "Descripción", "Valor"};
        private Class[] claseColum = {Short.class, String.class, Integer.class};

        @Override
        public int getRowCount() {
            if (orgTran == null) {
                return 0;
            }
            return orgTran.getListaMotivoMultas().size();
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
            return (columnIndex == 2);
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            MotivoMulta motMulta = orgTran.getListaMotivoMultas().get(rowIndex);

            switch (columnIndex) {
                case 0:
                    return motMulta.getCodigo();
                case 1:
                    return motMulta.getDescripcion();
                case 2:
                    return motMulta.getValor();
            }

            return "";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            //Obtener el objeto
            MotivoMulta mtMulta = orgTran.getListaMotivoMultas().get(rowIndex);

            if (columnIndex == 2) {
                mtMulta.setValor((int) aValue);
                try {
                    orgTran.getMotivoMultaJpaController().edit(mtMulta);
                } catch (Exception ex) {
                    Logger.getLogger(MotivosMulta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }

    }
}
