package org.swinglife.controller.action;


import java.util.ArrayList;
import java.util.List;

import org.common.base.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.swinglife.controller.bean.demo;
import org.swinglife.controller.service.DemoService;
@Controller
public class UserController extends AbstractBaseController{
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
			mav.addObject("listDemo", listDemo);
			return mav;
		}
		return new ModelAndView("index");
	}
	@RequestMapping(value="page/jump")
	public ModelAndView jump(String username,String password){
		return new ModelAndView("demo/index");
	}
	 
	@RequestMapping(value="page/getList")
	@ResponseBody 
	public void getList() throws Exception {  
		listDemo=demoService.getUserByUid();
		this.outputAjaxJsonData(listDemo);
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
