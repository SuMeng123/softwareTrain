package com.tsgl.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;
import com.opensymphony.xwork2.ActionContext;
import com.sun.net.httpserver.Authenticator.Success;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;
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
import com.tsgl.service.Impl.ClServiceImpl;
import com.tsgl.service.Impl.UserServiceImpl;

@Component
@Scope("prototype")
@Action(value="loginAction",results={
		@Result(name="success",location="/new/index.jsp"),
		@Result(name="toNewInfor",location="/new/newInfor.jsp"),
		@Result(name="jiechu",location = "bookAction.action", type = "redirectAction",params = {
				"flag", "${flag}" }),
		@Result(name="queshu",location="/new/queshu.jsp"),
		

})
public class LoginAction {
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
	private String userName;
	private String password;
	private String bookID;
	private String flag;
	private Hy user;
	private String isJy;
	private String bookId;
	

	public String jiaoyan()
	{
		bookId = bookId;
		isJy = isJy;
		user = userServiceImpl.getUser(userName);
		if(user.getUName() == null || user.getUName().equals("")||user.getUSex()==null||user.getUSex().equals("")||user.getUPhone()==null||user.getUPhone().equals("")||user.getUEmail()==null||user.getUEmail().equals(""))
		{
			flag = "请完善个人信息";
			return "toNewInfor";
		}
		else
		{
			flag = "操作成功";
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
		
	}
	public String checklogin(){
		String json = "";
		if(userServiceImpl.getUserCount(userName) < 1)
		{
			json = "用户名不存在";
		}
		else if(userServiceImpl.getUserCount(userName,password) < 1)
		{
			json = "密码不正确";
		}
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public void setUser(Hy user) {
		this.user = user;
	}
	public String execute()
	{
		return "success";
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
	public Hy getUser() {
		return user;
	}

}
