package hotelmanagement;

import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListEmployeeGUI extends JFrame{
        private JPanel contentPane;
        JTable table=new JTable();
        DAL dal=new DAL();
        public ListEmployeeGUI() throws SQLException{
        	setTitle("EMPLOYEES");
        	setVisible(true);
     		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     		setBounds(100, 100, 600, 450);
     		contentPane = new JPanel();
     		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
     		setContentPane(contentPane);
     		contentPane.setLayout(null);
     		String [] header ={"id","SSN","name","surname","gender","age","salary","hiredate"};
     		DefaultTableModel model = new DefaultTableModel(header,0);
    		String sql="SELECT id,SSN,name,surname,gender,age,salary,hiredate FROM Employee ";
    		PreparedStatement st= dal.getConnection().prepareStatement(sql);
    		ResultSet rs = st.executeQuery();
    		while(rs.next())
    		{
    		    int id = rs.getInt(1);
    		    int SSN=rs.getInt(2);
    		    String name = rs.getString(3);
    		    String surname=rs.getString(4);
    		    String gender=rs.getString(5);
    		    int age=rs.getInt(6);
    		    double salary=rs.getDouble(7);
    		    Date hiredate=rs.getDate(8);
    		    
    		    
    		    model.addRow(new Object[]{id, SSN, name,surname,gender,age,salary,hiredate});
    		}
    		JScrollPane scrollPane = new JScrollPane(table);
    		table.setModel(model);
    		contentPane.add(table);
    		table.setBounds(50, 25, 400, 200);
    		contentPane.add(table);

    		  
    		
    	
    		contentPane.add(table, BorderLayout.CENTER);
    		JLabel lblNewLabel = new JLabel("New label");
    		lblNewLabel.setBackground(new Color(0, 0, 255));
    		//lblNewLabel.setIcon(new ImageIcon("/home/turkandemirci/rsz_motel.jpg"));
    		lblNewLabel.setBounds(0, -12, 600, 450);
    		getContentPane().add(lblNewLabel);
        }
       
}
