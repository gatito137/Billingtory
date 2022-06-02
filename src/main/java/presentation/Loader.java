package presentation;

import bridge.StartConnection;

public class Loader extends javax.swing.JFrame implements Runnable{
    private Menu m;
    
    public Loader() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Cargando datos...");
    }
    
    protected void sendMenu(Menu m){
        this.m = m;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblGreeting = new javax.swing.JLabel();
        barProgress = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        lblPorcentaje = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblGreeting.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblGreeting.setText("Greeting");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel1.setText("Cargando...");

        lblPorcentaje.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblPorcentaje.setText("100");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel2.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(barProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPorcentaje)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 219, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblGreeting)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblGreeting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblPorcentaje)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(barProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loader().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barProgress;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblGreeting;
    private javax.swing.JLabel lblPorcentaje;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        int waitHere = 200;
        String[] greeting = {"¡Bienvenido!", "Estamos trabajando en las actualizaciones.", "Recuerda guardar tu trabajo constantemente."};
        StartConnection connection = new StartConnection(this);
        connection.start();
        
        for(int i = 0; i <= 100; i++){
            lblPorcentaje.setText(String.valueOf(i));
            barProgress.setValue(i);
            
            if(i < 33){
                lblGreeting.setText(greeting[0]);
            }else if(i > 33 && i < 66){
                lblGreeting.setText(greeting[1]);
            }else{
                lblGreeting.setText(greeting[2]);
            }
            
            if(this.getTitle().equals("Conexión establecida")){
                waitHere = 100;
                this.setTitle("Cargando formularios...");
            }else if(this.getTitle().equals("Cargando formularios...") && i > 75){
                waitHere = 50;
                this.setTitle("Terminando detalles...");
            }
            
            try{
                Thread.sleep(waitHere);
            }catch(InterruptedException e){}
        }
        
        m.setVisible(true);
        this.dispose();
    }
}
