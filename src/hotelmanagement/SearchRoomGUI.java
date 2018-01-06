package hotelmanagement;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import com.mysql.jdbc.Statement;

import javax.swing.JTable;
import javax.swing.JList;

public class SearchRoomGUI extends JFrame {

	private JPanel contentPane;
	JTable table=new JTable();
    DAL dal=new DAL();
	
	public SearchRoomGUI() throws SQLException {
	    setTitle("ROOMS");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String header[] = {"Room No", "Status", "Capacity", "Type"};
		  
		for(int i=0;i<table.getColumnCount();i++)
		{
		TableColumn column1 = table.getTableHeader().getColumnModel().getColumn(i);
		  
		column1.setHeaderValue(header[i]);
		} 
		DefaultTableModel model = new DefaultTableModel(header,0);
		String sql="SELECT roomNo,status,capacity,detail  FROM Room WHERE status = 'YES'";
		PreparedStatement st= dal.getConnection().prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		while(rs.next())
		{
		    int roomNo = rs.getInt(1);
		    String status = rs.getString(2);
		    int capacity= rs.getInt(3);
		    String type=rs.getString(4);
		    
		    model.addRow(new Object[]{roomNo, status, capacity,type});
		}
		JScrollPane scrollPane = new JScrollPane(table);
		table.setModel(model);
		contentPane.add(table);
		table.setBounds(50, 25, 400, 200);
		contentPane.add(table);

		  
		
		//JTableHeader header = table.getTableHeader();
		contentPane.add(table, BorderLayout.CENTER);
		
	    
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(0, 0, 255));
		lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
		lblNewLabel.setBounds(0, -12, 600, 450);
		getContentPane().add(lblNewLabel);
	}
}