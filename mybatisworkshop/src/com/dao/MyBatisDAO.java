package com.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.dto.StudentDTO;

public class MyBatisDAO {

	public List<StudentDTO> selectAllStudent(SqlSession session){
		List<StudentDTO> list = session.selectList("StudentMapper.selectAllStudent");
		return list;
	}
}
