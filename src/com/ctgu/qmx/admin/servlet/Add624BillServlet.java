package com.ctgu.qmx.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.dao.BillDao;
import com.ctgu.qmx.entity.Bill;
import com.ctgu.qmx.factoryProducer.FactoryProducer;

public class Add624BillServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String type = req.getParameter("type");
		int money =Integer.parseInt(req.getParameter("money")) ;
		String content = req.getParameter("content");
		Bill bill = new Bill();
		if(type.equals("收入")){
			bill.setMoney(money);
		}else {
			bill.setMoney(-money);
		}
		bill.setContent(content);
		try {
			BillDao billDao = FactoryProducer.getIBaseDaoFactory().getBillDaoImpl();
			billDao.doInsert(bill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
