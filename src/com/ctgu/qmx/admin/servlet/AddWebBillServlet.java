package com.ctgu.qmx.admin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctgu.qmx.dao.BillDao;
import com.ctgu.qmx.daoimpl.BillWebDaoImpl;
import com.ctgu.qmx.entity.Bill;
import com.ctgu.qmx.factoryProducer.FactoryProducer;

public class AddWebBillServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
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
		BillDao billDao = FactoryProducer.getIBaseDaoFactory().getBillDaoImpl(BillWebDaoImpl.class);
		if(billDao.doInsert(bill)){
			req.getRequestDispatcher("web_bill_submit.html").forward(req, resp);
		}
		else {
			out.write("系统出现错误，插入失败，请联系管理员！！！");
		}
	}

}
