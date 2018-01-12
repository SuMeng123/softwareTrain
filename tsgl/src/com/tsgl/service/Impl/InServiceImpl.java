package com.tsgl.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.InDao;
import com.tsgl.entity.Infor;
import com.tsgl.service.InService;
@Controller("inServiceImpl")
public class InServiceImpl implements InService {
	@Autowired
	private InDao inDao;
	@Override
	public void addInfor(Infor infor) {
		// TODO Auto-generated method stub
		inDao.Save(infor);
	}

}
