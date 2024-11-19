package com.demo.dao;

import com.demo.beans.LoginUser;

public interface LoginDao {

	LoginUser checkUser(String uname, String passwd);

}
