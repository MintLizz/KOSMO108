package a.b.c.com.kosmo.board.sql;

public abstract class BoardSqlMap {
	
	public static String getBoardSelectAll(){
		
		/*
		  SELECT 
		     A.BNUM         BNUM
		    ,A.BSUBJECT     BSUBJECT
		    ,A.BWRITER      BWRITER 
		    ,A.BPW          BPW
		    ,A.BMEMO        BMEMO
		    ,A.DELETEYN     BDELETEYN
		    ,TO_CHAR(A.INSERTDATE,'YYYY-MM-DD')   INSERTDATE
		    ,TO_CHAR(A.UPDATEDATE,'YYYY-MM-DD')   UPDATEDATE
		FROM MVC_BOARD A
		WHERE A.DELETEYN = 'Y'
		
		ORDER BY 1 DESC;
		  
		  */
		
		StringBuffer sb1 = new StringBuffer();
		
		sb1.append("SELECT														\n"); 
		sb1.append("		A.BNUM         							BNUM		\n");
		sb1.append("		,A.BSUBJECT     						BSUBJECT	\n");
		sb1.append("		,A.BWRITER      						BWRITER 	\n");
		sb1.append("		,A.BPW          						BPW			\n");	
		sb1.append("		,A.BMEMO        						BMEMO		\n");
		sb1.append("		,A.DELETEYN     						DELETEYN	\n");
		sb1.append("    	,TO_CHAR(A.INSERTDATE,'YYYY-MM-DD')  	INSERTDATE	\n");
		sb1.append("		,TO_CHAR(A.UPDATEDATE,'YYYY-MM-DD')   	UPDATEDATE	\n");
		sb1.append("FROM 	MVC_BOARD A											\n");
		sb1.append("WHERE 	A.DELETEYN = 'Y'									\n");
		sb1.append("ORDER BY 1 DESC											\n");
		
		return sb1.toString();
		
	}
	
	public static String getBoardSelect(){ 
		
		StringBuffer sb2 = new StringBuffer();
		
		sb2.append("SELECT												\n");		
		sb2.append("A.BNUM         							BNUM		\n");
		sb2.append(",A.BSUBJECT     						BSUBJECT	\n");
		sb2.append(",A.BWRITER      						BWRITER 	\n");
		sb2.append(",A.BPW          						BPW			\n");
		sb2.append(",A.BMEMO        						BMEMO		\n");
		sb2.append(",A.DELETEYN     						DELETEYN	\n");
		sb2.append(",TO_CHAR(A.INSERTDATE,'YYYY-MM-DD')  	INSERTDATE	\n");
		sb2.append(",TO_CHAR(A.UPDATEDATE,'YYYY-MM-DD')   	UPDATEDATE	\n");
		sb2.append("FROM 	MVC_BOARD A									\n");
		sb2.append("WHERE 	A.DELETEYN = 'Y'							\n");
		sb2.append("AND A.BNUM = ?										\n");
		
		return sb2.toString();
		}
	
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
	
	// Update 
	public static String getBoardUpdate(){ 
		
		
		StringBuffer sb4 = new StringBuffer();
		
		sb4.append("UPDATE      MVC_BOARD						\n");
		sb4.append("SET         BSUBJECT	=	?,				\n");
		sb4.append("			BMEMO		=	?,				\n");
		sb4.append("			UPDATEDATE 	= 	SYSDATE			\n");
		sb4.append("WHERE       DELETEYN 	= 	'Y'				\n");
		sb4.append("AND         BNUM 		= 	?				\n");		
		
		return sb4.toString();
		
	}
	
	public static String getBoardDelete(){ return null;}

}
