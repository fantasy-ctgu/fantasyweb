package com.ctgu.qmx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	public static ThreadLocal<Connection> t1 = new ThreadLocal<Connection>();
	private static String username = null;
	private static String password = null;
	private static String driver = null;
	private static String url = null;

	private static Connection con = null;

	static {
		Properties properties = new Properties();
		InputStream in = DBUtils.class.getResourceAsStream("db.properties");
		try {
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		username = properties.getProperty("jdbc.username");
		password = properties.getProperty("jdbc.password");
		driver = properties.getProperty("jdbc.driver");
		url = properties.getProperty("jdbc.url");
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection createCon() throws SQLException {
		con = DriverManager.getConnection(url, username, password);
		return con;
	}

	public static Connection getCon() throws SQLException{
		if(t1.get() == null){
			con = createCon();
			t1.set(con);
		}
		return t1.get();
	}
	
	public static void closeCon() throws SQLException {
		if (t1 != null) {
			t1.get().close();
			t1.set(null);
		}
	}
	public static void main(String []args) throws SQLException{
		System.out.println(createCon());
	}

}
