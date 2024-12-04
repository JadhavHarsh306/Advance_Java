package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;

public class ProductDaoImpl implements ProductDao{

	static Connection conn;
	static PreparedStatement psd;
	
	static {
		conn=DBUtil.MyConnection();
		try {
			psd=conn.prepareStatement("select * from myproduct");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public List<Product> getAll() {
		List<Product> plst= new ArrayList<>();
		try {
			ResultSet rs=psd.executeQuery();
			while(rs.next()) {
				plst.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3), rs.getInt(4),rs.getDate(5).toLocalDate()));
			}
			return plst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
