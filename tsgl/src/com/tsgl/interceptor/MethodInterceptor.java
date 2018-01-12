package com.tsgl.interceptor;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;


@Scope("prototype")
@Component
public class MethodInterceptor extends MethodFilterInterceptor {


	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void destroy() {
		super.destroy();
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 获取访问的action
				String action = invocation.getAction().getClass().getName();
				// 获取访问的method
				String method = invocation.getProxy().getMethod();
				// 获取session
				//Map session = invocation.getInvocationContext().getSession();
				
				// 登录页不拦截
				if (action.contains("com.tsgl.stage.action")||action.contains("com.tsgl.action.LoginOutAction")) {
					return invocation.invoke();
				}
				HttpSession session = ServletActionContext.getRequest().getSession();
				if(session == null || session.getAttribute("admin") == null || session.getAttribute("admin").equals(""))
				{
					return "noLogin";
				}else{
					if (action.contains("com.tsgl.action")){
						
						return invocation.invoke();
					}
				}
				
				return "noLogin";
	}
}
