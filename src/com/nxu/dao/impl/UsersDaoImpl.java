package com.nxu.dao.impl;

import com.nxu.dao.UsersDao;

public class UsersDaoImpl implements UsersDao {

	@Override
	public boolean isLogin(String username, String pwd) {
		boolean ret=false;
		if(username.equals("nxu")&&pwd.equals("nxu123")){
			ret=true;
		}
		return ret;
	}

}
