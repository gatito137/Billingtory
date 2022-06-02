package presentation;

import javax.swing.JOptionPane;

public class LogIn extends javax.swing.JPanel {
    private Menu m;
    
    public LogIn() {
        initComponents();
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        m.setTitle("LogIn...");
        txtUser.setText("");
        txtPass.setText("");
        txtUser.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JPasswordField();
        btnLogIn = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        txtPass.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        btnLogIn.setBackground(new java.awt.Color(0, 0, 102));
        btnLogIn.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnLogIn.setForeground(new java.awt.Color(255, 255, 255));
        btnLogIn.setText("Entrar");
        btnLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPass, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtUser, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(btnLogIn)
                .addContainerGap(132, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        txtUser.setText(m.c.getCleanText(txtUser.getText()));
        if(txtUser.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar un usuario.");
            txtUser.requestFocus();
            return;
        }
        
        txtPass.setText(m.c.getCleanText(txtPass.getText()));
        if(txtPass.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Debe ingresar una contraseña");
            txtPass.requestFocus();
            return;
        }
        
        m.setTitle("Validando usuario...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Users where User = '").append(txtUser.getText()).append("';");
        if(m.execute.getNat(m.c.query.toString()) != 1){
            JOptionPane.showMessageDialog(null, "Este usuario no existe.");
            Refresh();
            return;
        }
        
        m.setTitle("Validando contraseña...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Users ");
        m.c.query.append("where User = '").append(txtUser.getText()).append("' ");
        m.c.query.append("and Pass = '").append(txtPass.getText()).append("';");
        if(m.execute.getNat(m.c.query.toString()) != 1){
            JOptionPane.showMessageDialog(null, "La contraseña no es correcta.");
            Refresh();
            return;
        }
        
        m.setTitle("Guardando datos...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Permission from Users ");
        m.c.query.append("where User = '").append(txtUser.getText()).append("' ");
        m.c.query.append("and Pass = '").append(txtPass.getText()).append("';");
        m.cache.setPermission(m.execute.getNat(m.c.query.toString()));
        
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from Users ");
        m.c.query.append("where User = '").append(txtUser.getText()).append("' ");
        m.c.query.append("and Pass = '").append(txtPass.getText()).append("';");
        m.cache.setUser(m.execute.getNat(m.c.query.toString()));
        
        m.UnlockControls();
    }//GEN-LAST:event_btnLogInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
