package a.b.c.com.kosmo.board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import a.b.c.com.common.ChabunQuery;
import a.b.c.com.common.ChabunUtil;
import a.b.c.com.common.EncryptSHA;
import a.b.c.com.kosmo.board.service.BoardService;
import a.b.c.com.kosmo.board.service.BoardServiceImpl;
import a.b.c.com.kosmo.board.vo.BoardVO;


// http://localhost:8088/kosServlet/board
// 요청할때는 /kosServlet/board 이것만
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charSet=UTF-8");
		PrintWriter out = response.getWriter();
		
		String isudType = request.getParameter("isudType");
		
		if (isudType != null && isudType.length() > 0) {
			isudType = isudType.toUpperCase();
			
			if ("I".equals(isudType)) {
				
				String bnum = ChabunUtil.getBoardChabun("");
				String bsubject = request.getParameter("bsubject");
				String bwriter = request.getParameter("bwriter");
				String bpw = request.getParameter("bpw");
				String bmemo = request.getParameter("bmemo");
				
				BoardVO bvo = null;
				bvo = new BoardVO();
				
				// 테스트 해보기
				bsubject = "01";
				bwriter = "01";
				bpw = "01";
				bmemo = "01";

				bvo.setBnum(bnum);
				bvo.setBsubject(bsubject);
				bvo.setBwriter(bwriter);
				
				// 패스워드 암호화 하기
				bpw = EncryptSHA.encryptSHA256(bpw);
				bvo.setBpw(bpw);
				bvo.setBmemo(bmemo);
				
				System.out.println("	bvo.getBnum() 은 ?	>>> : " + bvo.getBnum());
				System.out.println("	bvo.getBsubject() 은 ?	>>> : " + bvo.getBsubject());
				System.out.println("	bvo.getBwriter() 은 ?	>>> : " + bvo.getBwriter());
				System.out.println("	bvo.getBpw() 는 ?	>>> : " + bvo.getBpw());
				System.out.println("	bvo.getBmemo() 는 ?	>>> : " + bvo.getBmemo());
				
				BoardService bs = new BoardServiceImpl();
				boolean bool = bs.boardInsert(bvo);
				
				if (bool) {
					
					System.out.println("	입력을 성공해슴!	>>> : " + bool);
					request.setAttribute("bool", new Boolean(bool));
					RequestDispatcher rd = request.getRequestDispatcher("#/kosmo/board/boardInsert.jsp");
					rd.forward(request, response);
				}else {
					System.out.println("	입력 실패 >>> :" + bool);
					out.println("<script>");
					out.println("location.href='#/kosmo/board/board.html'");
					out.println("</script>");
					
				}
			}
			
			if ("SALL".equals(isudType)) {
				
			}
			
		}else {
			
			System.out.println("	isudType 구분자가 없어서 무슨 일을 할지 모르게슴!!	>>> : ");
			
		} // end of if (isudType != null && isudType.length() > 0)
	} // end of protected void doGet(HttpServletRequest request, HttpServletResponse response)

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
