package presentation;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principle extends javax.swing.JPanel {
    private Menu m;
    
    public Principle() {
        initComponents();
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Status from Principle order by Name;");
        tabPrinciples.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
        lstStatus.setSelectedIndex(0);
        btnAdd.setText("Agregar");
        
        m.setTitle("Administración de principios activos");
        txtPrinciple.setText("");
        txtPrinciple.setEnabled(true);
        txtPrinciple.requestFocus();
        chkChangeName.setSelected(false);
    }
    
    private void SaveData(String namePrinciple){
        namePrinciple = m.c.getCleanText(namePrinciple);
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from Principle where Name = '");
        m.c.query.append(txtPrinciple.getText()).append("';");
        String id = m.execute.getValue(m.c.query.toString());
        
        if(namePrinciple.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre para el principio activo.");
            return;
        }
        if(namePrinciple.length() > 100){
            JOptionPane.showMessageDialog(null, "El nombre del principio activo no puede superar los 100 caracteres.");
            return;
        }
        
        //Check if could update or insert data
        if(getCountName(txtPrinciple.getText()) > 0){
            if(getCountName(namePrinciple) > 0 && chkChangeName.isSelected()){
                JOptionPane.showMessageDialog(null, "Este principio ya se ha registrado.");
                return;
            }
            m.setTitle("Actualizando principio activo...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update Principle set ");
            m.c.query.append("Name = '").append(namePrinciple).append("', ");
            m.c.query.append("Status = '").append(lstStatus.getSelectedIndex()).append("' ");
            m.c.query.append("where id = '").append(id).append("';");
            
            m.execute.executeQuery(m.c.query.toString());
            Refresh();
            JOptionPane.showMessageDialog(null, "Principio activo actualizado con éxito.");
            return;
        }
        
        //Insert data into table
        m.setTitle("Guardando principio activo...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("insert into Principle(Name, Status) values ('");
        m.c.query.append(namePrinciple).append("', '");
        m.c.query.append(lstStatus.getSelectedIndex()).append("');");
        m.execute.executeQuery(m.c.query.toString());
        Refresh();
        JOptionPane.showMessageDialog(null, "El principio activo se ha guardado con éxito.");
    }
    
    private Integer getCountName(String Name){
        m.setTitle("Validando principio...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Principle where Name ='");
        m.c.query.append(Name).append("';");
        
        return m.execute.getNat(m.c.query.toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPrinciples = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lstStatus = new javax.swing.JComboBox<>();
        txtPrinciple = new javax.swing.JTextField();
        btnSearcher = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        chkChangeName = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        tabPrinciples.setModel(new javax.swing.table.DefaultTableModel(
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
        tabPrinciples.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPrinciplesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPrinciples);

        jLabel1.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel1.setText("Principio activo:");

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel2.setText("Estado:");

        lstStatus.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        lstStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));

        txtPrinciple.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        btnSearcher.setBackground(new java.awt.Color(0, 0, 102));
        btnSearcher.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnSearcher.setForeground(new java.awt.Color(255, 255, 255));
        btnSearcher.setText("Buscar");
        btnSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearcherActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        chkChangeName.setBackground(new java.awt.Color(255, 255, 255));
        chkChangeName.setText("Cambiar nombre");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPrinciple, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkChangeName)
                                    .addComponent(btnSearcher))
                                .addGap(0, 5, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtPrinciple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearcher)))
                .addGap(24, 24, 24)
                .addComponent(chkChangeName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        m.c.getCleanText(txtPrinciple.getText());
        
        if(txtPrinciple.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un principio activo para buscar.");
            return;
        }
        
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Status from Principle where Name like '%");
        m.c.query.append(txtPrinciple.getText()).append("%' order by Name;");
        tabPrinciples.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
    }//GEN-LAST:event_btnSearcherActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Refresh();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea " + btnAdd.getText() + " este principio activo?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        if(!btnAdd.getText().equals("Agregar") && chkChangeName.isSelected()){
            try{
                SaveData(JOptionPane.showInputDialog("Ingrese el nuevo nombre para el principio activo", txtPrinciple.getText()));
            }catch(Exception e){
                Refresh();
            }
            
            return;
        }
        
        SaveData(txtPrinciple.getText());        
    }//GEN-LAST:event_btnAddActionPerformed

    private void tabPrinciplesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPrinciplesMouseClicked
        txtPrinciple.setEnabled(false);
        btnAdd.setText("Actualizar");
        txtPrinciple.setText(tabPrinciples.getValueAt(tabPrinciples.getSelectedRow(), 0).toString());
        lstStatus.setSelectedIndex(Integer.parseInt(tabPrinciples.getValueAt(tabPrinciples.getSelectedRow(), 1).toString()));
    }//GEN-LAST:event_tabPrinciplesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JCheckBox chkChangeName;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JTable tabPrinciples;
    private javax.swing.JTextField txtPrinciple;
    // End of variables declaration//GEN-END:variables
}
