package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;
import com.tsgl.dao.UpBookDao;
import com.tsgl.entity.UpBook;
import com.tsgl.service.UpBookService;
import com.tsgl.util.Page;
@Controller("upBookServiceImpl")
public class UpBookServiceImpl implements UpBookService {
	@Autowired
	private UpBookDao upBookDao;
	@Override
	public List<UpBook> getBooks() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", "注销");
		String hql = "from UpBook up where up.BStatus != :status";
		List<UpBook>up=upBookDao.find(hql, params);
		return up;
	}
	@Override
	public long getBookCount() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("status", "注销");
		String hql = "select count(distinct  up.bookId) from UpBook up where up.BStatus != :status";
		long count = upBookDao.count(hql, params);
		return count;
	}
	@Override
	public List<UpBook> getBooks(String clid, String tsName) {
		// TODO Auto-generated method stub
		String hql = "from UpBook up where up.BStatus != '注销'";
		if(!clid.equals("-1"))
		{
			hql += " and up.clid ="+clid;
		}
		if(tsName != null && !tsName.equals(""))
		{
			hql += " and up.BName like '%"+tsName+"%'";
		}
		List<UpBook>up=upBookDao.find(hql);
		return up;
	}

}
