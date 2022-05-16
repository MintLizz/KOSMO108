package a.b.c.com.kosmo.product.service;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import a.b.c.com.kosmo.product.dao.KosmoProductDAO;
import a.b.c.com.kosmo.product.dao.KosmoProductDAOImpl;

@Service
@Transactional
public class KosmoProductServiceImpl implements KosmoProductService {

	Logger logger = LogManager.getLogger(KosmoProductDAOImpl.class);
	
	private KosmoProductDAO kosmoProductDAO;
	
	@Autowired(required = false)
	public  KosmoProductServiceImpl(KosmoProductDAO kosmoProductDAO) {
		
		this.kosmoProductDAO = kosmoProductDAO;
	}

	@Override
	public int kosmoProductInsert(KosmoProductVO pvo) {
		// TODO Auto-generated method stub
		
		logger.info("	KosmoProductServiceImpl kosmoProductInsert 함수에 진입 해슴!	>>> : ");
		
		return kosmoProductDAO.kosmoProductInsert(pvo);
	}

	@Override
	public List kosmoProductSelectAll(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		
		logger.info("	KosmoProductServiceImpl kosmoProductSelectAll 함수에 진입 해슴!	>>> : ");

		return kosmoProductDAO.kosmoProductSelectAll(kpvo);
	}

}











