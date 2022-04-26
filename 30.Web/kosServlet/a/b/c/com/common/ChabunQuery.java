
package a.b.c.com.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class ChabunQuery {
	
	public static final short CHABUN_QUERY_MEMBER = 0;
	public static final short CHABUN_QUERY_BOARD = 1;
	
	public static String chabun_query[] = { 
			// SELSEC NVL 이거는 A.MNUM 변수의 숫자에서 뒤에서 4번째부터 출력하며,
			// 순서를 위해 +1 을 해준다.
			// 그리고 NVL 이거는 null이 있으면 0으로 치환해주는 값이다.
			// 그래서 A.MNUM에 null 값이 있으면 0으로 치환해줌
			"SELECT NVL(MAX(SUBSTR(A.MNUM, -4)), 0) + 1 AS COMM_NUM FROM KOS_MEMBER_PSH A",
			"SELECT /*+ INDEX_DESC(A SYS_C0011089) */ NVL(MAX(SUBSTR(A.BNUM, -4)), 0) + 1 AS COMMON FROM MVC_BOARD A"
		};
	
	public static String getMemChabunQuery() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";

		try {
			conn = KosConnectivity.getConnection();
			
			String sql = ChabunQuery.chabun_query[ChabunQuery.CHABUN_QUERY_MEMBER];
			pstmt = conn.prepareStatement(sql);
			// slq 이거는 우리가 선택한 채번쿼리 sql문이다.
			System.out.println("	채번 쿼리 >>> : " + sql);
	
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				while (rsRs.next()) {
					
					// ---------------------
					commNum = rsRs.getString("COMM_NUM");	// 5				
				}
				
			}else {
				System.out.println("	ChabunQuery :: 채번 검색 결과가 업슴! >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("	ChabunQuery :: 채번 검색중 에러가  발생해슴! >>> : " + e.getMessage());
		}
		return commNum;
	}
	
	public static String getBoardChabunQuery() {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		String commNum = "";
		
		try {
			conn = KosConnectivity.getConnection();
			
			String sql = ChabunQuery.chabun_query[1];
			pstmt = conn.prepareStatement(sql);
			
			// slq 이거는 우리가 선택한 채번쿼리 sql문이다.
			System.out.println("	채번 쿼리는 ?	>>> : " + sql);
	
			rsRs = pstmt.executeQuery();

			if (rsRs !=null) { 
				while (rsRs.next()) {
					
					// ---------------------
					commNum = rsRs.getString("COMMON");					
				}
				
			}else {
				System.out.println("	ChabunQuery :: 채번 검색 결과가 업슴! >>> : " + rsRs);
			}
		}catch(Exception e) {
			System.out.println("	ChabunQuery :: 채번 검색중 에러가  발생해슴! >>> : " + e.getMessage());
		}
		return commNum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 여기서 ChabunQuery.getBoardChabunQuery() 이렇게 메인함수에 선언한 이유
		// static으로 되어있기 때문에 class.함수명() 이렇게 선언한다.
		String commNum = ChabunQuery.getBoardChabunQuery();
		System.out.println("	commNum 리턴값은 ?	>>> : " + commNum);
		
	}

}


























