package hotelmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MangEmpGUI2 extends JFrame {

        private JPanel contentPane;

     
        public MangEmpGUI2(){
        	    setVisible(true);
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                setBounds(100, 100, 450, 300);
                contentPane = new JPanel();
                contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
                setContentPane(contentPane);
                contentPane.setLayout(null);

                JButton btnAddEmployee = new JButton("Add Employee");
                btnAddEmployee.setBounds(120, 120, 200, 25);
                contentPane.add(btnAddEmployee);

                JButton btnListOfEmployees = new JButton("List of Employees");
                btnListOfEmployees.setBounds(120, 150, 200, 25);
                contentPane.add(btnListOfEmployees);

                JLabel lblNewLabel = new JLabel("New label");
                lblNewLabel.setBackground(new Color(0, 0, 255));
              //  lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
                lblNewLabel.setBounds(0, -12, 450, 300);
                getContentPane().add(lblNewLabel);
                contentPane.add(lblNewLabel);
        
        btnAddEmployee.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new MangEmpGUI();
			}
        	
        }); 
        btnListOfEmployees.addActionListener(new ActionListener(){

    		
    			public void actionPerformed(ActionEvent arg0) {
    				try {
    			      new ListEmployeeGUI();
    					
    				} catch (SQLException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
    				
    			}
    			 
    		 });       
}
}
