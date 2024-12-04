package com.demo.service;

import com.demo.beans.LoginUser;

public interface LoginService {

	LoginUser validateUser(String uname, String passwd);
	
}
