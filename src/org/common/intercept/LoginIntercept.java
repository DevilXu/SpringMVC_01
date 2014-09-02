package org.common.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginIntercept implements HandlerInterceptor {
	private static final String[] IGNORE_URI = {"/login"};  
	private String mappingURL;//利用正则映射到需要拦截的路径    
	
	public void setMappingURL(String mappingURL) {    
		this.mappingURL = mappingURL;    
	}   
	  
	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
	    String url = arg0.getRequestURL().toString();
		for (String s : IGNORE_URI) {
            if (url.contains(s)) {
                flag = true;
                break;
            }
        }
		if (!flag) {
			if(arg0.getSession().getAttribute("user")==null){
				arg1.sendRedirect("login.html");
				flag = false;
			}
		}
		return flag;
	}

}
