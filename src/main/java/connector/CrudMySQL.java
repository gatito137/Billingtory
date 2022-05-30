package connector;

import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class CrudMySQL {
    private final ConnectToMySQL cn = new ConnectToMySQL();
    private int Attemps = 0;
    
    private int testAttemps(SQLException e){
        if(Attemps < 3){
            Attemps++;
        }else{
            JOptionPane.showMessageDialog(null, "Algo ha salido mal. :( " + e);
        }
        
        return Attemps;
    }
    
    public void executeQuery(String query){
        try{
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ps.executeUpdate();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public String getValue(String query){
        try{
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                query = rs.getObject(1).toString();
            }
        }catch(SQLException e){
            query = "";
        }
        
        return query;
    }
    
    public DefaultTableModel getTable(DefaultTableModel newTable, String query){
        try{
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                newTable.addColumn(rs.getMetaData().getColumnName(i+1));
            }
            
            Object Row[] = new Object[rs.getMetaData().getColumnCount()];
            
            while(rs.next()){
                for(int i = 0; i < rs.getMetaData().getColumnCount(); i++){
                    Row[i] = rs.getObject(i+1);
                }
                
                newTable.addRow(Row);
            }
        }catch(SQLException e){}
        
        return newTable;
    }
    
    public void getList(JComboBox List, String query){
        List.removeAllItems();
        List.addItem("");
        
        try{
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                List.addItem(rs.getObject(1));
            }
        }catch(SQLException e){}
    }
    
    public Integer getNatural(String query){
        try{
            PreparedStatement ps = cn.getConnection().prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                query = rs.getObject(1).toString();
                
                if(Integer.parseInt(query) < 0){
                    query = String.valueOf(Integer.parseInt(query) * -1);
                }
                
                query = String.valueOf(Integer.parseInt(query));
            }
            
            return Integer.parseInt(query);
        }catch(SQLException e){
            return -1;
        }
    }
}