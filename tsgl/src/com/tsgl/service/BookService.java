package com.tsgl.service;

import com.tsgl.entity.Book;

public interface BookService {
	/**
	 * 修改图书表
	 * @param book
	 */
	public void updateBook(Book book);
	/**
	 * 得到图书实体
	 * @param bookId
	 * @return
	 */
	public Book getBook(int bookId);

}
