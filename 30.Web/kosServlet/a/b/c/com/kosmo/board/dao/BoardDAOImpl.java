package a.b.c.com.kosmo.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.common.KosConnectivity;
import a.b.c.com.kosmo.board.controller.BoardController;
import a.b.c.com.kosmo.board.sql.BoardSqlMap;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardDAOImpl implements BoardDAO {
	
	Logger logger = LogManager.getLogger(BoardDAOImpl.class);

	
	// 전체 조회하기 해슴!
	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		
		logger.info("	 BoardDAOImpl 의 boardSelectAll() 함수 들어와슴!	>>> : ");
		
		// 사용할 객체를 지역변수로 선언하고 값을 디폴트로 초기화 한다.
		// 여기서 리턴값은 ArrayList이다.
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try {
			
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardSelectAll();
			pstmt = conn.prepareStatement(sqls);
			logger.info("	전체 조회 해슴!	>>> : " + sqls);
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null) {
				
				aList = new ArrayList<BoardVO>();
				
				// 데이터를 받아온다.
				while (rsRs.next()) {
					
					BoardVO _bvo = new BoardVO();
					
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBpw(rsRs.getString("BPW"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_bvo);
				}
			
			}
			
			KosConnectivity.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			
			logger.info("	 문제가 발생해슴!	>>> : " + e.getMessage());
			
		} finally {
			
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}
	
	// 조회한다.
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		logger.info("	 BoardDAOImpl 의 boardSelect() 함수 들어와슴!	>>> : ");
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rsRs = null;
		ArrayList<BoardVO> aList = null;
		
		try {
			
			conn = KosConnectivity.getConnection();
			
			String sqls = BoardSqlMap.getBoardSelect();
			pstmt = conn.prepareStatement(sqls);
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			logger.info("	조건을 조회해슴!	>>> : \n" + sqls);
			
			rsRs = pstmt.executeQuery();
			
			if (rsRs != null) {
				
				aList = new ArrayList<BoardVO>();
				
				while (rsRs.next()) {
					
					BoardVO _bvo = new BoardVO();
					
					_bvo.setBnum(rsRs.getString("BNUM"));
					_bvo.setBsubject(rsRs.getString("BSUBJECT"));
					_bvo.setBwriter(rsRs.getString("BWRITER"));
					_bvo.setBpw(rsRs.getString("BPW"));
					_bvo.setBmemo(rsRs.getString("BMEMO"));
					_bvo.setDeleteyn(rsRs.getString("DELETEYN"));
					_bvo.setInsertdate(rsRs.getString("INSERTDATE"));
					_bvo.setUpdatedate(rsRs.getString("UPDATEDATE"));
					
					aList.add(_bvo);
				}
			
			}
			
			KosConnectivity.conClose(conn, pstmt, rsRs);
			
		}catch(Exception e) {
			
			logger.info("	 문제가 발생해슴!	>>> : " + e.getMessage());
			
		} finally {
			
			KosConnectivity.conClose(conn, pstmt, rsRs);
		}
		
		return aList;
	}

	// 정보 삽입 해슴!
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		logger.info("	BoardDAOImpl의 boardInsert() 함수 들어와슴!	>>> : ");
		logger.info("	 bvo는 ?	 >>> : " + bvo);
		
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
			logger.info("	sqls 는 ?	>>> : " + sqls);
			
			// 플레이스 홀더에 데이터 바인딩하기
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBnum());
			pstmt.setString(2, bvo.getBsubject());
			pstmt.setString(3, bvo.getBwriter());
			pstmt.setString(4, bvo.getBpw());
			pstmt.setString(5, bvo.getBmemo());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			
			logger.info("	 nCnt는 ?	 >>> : " + nCnt);
			
			if (nCnt > 0) bool = true;
			
			KosConnectivity.conClose(conn, pstmt);
			
		} catch (Exception e) {
			
			System.out.println("	Insert DB에 에러가 발생해슴!	>>> : " + e.getMessage());
		
		} finally {
			
			KosConnectivity.conClose(conn, pstmt);
			
		}
		
		return bool;
	}

	// 수정 하기 해슴!
	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		logger.info("	 BoardDAOImpl의 boardUpdate() 함수 들어와슴!	>>> : ");
		logger.info("	 bvo는 ?	 >>> : " + bvo);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int nCnt = 0;
		boolean bool = false;
		
		try {
			
			conn = KosConnectivity.getConnection();
			String sqls = BoardSqlMap.getBoardUpdate();
			pstmt = conn.prepareStatement(sqls);
			logger.info("	업데이트 sqls 는 ?	>>> : " + sqls);
			
			pstmt.clearParameters();
			pstmt.setString(1, bvo.getBsubject());
			pstmt.setString(2, bvo.getBmemo());
			pstmt.setString(3, bvo.getBnum());
			
			nCnt = pstmt.executeUpdate();
			if (!conn.getAutoCommit()) conn.commit();
			logger.info("	업데이트 결과는 ?	>>> : " + nCnt);
			
			if (nCnt > 0) bool = true;
			
			KosConnectivity.conClose(conn, pstmt);
			
		}catch(Exception e) {
			
			logger.info("	업데이트 DB 에러가 발생해슴!	>>> : " + e.getMessage());
			
		} finally {

			KosConnectivity.conClose(conn, pstmt);
		}
		
		
		return bool;
	}

	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		return false;
	}

}






















