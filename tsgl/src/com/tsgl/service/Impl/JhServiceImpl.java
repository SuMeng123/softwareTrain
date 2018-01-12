package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.JhDao;
import com.tsgl.entity.JhBook;
import com.tsgl.service.JhService;
@Controller("jhServiceImpl")
public class JhServiceImpl implements JhService {
	@Autowired
	private JhDao jhDao;

	@Override
	public List<JhBook> getJhBook(int userID) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userID", userID);
		String hql ="from JhBook jh where jh.userId = :userID order by jh.inid desc";
		List<JhBook> jhBooks = jhDao.find(hql, params);
		return jhBooks;
	}

}
