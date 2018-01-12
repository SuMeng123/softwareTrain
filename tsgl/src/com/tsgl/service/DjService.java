package com.tsgl.service;

import java.util.List;

import com.tsgl.entity.Dj;

public interface DjService {
	/**
	 * 保存预定或缺书记录
	 * @param dj
	 */
	public void addDj(Dj dj);
	/**
	 * 得到dj实体
	 * @param bookid
	 * @param userid
	 * @return
	 */
	public Dj getdj(int bookid,int userid);
	/**
	 * 得到dj列表
	 * @param userid
	 * @return
	 */
	public List<Dj> getdj(int userid);
	/**
	 * 通过书名的到dj
	 * @param name
	 * @return
	 */
	public Dj getdj(String name,int userid);
	

}
