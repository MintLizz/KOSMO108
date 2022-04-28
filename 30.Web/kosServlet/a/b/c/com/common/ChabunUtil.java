package a.b.c.com.common;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import a.b.c.com.kosmo.board.controller.BoardController;

public abstract class ChabunUtil {
	
	static Logger logger = LogManager.getLogger(BoardController.class);
	
	// M으로 한 이유
	// B + 0001 B00001
	// 양식에서 요청사항에 M으로 해달라고 했기 때문이다.
	public static final String BIZ_GUBUN_BOARD = "B"; 
	
	public static String numPad(String t, String c){
		
		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		
		String ymd = DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}
	
	
		public static String getBoardChabun(String type) {
		
		String commNum = ChabunQuery.getBoardChabunQuery();	
		return BIZ_GUBUN_BOARD.concat(ChabunUtil.numPad(type, commNum));									
	}

	public static void main(String[] args) {
		logger.info("	ChabunUtil.getBoardChabun 는 ?	>>> : " + ChabunUtil.getBoardChabun(""));
	}
}
