package com.tsgl.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tsgl.action.base.BaseAction;
import com.tsgl.entity.Book;
import com.tsgl.entity.Cl;
import com.tsgl.entity.Dj;
import com.tsgl.entity.Hy;
import com.tsgl.entity.Infor;
import com.tsgl.entity.JhBook;
import com.tsgl.entity.Tuijian;
import com.tsgl.entity.UpBook;
import com.tsgl.service.BookService;
import com.tsgl.service.ClService;
import com.tsgl.service.DjService;
import com.tsgl.service.InService;
import com.tsgl.service.JhService;
import com.tsgl.service.TuijianService;
import com.tsgl.service.UserService;

import freemarker.template.utility.DOMNodeModel;
@Component
@Scope("prototype")
@Action(value="jhAction",results={
		@Result(name="success",location="/new/jiehuan.jsp"),
		@Result(name="tuijian",location="/new/index.jsp"),
		
})
public class JHAction extends BaseAction {
	@Autowired
	private JhService jhServiceImpl;
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private TuijianService tuijianServiceImpl;
	@Autowired
	private ClService clServiceImpl;
	private List<JhBook> jhBooks = new ArrayList<JhBook>();
	private String userName;
	private List<Tuijian> tuijians = new ArrayList<Tuijian>();
	public String execute(){
		Hy user = userServiceImpl.getUser(userName);
		List<JhBook> jhs = jhServiceImpl.getJhBook(user.getUserId());
		List<String> check = new ArrayList<String>();
		jhBooks = new ArrayList<JhBook>();
		for(JhBook jh : jhs)
		{
			if(!check.contains(jh.getInid()+""))
			{
				check.add(jh.getInid()+"");
				if(jh.getAdminId() == null || jh.getAdminId() == 0)
				{
					jh.setBStatus("锁定");
				}
				else if (jh.getHDate() != null && !jh.getHDate().equals("")) 
				{
					jh.setBStatus("已归还");
				}
				else
				{
					jh.setBStatus("借出");
				}
				jhBooks.add(jh);
			}
		}
		return "success";
	}
	
	public String tuijian(){
		Hy user = userServiceImpl.getUser(userName);
		List<Cl> cls = clServiceImpl.geTs();
		List<String> check = new ArrayList<String>();
		List<Tuijian> cc = new ArrayList<Tuijian>();
		for(Cl l : cls)
		{
			List<Tuijian> t = tuijianServiceImpl.geTuijians(l.getClNum());
			if(t != null && t.size()>=3)
			{
				cc.addAll(t.subList(0, 3));
			}
			if(t != null && t.size()<3)
			{
				cc.addAll(t);
			}
		}
		for(Tuijian tt : cc)
		{
			if(!check.contains(tt.getBookId()+""))
			{
				check.add(tt.getBookId()+"");
				tuijians.add(tt);
			}
		}
		return "tuijian";
	}
	public List<JhBook> getJhBooks() {
		return jhBooks;
	}
	public void setJhBooks(List<JhBook> jhBooks) {
		this.jhBooks = jhBooks;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Tuijian> getTuijians() {
		return tuijians;
	}
	public void setTuijians(List<Tuijian> tuijians) {
		this.tuijians = tuijians;
	}
	
}
