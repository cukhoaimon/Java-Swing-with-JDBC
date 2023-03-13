package qlsv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public static HomeFrame instance = null;
	private List<SinhVien> svList;
	
	public static HomeFrame getInstance() throws SQLException {
		if (instance == null) {
			instance = new HomeFrame();
		}
		
		return instance;
	}
	
	private HomeFrame() throws SQLException {
		JPanel inforContainer = new JPanel();
		inforContainer.setLayout(new BoxLayout(inforContainer, BoxLayout.Y_AXIS));
		inforContainer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		JPanel a = new JPanel();
		JPanel b = new JPanel();
		this.add(a, BorderLayout.EAST);
		this.add(a, BorderLayout.WEST);
		for (int i = 0; i < 10; i++) {
			JLabel x = new JLabel("Adu vjp", SwingConstants.CENTER);
			x.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			inforContainer.add(x);
			
		}
		JPanel optionContainer = new JPanel();
		optionContainer.setLayout(new FlowLayout());
		
		JButton addSv = new JButton("Thêm sinh viên");
		JButton delSv = new JButton("Xóa sinh viên");
		JButton logOut = new JButton("Đăng xuất");
		JButton changepsw = new JButton("Đổi mật khẩu");
		
		optionContainer.add(addSv);
		optionContainer.add(delSv);
		optionContainer.add(logOut);
		optionContainer.add(changepsw);
		
		
		int width = 800;
		int height = 600;
		Dimension pos = LoginFrame.getAlignPos(width, height);

		this.setTitle("Làm ơn chạy đi, tao mệt rồi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)pos.width, (int)pos.height, width, height);
		this.setLayout(new BorderLayout());
		
	
		
		this.add(inforContainer, BorderLayout.CENTER);
		this.add(optionContainer, BorderLayout.NORTH);
		
		this.setVisible(true);
	}
	
	
}
