package bridge;

import connector.CrudMySQL;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Bridge {
    private final CrudMySQL crud = new CrudMySQL();
    
    public String getValue(String query){
        return crud.getValue(query);
    }
    
    public void executeQuery(String query){
        crud.executeQuery(query);
    }
    
    public DefaultTableModel getTable(DefaultTableModel newTable, String query){
        return crud.getTable(newTable, query);
    }
    
    public void getList(JComboBox List, String query){
        crud.getList(List, query);
    }
    
    public Integer getNat(String query){
        return crud.getNatural(query);
    }
}
