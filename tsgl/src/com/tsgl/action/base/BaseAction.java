package com.tsgl.action.base;

import java.io.IOException;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Namespace;
import com.alibaba.fastjson.JSON;
import org.springframework.context.annotation.Scope;

import com.opensymphony.xwork2.ActionSupport;


@ParentPackage("default")
@Namespace("/")
@Scope("prototype")
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 5468737591027540687L;

	/**
	 * 将对象转换成JSON字符串，并响应回前台
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void writeJson(Object object) {
		try {

			String json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm");
			ServletActionContext.getResponse().setContentType("text/html;charset=utf-8");
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
