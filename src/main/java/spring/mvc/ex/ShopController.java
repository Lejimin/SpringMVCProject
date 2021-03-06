package spring.mvc.ex;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ShopController {

	@Autowired
	ShopService shopService;
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView create() { //create의 이름은 아무거나 가능 해당 이름으로 url에 적어서 들어가면 이름이 달라도 /create가 실행
		return new ModelAndView("shop/create");
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String,Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String shopId = this.shopService.create(map);
		if(shopId==null) {
			mav.setViewName("redirect:/create");
		}else {
			mav.setViewName("redirect:/detail?shopId="+shopId);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object> map) {
		System.out.println("detail");
		System.out.println(map);
		Map<String, Object> detailMap = this.shopService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String shopid = map.get("shopId").toString();
		mav.addObject("shopId", shopid);
		mav.setViewName("/shop/detail");
		
		return mav;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
