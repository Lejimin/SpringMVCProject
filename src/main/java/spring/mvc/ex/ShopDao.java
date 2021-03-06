package spring.mvc.ex;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDao {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("shop.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.sqlSessionTemplate.selectOne("shop.select_detail", map);
	}
}
