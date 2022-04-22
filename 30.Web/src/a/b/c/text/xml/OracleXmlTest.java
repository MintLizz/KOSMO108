package a.b.c.test.xml;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OracleXmlTest {
	
	public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml";
	
	public static final String XML_PROLOG = "<?xml version='1.0' encoding='euc-kr'?>";
	
	public String getXml(final String tableName) throws Exception{
		
		System.out.println("	String tableName 은 ?	>>> : " + tableName);
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		
		ResultSetMetaData resultMeta = null;
		int colCount = 0;
		
		StringBuffer strBuffer = new StringBuffer(XML_PROLOG);
		
		try {
			
			con = DBPropertyConn.getConnection();
			
		
			stmt = con.createStatement();
			rsRs = stmt.executeQuery("SELECT * FROM " + tableName);
			
			resultMeta = rsRs.getMetaData();
			
			colCount = resultMeta.getColumnCount();
			
			System.out.println("	" + tableName + " 테이블 컬럼 카운트는 ?	>>> : " + colCount);
			
			strBuffer.append("\n");
			strBuffer.append("<" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
			
			while (rsRs.next()) {
				
				strBuffer.append("<" +  "ROW" + ">");
				
				for ( int i = 0; i < colCount; i++ ) {
					
					strBuffer.append("<" + resultMeta.getColumnName(i+1) + ">");
					strBuffer.append(rsRs.getString(i+1));
					strBuffer.append("</" + resultMeta.getColumnName(i+1) + ">");
					strBuffer.append("\n");
					
				}
				
				strBuffer.append("</" +  "ROW" + ">");
			}

			strBuffer.append("</" + tableName.toUpperCase() + ">");
			strBuffer.append("\n");
			
		} catch (SQLException e) {
			
			System.out.println("	getXML() 은 ?	>>> : " + e);
			
		} finally {}
		
		return strBuffer.toString();
		
	}
	
	public static boolean xmlParse(String fileName, String xmlVal) {
		
		boolean bool = false;
		
		try {
			
			BufferedWriter bw = new BufferedWriter(
					
					new FileWriter(OracleXmlTest.XML_FILE_PATH + "/" + fileName.toLowerCase() + ".xml"));
			bw.write(xmlVal);
			bw.flush();
			bw.close();
			
			bool = true;
			
		} catch(IOException e) {
			
			System.out.println("	오류가 도착해슴!	>>> : " + e.getMessage());
			
		}
		
		return bool;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			OracleXmlTest ox = new OracleXmlTest();
			
			Scanner sc = new Scanner(System.in);
			System.out.println("	테이블의 이름을 KEY-IN 입력 하세요	>>> : ");
			
			String tableName = sc.next();
			
			if (tableName.length() > 0) {
				
				// EMP 테이블의 이름 길이는 EMP이기 때문에 3이다.
				System.out.println("	tableName.length()는 ?	>>> : " + tableName.length());
				
				final String fileName = tableName;
				
				String xmlVal = ox.getXml(fileName);
				System.out.println("	Oracle String Data를 XML로 생성한다.	>>> : " + xmlVal);
				
				if (xmlVal != null && xmlVal.length() > 0 ) {
					
					boolean bool = xmlParse(fileName, xmlVal);
					
					if (bool) {
						
						System.out.println("	" + OracleXmlTest.XML_FILE_PATH + " 디렉토리에 " + fileName + ".xml 파일이 잘 생성되어슴!");
					
					}else {
						
						System.out.println("	파일이 생성 안되슴! 다시 확인해보셈!");
					}
				}
				
			}else {
			
				System.out.println("	java OracleXmlTest 테이블의 이름!");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("	에러 메세지 발견!!!! " + e.getMessage());
			
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
