package servlet.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import servlet.VO.ServletVO;
import servlet.service.ServletService;

@Controller
public class ServletController {
	@Resource(name = "ServletService")
	private ServletService servletService;
	
	@RequestMapping(value = "/main.do")
	public String mainTest(ModelMap model, @RequestParam(name="loc", required = false, defaultValue = "") String loc) throws Exception {
		System.out.println("sevController.java - mainTest()");
		
		String str = servletService.addStringTest("START! ");
		model.addAttribute("resultStr", str);
		
		List<ServletVO> list = servletService.list();
		model.addAttribute("list",list);
		if(loc.length()>1) {
			loc = "sd_nm='"+loc+"'";
		} 
		model.addAttribute("loc",loc);
		
		return "main/main";
	}

}
