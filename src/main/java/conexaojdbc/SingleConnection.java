package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String url = "jdbc:mysql://127.0.0.1:3306/posjava";//posjava é o nome do banco
	private static String user = "Admin";
	private static String password = "mysqlAdmin";
	private static Connection connection = null;
	
	static {
		Conectar();
	}
	
	public SingleConnection() {
		Conectar();
	}
	
	private static void Conectar() {
		try {
			if(connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);
				System.out.println("Conectou com sucesso");
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
