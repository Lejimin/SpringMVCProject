package spring.mvc.ex;

import java.util.Map;

public interface ShopService {

	String create(Map<String, Object> map);

	Map<String, Object> detail(Map<String, Object> map);

}
