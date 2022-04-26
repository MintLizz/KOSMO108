package a.b.c.com.kosmo.board.sql;

public abstract class BoardSqlMap {
	
	public static String getBoardSelectAll(){return null;}
	
	public static String getBoardSelect(){ return null;}
	
	public static String getBoardInsert(){ 
		
		StringBuffer sb3 = new StringBuffer();
		
		/*
		 INSERT INTO MVC_BOARD (BNUM, BSUBJECT, BWRITER, BPW, BMEMO, DELETEYN, INSERTDATE, UPDATEDATE)
        VALUES (   ?,        ?,       ?,   ?,     ?,      'Y',    SYSDATE,   SYSDATE); 
		  
		*/
		
		sb3.append("	INSERT INTO									\n");
		sb3.append(" 		MVC_BOARD								\n");
		sb3.append(" 				(								\n"); 
		sb3.append(" 					 BNUM						\n"); // COLUMN1
		sb3.append(" 					,BSUBJECT					\n"); // COLUMN2
		sb3.append(" 					,BWRITER					\n"); // COLUMN3
		sb3.append(" 					,BPW						\n"); // COLUMN4
		sb3.append(" 					,BMEMO						\n"); // COLUMN5
		sb3.append(" 					,DELETEYN					\n"); // COLUMN6
		sb3.append(" 					,INSERTDATE					\n"); // COLUMN7
		sb3.append(" 					,UPDATEDATE					\n"); // COLUMN8
		sb3.append(" 				)								\n");
		sb3.append(" 		VALUES									\n");
		sb3.append(" 				(								\n");
		sb3.append(" 						 ?						\n"); // placeholder 1
		sb3.append(" 						,?						\n"); // placeholder 2
		sb3.append(" 						,?						\n"); // placeholder 3
		sb3.append(" 						,?						\n"); // placeholder 4
		sb3.append(" 						,?						\n"); // placeholder 5
		sb3.append(" 						,'Y'					\n"); // placeholder 6
		sb3.append(" 						,SYSDATE				\n"); // placeholder 7
		sb3.append(" 						,SYSDATE				\n"); // placeholder 8
		sb3.append(" 				)								\n");
		
		return sb3.toString();
		
	}
	
	public static String getBoardUpdate(){ return null;}
	
	public static String getBoardDelete(){ return null;}

}
