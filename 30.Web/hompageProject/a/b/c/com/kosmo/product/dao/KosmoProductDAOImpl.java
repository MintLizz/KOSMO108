package a.b.c.com.kosmo.product.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;

@Repository
public abstract class KosmoProductDAOImpl implements KosmoProductDAO {
	
	Logger logger = LogManager.getLogger(KosmoProductDAOImpl.class);
	
	@Autowired(required = false)
	private SqlSession sqlSession;

	@Override
	public int kosmoProductInsert(KosmoProductVO pvo) {
		// TODO Auto-generated method stub
		
			logger.info("	SpringEmpDAOImpl 의 springEmpInsert 함수에 진입 해슴!	>>> : ");
		
		return (Integer)sqlSession.insert("kosmoProductInsert", pvo);
	}
	
	@Override
	public List kosmoProductSelectAll(KosmoProductVO kpvo) {
		// TODO Auto-generated method stub
		
			logger.info("	SpringEmpDAOImpl 의 springEmpInsert 함수에 진입 해슴!	>>> : ");

			return sqlSession.selectList("kosmoProductSelectAll", kpvo);
	}

}