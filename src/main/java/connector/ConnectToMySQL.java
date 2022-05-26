package connector;

import common.Cache;
import java.sql.*;

public class ConnectToMySQL {
    private final Cache cache = new Cache();
    
    private Connection testConnection(){
        if(cache.getConnector() != null){
            try{
                cache.getConnector().prepareStatement("select 1 as [Uno];");
            }catch(SQLException e){
                cache.setConnector(null);
            }
        }      
        
        return cache.getConnector();
    }
    
    public Connection getConnection(){
        if(testConnection() == null){
            try{
                String url = "jdbc:mysql://remotemysql.com:3306/0gr50OWTph";
                String user = "0gr50OWTph";
                String pass = "ixbIlUDKfe";
                
                cache.setConnector(DriverManager.getConnection(url, user, pass));
            }catch(SQLException e){
                cache.setConnector(null);
            }
        }
        
        return cache.getConnector();
    }
}
