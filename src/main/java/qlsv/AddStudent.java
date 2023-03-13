package qlsv;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddStudent extends JFrame{
	public static AddStudent instance = null;
	
	public static AddStudent getInstance() throws SQLException {
		if (instance == null) {
			instance = new AddStudent();
		}
		
		return instance;
	}
	
	private AddStudent() {
		JPanel id = createInforLine("id");
		JPanel name = createInforLine("name");
		JPanel dob = createInforLine("dob");
		JPanel mark = createInforLine("mark");
		
		this.add(id);
		this.add(name);
		this.add(dob);
		this.add(mark);
		
		int width = 800;
		int height = 600;
		Dimension pos = LoginFrame.getAlignPos(width, height);
		this.setTitle("Làm ơn chạy đi, tao mệt rồi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)pos.width, (int)pos.height, width, height);
		this.setLayout(new BorderLayout());
		this.setVisible(true);
	}
	
	static private JPanel createInforLine(String request) {
		JPanel target = new JPanel();
		
		JLabel lb = new JLabel(request);
		JTextField textField = new JTextField();
		
		target.add(lb);
		target.add(textField);
		
		return target;
	}
	
}
