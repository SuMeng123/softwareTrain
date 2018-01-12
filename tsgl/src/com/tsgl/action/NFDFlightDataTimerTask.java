package com.tsgl.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;
import java.util.*;
import javax.mail.*;
import javax.mail.Message.RecipientType;
import javax.mail.internet.*;
import javax.activation.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.tsgl.entity.Hs;
import com.tsgl.service.HsService;
import com.tsgl.service.Impl.HsServiceImpl;
import com.tsgl.util.Test;
 
/**
 * 在 TimerManager 这个类里面，大家一定要注意 时间点的问题。如果你设定在凌晨2点执行任务。但你是在2点以后
 *发布的程序或是重启过服务，那这样的情况下，任务会立即执行，而不是等到第二天的凌晨2点执行。为了，避免这种情况
 *发生，只能判断一下，如果发布或重启服务的时间晚于定时执行任务的时间，就在此基础上加一天。
 * @author wls
 *
 */
public class NFDFlightDataTimerTask extends TimerTask {
	
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void run() {
        try {
             //在这里写你要执行的内容
            System.out.println("执行当前时间"+formatter.format(Calendar.getInstance().getTime()));
          
            //连接mysql或者sqlsever
            Connection conn = Test.getConn();;
            //执行sql(oracle)
            PreparedStatement stmt = null;
            //数据存储(oracle)
            ResultSet rs = null;
            String sql = "update Book set B_Status = '可借' where B_Status = '锁定'";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            sql = "delete from Infor where AdminID is null or AdminID = ''";
            stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            sql = "select * from CL";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            int newDay = 0;
            int oldDay = 0;
            while (rs.next()) {
                try {
                	if(rs.getString("CL_Name").equals("普通书借阅期限"))
                	{
                		oldDay = Integer.parseInt(rs.getString("CL_Num"));
                	}
                	if(rs.getString("CL_Name").equals("新书借阅期限"))
                	{
                		newDay = Integer.parseInt(rs.getString("CL_Num"));
                	}
                } catch (Exception e) {
                    continue;
                }
            }
            sql = "select * from hs";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                try {
                	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                	String dateString = rs.getString("J_Date");
                	Calendar calendar = Calendar.getInstance();
                	long nowDate = calendar.getTime().getTime(); //Date.getTime() 获得毫秒型日期                	
                	long specialDate = sdf.parse(dateString).getTime();
                    long betweenDate = (nowDate - specialDate) / (1000 * 60 * 60 * 24); //计算间隔多少天，则除以毫秒到天的转换公式
                	System.out.print(betweenDate);
                	if(rs.getString("IS_New").equals("新书"))
                	{
                		int cc = (int) (newDay - betweenDate);
                		if(cc<=3&&cc>=0)
                		{
                			System.out.print("还有"+cc+"天");
                			 // 创建Properties 类用于记录邮箱的一些属性
                	        Properties props = new Properties();
                	        // 表示SMTP发送邮件，必须进行身份验证
                	        props.put("mail.smtp.auth", "true");
                	        //此处填写SMTP服务器
                	        props.put("mail.smtp.host", "smtp.qq.com");
                	        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
                	        props.put("mail.smtp.port", "587");
                	        // 此处填写你的账号
                	        props.put("mail.user", "2418606562@qq.com");
                	        // 此处的密码就是前面说的16位STMP口令
                	        props.put("mail.password", "pbqwetkjrxzadjge");

                	        // 构建授权信息，用于进行SMTP进行身份验证
                	        Authenticator authenticator = new Authenticator() {

                	            protected PasswordAuthentication getPasswordAuthentication() {
                	                // 用户名、密码
                	                String userName = props.getProperty("mail.user");
                	                String password = props.getProperty("mail.password");
                	                return new PasswordAuthentication(userName, password);
                	            }
                	        };
                	        // 使用环境属性和授权信息，创建邮件会话
                	        Session mailSession = Session.getInstance(props, authenticator);
                	        // 创建邮件消息
                	        MimeMessage message = new MimeMessage(mailSession);
                	        // 设置发件人
                	        InternetAddress form = new InternetAddress(
                	                props.getProperty("mail.user"));
                	        message.setFrom(form);

                	        // 设置收件人的邮箱
                	        InternetAddress to = new InternetAddress(rs.getString("U_Email"));
                	        message.setRecipient(RecipientType.TO, to);

                	        // 设置邮件标题
                	        message.setSubject("到期啦！！！");

                	        // 设置邮件的内容体
                	        message.setContent(rs.getString("B_Name")+"还有"+cc+"天", "text/html;charset=UTF-8");

                	        // 最后当然就是发送邮件啦
                	        Transport.send(message);
                		}
                		else if (cc<0) 
                		{
                			System.out.print("逾期"+Math.abs(cc)+"天");
                			 // 创建Properties 类用于记录邮箱的一些属性
                	        Properties props = new Properties();
                	        // 表示SMTP发送邮件，必须进行身份验证
                	        props.put("mail.smtp.auth", "true");
                	        //此处填写SMTP服务器
                	        props.put("mail.smtp.host", "smtp.qq.com");
                	        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
                	        props.put("mail.smtp.port", "587");
                	        // 此处填写你的账号
                	        props.put("mail.user", "2418606562@qq.com");
                	        // 此处的密码就是前面说的16位STMP口令
                	        props.put("mail.password", "pbqwetkjrxzadjge");

                	        // 构建授权信息，用于进行SMTP进行身份验证
                	        Authenticator authenticator = new Authenticator() {

                	            protected PasswordAuthentication getPasswordAuthentication() {
                	                // 用户名、密码
                	                String userName = props.getProperty("mail.user");
                	                String password = props.getProperty("mail.password");
                	                return new PasswordAuthentication(userName, password);
                	            }
                	        };
                	        // 使用环境属性和授权信息，创建邮件会话
                	        Session mailSession = Session.getInstance(props, authenticator);
                	        // 创建邮件消息
                	        MimeMessage message = new MimeMessage(mailSession);
                	        // 设置发件人
                	        InternetAddress form = new InternetAddress(
                	                props.getProperty("mail.user"));
                	        message.setFrom(form);

                	        // 设置收件人的邮箱
                	        InternetAddress to = new InternetAddress(rs.getString("U_Email"));
                	        message.setRecipient(RecipientType.TO, to);

                	        // 设置邮件标题
                	        message.setSubject("逾期啦！！！");

                	        // 设置邮件的内容体
                	        message.setContent(rs.getString("B_Name")+"逾期"+Math.abs(cc)+"天", "text/html;charset=UTF-8");

                	        // 最后当然就是发送邮件啦
                	        Transport.send(message);
						}
                	}
                	else
                	{
                		int cc = (int) (oldDay - betweenDate);
                		if(cc<=3&&cc>=0)
                		{
                			System.out.print("还有"+cc+"天");
                			 // 创建Properties 类用于记录邮箱的一些属性
                	        Properties props = new Properties();
                	        // 表示SMTP发送邮件，必须进行身份验证
                	        props.put("mail.smtp.auth", "true");
                	        //此处填写SMTP服务器
                	        props.put("mail.smtp.host", "smtp.qq.com");
                	        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
                	        props.put("mail.smtp.port", "587");
                	        // 此处填写你的账号
                	        props.put("mail.user", "2418606562@qq.com");
                	        // 此处的密码就是前面说的16位STMP口令
                	        props.put("mail.password", "pbqwetkjrxzadjge");

                	        // 构建授权信息，用于进行SMTP进行身份验证
                	        Authenticator authenticator = new Authenticator() {

                	            protected PasswordAuthentication getPasswordAuthentication() {
                	                // 用户名、密码
                	                String userName = props.getProperty("mail.user");
                	                String password = props.getProperty("mail.password");
                	                return new PasswordAuthentication(userName, password);
                	            }
                	        };
                	        // 使用环境属性和授权信息，创建邮件会话
                	        Session mailSession = Session.getInstance(props, authenticator);
                	        // 创建邮件消息
                	        MimeMessage message = new MimeMessage(mailSession);
                	        // 设置发件人
                	        InternetAddress form = new InternetAddress(
                	                props.getProperty("mail.user"));
                	        message.setFrom(form);

                	        // 设置收件人的邮箱
                	        InternetAddress to = new InternetAddress(rs.getString("U_Email"));
                	        message.setRecipient(RecipientType.TO, to);

                	        // 设置邮件标题
                	        message.setSubject("到期啦！！！");

                	        // 设置邮件的内容体
                	        message.setContent(rs.getString("B_Name")+"还有"+cc+"天", "text/html;charset=UTF-8");

                	        // 最后当然就是发送邮件啦
                	        Transport.send(message);
                		}
                		else if (cc<0) 
                		{
                			System.out.print("逾期"+Math.abs(cc)+"天");
                			 // 创建Properties 类用于记录邮箱的一些属性
                	        Properties props = new Properties();
                	        // 表示SMTP发送邮件，必须进行身份验证
                	        props.put("mail.smtp.auth", "true");
                	        //此处填写SMTP服务器
                	        props.put("mail.smtp.host", "smtp.qq.com");
                	        //端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
                	        props.put("mail.smtp.port", "587");
                	        // 此处填写你的账号
                	        props.put("mail.user", "2418606562@qq.com");
                	        // 此处的密码就是前面说的16位STMP口令
                	        props.put("mail.password", "pbqwetkjrxzadjge");

                	        // 构建授权信息，用于进行SMTP进行身份验证
                	        Authenticator authenticator = new Authenticator() {

                	            protected PasswordAuthentication getPasswordAuthentication() {
                	                // 用户名、密码
                	                String userName = props.getProperty("mail.user");
                	                String password = props.getProperty("mail.password");
                	                return new PasswordAuthentication(userName, password);
                	            }
                	        };
                	        // 使用环境属性和授权信息，创建邮件会话
                	        Session mailSession = Session.getInstance(props, authenticator);
                	        // 创建邮件消息
                	        MimeMessage message = new MimeMessage(mailSession);
                	        // 设置发件人
                	        InternetAddress form = new InternetAddress(
                	                props.getProperty("mail.user"));
                	        message.setFrom(form);

                	        // 设置收件人的邮箱
                	        InternetAddress to = new InternetAddress(rs.getString("U_Email"));
                	        message.setRecipient(RecipientType.TO, to);

                	        // 设置邮件标题
                	        message.setSubject("逾期啦！！！");

                	        // 设置邮件的内容体
                	        message.setContent(rs.getString("B_Name")+"逾期"+Math.abs(cc)+"天", "text/html;charset=UTF-8");

                	        // 最后当然就是发送邮件啦
                	        Transport.send(message);
						}
                	}
                	
                } catch (Exception e) {
                    continue;
                }
            }
            
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }
    
     
}
