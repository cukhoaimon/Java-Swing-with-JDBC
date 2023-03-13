package qlsv;

import java.sql.SQLException;

import javax.swing.SwingUtilities;

@SuppressWarnings("unused")
public class Main extends Thread {
	private static LoginFrame login;
	private static HomeFrame home;

	public static void main(String[] args) throws SQLException {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				initLogin();
			}
		});
		
	}

	private static boolean initLogin() {
		login = new LoginFrame();
		return true;
	}
}
