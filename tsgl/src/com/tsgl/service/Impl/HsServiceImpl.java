package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.HsDao;
import com.tsgl.entity.Hs;
import com.tsgl.service.HsService;
@Controller("hsServiceImpl")
public class HsServiceImpl implements HsService {
	@Autowired
	private HsDao hsDao;

	@Override
	public List<Hs> getAllHs() {
		// TODO Auto-generated method stub
		String hql = "from Hs hs";
		List<Hs> hs = hsDao.find(hql);
		return hs;
	}

	@Override
	public List<Hs> getHs(int userID) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userID", userID);
		String hql ="from Hs hs where hs.userId = :userID";
		List<Hs> hs = hsDao.find(hql, params);
		return hs;
	}
	

}
