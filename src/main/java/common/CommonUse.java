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
    
    public String validateMail(String mail){
        mail = getCleanText(mail);
        
        if(mail.indexOf("@") == 0){
            return "";
        }
        
        if(mail.substring(0, mail.indexOf("@")).length() < 4 && mail.substring(mail.indexOf("@") + 1, mail.length()).length() < 5){
            return "";
        }
        
        if(CountCaracteres(mail.substring(mail.indexOf("@"), mail.length()), ".") != 1){
            return "";
        }
        
        return mail;
    }
    
    private int CountCaracteres(String Text, String Caracter){
        int Counter = 0;
        
        for(int i = 0; i < Text.length(); i++){
            if(Text.substring(i, i+1).equals(Caracter)){
                Counter++;
            }
        }
        
        return Counter;
    }
}