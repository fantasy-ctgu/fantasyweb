package com.ctgu.qmx.abstructFactory;

import java.sql.SQLException;

import com.ctgu.qmx.dao.AdminDao;
import com.ctgu.qmx.dao.BillDao;

public interface AbstructFactory {
	public abstract AdminDao getAdminDaoImpl() throws SQLException;
	public abstract <T extends BillDao> T getBillDaoImpl(Class<T> clz);
}
