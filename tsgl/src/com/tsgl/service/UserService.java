package com.tsgl.service;

import com.tsgl.entity.Hy;

public interface UserService {
	/**
	 * 根据用户名得到用户数量
	 * @param userName
	 * @return
	 */
	public long getUserCount(String userName);
	/**
	 * 根据用户名和密码得到用户数量
	 * @param userName
	 * @param password
	 * @return
	 */
	public long getUserCount(String userName,String password);
	/**
	 * 根据用户名得到用户
	 * @param userName
	 * @return
	 */
	public Hy getUser(String userName);
	/**
	 * 更改用户信息
	 * @param user
	 */
	public void update(Hy user);

}
