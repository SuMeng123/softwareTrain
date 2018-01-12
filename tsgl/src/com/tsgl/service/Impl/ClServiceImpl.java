package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.ClDao;
import com.tsgl.entity.Cl;
import com.tsgl.service.ClService;
@Controller("clServiceImpl")
public class ClServiceImpl implements ClService {
	@Autowired
	private ClDao clDao;

	@Override
	public List<Cl> geTs() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("tslb", "图书类别");
		String hql ="from Cl cl where cl.clName = :tslb";
		List<Cl> cls = clDao.find(hql, params);
		return cls;
	}

	@Override
	public Cl getTs(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		String hql ="from Cl cl where cl.clName = :name";
		Cl cls = clDao.Get(hql, params);
		return cls;
	}

}
