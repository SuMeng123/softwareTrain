package com.tsgl.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.tsgl.dao.BookDao;
import com.tsgl.entity.Book;
import com.tsgl.service.BookService;
@Controller("bookServiceImpl")
public class BookServiceImpl implements BookService {
	@Autowired
	private BookDao bookDao;
	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDao.update(book);
		
	}
	@Override
	public Book getBook(int bookId) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("bookId", bookId);
		String hql ="from Book book where book.bookId = :bookId";
		Book book = bookDao.Get(hql, params);
		return book;
	}

}
