package hotelmanagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

public class MangEmpGUI extends JFrame {
   DAL dal=new DAL();
    private JPanel contentPane;
	private JTextField textField;
	private  JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblGender;
	private JLabel lblNewLabel;
	private JLabel lblAge;
	private JTextField textField_6;
	private JTextField textField_7;
	 

	public MangEmpGUI() {
		setVisible(true);
		setTitle("EMPLOYEE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(32, 49, 140, 20);
		contentPane.add(lblSurname);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setForeground(Color.WHITE);
		lblSsn.setBounds(32, 79, 140, 20);
		contentPane.add(lblSsn);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(32, 19, 140, 20);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(204, 19, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 49, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 79, 200, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(204, 109, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 139, 200, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setBounds(32, 109, 140, 20);
		contentPane.add(lblPhone);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(32, 139, 140, 20);
		contentPane.add(lblGender);
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(Color.WHITE);
		lblAge.setBounds(32, 169, 140, 20);
		contentPane.add(lblAge);
		
		textField_6 = new JTextField();
		textField_6.setBounds(204, 169, 200, 20);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(471, 390, 117, 25);
		contentPane.add(btnSave);
		
		
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    JFormattedTextField calendar = new JFormattedTextField(formatter);
		calendar.setBounds(204, 260, 200, 20);
		contentPane.add(calendar);
		
		JLabel lblHireDate = new JLabel("Hire Date");
		lblHireDate.setForeground(Color.WHITE);
		lblHireDate.setBounds(32, 260, 140, 20);
		contentPane.add(lblHireDate);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setBounds(32, 199, 70, 15);
		contentPane.add(lblSalary);
		
		textField_7 = new JTextField();
		textField_7.setBounds(204, 199, 200, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
	
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		//lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
		lblNewLabel.setBounds(5, 5, 590, 440);
		getContentPane().add(lblNewLabel);
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Connection myConn=dal.getConnection();
					String name=textField.getText();
			        String surname=textField_1.getText();
			        int  SSN= Integer.parseInt(textField_2.getText());
			        String phone=textField_3.getText();
			        String gender=textField_4 .getText();
			        int age=Integer.parseInt(textField_6.getText());
			        double salary=Double.parseDouble(textField_7.getText());
			        Date date=new Date();
			        String dateString =formatter.format(date);
			        
			    		 
                    PreparedStatement ps=myConn.prepareStatement("INSERT INTO Employee(id,name,surname,SSN,phone,gender,age,salary,hiredate) VALUES(null,'"+name+"','"+surname+"','"+SSN+"','"+phone+"','"+gender+"','"+age+"','"+salary+"','"+dateString+"')");
			        if(SSN==0){
			        	JOptionPane.showConfirmDialog(null, "SSN can not be NULL!",
	                            "Result", JOptionPane.DEFAULT_OPTION,
	                            JOptionPane.PLAIN_MESSAGE);
			        }
			    		   
			        ps.executeUpdate();
			        JOptionPane.showConfirmDialog(null, "Employee is saved !",
                            "Result", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
			        myConn.close();
			        ps.close();
					
			    		  
			    
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
			}
		});
		
	}
}