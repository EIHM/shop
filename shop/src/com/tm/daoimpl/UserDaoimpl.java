package com.tm.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tm.dao.UserDao;
import com.tm.domain.User;
import com.tm.utils.UtilTools;


public class UserDaoimpl implements UserDao {
	static Connection conn = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;

	// ��½�û� �������ݷ��ض��󼯺�
	public User getUsers(String name, String password) {
		// List<User> list=new ArrayList<User>();
		User user = new User();
		conn = com.tm.utils.UtilTools.getCon();
		String sql = "SELECT ID,NAME,PASSWORD FROM USER WHERE NAME=? AND PASSWORD=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while (rs.next()) {

				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));

				// list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		// return list ;

	}

	// ע���û�
	public void regist(String name, String password) {
		conn = UtilTools.getCon();
		String sql = "INSERT INTO USER (NAME,PASSWORD) VALUES (?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// ����û����Ƿ��ظ�
	public boolean isUserHas(String name) {
		int flag = 0;
		conn = UtilTools.getCon();
		String sql = "SELECT ID FROM USER WHERE NAME=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				flag = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (flag == 0) {
			return false; // ����false��û�и��û�
		} else {
			return true; // ����true���и��û�
		}
	}

}
