package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.LoginUser;

public class LoginDaoImpl implements LoginDao{
	static Connection conn;
	static PreparedStatement psc;
	
	static {
		conn=DBUtil.MyConnection();
		try {
			psc=conn.prepareStatement("select user,pass,role from login where user=? and pass=?");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public LoginUser checkUser(String uname, String passwd) {
		try {
			psc.setString(1, uname);
			psc.setString(2, passwd);
			ResultSet rs=psc.executeQuery();
//			System.out.println(rs.getString(1)+"-----"+rs.getString(2));
			if(rs.next()) {
				return (new LoginUser(rs.getString(1),rs.getString(2),rs.getString(3))); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
