package com.tsgl.service;

import java.util.List;

import com.tsgl.entity.Hs;

public interface HsService {
	/**
	 * 
	 * @return
	 */
	public List<Hs> getAllHs();
	/**
	 * 
	 * @param userID
	 * @return
	 */
	public List<Hs> getHs(int userID);

}
