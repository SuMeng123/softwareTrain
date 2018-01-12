package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.TuijianDao;
import com.tsgl.entity.Tuijian;
import com.tsgl.service.AdminService;
import com.tsgl.service.TuijianService;
@Controller("tuijianServiceImpl")
public class TuijianServiceImpl implements TuijianService {
	@Autowired
	private TuijianDao tuijianDao;

	@Override
	public List<Tuijian> geTuijians(String name) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", name);
		String hql ="from Tuijian tj where tj.clNum = :name order by tj.BSl desc";
		List<Tuijian> tuijians = tuijianDao.find(hql, params);
		
		return tuijians;
	}

}
