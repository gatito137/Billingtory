package presentation;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Laboratory extends javax.swing.JPanel {
    private Menu m;
    
    public Laboratory() {
        initComponents();
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Status from Laboratories order by Name;");
        tabLaboratories.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
        
        btnAdd.setText("Agregar");
        txtLab.setText("");
        txtLab.setEnabled(true);
        lstStatus.setSelectedIndex(0);
        m.setTitle("Administrador de laboratorios");
        txtLab.requestFocus();
        chkName.setSelected(false);
    }
    
    private Integer getCountName(String Name){
        m.setTitle("Verificando existencia...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Laboratories where Name = '").append(Name).append("';");
        return m.execute.getNat(m.c.query.toString());
    }
    
    private void saveData(String Name){
        Name = m.c.getCleanText(Name);
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from Laboratories where Name = '");
        m.c.query.append(txtLab.getText()).append("';");
        String id = m.execute.getValue(m.c.query.toString());
        
        if(Name.equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre válido para el laboratorio.");
            return;
        }
        if(Name.length() > 100){
            JOptionPane.showMessageDialog(null, "El nombre del laboratorio no puede exceder los 100 caracteres.");
            return;
        }
        
        if(getCountName(txtLab.getText()) > 0){
            if(getCountName(Name) > 0 && chkName.isSelected()){
                JOptionPane.showMessageDialog(null, "El laboratorio ya ha sido registrado.");
                return;
            }
            
            m.setTitle("Actualizando laboratorio...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update Laboratories set ");
            m.c.query.append("Name = '").append(Name).append("', ");
            m.c.query.append("Status = '").append(lstStatus.getSelectedIndex()).append("' ");
            m.c.query.append("where id = '").append(id).append("';");
            
            m.execute.executeQuery(m.c.query.toString());
            Refresh();
            JOptionPane.showMessageDialog(null, "Datos actualizados con éxito.");
            return;
        }
        
        m.setTitle("Guardando laboratorio...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("insert into Laboratories(Name, Status) values ('");
        m.c.query.append(Name).append("', '");
        m.c.query.append(lstStatus.getSelectedIndex()).append("');");
        
        m.execute.executeQuery(m.c.query.toString());
        Refresh();
        JOptionPane.showMessageDialog(null, "Los datos se han guardado con éxito.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabLaboratories = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnSearcher = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtLab = new javax.swing.JTextField();
        lstStatus = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();
        chkName = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        tabLaboratories.setModel(new javax.swing.table.DefaultTableModel(
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
        tabLaboratories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabLaboratoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabLaboratories);

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearcher.setBackground(new java.awt.Color(0, 0, 102));
        btnSearcher.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnSearcher.setForeground(new java.awt.Color(255, 255, 255));
        btnSearcher.setText("Buscar");
        btnSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearcherActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel1.setText("Laboratorio:");

        txtLab.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        lstStatus.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        lstStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));

        jLabel2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel2.setText("Estado:");

        btnRefresh.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        chkName.setBackground(new java.awt.Color(255, 255, 255));
        chkName.setText("Cambiar nombre");

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
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLab, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearcher)
                        .addGap(0, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(chkName)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearcher))
                .addGap(18, 18, 18)
                .addComponent(chkName)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnAdd)
                    .addComponent(btnRefresh, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        txtLab.setText(m.c.getCleanText(txtLab.getText()));
        
        if(txtLab.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre de un laboratorio para buscarlo.");
            return;
        }
        
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name, Status from Laboratories ");
        m.c.query.append("where Name like '%").append(txtLab.getText()).append("%' order by Name;");
        tabLaboratories.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
    }//GEN-LAST:event_btnSearcherActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea " + btnAdd.getText() +" estos datos?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        if(!btnAdd.getText().equals("Agregar") && chkName.isSelected()){
            try{
                saveData(JOptionPane.showInputDialog("Ingrese el nuevo nombre del establecimiento:", txtLab.getText()));
            }catch(Exception e){
                Refresh();
            }
                
            return;
        }
        
        saveData(txtLab.getText());        
    }//GEN-LAST:event_btnAddActionPerformed

    private void tabLaboratoriesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabLaboratoriesMouseClicked
        btnAdd.setText("Actualizar");
        txtLab.setEnabled(false);
        txtLab.setText(tabLaboratories.getValueAt(tabLaboratories.getSelectedRow(), 0).toString());
        lstStatus.setSelectedIndex(Integer.parseInt(tabLaboratories.getValueAt(tabLaboratories.getSelectedRow(), 1).toString()));        
    }//GEN-LAST:event_tabLaboratoriesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JCheckBox chkName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JTable tabLaboratories;
    private javax.swing.JTextField txtLab;
    // End of variables declaration//GEN-END:variables
}
