package com.ctgu.qmx.createFactory;

import java.sql.SQLException;

import com.ctgu.qmx.abstructFactory.AbstructFactory;
import com.ctgu.qmx.dao.AdminDao;
import com.ctgu.qmx.dao.BillDao;
import com.ctgu.qmx.daoimpl.AdminDaoImpl;

public class IBaseDaoFactory implements AbstructFactory {

	public AdminDao getAdminDaoImpl() throws SQLException{
		return new AdminDaoImpl();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BillDao> T getBillDaoImpl(Class<T> clz) {
		BillDao billDao = null;
		try {
			billDao = (BillDao)Class.forName(clz.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (T) billDao;
	}
	
}
