package org.swinglife.controller.action;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.swinglife.controller.bean.demo;
import org.swinglife.controller.service.DemoService;
@Controller
public class UserController {
	@Autowired   
	private demo demo=new demo();
	@Autowired   
	private DemoService demoService;
	private List<demo> listDemo=new ArrayList<demo>();
	@RequestMapping(value="page/login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password){
		if(this.checkParams(new String[]{username,password})){
			ModelAndView mav = new ModelAndView("succ");
			mav.addObject("username",username);
			mav.addObject("password", password);
			listDemo=demoService.getUserByUid();
			return mav;
		}
		return new ModelAndView("home");
	}

	/***
	 * ��֤����
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params){
		for(String param:params){
			if(param==""||param==null||param.isEmpty()){
				return false;
			}
		}
		return true;
	}


}
