package com.tsgl.service;

import com.tsgl.entity.Qs;

public interface QsService {
	/**
	 * 根据bookid得到qs
	 * @param bookid
	 * @return
	 */
	public Qs getqs(int bookid);
	/**
	 * 根据书名得到
	 * @param name
	 * @return
	 */
	public Qs getqs(String name);
	/**
	 * 保存
	 * @param qs
	 */
	public void addQs(Qs qs);

}
