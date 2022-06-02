package presentation;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Clients extends javax.swing.JPanel {
    private Menu m;
    
    public Clients() {
        initComponents();
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(String Conditions){
        chkChangeName.setEnabled(false);
        chkChangeName.setSelected(false);
        btnRegistered.setText("Registrar");
        txtName.setEnabled(true);
        
        m.setTitle("Administrar clientes");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Nit, Tel, Mail, Status ");
        m.c.query.append("from Clients ");
        m.c.query.append(Conditions);
        m.c.query.append("order by Name;");
        tabClients.setModel(m.execute.getTable(new javax.swing.table.DefaultTableModel(), m.c.query.toString()));
        
        txtName.setText("");
        txtNit.setText("");
        txtTel.setText("");
        txtMail.setText("");
        lstStatus.setSelectedIndex(0);
    }
          
    private void SaveData(String Name){
        //Validate if it does exists
        m.setTitle("Validando existencia...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Clients where Name = '").append(txtName.getText()).append("';");
        if(m.execute.getNat(m.c.query.toString()) > 0){
            //Get id
            m.setTitle("Obteniendo id...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("select id from Clients where Name = '").append(txtName.getText()).append("';");
            int id = m.execute.getNat(m.c.query.toString());
            
            //Update data
            m.setTitle("Actualizando data...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update Clients set ");
            m.c.query.append("Name = '").append(Name).append("', ");
            m.c.query.append("Nit = '").append(txtNit.getText()).append("', ");
            m.c.query.append("Tel = '").append(txtTel.getText()).append("', ");
            m.c.query.append("Mail = '").append(txtMail.getText()).append("', ");
            m.c.query.append("Status = '").append(lstStatus.getSelectedIndex()).append("' ");
            m.c.query.append("where id = '").append(id).append("';");
            m.execute.executeQuery(m.c.query.toString());
            
            Refresh("");
            JOptionPane.showMessageDialog(null, "Los datos se han actualizado con éxito.");
            return;
        }
        
        //Save data
        m.setTitle("Guardando data...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("insert into Clients(Name, Nit, Tel, Mail, Status) values ('");
        m.c.query.append(txtName.getText()).append("', '");
        m.c.query.append(txtNit.getText()).append("', '");
        m.c.query.append(txtTel.getText()).append("', '");
        m.c.query.append(txtMail.getText()).append("', '");
        m.c.query.append(lstStatus.getSelectedIndex()).append("');");
        m.execute.executeQuery(m.c.query.toString());
        
        Refresh("");
        JOptionPane.showMessageDialog(null, "Los datos han sido guardados con éxito.");        
    }
    
    private String ValidateQuery(String query){
        if(query.substring(query.length() - 6, query.length()).equals("where ")){
            return "";
        }else if(query.substring(query.length() - 4, query.length()).equals("and ")){
            return "";
        }else{
            return "and ";
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabClients = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        btnRegistered = new javax.swing.JButton();
        btnSearcher = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lstStatus = new javax.swing.JComboBox<>();
        chkChangeName = new javax.swing.JCheckBox();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(550, 450));

        tabClients.setModel(new javax.swing.table.DefaultTableModel(
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
        tabClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabClientsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabClients);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Nit:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("E-mail:");

        btnRegistered.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistered.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistered.setText("Registrar");
        btnRegistered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisteredActionPerformed(evt);
            }
        });

        btnSearcher.setBackground(new java.awt.Color(0, 0, 102));
        btnSearcher.setForeground(new java.awt.Color(255, 255, 255));
        btnSearcher.setText("Buscar");
        btnSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearcherActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Estado:");

        lstStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));

        chkChangeName.setBackground(new java.awt.Color(255, 255, 255));
        chkChangeName.setText("Cambiar nombre");

        btnRefresh.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtNit)
                            .addComponent(txtTel)
                            .addComponent(txtMail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(chkChangeName)
                                .addComponent(btnRegistered, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistered)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearcher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRefresh)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkChangeName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int Row = tabClients.getSelectedRow();
        
        if(Row < 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un cliente para agregarlo a la factura.");
            return;
        }
        
        if(tabClients.getValueAt(Row, 4).toString().equals("0")){
            JOptionPane.showMessageDialog(null, "Este cliente está inactivo.");
            return;
        }
        
        m.bill.lblName.setText(tabClients.getValueAt(Row, 0).toString());
        m.bill.lblNit.setText(tabClients.getValueAt(Row, 1).toString());
        m.bill.lblTel.setText(tabClients.getValueAt(Row, 2).toString());
        m.bill.lblMail.setText(tabClients.getValueAt(Row, 3).toString());
        m.bill.Refresh();
        m.btnBill.setEnabled(true);
        
        Refresh("");
        JOptionPane.showMessageDialog(null, "Se ha agregado el cliente a la factura.");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("where ");
        
        if(!txtName.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Name like '%").append(txtName.getText()).append("%' ");
        }        
        if(!txtNit.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Nit like '%").append(txtNit.getText()).append("%' ");
        }
        if(!txtTel.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Tel like '%").append(txtTel.getText()).append("%' ");
        }
        if(!txtMail.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Mail like '%").append(txtMail.getText()).append("%' ");
        }
        if(m.c.query.toString().equals("where ")){
            m.c.query.delete(0, m.c.query.length());
        }
        
        Refresh(m.c.query.toString());
    }//GEN-LAST:event_btnSearcherActionPerformed

    private void btnRegisteredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisteredActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea " + btnRegistered.getText() + " este cliente?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        if(chkChangeName.isSelected()){
            String newName;
            try{
                newName = m.c.getCleanText(JOptionPane.showInputDialog("ingrese el nuevo nombre del cliente:"));                
            }catch(HeadlessException e){
                Refresh("");
                return;
            }
            
            if(newName.equals("")){
                JOptionPane.showMessageDialog(null, "El nombre no puede ser nulo.");
                return;
            }
                
            SaveData(newName);
        }else{
            SaveData(txtName.getText());
        }
    }//GEN-LAST:event_btnRegisteredActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh("");
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tabClientsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabClientsMouseClicked
        int Row = tabClients.getSelectedRow();
        
        txtName.setText(tabClients.getValueAt(Row, 0).toString());
        txtNit.setText(tabClients.getValueAt(Row, 1).toString());
        txtTel.setText(tabClients.getValueAt(Row, 2).toString());
        txtMail.setText(tabClients.getValueAt(Row, 3).toString());
        lstStatus.setSelectedIndex(Integer.parseInt(tabClients.getValueAt(Row, 4).toString()));
        
        txtName.setEnabled(false);
        chkChangeName.setEnabled(true);
        btnRegistered.setText("Actualizar");
    }//GEN-LAST:event_tabClientsMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRegistered;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JCheckBox chkChangeName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JTable tabClients;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
