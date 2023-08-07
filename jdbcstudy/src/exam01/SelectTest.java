package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {

	public static void main(String[] args) {

		// 오라클DB와 연동하기 위해 필요한 4가지 정보를 "문자열"로 저장
		
		// ojdbc6_g.jar 파일들 중 가장 핵심되는 클래스명을 지정
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 오라클 접속정보를 저장
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		// 계정명
		String userid = "SCOTT";
		// 계정비밀번호
		String passwd = "TIGER";

		// 드라이버 로딩
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//
		

		// 오라클 연결  + SQL문 작성 + SQL문 전송객체 + SQL문 전송하기 + API close
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
		 con = DriverManager.getConnection(url, userid, passwd); //오라클연결
		 
		 String sql = "select deptno as no, dname, loc from dept"; //SQL문 문자열로 작성
		 pstmt = con.prepareStatement(sql); //SQL문 전송객체
		 rs = pstmt.executeQuery(); //SQL문 전송하기

		 while(rs.next()) {
			 int deptno = rs.getInt("no");   //컬럼헤더명
			 String dname = rs.getString(2);  //순서값
			 String loc =  rs.getString("loc"); 
			 System.out.println(deptno+"\t"+dname+"\t"+loc);
		 }
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {  //API close 역순으로.
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 연결완료
		
	} //end main

}
