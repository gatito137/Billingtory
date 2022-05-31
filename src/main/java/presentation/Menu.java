package presentation;

import common.CommonUse;
import bridge.Bridge;

public class Menu extends javax.swing.JFrame {
    private final Products products = new Products();
    private final Laboratory laboratory = new Laboratory();
    private final Principle principles = new Principle();
    private final Searcher searcher = new Searcher();
    private final Sales bill = new Sales();
    public final CommonUse c = new CommonUse();
    public final Bridge execute = new Bridge();
    
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menú principal");
        
        laboratory.sendMenu(this);
        principles.sendMenu(this);
        products.sendMenu(this);
        searcher.sendMenu(this);
        bill.sendMenu(this);
        
        LockControls();
    }
    
    private void LockControls(){
        pnlBilling.setVisible(false);
        pnlInventory.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnInventory = new javax.swing.JButton();
        pnlInventory = new javax.swing.JPanel();
        btnProducts = new javax.swing.JButton();
        btnLabs = new javax.swing.JButton();
        btnPrinciple = new javax.swing.JButton();
        btnBilling = new javax.swing.JButton();
        pnlBilling = new javax.swing.JPanel();
        btnSearcher = new javax.swing.JButton();
        btnClient = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(550, 400));

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        btnInventory.setBackground(new java.awt.Color(0, 0, 153));
        btnInventory.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnInventory.setText("Inventario");
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        pnlInventory.setBackground(new java.awt.Color(0, 102, 204));

        btnProducts.setBackground(new java.awt.Color(0, 0, 153));
        btnProducts.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnProducts.setForeground(new java.awt.Color(204, 204, 204));
        btnProducts.setText("Productos");
        btnProducts.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnProducts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductsActionPerformed(evt);
            }
        });

        btnLabs.setBackground(new java.awt.Color(0, 0, 153));
        btnLabs.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnLabs.setForeground(new java.awt.Color(204, 204, 204));
        btnLabs.setText("Laboratorios");
        btnLabs.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnLabs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLabsActionPerformed(evt);
            }
        });

        btnPrinciple.setBackground(new java.awt.Color(0, 0, 153));
        btnPrinciple.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnPrinciple.setForeground(new java.awt.Color(204, 204, 204));
        btnPrinciple.setText("Principio activo");
        btnPrinciple.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPrinciple.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrincipleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInventoryLayout = new javax.swing.GroupLayout(pnlInventory);
        pnlInventory.setLayout(pnlInventoryLayout);
        pnlInventoryLayout.setHorizontalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLabs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPrinciple, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)))
        );
        pnlInventoryLayout.setVerticalGroup(
            pnlInventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInventoryLayout.createSequentialGroup()
                .addComponent(btnProducts)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLabs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPrinciple))
        );

        btnBilling.setBackground(new java.awt.Color(0, 0, 153));
        btnBilling.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        btnBilling.setForeground(new java.awt.Color(255, 255, 255));
        btnBilling.setText("Facturación");
        btnBilling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillingActionPerformed(evt);
            }
        });

        pnlBilling.setBackground(new java.awt.Color(0, 102, 204));

        btnSearcher.setBackground(new java.awt.Color(0, 0, 153));
        btnSearcher.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnSearcher.setForeground(new java.awt.Color(204, 204, 204));
        btnSearcher.setText("Buscar");
        btnSearcher.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearcherActionPerformed(evt);
            }
        });

        btnClient.setBackground(new java.awt.Color(0, 0, 153));
        btnClient.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnClient.setForeground(new java.awt.Color(204, 204, 204));
        btnClient.setText("Cliente");
        btnClient.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientActionPerformed(evt);
            }
        });

        btnBill.setBackground(new java.awt.Color(0, 0, 153));
        btnBill.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnBill.setForeground(new java.awt.Color(204, 204, 204));
        btnBill.setText("Factura");
        btnBill.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBillingLayout = new javax.swing.GroupLayout(pnlBilling);
        pnlBilling.setLayout(pnlBillingLayout);
        pnlBillingLayout.setHorizontalGroup(
            pnlBillingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBillingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSearcher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBill, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)))
        );
        pnlBillingLayout.setVerticalGroup(
            pnlBillingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillingLayout.createSequentialGroup()
                .addComponent(btnSearcher)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBill))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(pnlInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(pnlBilling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnBilling, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlBilling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        if(pnlInventory.isVisible()){
            pnlInventory.setVisible(false);
        }else{
            pnlInventory.setVisible(true);
        }
        
        pnlBilling.setVisible(false);
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnBillingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillingActionPerformed
        if(pnlBilling.isVisible()){
            pnlBilling.setVisible(false);
        }else{
            pnlBilling.setVisible(true);
        }
        
        pnlInventory.setVisible(false);
    }//GEN-LAST:event_btnBillingActionPerformed

    private void btnProductsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductsActionPerformed
        products.setSize(550, 450);
        products.setLocation(0, 0);
        products.Refresh();
        
        pnlPrincipal.removeAll();
        pnlPrincipal.add(products);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        pnlInventory.setVisible(false);
        this.setTitle("Administrar productos");
    }//GEN-LAST:event_btnProductsActionPerformed

    private void btnLabsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLabsActionPerformed
        laboratory.setSize(550, 450);
        laboratory.setLocation(0, 0);
        laboratory.Refresh();
        
        pnlPrincipal.removeAll();
        pnlPrincipal.add(laboratory);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        pnlInventory.setVisible(false);
        this.setTitle("Administrar laboratorios");
    }//GEN-LAST:event_btnLabsActionPerformed

    private void btnPrincipleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrincipleActionPerformed
        principles.setSize(550, 450);
        principles.setLocation(0, 0);
        principles.Refresh();
        
        pnlPrincipal.removeAll();
        pnlPrincipal.add(principles);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        pnlInventory.setVisible(false);
        this.setTitle("Administrar principios activos");
    }//GEN-LAST:event_btnPrincipleActionPerformed

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        searcher.setSize(550, 450);
        searcher.setLocation(0, 0);
        searcher.Refresh();
        
        pnlPrincipal.removeAll();
        pnlPrincipal.add(searcher);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        pnlBilling.setVisible(false);
        this.setTitle("Buscar productos");
    }//GEN-LAST:event_btnSearcherActionPerformed

    private void btnClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientActionPerformed
        pnlBilling.setVisible(false);
        this.setTitle("Administrar clientes");
    }//GEN-LAST:event_btnClientActionPerformed

    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        bill.setSize(550, 450);
        bill.setLocation(0, 0);
        
        pnlPrincipal.removeAll();
        pnlPrincipal.add(bill);
        pnlPrincipal.revalidate();
        pnlPrincipal.repaint();
        
        pnlBilling.setVisible(false);
        this.setTitle("Administrar factura");
    }//GEN-LAST:event_btnBillActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnBilling;
    private javax.swing.JButton btnClient;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnLabs;
    private javax.swing.JButton btnPrinciple;
    private javax.swing.JButton btnProducts;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlBilling;
    private javax.swing.JPanel pnlInventory;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
