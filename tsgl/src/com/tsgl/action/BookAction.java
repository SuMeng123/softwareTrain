package com.tsgl.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tsgl.action.base.BaseAction;
import com.tsgl.entity.Cl;
import com.tsgl.entity.Dj;
import com.tsgl.entity.Hy;
import com.tsgl.entity.Qs;
import com.tsgl.entity.UpBook;
import com.tsgl.service.ClService;
import com.tsgl.service.DjService;
import com.tsgl.service.QsService;
import com.tsgl.service.UpBookService;
import com.tsgl.service.UserService;
import com.tsgl.util.Page;

import freemarker.template.utility.DOMNodeModel;
@Component
@Scope("prototype")
@Action(value="bookAction",results={
		@Result(name="success",location="/new/book.jsp"),
		@Result(name="getBooks",location="/new/book.jsp"),
		@Result(name="toNewLogin",location="/new/login.jsp"),
		@Result(name="addQsDj",location = "bookAction.action", type = "redirectAction",params = {
				"flag", "${flag}" }),
		@Result(name="getYD",location="/new/yuding.jsp"),

})
public class BookAction extends BaseAction {
	@Autowired
	private UpBookService upBookServiceImpl;
	@Autowired
	private ClService clServiceImpl;
	@Autowired
	private DjService djServiceImpl;
	@Autowired
	private QsService qsServiceImpl;
	@Autowired
	private UserService userServiceImpl;
	private List<UpBook> upBooks = new ArrayList<UpBook>();
	private String pageHtml;// 分页
	private int cp = 1;// 当前页
	private List<Cl> cls = new ArrayList<Cl>();
	private String mySelect;
	private String num;
	private String bookId;
	private String flag;
	private String isJy;
	private Dj dj;
	private List<Dj> djs = new ArrayList<Dj>();
	private String userName;
	public String execute(){
		if(flag != null && flag.equals(""))
		{
			flag = flag;
		}
		Page page = new Page();
		page.setCurrentPage(cp);
		page.setTotalNum(upBookServiceImpl.getBookCount());
		List<UpBook> ups = upBookServiceImpl.getBooks();
		List<String> check = new ArrayList<String>();
		List<UpBook> books = new ArrayList<UpBook>();
		for(UpBook up : ups)
		{
			if(!check.contains(up.getBookId()+""))
			{
				check.add(up.getBookId()+"");
				books.add(up);
			}
			
		}
		if(books.size()<=cp*10)
		{
			upBooks = books.subList((cp-1)*10, books.size());
		}
		else
		{
			upBooks = books.subList((cp-1)*10, cp*10);
		}
		setCls(clServiceImpl.geTs());
		mySelect = "-1";
		pageHtml = page.getPage("bookAction.action"); 
		return "success";
	}
	public String getBooks()
	{
		Page page = new Page();
		page.setCurrentPage(cp);
		List<UpBook> ups = upBookServiceImpl.getBooks(mySelect,num);
		List<String> check = new ArrayList<String>();
		List<UpBook> books = new ArrayList<UpBook>();
		for(UpBook up : ups)
		{
			if(!check.contains(up.getBookId()+""))
			{
				check.add(up.getBookId()+"");
				books.add(up);
			}
			
		}
		page.setTotalNum(books.size());
		if(books.size()<=cp*10)
		{
			upBooks = books.subList((cp-1)*10, books.size());
		}
		else
		{
			upBooks = books.subList((cp-1)*10, cp*10);
		}
		setCls(clServiceImpl.geTs());
		pageHtml = page.getPage("bookAction!getBooks.action?mySelect="+mySelect+"&num="+num);
		return "getBooks";
	}
	public String toNewLogin()
	{
		bookId = bookId;
		isJy = isJy;
		flag = "请登录";
		return "toNewLogin";
	}
	public String addQsDj()
	{
		flag = "操作完成";
		dj.setDjStatus("缺书");
		dj.setBookId(-1);
		Dj test =djServiceImpl.getdj(dj.getDjName(), dj.getUserId());
		if(test == null || test.getDjStatus().equals("已到书"))
		{
			if(test != null && test.getDjStatus().equals("已到书"))
			{
				test.setDjStatus("预定");
				djServiceImpl.addDj(test);
			}
			else
			{
				djServiceImpl.addDj(dj);
			}
			Qs qs = qsServiceImpl.getqs(dj.getDjName());
			if(qs == null)
			{
				Qs q = new Qs();
				q.setAu(dj.getDjAu());
				q.setName(dj.getDjName());
				q.setStatus("缺书");
				q.setSl(1);
				q.setBookId(dj.getBookId());
				qsServiceImpl.addQs(q);
			}
			else
			{
				
				qs.setSl(qs.getSl()+1);
				qsServiceImpl.addQs(qs);
			}
		}
		return "addQsDj";
	}
	public String getYD()
	{
		Hy user = userServiceImpl.getUser(userName);
		setDjs(djServiceImpl.getdj(user.getUserId()));
		return "getYD";
	}
	public List<UpBook> getUpBooks() {
		return upBooks;
	}
	public void setUpBooks(List<UpBook> upBooks) {
		this.upBooks = upBooks;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public List<Cl> getCls() {
		return cls;
	}
	public void setCls(List<Cl> cls) {
		this.cls = cls;
	}
	public String getMySelect() {
		return mySelect;
	}
	public void setMySelect(String mySelect) {
		this.mySelect = mySelect;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getIsJy() {
		return isJy;
	}
	public void setIsJy(String isJy) {
		this.isJy = isJy;
	}
	public Dj getDj() {
		return dj;
	}
	public void setDj(Dj dj) {
		this.dj = dj;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Dj> getDjs() {
		return djs;
	}
	public void setDjs(List<Dj> djs) {
		this.djs = djs;
	}
	
	
}
