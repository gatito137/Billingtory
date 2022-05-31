package presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Products extends javax.swing.JPanel {
    private Menu m;
    
    public Products() {
        initComponents();
    }

    protected void sendMenu(Menu menu){
        this.m = menu;
    }
    
    protected void Refresh(){
        CleanControls();
        m.setTitle("Cargando datos...");
        
        //Fill in the list of principles
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select Name from Principle where Status > 0 order by Name;");
        m.execute.getList(lstPrinciple, m.c.query.toString());
        
        //Fill in the list of laboratories
        m.c.query.delete(0,m.c.query.length());
        m.c.query.append("select Name from Laboratories where Status > 0 order by Name;");
        m.execute.getList(lstLab, m.c.query.toString());
        
        FillTable("");
    }
    
    private void CleanControls(){
        m.setTitle("Limpiando controles...");
        
        txtCode.setText("");
        txtDescription.setText("");
        lstDependence.setSelectedIndex(0);
        lstPrinciple.setSelectedIndex(0);
        txtPacksize.setText("1");
        txtLot.setText("");
        txtUPC.setText("");
        lstLab.setSelectedIndex(0);
        txtUnits.setText("");
        txtPurchasePrice.setText("");
        txtSalePrice.setText("");
        txtGain.setText("0");
        lstStatus.setSelectedIndex(0);
        btnAdd.setText("Agregar");
        
        txtCode.setEnabled(true);
        txtLot.setEnabled(true);
    }
    
    private void FillTable(String Conditions){
        m.setTitle("Llenando tabla...");
        //Fill in the table
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select mp.Code, mp.Description, mp.isBox, ");
        m.c.query.append("pp.Name as Principle, mp.Packsize, p.UPC, p.Lot, ");
        m.c.query.append("p.EntryDate, p.ExpirationDate, l.Name as Laboratory, ");
        m.c.query.append("p.Units, p.PurchasePrice, p.SalePrice, p.Status ");
        m.c.query.append("from Products as p ");
        m.c.query.append("inner join MasterProducts as mp on p.CodeMaster = mp.id ");
        m.c.query.append("inner join Principle as pp on pp.id = mp.Principle ");
        m.c.query.append("inner join Laboratories as l on l.id = p.Laboratory ");
        m.c.query.append(Conditions);
        m.c.query.append("order by mp.Description;");
        tabPrincipal.setModel(m.execute.getTable(new DefaultTableModel(), m.c.query.toString()));
        
        m.setTitle("Administrar productos");
    }
    
    private String valQuery(String query){
        if(query.substring(query.length() - 6, query.length()).equals("where ")){
            return "";
        }else if(query.substring(query.length() - 4, query.length()).equals("and ")){
            return "";
        }else{
            return "and ";
        }
    }
    
    private String ValidateData(){
        //Validate code
        txtCode.setText(m.c.getCleanText(txtCode.getText()));
        if(txtCode.getText().equals("")){
            return "Debe ingresar un código válido.";
        }
        
        //Validate description
        txtDescription.setText(m.c.getCleanText(txtDescription.getText()));
        if(txtDescription.getText().equals("")){
            return "Debe ingresar una descripción válida para el producto.";
        }
        if(txtDescription.getText().length() > 200){
            return "La descripción debe ser menor a 200 caracteres.";
        }
        
        //Validate priciple active
        if(lstPrinciple.getSelectedIndex() == 0){
            return "Debe seleccionar un principio activo.";
        }
        
        //Validate packsize
        txtPacksize.setText(String.valueOf(m.c.getNat(txtPacksize.getText())));
        if(txtPacksize.getText().equals("-1") || txtPacksize.getText().equals("0")){
            return "Debe ingresar números mayores a cero (0) para el packsize.";
        }
        
        //Validate lot
        txtLot.setText(m.c.getCleanText(txtLot.getText()));
        if(txtLot.getText().length() > 10){
            return "El lote no puede exceder los 10 caracteres.";
        }
        
        //Validate UPC
        txtUPC.setText(m.c.getCleanText(txtUPC.getText()));
        if(txtUPC.getText().length() > 20){
            return "El código de barras no puede exceder los 20 caracteres.";
        }
                
        //Validate laboratory
        if(lstLab.getSelectedIndex() == 0){
            return "Debe seleccionar un laboratorio válido.";
        }
        
        //Validate units
        txtUnits.setText(String.valueOf(m.c.getNat(txtUnits.getText())));
        if(txtUnits.getText().equals("-1")){
            return "Debe ingresar números naturales para las unidades.";
        }
        
        //Validate purchase price
        txtPurchasePrice.setText(String.valueOf(m.c.getFloat(txtPurchasePrice.getText())));
        if(txtPurchasePrice.getText().equals("-1.0")){
            return "Debe ingresar un número mayor a cero (0) para el precio de compra.";
        }
        
        //Validate sale price
        txtSalePrice.setText(String.valueOf(m.c.getFloat(txtSalePrice.getText())));
        if(txtSalePrice.getText().equals("-1.0")){
            return "Debe ingresar un número mayor a cero(0) para el precio de venta.";
        }
        
        return "";
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabPrincipal = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lstDependence = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        lstPrinciple = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtLot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lstLab = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtUnits = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtPurchasePrice = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPacksize = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lstStatus = new javax.swing.JComboBox<>();
        btnSearcher = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txtSalePrice = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGain = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtUPC = new javax.swing.JTextField();
        btnRefresh = new javax.swing.JButton();
        txtDate = new com.toedter.calendar.JDateChooser();

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
        tabPrincipal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPrincipalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabPrincipal);

        jLabel1.setText("Código:");

        jLabel2.setText("Descripción:");

        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodeKeyTyped(evt);
            }
        });

        jLabel3.setText("Dependencia:");

        lstDependence.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Padre", "Hijo" }));

        jLabel4.setText("Principio activo:");

        lstPrinciple.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Lote:");

        txtLot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLotKeyTyped(evt);
            }
        });

        jLabel6.setText("Vencimiento:");

        jLabel7.setText("Laboratorio:");

        lstLab.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Unidades:");

        jLabel9.setText("Precio compra:");

        jLabel10.setText("Packsize:");

        btnAdd.setBackground(new java.awt.Color(0, 0, 102));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Agregar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel11.setText("Estado:");

        lstStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Inactivo", "Activo" }));

        btnSearcher.setBackground(new java.awt.Color(0, 0, 102));
        btnSearcher.setForeground(new java.awt.Color(255, 255, 255));
        btnSearcher.setText("Buscar");
        btnSearcher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearcherActionPerformed(evt);
            }
        });

        jLabel12.setText("Precio venta:");

        txtSalePrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSalePriceKeyTyped(evt);
            }
        });

        jLabel13.setText("Ganancia:");

        txtGain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtGainKeyTyped(evt);
            }
        });

        jLabel14.setText("%");

        jLabel15.setText("Código de barras:");

        txtUPC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUPCKeyTyped(evt);
            }
        });

        btnRefresh.setBackground(new java.awt.Color(0, 0, 102));
        btnRefresh.setForeground(new java.awt.Color(255, 255, 255));
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        txtDate.setDateFormatString("yyyy-MM-dd");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLot)
                            .addComponent(txtPacksize)
                            .addComponent(txtCode)
                            .addComponent(txtDescription)
                            .addComponent(lstDependence, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lstPrinciple, 0, 150, Short.MAX_VALUE)
                            .addComponent(txtUPC)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearcher, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lstLab, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUnits)
                            .addComponent(txtPurchasePrice, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtSalePrice)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtGain, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14))
                            .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnRefresh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lstDependence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lstPrinciple, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtPacksize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lstLab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnits, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPurchasePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtSalePrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(txtGain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtUPC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRefresh)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnSearcher)
                        .addComponent(btnAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(lstStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyTyped
        txtCode.setText(txtCode.getText().toUpperCase());
        txtCode.setText(m.c.getCleanText(txtCode.getText()));

        if(txtCode.getText().length() > 7){
            txtCode.setText(txtCode.getText().substring(0, 6));
        }
    }//GEN-LAST:event_txtCodeKeyTyped

    private void btnSearcherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearcherActionPerformed
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("where ");
        
        if(!txtCode.getText().equals("")){
            m.c.query.append("mp.Code like '%").append(txtCode.getText()).append("%' ");
        }
        if(!txtDescription.getText().equals("")){
            m.c.query.append(valQuery(m.c.query.toString()));
            m.c.query.append("mp.Description like '%").append(txtDescription.getText()).append("%' ");
        }
        if(lstPrinciple.getSelectedIndex() != 0){
            m.c.query.append(valQuery(m.c.query.toString()));
            m.c.query.append("pp.Name = '").append(lstPrinciple.getSelectedItem()).append("' ");
        }
        if(!txtLot.getText().equals("")){
            m.c.query.append(valQuery(m.c.query.toString()));
            m.c.query.append("p.Lot like '%").append(txtLot.getText()).append("%' ");
        }
        if(!txtUPC.getText().equals("")){
            m.c.query.append("");
        }
        if(lstLab.getSelectedIndex() != 0){
            m.c.query.append(valQuery(m.c.query.toString()));
            m.c.query.append("l.Name = '").append(lstLab.getSelectedItem()).append("' ");
        }
        if(!txtUPC.getText().equals("")){
            m.c.query.append(valQuery(m.c.query.toString()));
            m.c.query.append("p.UPC like '%").append(txtUPC.getText()).append("%' ");
        }
        
        if(m.c.query.toString().equals("where ")){
            m.c.query.delete(0, m.c.query.length());
        }        
        FillTable(m.c.query.toString());
    }//GEN-LAST:event_btnSearcherActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(JOptionPane.showConfirmDialog(null, "¿Está seguro que quiere " + btnAdd.getText()+ " este producto?", "", JOptionPane.OK_OPTION) != JOptionPane.OK_OPTION){
            return;
        }
        
        String msgError = ValidateData();
        if(!msgError.equals("")){
            JOptionPane.showMessageDialog(null, msgError);
            return;
        }
        
        //Getting id Master
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from MasterProducts ");
        m.c.query.append("where Code = '").append(txtCode.getText()).append("';");
        String id = m.execute.getValue(m.c.query.toString());        
        
        //Check if it does exists
        m.setTitle("Validando código...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from MasterProducts ");
        m.c.query.append("where Code = '").append(txtCode.getText()).append("';");
        if(m.execute.getNat(m.c.query.toString()) != 0){
            //Update the MasterProducts
            m.setTitle("Actualizando tabla maestra...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update MasterProducts set ");
            m.c.query.append("Description = '").append(txtDescription.getText()).append("', ");
            m.c.query.append("isBox = '").append(lstDependence.getSelectedIndex()).append("', ");
            m.c.query.append("Principle = '").append(m.execute.getNat("select id from Principle where Name = '" + lstPrinciple.getSelectedItem() + "';")).append("', ");
            m.c.query.append("Packsize = '").append(txtPacksize.getText()).append("' ");
            m.c.query.append("where id = '").append(id).append("';");
        }else{
            m.setTitle("Guardando datos...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("insert into MasterProducts(Code, Description, isBox, Principle, Packsize) values('");
            m.c.query.append(txtCode.getText()).append("', '");
            m.c.query.append(txtDescription.getText()).append("', '");
            m.c.query.append(lstDependence.getSelectedIndex()).append("', '");
            m.c.query.append(m.execute.getNat("select id from Principle where Name = '" + lstPrinciple.getSelectedItem() + "';")).append("', '");
            m.c.query.append(txtPacksize.getText()).append("');");
        }
        m.execute.executeQuery(m.c.query.toString());
        
        //Getting id Master
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select id from MasterProducts ");
        m.c.query.append("where Code = '").append(txtCode.getText()).append("';");
        id = m.execute.getValue(m.c.query.toString());
        
        //Chek if it does exists
        m.setTitle("Validando lote...");
        m.c.query.delete(0, m.c.query.length());
        m.c.query.append("select count(1) from Products ");
        m.c.query.append("where CodeMaster = '").append(m.execute.getNat("select id from MasterProducts where Code = '" + txtCode.getText() + "';")).append("' ");
        m.c.query.append("and Lot ='").append(txtLot.getText()).append("';");
        if(m.execute.getNat(m.c.query.toString()) != 0){
            //Update the products
            m.setTitle("Actualizando productos...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("update Products set ");
            m.c.query.append("EntryDate = now(), ");
            m.c.query.append("ExpirationDate = '").append(new java.sql.Date(txtDate.getDate().getTime())).append("', ");
            m.c.query.append("Laboratory = '").append(m.execute.getNat("select id from Laboratories where Name = '" + lstLab.getSelectedItem() + "';")).append("', ");
            m.c.query.append("Status = '").append(lstStatus.getSelectedIndex()).append("', ");
            m.c.query.append("Units = '").append(txtUnits.getText()).append("', ");
            m.c.query.append("PurchasePrice = '").append(txtPurchasePrice.getText()).append("', ");
            m.c.query.append("SalePrice = '").append(txtSalePrice.getText()).append("', ");
            m.c.query.append("UPC = '").append(txtUPC.getText()).append("' ");
            m.c.query.append("where CodeMaster = '").append(id).append("' ");
            m.c.query.append("and Lot = '").append(txtLot.getText()).append("';");            
        }else{
            //Insert into table products
            m.setTitle("Guardando productos...");
            m.c.query.delete(0, m.c.query.length());
            m.c.query.append("insert into Products(CodeMaster, Lot, EntryDate, ");
            m.c.query.append("ExpirationDate, Laboratory, Status, Units, ");
            m.c.query.append("PurchasePrice, SalePrice, UPC) values('");
            m.c.query.append(id).append("', '");
            m.c.query.append(txtLot.getText()).append("', ");
            m.c.query.append("now()").append(", '");
            m.c.query.append(new java.sql.Date(txtDate.getDate().getTime())).append("', '");
            m.c.query.append(m.execute.getNat("select id from Laboratories where Name = '" + lstLab.getSelectedItem() + "';")).append("', '");
            m.c.query.append(lstStatus.getSelectedIndex()).append("', '");
            m.c.query.append(txtUnits.getText()).append("', '");
            m.c.query.append(txtPurchasePrice.getText()).append("', '");
            m.c.query.append(txtSalePrice.getText()).append("', '");
            m.c.query.append(txtUPC.getText()).append("');");
        }
        m.execute.executeQuery(m.c.query.toString());
        
        Refresh();
        JOptionPane.showMessageDialog(null, "Datos actualizados con éxito.");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        Refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tabPrincipalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPrincipalMouseClicked
        int Row = tabPrincipal.getSelectedRow();
        
        txtCode.setEnabled(false);
        txtLot.setEnabled(false);
        btnAdd.setText("Actualizar");
        
        txtCode.setText(tabPrincipal.getValueAt(Row, 0).toString());
        txtDescription.setText(tabPrincipal.getValueAt(Row, 1).toString());
        lstDependence.setSelectedIndex(Integer.parseInt(tabPrincipal.getValueAt(Row, 2).toString()));
        m.c.changeListIndex(lstPrinciple, tabPrincipal.getValueAt(Row, 3).toString());
        txtPacksize.setText(tabPrincipal.getValueAt(Row, 4).toString());
        txtUPC.setText(tabPrincipal.getValueAt(Row, 5).toString());
        txtLot.setText(tabPrincipal.getValueAt(Row, 6).toString());
        try{
            txtDate.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(tabPrincipal.getValueAt(Row, 8).toString()));
        }catch(ParseException e){}
        m.c.changeListIndex(lstLab, tabPrincipal.getValueAt(Row, 9).toString());
        txtUnits.setText(tabPrincipal.getValueAt(Row, 10).toString());
        txtPurchasePrice.setText(tabPrincipal.getValueAt(Row, 11).toString());
        txtSalePrice.setText(tabPrincipal.getValueAt(Row, 12).toString());
        lstStatus.setSelectedIndex(Integer.parseInt(tabPrincipal.getValueAt(Row, 13).toString()));        
    }//GEN-LAST:event_tabPrincipalMouseClicked

    private void txtSalePriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSalePriceKeyTyped
        try{
            Float SalePrice = Float.parseFloat(txtSalePrice.getText());
            Float PurchasePrice = Float.parseFloat(txtPurchasePrice.getText());
            
            txtGain.setText(String.valueOf((SalePrice/PurchasePrice - 1) * 100));
        }catch(NumberFormatException e){
            txtGain.setText("0");
        }
    }//GEN-LAST:event_txtSalePriceKeyTyped

    private void txtGainKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGainKeyTyped
        try{
            Float PurchasePrice = Float.parseFloat(txtPurchasePrice.getText());
            Float Percentage = Float.parseFloat(txtGain.getText());
            
            txtSalePrice.setText(String.valueOf((Percentage / 100 + 1) * PurchasePrice));
        }catch(NumberFormatException e){
            txtSalePrice.setText("");
        }
    }//GEN-LAST:event_txtGainKeyTyped

    private void txtLotKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLotKeyTyped
        txtLot.setText(txtLot.getText().toUpperCase());
    }//GEN-LAST:event_txtLotKeyTyped

    private void txtUPCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUPCKeyTyped
        txtUPC.setText(txtUPC.getText().toUpperCase());
    }//GEN-LAST:event_txtUPCKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearcher;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> lstDependence;
    private javax.swing.JComboBox<String> lstLab;
    private javax.swing.JComboBox<String> lstPrinciple;
    private javax.swing.JComboBox<String> lstStatus;
    private javax.swing.JTable tabPrincipal;
    private javax.swing.JTextField txtCode;
    private com.toedter.calendar.JDateChooser txtDate;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtGain;
    private javax.swing.JTextField txtLot;
    private javax.swing.JTextField txtPacksize;
    private javax.swing.JTextField txtPurchasePrice;
    private javax.swing.JTextField txtSalePrice;
    private javax.swing.JTextField txtUPC;
    private javax.swing.JTextField txtUnits;
    // End of variables declaration//GEN-END:variables
}
