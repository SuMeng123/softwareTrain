package com.tsgl.service;

import java.util.List;

import com.tsgl.entity.UpBook;
import com.tsgl.util.Page;

public interface UpBookService {
	/**
	 * 得到所有没有注销的图书
	 * @return
	 */
	public List<UpBook> getBooks();
	/**
	 * 得到所有图书数量
	 * @return
	 */
	public long getBookCount();
	/**
	 * 根据种类id和图书名称查询
	 * @param clid
	 * @param tsName
	 * @return
	 */
	public List<UpBook> getBooks(String clid,String tsName);

}
