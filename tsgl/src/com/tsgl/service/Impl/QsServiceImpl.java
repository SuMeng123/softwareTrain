package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.QsDao;
import com.tsgl.entity.Qs;
import com.tsgl.service.AdminService;
import com.tsgl.service.QsService;
@Controller("qsServiceImpl")
public class QsServiceImpl implements QsService {
	@Autowired 
	private QsDao qsDao;
	@Override
	public Qs getqs(int bookid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookid", bookid);
		String hql ="from Qs qs where qs.bookId = :bookid";
		Qs qs = qsDao.Get(hql, params);
		return qs;
	}

	@Override
	public Qs getqs(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		String hql ="from Qs qs where qs.name = :name";
		Qs qs = qsDao.Get(hql, params);
		return qs;
	}

	@Override
	public void addQs(Qs qs) {
		// TODO Auto-generated method stub
		qsDao.saveOrUpdate(qs);;
	}

}
