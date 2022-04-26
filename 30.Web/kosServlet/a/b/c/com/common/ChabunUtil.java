package a.b.c.com.common;

public abstract class ChabunUtil {
	
	// M으로 한 이유
	// M + YYYYMMDD + 0001 M202203300001
	// 양식에서 요청사항에 M으로 해달라고 했기 때문이다.
	public static final String BIZ_GUBUN_MEMBER = "M"; 
	public static final String BIZ_GUBUN_BOARD = "B"; 
	
	public static String numPad(String t, String c){
		
		for (int i = c.length(); i < 4; i++) {
			c = "0" + c;
		}
		
		String ymd = DateFormatUtil.ymdFormats(t);
		return ymd.concat(c);
	}
	
	public static String getMemChabun(String type) {
		
		String commNum = ChabunQuery.getMemChabunQuery();	
		return BIZ_GUBUN_MEMBER.concat(ChabunUtil.numPad(type, commNum));									
	}
	
		public static String getBoardChabun(String type) {
		
		String commNum = ChabunQuery.getBoardChabunQuery();	
		return BIZ_GUBUN_BOARD.concat(ChabunUtil.numPad(type, commNum));									
	}

	public static void main(String[] args) {
		System.out.println("	ChabunUtil.getBoardChabun 는 ?	>>> : " + ChabunUtil.getBoardChabun(""));
	}
}
