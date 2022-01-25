package GUI;

import Modelo.Multa;
import Modelo.OrganismoTransito;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MultasImpuestas extends javax.swing.JInternalFrame {
   
    private OrganismoTransito orgTran;
    
    public MultasImpuestas(OrganismoTransito orgTran) {
        this.orgTran = orgTran;
        
        initComponents();
        
        this.tablaMultasImpuestas.setModel(new MultasImpuestasTableModel());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaMultasImpuestas = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Multas Impuestas");

        tablaMultasImpuestas.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaMultasImpuestas.getTableHeader().setResizingAllowed(false);
        tablaMultasImpuestas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaMultasImpuestas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaMultasImpuestas;
    // End of variables declaration//GEN-END:variables

    public class MultasImpuestasTableModel implements TableModel {

        private String[] nombreColum = {"Fecha" , "Conductor" , "Vehiculo" , "Valor"};
        private Class[] claseColum = {Object.class , Object.class , Object.class , Integer.class};
        
        @Override
        public int getRowCount() {
            if(orgTran == null) {
                return 0;
            }
            return orgTran.getListadoMultas().size();
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
            Multa multa = orgTran.getListadoMultas().get(rowIndex);
            //LocalDate date = multa.getFechaMulta().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            switch(columnIndex) {
                case 0: return formato.format(multa.getFechaMulta());
                case 1: return multa.getPersona();
                case 2: return multa.getVehiculo();
                case 3: return multa.getValor();
            }
            
            return "";
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
        }
        
    }
}
