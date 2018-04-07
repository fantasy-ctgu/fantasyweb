package com.ctgu.qmx.createFactory;

import java.sql.SQLException;

import com.ctgu.qmx.abstructFactory.AbstructFactory;
import com.ctgu.qmx.dao.AdminDao;
import com.ctgu.qmx.dao.BillDao;
import com.ctgu.qmx.daoimpl.AdminDaoImpl;
import com.ctgu.qmx.daoimpl.BillDaoImpl;
import com.ctgu.qmx.utils.DBUtils;

public class IBaseDaoFactory implements AbstructFactory {

	public AdminDao getAdminDaoImpl() throws SQLException{
		return new AdminDaoImpl(DBUtils.getCon());
	}
	public BillDao getBillDaoImpl() throws SQLException{
		return new BillDaoImpl(DBUtils.getCon());
	}
}
