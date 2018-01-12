/**
 * 
 */
package com.tsgl.util;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

/**
 * @author 李俊
 * 
 *         类型转换
 *
 */
public class TypeConverter {
	
	/**
	 * 将Date 类型转换为Timestamp
	 * @param date
	 * @return 刘凤双
	 */
	public static Timestamp date2Timestamp(Date date){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf.format(date);
		System.out.println(dd);
		Timestamp ss = Timestamp.valueOf(dd);
		System.out.println(ss);
		return ss;
	}
	
	public static String dateTimestamp(Date date){
		if(date==null){
			return null;
		}else{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dd = sdf.format(date);
		//System.out.println(dd);
		return dd;
		}
	}
	
	/**
	 *这个函数,将日期后面的时分秒去掉 由 2014-09-09-11:11:11 改为2014-09-09
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public static Date dateFormatToDate(Date date) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String str = sdf.format(date);
		date = sdf.parse(str);
		return date;
	}
	
	/**
	 * 将list对象转换成字符串，分隔符为seperator
	 * 
	 * @param list
	 * @param seperator
	 * @return 如果list为空，返回null
	 */
	public static String convertList2String(List<Object> list, String seperator) {
		StringBuilder sb = new StringBuilder();
		int i;
		if (null == list) {
			return null;
		} else {
			for (i = 0; i < list.size() - 1; i++) {
				sb.append(list.get(i).toString());
				sb.append(seperator);
			}
			sb.append(list.get(i).toString());
			return sb.toString();
		}
	}

	/**
	 * 将日期格式化为 YYYY-MM-DD的字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		return dateString;
	}
	/**
	 * 讲字符串才转换成Date类型    刘凤双
	 * @param str
	 * @return
	 */
	public static Date strToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date=sdf.parse(str);
			return date;
		} catch (ParseException e) {
			return null;
		}  
	} 
	public static Date stringToDate(String str){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date date=sdf.parse(str);
			return date;
		} catch (ParseException e) {
			return null;
		}  
	} 
	
	
	/**
	 * 将字符串转换为日期
	 * 
	 * @param date
	 * @param format
	 * @return 如果字符串不符合日期格式，则返回null
	 */
	public static Date convertString2Date(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date resultDate;
		try {
			resultDate = sdf.parse(date);
			return resultDate;
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * 将日期转换为指定格式字符串
	 * 
	 * @param date
	 * @param format
	 * @return 如果字符串不符合日期格式，则返回null
	 */
	public static String convertDate2String(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}


	/**
	 * 将数组转化成字符串
	 * 
	 * @param str
	 *            要转化的字符串
	 * @param seperator
	 *            分隔符
	 * @return
	 */
	public static String arrToString(String[] str, String seperator) {
		StringBuilder sb = new StringBuilder();
		if (str.length == 0) {
			return "";
		}
		sb.append(str[0]);
		for (int i = 1; i < str.length; i++) {
			sb.append(",");
			sb.append(str[i]);
		}
		String string = "(" + sb.toString() + ")";
		return string;
	}

	/**
	 * list转换为string
	 */
	public static String list2FormatString(List<Object> list, String seperator) {
		if (list == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			sb.append(",");
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	/**
	 * list转换为string
	 * @param list
	 * @param seperator
	 * @return
	 */
	public static String list3FormatString(List<String> list, String seperator) {
		if (list == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			sb.append(",");
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	/**
	 * list转换为string
	 * @param list
	 * @param seperator
	 * @return
	 */
	public static String list4FormatString(List<Integer> list, String seperator) {
		if (list == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			sb.append(",");
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	/**
	 * 刘凤双  将int 数组转换成list
	 * @param ids
	 * @return
	 */
	public static List<Object> arrayToList(int [] ids){
		List<Object> list = new ArrayList<Object> ();
		for(int i = 0; i<ids.length; i++){
			list.add(ids[i]);
		}
		return list;
	}
	/**
	 * 苏东航  将字符串转化为List
	 * @param result
	 * @return
	 */
	public static List<Object> stringToList(String result){
		String[] array = result.split(",");
		List<Object> abcList = new ArrayList<Object>();
		for (String str : array)
		{
		abcList.add(str);
		}
		return abcList;
	}
	/**
	 * 苏东航 将String类型的数组转化为List
	 * @param userid
	 * @return
	 */
	public static List<String> arrayToList(String [] userid){
		List<String> userList = new ArrayList<String>();

		Collections.addAll(userList, userid);
		return userList;
	}
	
}
