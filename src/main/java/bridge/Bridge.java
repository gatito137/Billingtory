package bridge;

import connector.CrudMySQL;

public class Bridge {
    private final CrudMySQL crud = new CrudMySQL();
    
    public String getValue(String query){
        return crud.getValue(query);
    }
}
