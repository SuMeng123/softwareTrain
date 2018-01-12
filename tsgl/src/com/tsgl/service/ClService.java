package com.tsgl.service;

import java.util.List;

import com.tsgl.entity.Cl;

public interface ClService {
	/**
	 * 得到所有图书类别
	 * @return
	 */
	public List<Cl> geTs();
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Cl getTs(String name);

}
