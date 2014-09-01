package org.swinglife.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/***
 * �û�������
 * @author swinglife
 *
 */
@Controller
public class UserController {

	/***
	 * �û���½
	 * <p>ע�����ã�ֻ����POST�ύ���÷���
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value="page/login",method=RequestMethod.POST)
	public ModelAndView login(String username,String password){
		//��֤���ݹ����Ĳ����Ƿ���ȷ�����򷵻ص���½ҳ�档
		if(this.checkParams(new String[]{username,password})){
			//ָ��Ҫ���ص�ҳ��Ϊsucc.jsp
			ModelAndView mav = new ModelAndView("succ");
			//������ظ�ҳ��
			mav.addObject("username",username);
			mav.addObject("password", password);
			return mav;
		}
		return new ModelAndView("home");
	}

//	/***
//	 * ��һ�ֲ���ݵ���ʽ
//	 * ͨ��request��������������Ĳ���
//	 * @param username
//	 * @param password
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping(value="login",method=RequestMethod.POST)
//	public ModelAndView login(String username,String password,HttpServletRequest request){
//		request.setAttribute("username", username);
//		request.setAttribute("password", password);
//		return new ModelAndView("succ");
//	}
	
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
