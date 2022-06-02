package bridge;

import presentation.Loader;
import connector.CrudMySQL;

public class StartConnection extends Thread{
    private Loader load;
    private CrudMySQL crud = new CrudMySQL();
    
    public StartConnection(Loader load){
        this.load = load;
    }
    
    @Override
    public void run(){
        load.setTitle("Estableciendo conexión...");
        int nope = crud.getNatural("select 1 as Uno;");
        load.setTitle("Conexión establecida");
    }
}