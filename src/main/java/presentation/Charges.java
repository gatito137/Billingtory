package presentation;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Charges extends javax.swing.JPanel {
    private Menu m;
    public Charges() {
        initComponents();
    }
    
    protected void sendMen(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        lblTotal.setText(m.bill.lblTotal.getText());
        txtCharge.setText(lblTotal.getText());
        
        DefaultTableModel newTable = new DefaultTableModel();
        newTable.addColumn("Monto");
        newTable.addColumn("Tipo");
        newTable.addColumn("Factura");
        tabCharges.setModel(newTable);
        
        btnBilling.setEnabled(false);
    }
    
    private Float getSubTotal(){
        Float subTotal = Float.parseFloat(String.valueOf(0));
        
        for(int row = 0; row < tabCharges.getRowCount(); row++){
            subTotal += Float.parseFloat(tabCharges.getValueAt(row, 0).toString());
        }        
        
        return subTotal;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lstCharge = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabCharges = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnAddCharge = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtCharge = new javax.swing.JTextField();
        btnBilling = new javax.swing.JButton();
        btnRemoveCharge = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel1.setText("Tipo de cobro:");

        lstCharge.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        lstCharge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Tarjeta" }));

        tabCharges.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabCharges);

        jLabel2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel2.setText("Total a pagar: Q");

        lblTotal.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        lblTotal.setText("[Total]");

        btnAddCharge.setBackground(new java.awt.Color(0, 0, 102));
        btnAddCharge.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnAddCharge.setForeground(new java.awt.Color(255, 255, 255));
        btnAddCharge.setText("Agregar cobro");
        btnAddCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddChargeActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setText("Monto:");

        txtCharge.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        btnBilling.setBackground(new java.awt.Color(0, 0, 102));
        btnBilling.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnBilling.setForeground(new java.awt.Color(255, 255, 255));
        btnBilling.setText("Facturar");
        btnBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillingActionPerformed(evt);
            }
        });

        btnRemoveCharge.setBackground(new java.awt.Color(0, 0, 102));
        btnRemoveCharge.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnRemoveCharge.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoveCharge.setText("Remover cobro");
        btnRemoveCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveChargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lstCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnAddCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoveCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(lblTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(lstCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(btnAddCharge)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, Short.MAX_VALUE)
                        .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoveCharge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddChargeActionPerformed
        Float charge;
        Float Total = Float.parseFloat(lblTotal.getText());
        
        try{
            charge = Float.parseFloat(txtCharge.getText());
        }catch(NumberFormatException e){
            charge = Float.parseFloat(String.valueOf(0));
        }
        
        if(charge == 0){
            JOptionPane.showMessageDialog(null, "Debe ingresar un monto mayor a cero(0).");
            txtCharge.setText(String.valueOf(Total - charge - getSubTotal()));
            return;
        }
        
        if(Total < charge + getSubTotal()){
            JOptionPane.showMessageDialog(null, "No se puede cobrar un monto mayor al monto de la factura.");
            txtCharge.setText(String.valueOf(Total - charge - getSubTotal()));
            return;
        }
        
        if(Total - charge - getSubTotal() == 0){
            btnAddCharge.setEnabled(false);
            btnBilling.setEnabled(true);
        }
        txtCharge.setText(String.valueOf(Total - charge - getSubTotal()));
        
        //Add charge
        Object[] row = new Object[3];
        row[0] = charge;
        row[1] = lstCharge.getSelectedIndex();
        row[2] = m.bill.lblCorrelative.getText();
        DefaultTableModel newTable = (DefaultTableModel) tabCharges.getModel();
        newTable.addRow(row);
        tabCharges.setModel(newTable);
    }//GEN-LAST:event_btnAddChargeActionPerformed

    private void btnRemoveChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveChargeActionPerformed
        int row = tabCharges.getSelectedRow();
        
        if(row < 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cobro para eliminar.");
            return;
        }
        
        //Remove row
        DefaultTableModel newTable = (DefaultTableModel) tabCharges.getModel();
        newTable.removeRow(row);
        tabCharges.setModel(newTable);
        
        btnBilling.setEnabled(false);
        btnAddCharge.setEnabled(true);
        
        txtCharge.setText(String.valueOf(Float.parseFloat(lblTotal.getText()) - getSubTotal()));
    }//GEN-LAST:event_btnRemoveChargeActionPerformed

    private void btnBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillingActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere cobrar esta factura?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        //Save the invoice
        m.setTitle("Guardando factura...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("insert into Invoices(Client, SaleDate) values('");
        m.c.query.append(m.execute.getNat("select id from Clients where Name = '" + m.bill.lblName.getText() + "';")).append("', ");
        m.c.query.append("now()").append(");");
        m.execute.executeQuery(m.c.query.toString());
        
        //Save charges
        m.setTitle("Guardando cobros...");
        for(int row = 0; row < tabCharges.getRowCount(); row++){
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("insert into Charges(Charge, Type, Invoice) values ('");
            m.c.query.append(tabCharges.getValueAt(row, 0)).append("', '");
            m.c.query.append(tabCharges.getValueAt(row, 1)).append("', '");
            m.c.query.append(tabCharges.getValueAt(row, 2)).append("');");
            m.execute.executeQuery(m.c.query.toString());           
        }
        
        //Save sales
        int id;
        for(int row = 0; row < m.bill.tabSales.getRowCount(); row++){
            m.setTitle("Guardando ventas...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("select id from MasterProducts where Code = '").append(m.bill.tabSales.getValueAt(row, 0).toString()).append("';");
            id = m.execute.getNat(m.c.query.toString());
            
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("insert into Sales(Code, Client, Invoice, Lot, Units, PurchasePrice, SalePrice, Discount) values('");
            m.c.query.append(id).append("', '");
            m.c.query.append(m.execute.getNat("select id from Clients where Name = '" + m.bill.lblName.getText() + "';")).append("', '");
            m.c.query.append(m.bill.lblCorrelative.getText()).append("', '");
            m.c.query.append(m.bill.tabSales.getValueAt(row, 1)).append("', '");
            m.c.query.append(m.bill.tabSales.getValueAt(row, 3)).append("', '");
            m.c.query.append(m.execute.getValue("select PurchasePrice from Products where CodeMaster = '" + id + "';")).append("', '");
            m.c.query.append(m.bill.tabSales.getValueAt(row, 4)).append("', '");
            m.c.query.append(m.bill.tabSales.getValueAt(row, 5)).append("');");
            m.execute.executeQuery(m.c.query.toString());
            
            //Update products
            m.setTitle("Actualizando inventario...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update Products set ");
            m.c.query.append("Units = '").append(m.execute.getNat("select Units from Products where CodeMaster = '" + id + "';") - Integer.parseInt(m.bill.tabSales.getValueAt(row, 3).toString())).append("' ");
            m.c.query.append("where CodeMaster = '").append(id).append("';");
            m.execute.executeQuery(m.c.query.toString());
        }
        
        m.pnlPrincipal.removeAll();
        m.pnlPrincipal.revalidate();
        m.pnlPrincipal.repaint();
        JOptionPane.showMessageDialog(null, "Los datos han sido guardados con éxito.");
        m.setTitle("Menú principal");
    }//GEN-LAST:event_btnBillingActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCharge;
    private javax.swing.JButton btnBilling;
    private javax.swing.JButton btnRemoveCharge;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JComboBox<String> lstCharge;
    private javax.swing.JTable tabCharges;
    private javax.swing.JTextField txtCharge;
    // End of variables declaration//GEN-END:variables
}
