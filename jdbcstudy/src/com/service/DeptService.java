package com.service;

import java.sql.Connection;
import java.util.List;

import com.dto.DeptDTO;
import com.exception.DuplicatedDeptnoException;

// dept 테이블의 데이터를 가공하는 역할 ==> 비즈니스 로직 처리 및 트랜잭션 처리 담당.
public interface DeptService {

	public List<DeptDTO> findAll();

	// DML
	public int insert(DeptDTO dto) throws DuplicatedDeptnoException;
	public int update(DeptDTO dto);
	public int delete(int deptno);

	// 수정 및 삭제처리하는 메서드
	public int updateAndDelete(DeptDTO dto, int deptno);  //deptno2 변수 맘대로
	
}