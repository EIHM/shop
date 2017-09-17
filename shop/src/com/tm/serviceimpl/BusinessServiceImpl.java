package com.tm.serviceimpl;

import com.tm.dao.UserDao;
import com.tm.daoimpl.UserDaoimpl;
import com.tm.domain.User;
import com.tm.userexception.ExistUserException;

public class BusinessServiceImpl {

	private UserDao userDao = new UserDaoimpl();

	// web层注册用户
	public void register(User user) throws ExistUserException {
		String name = user.getName();
		boolean bool = userDao.isUserHas(name);
		if (bool) {
			// System.out.println("该用户已注册");
			throw new ExistUserException(); // 抛出一个异常如果web端抓到他就处理给其他页面
		} else {
			String password = user.getPassword();
			userDao.regist(name, password);
		}

	}

	// web层登陆用户

	public User login(String name, String password) {

		User user = userDao.getUsers(name, password);

		return user;

	}

}
