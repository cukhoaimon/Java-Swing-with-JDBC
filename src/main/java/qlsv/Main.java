package qlsv;

import java.sql.SQLException;

@SuppressWarnings("unused")
public class Main extends Thread {
	private static LoginFrame login;
	private static HomeFrame home;
	
	
	public static void main(String[] args)  throws SQLException {
		initLogin();
}
	
	private static boolean initLogin() {
		login = new LoginFrame();
		return true;
	}
}
