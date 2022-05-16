package a.b.c.com.kosmo.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import a.b.c.com.kosmo.common.ChabunUtil;
import a.b.c.com.kosmo.common.CommonUtils;
import a.b.c.com.kosmo.common.FileUploadUtil;
import a.b.c.com.kosmo.common.service.ChabunService;
import a.b.c.com.kosmo.product.service.KosmoProductService;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Controller
public class KosmoProductController {
	
	Logger logger = LogManager.getLogger(KosmoProductController.class);
	
	// 필드 오토 와이어드
	@Autowired(required = false)
	private KosmoProductService kosmoProductService;
	
	@Autowired(required = false)
	private ChabunService chabunService;
	
	// 생성자 오토 와이어드
	/*
	@Autowired(required = false)
	public KosmoProductController(KosmoProductService kosmoProductService, ChabunService chabunService) {
		
		this.kosmoProductService = kosmoProductService;
		this.chabunService = chabunService;
	}*/
	
	// 게시판 글 입력 폼
	// kosmoProductInsertForm
	@RequestMapping(value = "kosmoProductInsertForm",  method = RequestMethod.GET)
	public String kosmoProductInsertForm(Model model) {
		
		logger.info("	KosmoProductController 의 kosmoProductInsertForm 함수에 진입 해슴!	>>> : ");
		
		return "product/kosmoProductInsertForm";
	}
	
	// 글쓰기
	@RequestMapping(value = "kosmoProductInsert", method = RequestMethod.POST)
	public String kosmoProductInsert(HttpServletRequest req) {
		
		logger.info("	KosmoProductController 의 kosmoProductInsert 함수에 진입 해슴!	>>> : ");
		
		/*
		 ChabunService -> getBoardChabun -> getSbnum
		  
		 */
		
		// 1. 채번 구하기
		
		String kpnum = ChabunUtil.getProductChabun("D", chabunService.getProductChabun().getKpnum());
		logger.info("	KosmoProductController 의 kosmoProductInsert pknum 은 ?	>>> : " + kpnum);
		
		// 2. 이미지 업로드
		
			FileUploadUtil fu = new FileUploadUtil( CommonUtils.PRODUCT_IMG_UPLOAD_PATH
													,CommonUtils.PRODUCT_IMG_FILE_SIZE
													,CommonUtils.PRODUCT_EN_CODE);
		
		// 3. 서비스 호출하기
			
		boolean bool = fu.imgfileUpload(req);
		// 이미지 파일 원본 사이즈 크기 조절 하기 
		// boolean bool = fu.imgfileUploadSize(req);
			
		logger.info("	KosmoProductController 의 kosmoProductInsert bool 은 ?	>>> : " + bool);
		
		KosmoProductVO _kpvo = null;
		_kpvo = new KosmoProductVO();
		
		_kpvo.setKpnum(kpnum);
		_kpvo.setKpid(fu.getParameter("kpid"));
		_kpvo.setKpname(fu.getParameter("kpname"));
		_kpvo.setKpcompany(fu.getParameter("kpcompany"));
		
		_kpvo.setKpimage(fu.getFileName("kpimage"));
		
		_kpvo.setKpcnt(fu.getParameter("kpcnt"));
		_kpvo.setKpprice(fu.getParameter("kpprice"));
		_kpvo.setKpdesc(fu.getParameter("kpdesc"));
		
		
		
		int nCnt = kosmoProductService.kosmoProductInsert(_kpvo);
		logger.info("	KosmoProductController 의  kosmoProductInsert 의 nCnt는 ?	>>> : " + nCnt);
		
		if( nCnt > 0) {
			
			return "product/kosmoProductInsert";
		}
		
		return "product/kosmoProductInsertForm";
	}
	
	// SelectAll 시작!
	@RequestMapping(value = "kosmoProductSelectAll", method = RequestMethod.GET)
	public String kosmoProductSelectAll(KosmoProductVO kpvo, Model model) {
		
		logger.info("	KosmoProductController 의  kosmoProductSelectAll에 도착함!	>>> : ");
		
		// 페이징 처리 ==================================================================
		// 여기서 kosmoProductSelectAll(KosmoProductVO kpvo, Model model) 를 한 이유
		// 기존 selectAll은 이미 깡통클래스에 값이 있어서 상관 없는데
		// 여기서는 추가로 넣기 때문에 깡통 클래슬ㄹ 위해 KosmoProductVO kpvo, Model model 가 필요하다.
		int pageSize = CommonUtils.PRODUCT_PAGE_SIZE;
		int groupSize = CommonUtils.PRODUCT_GROUP_SIZE;
		int curPage = CommonUtils.PRODUCT_CUR_PAGE;
		int totalCount = CommonUtils.PRODUCT_TOTAL_COUNT;
		
		if (kpvo.getCurPage() != null) {
			
			curPage = Integer.parseInt(kpvo.getCurPage());
		}
		
		
		kpvo.setPageSize(String.valueOf(pageSize));
		kpvo.setGroupSize(String.valueOf(groupSize));
		kpvo.setCurPage(String.valueOf(curPage));
		kpvo.setTotalCount(String.valueOf(totalCount));
		
		logger.info("	KosmoProductController 의 kosmoProductSelectAll kpvo.getPageSize()는 ?	>>> : " + kpvo.getPageSize());
		logger.info("	KosmoProductController 의 kosmoProductSelectAll kpvo.getGroupSize()는 ?	>>> : " + kpvo.getGroupSize());
		logger.info("	KosmoProductController 의 kosmoProductSelectAll kpvo.getCurPage()는 ?	>>> : " + kpvo.getCurPage());
		logger.info("	KosmoProductController 의 kosmoProductSelectAll kpvo.getTotalCount()는 ?	>>> : " + kpvo.getTotalCount());
		
		// 리스트 호출함!
		List<KosmoProductVO> listAll = kosmoProductService.kosmoProductSelectAll(kpvo);
		
		int nCnt = listAll.size();
		
		if (nCnt > 0) {
			
			logger.info("	KosmoProductController 의 kosmoProductSelectAll nCnt는 ?	>>> : " + nCnt);
			
			model.addAttribute("pagingKPVO", kpvo);
			model.addAttribute("listAll", listAll);
			
			return "product/kosmoProductSelectAll";
			
		}
		
		return "product/kosmoProductInsertForm";
	}
	
	


}











