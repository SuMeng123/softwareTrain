package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.DjDao;
import com.tsgl.entity.Dj;
import com.tsgl.service.DjService;
@Controller("djServiceImpl")
public class DjServiceImpl implements DjService {
	@Autowired
	private DjDao djDao;

	@Override
	public void addDj(Dj dj) {
		// TODO Auto-generated method stub
		djDao.saveOrUpdate(dj);;
	}

	@Override
	public Dj getdj(int bookid, int userid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		params.put("bookid", bookid);
		String hql ="from Dj dj where dj.userId = :userid and dj.bookId = :bookid";
		Dj dj = djDao.Get(hql, params);
		return dj;
	}

	@Override
	public List<Dj> getdj(int userid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		String hql ="from Dj dj where dj.userId = :userid";
		List<Dj> djs = djDao.find(hql, params);
		return djs;
	}

	@Override
	public Dj getdj(String name ,int userid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		params.put("name", name);
		String hql ="from Dj dj where dj.userId = :userid and dj.djName = :name";
		Dj dj = djDao.Get(hql, params);
		return dj;
	}

}
