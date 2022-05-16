package a.b.c.com.kosmo.common.dao;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChabunDAOImpl implements ChabunDAO {
	private Logger logger = Logger.getLogger(ChabunDAOImpl.class);

	// 이거는 필드버전
	@Autowired(required = false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public KosmoProductVO getProductChabun() {
		// TODO Auto-generated method stub
		
		logger.info("	ChabunDAOImpl 의 getProductChabun 에 도착해슴!	>>> : ");
		
		return sqlSession.selectOne("getProductChabun");
	}

}
