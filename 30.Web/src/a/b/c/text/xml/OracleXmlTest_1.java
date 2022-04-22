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

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class OracleXmlTest_1 {
	
	// C:\00.KOSMO108\30.Web\eclipse_work_hbe_work\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\kosMember\kos_xml	
	public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_web_work_psh\\kosmoMember\\WebContent\\kos_xml";
	
	// public static final String XML_FILE_PATH = "C:\\00.KOSMO108\\30.Web\\eclipse_work_hbe_work\\kosMember\\WebContent\\kos_xml";
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
	
	public boolean makeXml(final String tableName) {
			
			boolean bool = false;
			
			try{		
				
				if(tableName.length() > 0){		
					
					final String fileName = tableName; 
					
					System.out.println("	fineName 은 ?	>>> : " + fileName);
					
					String xmlVal = getXml(fileName);
					System.out.println("	Oralce String Data를 xml로 생성 >>> : \n" + xmlVal);
					
					if (xmlVal !=null && xmlVal.length() > 0){
						
						bool = OracleXmlTest_1.xmlParse(fileName, xmlVal);
						if (bool){
							System.out.println("	" + OracleXmlTest_1.XML_FILE_PATH +" 디렉토리에 " + fileName +".xml 파일이 잘 생성 되었습니다. ");
						}else{
							System.out.println(" 파일이 생성 되지 않았습니다. ");
						}	
					}
				}else{	
					System.out.println("	java OracleXmlTest 테이블이름 ");
					
				}				
			}catch(Exception e){
				
				System.out.println("	e.getMessage() >>> : " + e.getMessage());
			}	
			
			return bool;
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Logger logger = LogManager.getLogger(OracleXmlTest.class);
		
		
		
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("	테이블의 이름을 KEY-IN 입력 하세요	>>> : ");
			
			// 1. tableName 테이블 이름을 입력하세요.
			// 여기서 스타트를 한다.
			String tableName = sc.next();
			logger.info("	tableName 테이블 이름은 ?	>>> : " + tableName);
			
			OracleXmlTest_1 ot_1 = new OracleXmlTest_1();
			
			if (tableName.length() > 0) {
				
				// EMP 테이블의 이름 길이는 EMP이기 때문에 3이다.
				System.out.println("	tableName.length()는 ?	>>> : " + tableName.length());
					
					boolean bool = ot_1.makeXml(tableName);
					
					System.out.println("	bool 의 값은 ?	>>> : " + bool);
					
			}else {
			
				System.out.println("	java OracleXmlTest 테이블의 이름!");
				
			}
			
		} catch (Exception e) {
			
			System.out.println("	에러 메세지 발견!!!! " + e.getMessage());
			
		}
		
	}
}
