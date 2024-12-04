package com.demo.service;

import com.demo.beans.LoginUser;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService{
	LoginDao ldao;
	public LoginServiceImpl(){
		ldao=new LoginDaoImpl();
	}
	@Override
	public LoginUser validateUser(String uname, String passwd) {
		return ldao.checkUser(uname,passwd);
	}
}
