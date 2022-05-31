package presentation;

import javax.swing.table.DefaultTableModel;

public class Searcher extends javax.swing.JPanel {
    private Menu m;
    
    public Searcher() {
        initComponents();
    }
    
    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        txtSearcher.setText("");
        txtPrinciple.setText("");
        txtLabs.setText("");
        txtDescription.setText("");
        txtUPC.setText("");
                
        LoadTable("", ValidateColumns());
    }
    
    private String ValidateColumns(){
        String Columns = "";
        
        if(chkPrinciple.isSelected()){
            Columns += ", pp.Name as PrincipioActivo ";
        }
        if(chkUPC.isSelected()){
            Columns += ", p.UPC ";
        }
        if(chkLot.isSelected()){
            Columns += ", p.Lot as Lote ";
        }
        if(chkExpirationDate.isSelected()){
            Columns += ", p.ExpirationDate as FechaVencimiento ";
        }
        if(chkLaboratory.isSelected()){
            Columns += ", l.Name as Laboratorio ";
        }
        
        return Columns;
    }
    
    private void LoadTable(String Conditions, String Columns){
        m.setTitle("Cargando tabla de productos...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select mp.Code as Código, mp.Description as Descripción, p.SalePrice as PrecioVenta, ");
        m.c.query.append("mp.isBox as EsPadre, p.Units as Existencia, mp.Packsize ");
        m.c.query.append(Columns);
        m.c.query.append(Conditions);
        m.c.query.append("from Products as p ");
        m.c.query.append("inner join MasterProducts as mp on p.CodeMaster = mp.id ");
        m.c.query.append("inner join Principle as pp on pp.id = mp.Principle ");
        m.c.query.append("inner join Laboratories as l on l.id = p.Laboratory ");
        m.c.query.append("where p.Status = 1 ");
        m.c.query.append("order by mp.Description;");
        
        tabPrincipal.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
        m.setTitle("Búsqueda de productos");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPrincipal = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrinciple = new javax.swing.JTextField();
        txtLabs = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtUPC = new javax.swing.JTextField();
        chkPrinciple = new javax.swing.JCheckBox();
        chkUPC = new javax.swing.JCheckBox();
        chkLaboratory = new javax.swing.JCheckBox();
        btnFilter = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        txtSearcher = new javax.swing.JTextField();
        btnSearcher = new javax.swing.JButton();
        chkLot = new javax.swing.JCheckBox();
        chkExpirationDate = new javax.swing.JCheckBox();
        btnRefresh = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        tabPrincipal.setModel(new javax.swing.table.DefaultTableModel(
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
        tabPrincipal.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(tabPrincipal);

        jLabel2.setText("Principio activo:");

        jLabel3.setText("Laboratorio:");

        jLabel4.setText("Descripción:");

        jLabel1.setText("UPC:");

        chkPrinciple.setText("Principio activo");

        chkUPC.setText("UPC");

        chkLaboratory.setText("Laboratorio");

        btnFilter.setBackground(new java.awt.Color(0, 0, 102));
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setText("Filtrar");

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");

        txtSearcher.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N

        btnSearcher.setBackground(new java.awt.Color(0, 51, 102));
        btnSearcher.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        btnSearcher.setForeground(new java.awt.Color(255, 255, 255));
        btnSearcher.setText("Buscar");

        chkLot.setText("Lote");

        chkExpirationDate.setText("Fecha de expiración");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrinciple)
                            .addComponent(txtLabs, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDescription)
                            .addComponent(txtUPC, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkLot)
                            .addComponent(chkUPC))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkLaboratory)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkPrinciple)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(chkExpirationDate)
                                .addGap(218, 218, 218)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnFilter, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearcher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(txtPrinciple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtLabs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtUPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkLot)
                    .addComponent(chkExpirationDate)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFilter)
                        .addComponent(btnAdd))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkUPC)
                        .addComponent(chkLaboratory)
                        .addComponent(chkPrinciple)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnFilter;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JCheckBox chkExpirationDate;
    private javax.swing.JCheckBox chkLaboratory;
    private javax.swing.JCheckBox chkLot;
    private javax.swing.JCheckBox chkPrinciple;
    private javax.swing.JCheckBox chkUPC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabPrincipal;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtLabs;
    private javax.swing.JTextField txtPrinciple;
    private javax.swing.JTextField txtSearcher;
    private javax.swing.JTextField txtUPC;
    // End of variables declaration//GEN-END:variables
}
