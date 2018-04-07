package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ctgu.qmx.dao.AdminDao;
import com.ctgu.qmx.entity.AdminUsers;

public class AdminDaoImpl implements AdminDao{

	private Connection con;
	private PreparedStatement ps;
	
	public AdminDaoImpl(Connection con) {
		this.con = con;
	}
	
	@Override
	public boolean doInsert(AdminUsers v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doDelete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(AdminUsers v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public AdminUsers findById(String k) {
		String sql = "select * from adminusers where username = ?";
		AdminUsers users = null;
		try {
			this.ps = con.prepareStatement(sql);
			ps.setString(1, k);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				users = new AdminUsers();
				users.setUsername(rs.getString("username"));
				users.setPassword(rs.getString("password"));
				users.setName(rs.getString("name"));
				users.setSex(rs.getString("sex"));
				users.setPhone(rs.getString("phone"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public List<AdminUsers> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AdminUsers> findAllPaging(String column, String keyWord, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllContent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
