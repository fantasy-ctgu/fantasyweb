package com.ctgu.qmx.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ctgu.qmx.entity.AdminUsers;
import com.ctgu.qmx.factoryProducer.FactoryProducer;

public class AdminLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if(username == null){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		try {
			AdminUsers adminUsers = null;
			adminUsers = FactoryProducer.getIBaseDaoFactory().getAdminDaoImpl().findById(username);
			if(adminUsers != null && password.equals(adminUsers.getPassword())){
				HttpSession session = req.getSession();
				session.setAttribute("adminUser", adminUsers.getUsername());
				req.removeAttribute("error");
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			else {
				req.setAttribute("error", "非法用户");
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
