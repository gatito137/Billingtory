package presentation;

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
        m.setTitle("Administrar clientes");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Nit, Tel, Mail, Status ");
        m.c.query.append("from Clients ");
        m.c.query.append(Conditions);
        m.c.query.append("order by Name;");
        tabClients.setModel(m.execute.getTable(new javax.swing.table.DefaultTableModel(), m.c.query.toString()));
    }
    
    private String ValidateQuery(String query){
        if(query.substring(query.length() - 6, query.length()).equals("where ")){
            return "";
        }else if(query.substring(query.length() - 4, query.length()).equals("and ")){
            return "";
        }else{
            return "";
        }
    }
    
    private void setCleanTexts(){
        txtName.setText(m.c.getCleanText(txtName.getText()));
        txtNit.setText(m.c.getNat(txtNit.getText()).toString());
        txtTel.setText(m.c.getNat(txtTel.getText()).toString());
        txtMail.setText(m.c.validateMail(txtMail.getText()));
    }
    
    private String ValidateConditions(){
        setCleanTexts();
        
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("where ");
        
        //Validate name
        if(!txtName.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Name like '%").append(txtName.getText()).append("%' ");
        }
        
        //Validate Nit
        if(!txtNit.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Nit like '%").append(txtNit.getText()).append("%' ");
        }
        
        //Validate phone
        if(!txtTel.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Tel like '%").append(txtTel.getText()).append("%' ");
        }
        
        //Validate mail
        if(!txtMail.getText().equals("")){
            m.c.query.append(ValidateQuery(m.c.query.toString()));
            m.c.query.append("Maill like '%").append(txtMail.getText()).append("%' ");
        }
        
        if(m.c.query.toString().equals("where ")){
            m.c.query.delete(0, m.c.query.length());
        }
        
        return m.c.query.toString();
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
        jScrollPane1.setViewportView(tabClients);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Nit:");

        jLabel3.setText("Teléfono:");

        jLabel4.setText("E-mail:");

        btnRegistered.setBackground(new java.awt.Color(0, 0, 102));
        btnRegistered.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistered.setText("Registrar");

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
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(chkChangeName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnRegistered, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistered)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearcher)
                                .addGap(49, 49, 49)
                                .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chkChangeName)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(tabClients.getSelectedRow() < 0){
            
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        Refresh(ValidateConditions());
    }//GEN-LAST:event_btnSearcherActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
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
