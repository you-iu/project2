package com.khrd.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.khrd.dto.Project;
import com.khrd.jdbc.JDBCUtil;

public class ProjectDAO {
	private static final ProjectDAO dao = new ProjectDAO();
	
	public static ProjectDAO getInstance() {
		return dao;
	}
	
	private ProjectDAO() {}
	
	public List<Project> selectProjectList(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Project> list = null;
		try {
			String sql = "select * from project order by project_no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				Project pro = new Project(
						0,
						rs.getString("project_name"),
						null,
						rs.getTimestamp("regdate"),
						rs.getTimestamp("moddate"),
						rs.getString("project_re"));					
				list.add(pro);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
			JDBCUtil.close(rs);
		}
		return null;
	}
	public int insertProject(Connection conn, Project pro) {
		PreparedStatement pstmt = null;
		try {
			String sql="insert into project values (null,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pro.getProject_name());
			pstmt.setDate(2, (Date) pro.getRegdate());
			pstmt.setDate(3, (Date) pro.getModdate());
			pstmt.setString(4, pro.getProject_re());
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	public int insertProjectContent(Connection conn, String content) {
		PreparedStatement pstmt = null;
		try {
			String sql="insert into project_content values (last_insert_id(),?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, content);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt);
		}
		return -1;
	}
	
	public Project selectByNo(Connection conn,int project_no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql="select * from project as v left join project_content as s on v.project_no = s.project_no where v.project_no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, project_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Project pro = new Project(rs.getInt("project_no"),
										rs.getString("project_name"),
										rs.getString("project_content"),
										rs.getTimestamp("regdate"),
										rs.getTimestamp("moddate"),
										rs.getString("project_re")
										);
				return pro;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs);
			JDBCUtil.close(pstmt);
		}
		return null;
	}
}
