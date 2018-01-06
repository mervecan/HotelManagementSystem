package hotelmanagement;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReservationGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
    private JTextField roomField;
    
	public ReservationGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setTitle("RESERVATION");
	
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBounds(32, 69, 140, 20);
		contentPane.add(lblSurname);
		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setForeground(Color.WHITE);
		lblSsn.setBounds(32, 99, 140, 20);
		contentPane.add(lblSsn);
		
		JLabel lblNumberOfGuest = new JLabel("Number of Guest");
		lblNumberOfGuest.setForeground(Color.WHITE);
		lblNumberOfGuest.setBounds(32, 129, 140, 20);
		contentPane.add(lblNumberOfGuest);
		
		JLabel lblCheckinDate = new JLabel("Check-in Date");
		lblCheckinDate.setForeground(Color.WHITE);
		lblCheckinDate.setBounds(32, 189, 140, 20);
		contentPane.add(lblCheckinDate);
		
		JLabel lblCheckoutDate = new JLabel("Check-out Date");
		lblCheckoutDate.setForeground(Color.WHITE);
		lblCheckoutDate.setBounds(32, 219, 140, 20);
		contentPane.add(lblCheckoutDate);
		
		JLabel lblReservationDetail = new JLabel("Reservation Detail");
		lblReservationDetail.setForeground(Color.WHITE);
		lblReservationDetail.setBounds(32, 159, 140, 20);
		contentPane.add(lblReservationDetail);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setBounds(32, 39, 140, 20);
		contentPane.add(lblName);
		 
		JLabel lblRoom=new JLabel("Room");
		lblRoom.setForeground(Color.WHITE);
		lblRoom.setBounds(32,249,140,20);
		contentPane.add(lblRoom);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField calendar = new JFormattedTextField(formatter);
		calendar.setBounds(204, 189, 200, 20);
		contentPane.add(calendar);
		SimpleDateFormat formatter_1 = new SimpleDateFormat("yyyy-MM-dd");
		JFormattedTextField calendar_1 = new JFormattedTextField(formatter_1);
		
		calendar_1.setBounds(204, 219, 200, 20);
		contentPane.add(calendar_1);
		
		textField = new JTextField();
		textField.setBounds(204, 39, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(204, 69, 200, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(204, 99, 200, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(204, 129, 200, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(204, 159, 200, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		roomField=new JTextField();
		roomField.setBounds(204, 250, 200, 20);
		contentPane.add(roomField);
		roomField.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setForeground(Color.WHITE);
		lblAmount.setBounds(32, 299, 140, 20);
		contentPane.add(lblAmount);
		
		textField_5 = new JTextField();
		textField_5.setBounds(204, 300, 200, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnSave = new JButton("SAVE");
		btnSave.setForeground(Color.BLUE);
		btnSave.setBounds(448, 400, 117, 25);
		contentPane.add(btnSave);
		
		JButton btnChoose =new JButton("CHOOSE");
		btnChoose.setForeground(Color.BLUE);
		btnChoose.setBounds(408, 250, 117, 25);
		contentPane.add(btnChoose);	
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		//lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
		lblNewLabel.setBounds(0, -12, 600, 450);
		getContentPane().add(lblNewLabel);
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Connection myConn=DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagement?useSSL=false","root","Turkan*94");
					String name=textField.getText();
			        String surname=textField_1.getText();
			        int  SSN=Integer.parseInt(textField_2.getText());
			        int numberofPerson=Integer.parseInt(textField_3.getText());
			        String detail=textField_4.getText();
				    Date date=new Date();
			        String checkinDate =formatter.format(date);
			        Date date1=new Date();
			        String checkoutDate=formatter_1.format(date1);
			        int room=Integer.parseInt(roomField.getText());
			        double amount=Double.parseDouble(textField_5.getText());
			        
			       PreparedStatement ps=myConn.prepareStatement("INSERT INTO Reservation(id,name,surname,SSN,numberofperson,detail,checkindate,checkoutdate,roomNo,amount) VALUES(null,'"+name+"','"+surname+"','"+SSN+"','"+numberofPerson+"','"+detail+"','"+checkinDate+"','"+checkoutDate+"','"+room+"','"+amount+"')");
			         
		    		   
			       ps.executeUpdate();
			        JOptionPane.showConfirmDialog(null, "Reservation completed successfully!",
                            "Result", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.PLAIN_MESSAGE);
				    
				 } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			     
				}
				
			
		});
		btnChoose.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				try {
					new SearchRoomGUI();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		
	
	}
}