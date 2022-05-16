package a.b.c.com.kosmo.product.dao;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import java.util.List;

public interface KosmoProductDAO {
	
	public int kosmoProductInsert(KosmoProductVO pvo);
	public List kosmoProductSelectAll(KosmoProductVO kpvo);

	
}
