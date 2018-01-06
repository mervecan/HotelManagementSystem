package hotelmanagement;

import java.awt.BorderLayout;
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

public class MenuGUI extends JFrame {

	private JPanel contentPane;

	
	public MenuGUI() {
	
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.setBounds(129, 70, 187, 25);
		contentPane.add(btnMakeReservation);
		
		JButton btnSearchRooms = new JButton("Search Rooms");
		btnSearchRooms.setBounds(129, 110, 187, 25);
		contentPane.add(btnSearchRooms);
		
		JButton btnManageGuest = new JButton("Manage Guest");
		btnManageGuest.setBounds(129, 150, 187, 25);
		contentPane.add(btnManageGuest);
		
		JButton btnManageEmployee = new JButton("Manage Employee");
		btnManageEmployee.setBounds(129, 190, 187, 25);
		contentPane.add(btnManageEmployee);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(114, 50, 1, 15);
		//lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
		lblNewLabel.setBounds(0, -12, 450, 300);
		contentPane.add(lblNewLabel);
		setVisible(true);
		

		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
					new ReservationGUI();
				    
				
			}
		});
		
		btnManageGuest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
					new MangGuestGUI();
				    
				
			}
		});
		btnManageEmployee.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				new LoginEmpGUI();
			}
		});
		btnSearchRooms.addActionListener(new ActionListener(){
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