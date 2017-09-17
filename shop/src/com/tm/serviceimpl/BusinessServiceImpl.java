package com.tm.serviceimpl;

import com.tm.dao.UserDao;
import com.tm.daoimpl.UserDaoimpl;
import com.tm.domain.User;
import com.tm.userexception.ExistUserException;

public class BusinessServiceImpl {

	private UserDao userDao = new UserDaoimpl();

	// web��ע���û�
	public void register(User user) throws ExistUserException {
		String name = user.getName();
		boolean bool = userDao.isUserHas(name);
		if (bool) {
			// System.out.println("���û���ע��");
			throw new ExistUserException(); // �׳�һ���쳣���web��ץ�����ʹ��������ҳ��
		} else {
			String password = user.getPassword();
			userDao.regist(name, password);
		}

	}

	// web���½�û�

	public User login(String name, String password) {

		User user = userDao.getUsers(name, password);

		return user;

	}

}
