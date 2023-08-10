package com.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.config.MySqlSessionFactory;
import com.dao.MyBatisDAO;
import com.dto.StudentDTO;

public class MyBatisServiceImpl implements MyBatisService {

	@Override
	public List<StudentDTO> selectAllStudent() {
		List<StudentDTO> list = null;
		SqlSession session = MySqlSessionFactory.getSession();
		try {
		//DAO 연동
		 MyBatisDAO dao = new MyBatisDAO();
		 list = dao.selectAllStudent(session);
		}finally {
			session.close();
		}
		return list;
	}
} //MyBatisServiceImpl


/*
 * SqlSession session = MySqlSessionFactory.getSession();
		try{
		
		}finally {
			session.close();
		}
*/
