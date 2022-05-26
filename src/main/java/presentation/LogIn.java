package presentation;

import common.*;
import bridge.Bridge;
import javax.swing.*;

public class LogIn extends JPanel {
    private final CommonUse c = new CommonUse();
    private final Bridge execute = new Bridge();
    private final Cache cache = new Cache();
    private Menu menu = null;
    
    public LogIn() {
        initComponents();
        
        txtUser.requestFocus();
    }
    
    protected void reciveMenu(Menu menu){
        this.menu = menu;
        this.menu.setTitle("Ingresa tus credenciales para continuar.");
    }
        
    private void CleanControls(){
        menu.setTitle("LogIn");
        txtUser.setText("");
        txtPass.setText("");
        txtUser.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        txtUser = new JTextField();
        txtPass = new JPasswordField();
        btnLogIn = new JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel1.setText("Usuario:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel2.setText("Contraseña:");

        txtUser.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtUser.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        txtPass.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        txtPass.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        btnLogIn.setBackground(new java.awt.Color(240, 240, 240));
        btnLogIn.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        btnLogIn.setText("Entrar");
        btnLogIn.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUser)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogInActionPerformed
        menu.setTitle("Validando datos...");
                
        txtUser.setText(c.getCleanText(txtUser.getText()));
        if(txtUser.getText().length() > 30) {
            JOptionPane.showMessageDialog(null, "El nombre de usuario es demasiado largo.");
            CleanControls();
            return;
        }
        
        if(txtPass.getText().length() > 30){
            JOptionPane.showMessageDialog(null, "La contraseña es demasiado larga.");
            CleanControls();
            return;
        }
        
        menu.setTitle("Revisando usuario...");
       //check that the user exists.
       c.query.delete(0, c.query.length());
       c.query.append("select count(1) from Users where User = '").append(txtUser.getText()).append("';");
       if(execute.getValue(c.query.toString()).equals("0")){
           JOptionPane.showMessageDialog(null, "Este usuario no existe.");
           CleanControls();
           return;
       }
       
       menu.setTitle("Revisando contraseña...");
       //Check that the credentials are correct
       c.query.delete(0, c.query.length());
       c.query.append("select count(1) from Users where ");
       c.query.append("User = '").append(txtUser.getText()).append("' ");
       c.query.append("and Pass = '").append(txtPass.getText()).append("';");
       if(execute.getValue(c.query.toString()).equals("0")){
           JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");
           CleanControls();
           return;
       }
       
       menu.setTitle("Guardando datos...");
       //Save data in cache.
       c.query.delete(0, c.query.length());
       c.query.append("Select id from Users where User = '").append(txtUser.getText()).append("';");
       cache.setUser(Integer.parseInt(execute.getValue(c.query.toString())));
       c.query.delete(0, c.query.length());
       c.query.append("select Permission from Users where User = '").append(txtUser.getText()).append("';");
       cache.setPermission(Integer.parseInt(execute.getValue(c.query.toString())));
       
       CleanControls();
       menu.setTitle("¡Registro exitoso!");   
       menu.showPermissions();
    }//GEN-LAST:event_btnLogInActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
