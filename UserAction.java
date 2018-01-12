package com.tsgl.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tsgl.action.base.BaseAction;
import com.tsgl.entity.Book;
import com.tsgl.entity.Dj;
import com.tsgl.entity.Hs;
import com.tsgl.entity.Hy;
import com.tsgl.entity.Infor;
import com.tsgl.entity.Qs;
import com.tsgl.service.BookService;
import com.tsgl.service.ClService;
import com.tsgl.service.DjService;
import com.tsgl.service.HsService;
import com.tsgl.service.InService;
import com.tsgl.service.QsService;
import com.tsgl.service.UserService;

import freemarker.template.utility.DOMNodeModel;
@Component
@Scope("prototype")
@Action(value="userAction",results={
		@Result(name="success",location="/jsp/login.jsp"),
		@Result(name="getUserBySnum",location="/new/infor.jsp"),
		@Result(name="updateUser",location="/new/infor.jsp"),
		@Result(name="jiechu",location = "bookAction.action", type = "redirectAction",params = {
				"flag", "${flag}" }),
		@Result(name="queshu",location="/new/queshu.jsp"),

})
public class UserAction extends BaseAction {
	@Autowired
	private UserService userServiceImpl;
	@Autowired
	private InService inServiceImpl;
	@Autowired
	private BookService bookServiceImpl;
	@Autowired
	private DjService djServiceImpl;
	@Autowired
	private QsService qsServiceImpl;
	@Autowired
	private ClService clServiceImpl;
	@Autowired
	private HsService hsServiceImpl;
	private Hy user;
	private String userName;
	private String demo;
	private String flag;
	private String isJy;
	private String bookId;
	
	public String execute(){
		demo = "0000";
		return "success";
	}
	public String jiaoyan()
	{
		flag = "操作成功";
		userServiceImpl.update(user);
		if(isJy.equals("借出"))
		{
			Book b = bookServiceImpl.getBook(Integer.parseInt(bookId));
			if(b.getIsNew().equals("新书"))
			{
				int newCount = Integer.parseInt(clServiceImpl.getTs("新书借阅数量").getClNum());
				List<Hs> hs = hsServiceImpl.getHs(user.getUserId());
				if(hs != null && hs.size()>newCount)
				{
					flag = "借书已达上限";
					return "jiechu";
				}
			}
			else{
				int newCount = Integer.parseInt(clServiceImpl.getTs("普通书借阅数量").getClNum());
				List<Hs> hs = hsServiceImpl.getHs(user.getUserId());
				if(hs != null && hs.size()>newCount)
				{
					flag = "借书已达上限";
					return "jiechu";
				}
			}
			Infor infor  = new Infor();
			infor.setBookId(Integer.parseInt(bookId));
			infor.setUserId(user.getUserId());
			Date d = new Date();  
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
	        String jcDate = sdf.format(d);
	        infor.setJDate(jcDate);
	        inServiceImpl.addInfor(infor);
	        Book book = bookServiceImpl.getBook(Integer.parseInt(bookId));
	        book.setBStatus("锁定");
	        book.setBSl(book.getBSl()+1);
	        bookServiceImpl.updateBook(book);
		}
		if(isJy.equals("预定"))
		{
			Dj dj = new Dj();
			dj.setUserId(user.getUserId()); 
			Book book = bookServiceImpl.getBook(Integer.parseInt(bookId));
			dj.setDjAu(book.getBAu());
			dj.setDjStatus("预定");
			dj.setBookId(book.getBookId());
			dj.setDjName(book.getBName());
			Dj test =djServiceImpl.getdj(book.getBookId(), user.getUserId());
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
				Qs qs = qsServiceImpl.getqs(book.getBookId());
				if(qs == null)
				{
					Qs q = new Qs();
					q.setAu(dj.getDjAu());
					q.setName(dj.getDjName());
					q.setStatus("预定");
					q.setSl(1);
					q.setBookId(dj.getBookId());
					qsServiceImpl.addQs(q);
				}
				else
				{
					
					qs.setSl(qs.getSl()+1);
					qsServiceImpl.addQs(qs);
				}
		        book.setBSl(book.getBSl()+1);
		        bookServiceImpl.updateBook(book);
			}
		}
		if(isJy.equals("缺书"))
		{
			flag = "完善图书信息";
			return "queshu";
		}
		return "jiechu";
	}
	public String getUserBySnum()
	{
		user = userServiceImpl.getUser(userName);
		return "getUserBySnum";
	}
	public String updateUser()
	{
		userServiceImpl.update(user);
		return "updateUser";
	}

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}
	public Hy getUser() {
		return user;
	}
	public void setUser(Hy user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

}
