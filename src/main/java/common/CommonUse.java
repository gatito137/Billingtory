package common;

public class CommonUse {
    public StringBuilder query = new StringBuilder();
    
    public String getCleanText(String Text){
        return Text.trim().replace("/", "").replace("-", "").replace("'", "");
    }
    
    public Integer getNat(String toValue){
        toValue = getCleanText(toValue);
        
        try{
            if(Integer.parseInt(toValue) < 0){
                return Integer.parseInt(toValue) * -1;
            }
            
            return Integer.parseInt(toValue);            
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    public float getFloat(String toValue){
        toValue = getCleanText(toValue);
        
        try{
            if(Float.parseFloat(toValue) < 0){
                return Float.parseFloat(toValue) * -1;
            }      
            
            return Float.parseFloat(toValue);
        }catch(NumberFormatException e){
            return -1;
        }
    }
    
    public void changeListIndex(javax.swing.JComboBox List, String Find){
        List.setSelectedIndex(0);
        
        for(int  i = 1; i < List.getItemCount(); i++){
            if(List.getItemAt(i).equals(Find)){
                List.setSelectedIndex(i);
                return;
            }
        }
    }
}