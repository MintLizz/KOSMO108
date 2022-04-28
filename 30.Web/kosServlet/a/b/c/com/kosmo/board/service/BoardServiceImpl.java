package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.controller.BoardController;
import a.b.c.com.kosmo.board.dao.BoardDAO;
import a.b.c.com.kosmo.board.dao.BoardDAOImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;

public class BoardServiceImpl implements BoardService {
	
	Logger logger = LogManager.getLogger(BoardServiceImpl.class);

	// 전체 조회 해슴!
	@Override
	public ArrayList<BoardVO> boardSelectAll() {
		// TODO Auto-generated method stub
		
		BoardDAO bdao = new BoardDAOImpl();
		
		logger.info("	BoardServiceImpl 의 boardSelectAll() 함수 진입 성공해슴!	>>> : ");
		ArrayList<BoardVO> aList = bdao.boardSelectAll();
		
		return aList;
	}

	// 조건 조회 해슴!
	@Override
	public ArrayList<BoardVO> boardSelect(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		BoardDAO bdao = new BoardDAOImpl();
		
		logger.info("	BoardServiceImpl 의 boardSelect() 함수 진입 성공해슴!	>>> : ");
		ArrayList<BoardVO> aList = bdao.boardSelect(bvo);
		
		return aList;
		// return bdao.boardSelect(bvo); 도 가능하다!
	}

	// 정보 입력 해슴!
	@Override
	public boolean boardInsert(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		logger.info("	boardInsert() 함수 진입 성공해슴!	>>> : ");
		logger.info("	bov 는 ?	>>> : " + bvo);
		
		BoardDAO bdao = new BoardDAOImpl();
		
		boolean bool = bdao.boardInsert(bvo);
		
		// return bdao.boardInsert(bvo);
		
		logger.info("	bool 은 ?	>>> : " + bool);
		
		return bool;
	}

	// 정보 변경 해슴!
	@Override
	public boolean boardUpdate(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		logger.info("	boardUpdate() 함수 진입 성공해슴!	>>> : ");
		logger.info("	bov 는 ?	>>> : " + bvo);
		
		BoardDAO bdao = new BoardDAOImpl();
		
		boolean bool = bdao.boardUpdate(bvo);
		
		// return bdao.boardInsert(bvo);
		
		logger.info("	bool 은 ?	>>> : " + bool);
		
		return bool;
	}
	
	// 정보 삭제 해슴!
	@Override
	public boolean boardDelete(BoardVO bvo) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
