package a.b.c.test.xml;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public abstract class DBPropertyConn {
	
	public static Connection getConnection() {
		
		String path = "C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\src";
		Connection conn = null;
		
		try {
			
			FileReader fr = new FileReader(path + "/" + "db.properties");
			Properties prop = new Properties();
			prop.load(fr);
			
			String JDBC_DRIVER = prop.getProperty("driver");
			String JDBC_URL = prop.getProperty("url");
			String JDBC_USER = prop.getProperty("username");
			String JDBC_PASSWORD = prop.getProperty("password");
			
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			
		}catch (Exception e) {
			
			System.out.println("	데이터 베이스 연결에 문제가 발생해슴!	>>>> : " +  e.getMessage());
			
		}
		
		return conn;
		
	}
	
	public static void conClose( Connection conn, PreparedStatement pstmt, ResultSet rsRs) {
		
		try {
			
			if (rsRs != null)	try { rsRs.close(); rsRs = null;}	catch(Exception e) {}
			if (pstmt != null)	try { pstmt.close(); pstmt = null;}	catch(Exception e) {}
			if (conn != null)	try { conn.close(); conn = null;}	catch(Exception e) {}
			
		}catch(Exception e) {
			
			System.out.println("	conClose 1번의 문제 메세지임	>>> : " + e.getMessage());
		}
	}
	
	public static void conClose( Connection conn, PreparedStatement pstmt) {
		
		try {
			
			if (pstmt != null)	try { pstmt.close(); pstmt = null;}	catch(Exception e) {}
			if (conn != null)	try { conn.close(); conn = null;}	catch(Exception e) {}
			
		}catch(Exception e2) {
			
			System.out.println("	conClose 2번의 문제 메세지임	>>> : " + e2.getMessage());
		}
	}

}
