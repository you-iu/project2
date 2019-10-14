package com.khrd.handler;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.khrd.controller.CommandHandler;
import com.khrd.dao.ProjectDAO;
import com.khrd.dto.Project;
import com.khrd.jdbc.ConnectionProvider;
import com.khrd.jdbc.JDBCUtil;

public class ProjectInsertHandler implements CommandHandler {
	SimpleDateFormat sFormat;
	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(request.getMethod().equalsIgnoreCase("get")) {
			return "WEB-INF/view/projectInsert.jsp";
		}else if(request.getMethod().equalsIgnoreCase("post")) {
			request.setCharacterEncoding("utf-8");
			String name = request.getParameter("title");
			String content = request.getParameter("content");
			String regdate = request.getParameter("regdate");
			String moddate = request.getParameter("moddate");
			String re = request.getParameter("re");
			Connection conn = null;
			try {
				conn = ConnectionProvider.getConnection();
				conn.setAutoCommit(false);
				ProjectDAO dao = ProjectDAO.getInstance();
				Project pro = new Project(0, name, content, regdate, moddate, re);
				dao.insertProject(conn, pro);
				conn.commit();
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				JDBCUtil.close(conn);
			}
		}
		return null;
	}

}
