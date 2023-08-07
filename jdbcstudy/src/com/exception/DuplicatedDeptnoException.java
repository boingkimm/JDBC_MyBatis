package com.exception;

// 사용자정의 예외클래스
// 예외발생시 try~catch 또는 throws에 사용할 수 있다.
public class DuplicatedDeptnoException extends Exception {

	// 필요시 변수, 메서드 추가 가능
	
	// 생성자(String)
	public DuplicatedDeptnoException(String message) {  //예외발생시 보여주는 메시지
		super(message);
	}

	
}
