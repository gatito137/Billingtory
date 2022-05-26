package common;

public class CommonUse {
    public StringBuilder query = new StringBuilder();
    
    public String getCleanText(String Text){
        return Text.trim().replace("/", "").replace("-", "").replace("'", "");
    }
}
