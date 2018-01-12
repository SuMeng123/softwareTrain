package com.tsgl.dao;
import org.springframework.stereotype.Repository;

import com.tsgl.dao.base.BaseDao;
import com.tsgl.entity.Book;


@Repository("bookDao")
public class BookDao extends BaseDao<Book>{

}
