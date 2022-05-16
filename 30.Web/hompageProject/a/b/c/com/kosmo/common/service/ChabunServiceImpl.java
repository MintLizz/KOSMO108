package a.b.c.com.kosmo.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.common.dao.ChabunDAO;
import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	// 이거는 필드 버전
	@Autowired(required = false)
	private ChabunDAO chabunDAO;
	
	// 이거는 생성자 버전
	/*
	@Autowired(required = false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		
		this.chabunDAO = chabunDAO;
	}
	*/

	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		
		logger.info("	ChabunServiceImpl 의 getBoardChabun 에 도착해슴!	>>> : ");

		return chabunDAO.getProductChabun();
	}

}
