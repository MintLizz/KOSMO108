package a.b.c.com.kosmo.board.service;

import java.util.ArrayList;

import a.b.c.com.kosmo.board.vo.BoardVO;

// 인터페이스 특)
// 구현체가 없고 추상함수만 있다.

public interface BoardService {
	
	public ArrayList<BoardVO> boardSelectAll();
	public ArrayList<BoardVO> boardSelect(BoardVO bvo);
	public boolean boardInsert(BoardVO bvo);
	public boolean boardUpdate(BoardVO bvo);
	public boolean boardDelete(BoardVO bvo);

}
