package connector;

import java.sql.*;
import javax.swing.JOptionPane;

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
            if(testAttemps(e) < 3){
                executeQuery(query);
            }
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
}
