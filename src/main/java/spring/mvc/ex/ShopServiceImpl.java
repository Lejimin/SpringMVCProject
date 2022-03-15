package spring.mvc.ex;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	ShopDao shopDao;
	
	@Override
	public String create(Map<String,Object> map) {
		int affectRowCount = this.shopDao.insert(map);
		if(affectRowCount==1) {
			return map.get("shop_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object> map){
		return this.shopDao.selectDetail(map);
	}
}
