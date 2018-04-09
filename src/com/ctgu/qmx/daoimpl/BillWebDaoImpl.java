package com.ctgu.qmx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.ctgu.qmx.dao.BillDao;
import com.ctgu.qmx.entity.Bill;
import com.ctgu.qmx.utils.DBUtils;

public class BillWebDaoImpl implements BillDao {

	private Connection con;
	private PreparedStatement ps;

	public BillWebDaoImpl() {
		try {
			this.con = DBUtils.getCon();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean doInsert(Bill v) {
		String sql = "insert into webbill(money,content) value(?,?)";
		try {
			this.ps = con.prepareStatement(sql);
			ps.setDouble(1, v.getMoney());
			ps.setString(2, v.getContent());
			if (ps.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean doDelete(String k) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Bill v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bill findById(String k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> findAllPaging(String column, String keyWord, int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllContent() {
		// TODO Auto-generated method stub
		return 0;
	}

}
