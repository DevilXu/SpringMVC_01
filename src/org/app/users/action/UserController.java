package org.app.users.action;


import java.util.ArrayList;
import java.util.List;

import org.common.base.AbstractBaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.app.users.bean.demo;
import org.app.users.service.DemoService;
@Controller
public class UserController extends AbstractBaseController{
	@Autowired   
	private demo demo=new demo();
	@Autowired   
	private DemoService demoService;
	private List<demo> listDemo=new ArrayList<demo>();
	@RequestMapping(value="page/login")
	public ModelAndView login(String username,String password){
		if(this.checkParams(new String[]{username,password})){
			ModelAndView mav = new ModelAndView("succ");
			mav.addObject("username",username);
			mav.addObject("password", password);
			this.getSession().setAttribute("user", username);
			listDemo=demoService.getUserByUid();
			mav.addObject("listDemo", listDemo);
			return mav;
		}
		return new ModelAndView("login");
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
	/**
	 * 判断session中是否存在登录用户信息 保证登录的唯一性
	 * @param username
	 */
	private final void sessionControll(String username){
		if(username.equals(this.getSession().getAttribute("user"+username))){
			this.getSession().removeAttribute("user"+username);
			this.getSession().setAttribute("user"+username, username);
		}
	}
}
