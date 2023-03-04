package qlsv;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


@SuppressWarnings("serial")
public class LoginFrame extends JFrame{
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginButton;
	private JPanel contentPanel;
	
	public LoginFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		// setup panel
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(null);
		
		this.setContentPane(contentPanel);
		
		// setup label
		final JLabel logLabel = new JLabel("Login");
		logLabel.setForeground(Color.black);
		logLabel.setFont(new Font("Consolas", Font.BOLD, 46));
		logLabel.setBounds(423, 13, 273, 93);
		
		contentPanel.add(logLabel);
		
		// setup text field
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
		textField.setBounds(481, 170, 281, 68);
        contentPanel.add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPanel.add(passwordField);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPanel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPanel.add(lblPassword);
        
        loginButton = new JButton("Login");
        loginButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        loginButton.setBounds(545, 392, 162, 73);
        loginButton.addActionListener(new ActionListener() {
        	@SuppressWarnings("deprecation")
        	public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				try {
					DBManager sql = DBManager.getInstance();
					
					String loginInfo = "SELECT * FROM ThongTinDangNhap WHERE username =\'" + username + "\' AND password =\'" + password + "\'";
					ResultSet result = sql.runQuery(loginInfo);
					
					if (result.next() == true)
					{
						hideLogin();
						HomeFrame hom = HomeFrame.getInstance();
					}
					else {
						logLabel.setText("Nice try");
						
						System.out.println("Sai mat khau");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
        });
        
       
        contentPanel.add(loginButton);
        Dimension pos = getAlignPos(1014, 597);
        this.setBounds(pos.width, pos.height, 1024, 600);
        this.setVisible(true);
	}
	
	
	
	public static Dimension getAlignPos(int frameWidth, int frameHeight) {
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
	    
	    // width will store the width of the screen
	    int screenWidth = (int)size.getWidth();
	    int screenHeight = (int)size.getHeight();
	    
	    int posX = (int)(screenWidth - frameWidth)/2; 
	    int posY = (int)(screenHeight - frameHeight)/2; 
	    
	    Dimension position = new Dimension(posX, posY);
	    return position;
	}
	
	private void hideLogin() {
		this.setVisible(false);
	}
}

