package a.b.c.com.kosmo.product.service;

import a.b.c.com.kosmo.product.vo.KosmoProductVO;
import java.util.List;

public interface KosmoProductService {
		
	public int kosmoProductInsert(KosmoProductVO pvo);
	public List kosmoProductSelectAll(KosmoProductVO kpvo);

}
