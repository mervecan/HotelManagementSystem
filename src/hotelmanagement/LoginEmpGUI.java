package hotelmanagement;



import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginEmpGUI extends JFrame {
	private JTextField textField;
	private JPasswordField textField_1;
    Login login =new Login();
	
	public LoginEmpGUI() {
		setVisible(true);
		
		getContentPane().setEnabled(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblUs = new JLabel("Username: ");
		lblUs.setBackground(new Color(0, 255, 255));
		lblUs.setForeground(Color.WHITE);
		lblUs.setBounds(12, 175, 120, 15);
		getContentPane().add(lblUs);
		
		JLabel lblPs = new JLabel("Password:  ");
		lblPs.setForeground(Color.WHITE);
		lblPs.setSize(115, 15);
		lblPs.setLocation(12, 220);
		lblUs.setBounds(12, 175, 115, 15);
		getContentPane().add(lblPs);
		
		textField = new JTextField();
		textField.setBounds(140, 175, 280, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField(20);
		textField_1.setBounds(140, 220, 280, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLogin.setBounds(302, 268, 117, 20);
		getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.setBounds(165, 268, 117, 20);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		//lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
		lblNewLabel.setBounds(0, -12, 450, 300);
		getContentPane().add(lblNewLabel);
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if(login.authenticateEmployee(getUsername(),getPassword())){
					new MangEmpGUI2();
					
				}
				else{
					String message = "Wrong username or password";
				      
				    JOptionPane.showMessageDialog(new JFrame(), message, "WARNING",
				        JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});

	}
	public String getUsername() {
        return textField.getText().trim();
    }
 
    public String getPassword() {
         return new String (textField_1.getPassword());
    }
 
}
