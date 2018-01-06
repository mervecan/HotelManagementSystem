package hotelmanagement;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login {
    
    public static boolean authenticate(String username, String password) {
        
        if (username.equals("xxmotel") && password.equals("secret")) {
            return true;
        }
        return false;
    }
    public static boolean authenticateEmployee(String username,String password){
    	if(username.equals("manager") && password.equals("secret")){
    		return true;
    	}
    	return false;
    }
	
}