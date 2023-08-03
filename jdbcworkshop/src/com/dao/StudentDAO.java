package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.Student;

public class StudentDAO {

	//1. 학생 정보 조회 (1. 전체 학생 목록)
	public ArrayList<Student> selectAllStudent(Connection con) {
		ArrayList<Student> list = new ArrayList<Student>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select student_no 학번, student_name 이름, rpad(substr(student_ssn, 0, 8), 14, '*') 주민번호, substr(student_address, 0, 10)||'...' 주소, to_char(entrance_date, 'yyyy/mm/dd') 입학년도, absence_yn 휴학여부";
		   sql += " from tb_student order by 1";
	String sql2 = "select count(student_name) from tb_student";
		
	try {
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String stuNo = rs.getString("학번");
			String stuName = rs.getString("이름");
			String stuSsn = rs.getString("주민번호");
			String stuAddress = rs.getString("주소");
			String entDate = rs.getString("입학년도");
			String absYn = rs.getString("휴학여부");
			
			Student s = new Student(stuNo, stuName, stuSsn, stuAddress, entDate,	absYn);
			list.add(s);	
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return list;
	}//findAll
}
