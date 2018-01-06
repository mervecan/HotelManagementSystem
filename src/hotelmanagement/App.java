package hotelmanagement;



import javax.swing.JOptionPane;

public class App {

	public static void main(String[] args) throws Exception {
	
		 try
		  {
		  LoginGUI frame=new LoginGUI();
		 
		  frame.setVisible(true);
		  }
		  catch(Exception e)
		  {
			  JOptionPane.showMessageDialog(null, e.getMessage());
			  }
		  }
      }
      



