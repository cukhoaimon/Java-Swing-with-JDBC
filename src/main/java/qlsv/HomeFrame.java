package qlsv;

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
		
		DBManager sql = DBManager.getInstance();
		ResultSet qr = sql.runQuery("SELECT * FROM SinhVien");
		svList = new ArrayList<SinhVien>();
		
		while (qr.next()) {
			svList.add(new SinhVien.Builder().id(qr.getString(1))
					.name(qr.getString(2)).dob(qr.getString(3))
					.mark(qr.getDouble(4)).build());		
		}
		
		svList.forEach(sv -> {
			JLabel lab = new JLabel(sv.toString());
			lab.setFont(new Font("Consolas", Font.PLAIN, 16));
			inforContainer.add(lab);
		});
		
		JPanel optionContainer = new JPanel();
		optionContainer.setLayout(new BoxLayout(optionContainer, BoxLayout.Y_AXIS));
		
		JButton addSV = new JButton("Thêm sinh viên");
		addSV.setFont(new Font("Serif", Font.PLAIN, 32));
		JButton delSV = new JButton("Xóa sinh viên");
		delSV.setFont(new Font("Serif", Font.PLAIN, 32));
		
		optionContainer.add(addSV);
		optionContainer.add(Box.createRigidArea(new Dimension(100, 100)));
		optionContainer.add(delSV);
		
		int width = 800;
		int height = 600;
		Dimension pos = LoginFrame.getAlignPos(width, height);

		this.setTitle("Làm ơn chạy đi, tao mệt rồi");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds((int)pos.width, (int)pos.height, width, height);
		this.setLayout(new FlowLayout());
		this.add(inforContainer);
		this.add(optionContainer, JPanel.CENTER_ALIGNMENT);

		System.out.println("Khởi tạo rùi địt mẹ mày");
		this.setVisible(true);
	}
	
	
}
