package com.tsgl.service;

import java.util.List;

import com.tsgl.entity.JhBook;

public interface JhService {
	/**
	 * 得到借还书目列表
	 * @param userID
	 * @return
	 */
	public List<JhBook> getJhBook(int userID);

}
