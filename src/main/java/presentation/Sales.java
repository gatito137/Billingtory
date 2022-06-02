package presentation;

import java.awt.*;
import java.awt.print.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sales extends javax.swing.JPanel implements Printable{
    private Menu m;
    
    public Sales() {
        initComponents();
        DefaultTableModel Table = new DefaultTableModel();
        Table.addColumn("Código");
        Table.addColumn("Lote");
        Table.addColumn("Descripción");
        Table.addColumn("Unidades");
        Table.addColumn("Precio");
        Table.addColumn("Descuento");
        Table.addColumn("SubTotal");
        
        tabSales.setModel(Table);
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        //Sum the subtotals
        lblTotal.setText("0");
        for(int rows = 0; rows < tabSales.getRowCount(); rows++){
            lblTotal.setText(String.valueOf(Float.parseFloat(lblTotal.getText()) + Float.parseFloat(tabSales.getValueAt(rows, 6).toString())));
        }
        
        //Get correlative
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from Invoices order by id desc limit 1;");
        if(m.execute.getNat(m.c.query.toString()) < 0){
            lblCorrelative.setText("1");
        }else{
            lblCorrelative.setText(String.valueOf(m.execute.getNat(m.c.query.toString()) + 1));
        }
        
        //Date
        lblDate.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(LocalDateTime.now()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblCorrelative = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblNit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabSales = new javax.swing.JTable();
        lblTel = new javax.swing.JLabel();
        lblMail = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnPrint = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        btnCharge = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel1.setText("Farmacias Huales");

        jLabel2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel2.setText("Nit: 95190228");

        jLabel3.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel3.setText("Teléfono: 4775 1886");

        jLabel4.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabel4.setText("4 Avenida, 14-53 Zona 1");

        jLabel5.setText("Correlativo:");

        lblCorrelative.setText("[Correlative]");

        lblDate.setText("Date");

        jLabel6.setText("Nombre:");

        jLabel7.setText("Nit:");

        jLabel8.setText("Tel:");

        jLabel9.setText("Correo:");

        lblName.setText("[Name]");

        lblNit.setText("[Nit]");

        tabSales.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabSales);

        lblTel.setText("[Tel]");

        lblMail.setText("[Mail]");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        jLabel11.setText("Total:");

        lblTotal.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        lblTotal.setText("[Total]");

        btnPrint.setBackground(new java.awt.Color(0, 0, 102));
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Imprimir");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(0, 0, 102));
        btnRemove.setForeground(new java.awt.Color(255, 255, 255));
        btnRemove.setText("Remover");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagine/logo.jpg"))); // NOI18N

        btnCancel.setBackground(new java.awt.Color(0, 0, 102));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Anular");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnCharge.setBackground(new java.awt.Color(0, 0, 102));
        btnCharge.setForeground(new java.awt.Color(255, 255, 255));
        btnCharge.setText("Cobrar");
        btnCharge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(8, 8, 8)
                                    .addComponent(jLabel3))
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(jLabel2))
                                .addComponent(jLabel1)))
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 538, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnPrint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCharge, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal)
                        .addGap(27, 27, 27))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblNit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTel)
                            .addComponent(lblMail))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDate)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCorrelative)))
                        .addGap(35, 35, 35))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(lblName))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(lblNit)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(lblCorrelative))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblDate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lblTel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lblMail))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(lblTotal)
                    .addComponent(btnPrint)
                    .addComponent(btnRemove)
                    .addComponent(btnCancel)
                    .addComponent(btnCharge))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        int Row = tabSales.getSelectedRow();
        if(Row < 0){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para eliminar.");
            return;
        }
        
        if(JOptionPane.showConfirmDialog(null,"¿Está seguro que desea eliminar esta venta de la factura?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        DefaultTableModel removeRow = (DefaultTableModel) tabSales.getModel();
        removeRow.removeRow(Row);
        tabSales.setModel(removeRow);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        lblDate.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").format(LocalDateTime.now()));
        
        PrinterJob job = PrinterJob.getPrinterJob();
        
        if(job.printDialog()){
            try{
                job.print();
            }catch(PrinterException e){
                JOptionPane.showMessageDialog(null, "No se ha podido realizar la impresión.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Se ha cancelado la impresión.");
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la factura?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        tabSales.setModel(new DefaultTableModel());
        m.pnlPrincipal.removeAll();
        m.pnlPrincipal.revalidate();
        m.pnlPrincipal.repaint();
        m.btnBill.setEnabled(false);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnChargeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeActionPerformed
        Refresh();
        
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que desea realizar el cobro de esta factura?", null, JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        if(lblTotal.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "No se puede tener un cobro cero (0)");
            return;
        }
        
        m.charges.setSize(550,450);
        m.charges.setLocation(0, 0);
        m.charges.Refresh();
        m.pnlPrincipal.removeAll();
        m.pnlPrincipal.add(m.charges);
        m.pnlPrincipal.revalidate();
        m.pnlPrincipal.repaint();
    }//GEN-LAST:event_btnChargeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCharge;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JLabel lblCorrelative;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblLogo;
    protected javax.swing.JLabel lblMail;
    protected javax.swing.JLabel lblName;
    protected javax.swing.JLabel lblNit;
    protected javax.swing.JLabel lblTel;
    protected javax.swing.JLabel lblTotal;
    protected javax.swing.JTable tabSales;
    // End of variables declaration//GEN-END:variables

    @Override
    public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
        if(i == 0){
            Graphics2D newGraphic = (Graphics2D) grphcs;
            newGraphic.translate(pf.getImageableX(), pf.getImageableY());
            printAll(newGraphic);
            
            return PAGE_EXISTS;
        }else{
            return NO_SUCH_PAGE;
        }
    }
}
