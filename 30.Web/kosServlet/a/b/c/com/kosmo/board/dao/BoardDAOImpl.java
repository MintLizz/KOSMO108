package a.b.c.com.kosmo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import a.b.c.com.common.KosConnectivity;
import a.b.c.com.kosmo.board.sql.BoardSqlMap;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {

	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		
		// 사용할 객체를 지역변수로 선언하고 초기화 하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		
		// JDBC 객체를 이용해서 테이블에 INSERT 하기
		
		try {
			
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardInsert();
			pstmt = conn.prepareStatement(sqls);
			System.out.println("	sqls 는 ?	>>> : " + sqls);
			
			// 플레이스 홀더에 데이터 바인딩하기
			/*
			sb3.append(" 						 ?						\n"); // placeholder 1
			sb3.append(" 						,?						\n"); // placeholder 2
			sb3.append(" 						,?						\n"); // placeholder 3
			sb3.append(" 						,?						\n"); // placeholder 4
			sb3.append(" 						,?						\n"); // placeholder 5
			
			*/
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			if (nCnt > 0) bool = true;
			
			KosConnectivity.conClose(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("	Insert DB에 에러가 발생해슴!	>>> : " + e.getMessage());
		} finally {
			
			KosConnectivity.conClose(conn, pstmt);
			
		}
		
		return bool;
	}

	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
