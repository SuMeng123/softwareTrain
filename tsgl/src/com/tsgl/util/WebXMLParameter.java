package com.tsgl.util;

import org.apache.struts2.ServletActionContext;
import org.testng.annotations.Test;
/**
 * 获取web.xml配置文件中的参数
 * @author lilicong
 *
 */
public class WebXMLParameter {
	
	/**
	 * 根据paramName获得配置文件中paramValue
	 * @param  paramName  参数名
	 * @return paramValue 参数值
	 */
	public static String getParamValue(String paramName){
		String paramValue = ServletActionContext.getServletContext().getInitParameter(paramName);
		return paramValue;
	}
	
	/**
	 * 获取web.xml配置文件的参数
	 * @param paramName  参数名
	 * @return  参数值
	 */
	public static int getParam(String paramName){
		
		String paramValue = ServletActionContext.getServletContext().getInitParameter(paramName);
		return Integer.parseInt(paramValue.trim());
	}
	/**
	 * 获取对接系统的appkey
	 * @param appkey 键名
	 * @return 键值
	 */
	public static String getParamByappkey(String appkey){
		String paramValue = ServletActionContext.getServletContext().getInitParameter(appkey);
		return paramValue;
	}
	
	/**
	 * 根据栏目号获取栏目编码
	 * @param paramName  栏目号
	 * @return 栏目编码
	 */
	public static String getColumnCod(String paramName){
		String paramValue = ServletActionContext.getServletContext().getInitParameter(paramName);
		return paramValue;
	}
	


}

