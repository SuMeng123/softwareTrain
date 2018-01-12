package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.UserDao;
import com.tsgl.entity.Hy;
import com.tsgl.service.UserService;
@Controller("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public long getUserCount(String userName) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		String hql ="select count(*) from Hy hy where hy.USnum = :userName";
		long count =	userDao.count(hql, params);
		return count;
	}

	@Override
	public long getUserCount(String userName, String password) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("password", password);
		String hql ="select count(*) from Hy hy where hy.USnum = :userName and hy.UPsw = :password";
		long count = userDao.count(hql, params);
		return count;
	}

	@Override
	public Hy getUser(String userName) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		String hql ="from Hy hy where hy.USnum = :userName";
		Hy user = userDao.Get(hql, params);
		return user;
	}

	@Override
	public void update(Hy user) {
		// TODO Auto-generated method stub
		userDao.update(user);
	}
	
}
