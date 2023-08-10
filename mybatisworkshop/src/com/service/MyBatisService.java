package com.service;

import java.util.List;
import com.dto.StudentDTO;

public interface MyBatisService {
	public List<StudentDTO> selectAllStudent();
}
