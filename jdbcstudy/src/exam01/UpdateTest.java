package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

public class UpdateTest {

	public static void main(String[] args) {


		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "SCOTT";
		String passwd = "TIGER";

		// 드라이버 로딩
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
				
		// 오라클 연결  + SQL문 작성 + SQL문 전송객체 + SQL문 전송하기 + API close
		Connection con = null;
		PreparedStatement pstmt = null;

		
		try{
		 con = DriverManager.getConnection(url, userid, passwd);
		 // 자동 줄바꿈 - 공백 하나씩 꼭 넣기
		 String sql = "update dept set dname=?, loc=? where deptno=?";
		 
		 pstmt = con.prepareStatement(sql);
		 
		 // ? 대신에 값 설정하기
		 pstmt.setInt(3, 11); 
		 pstmt.setString(1,	"개발부");
		 pstmt.setString(2, "서울시");		 
		 
		 int num = pstmt.executeUpdate();
		 System.out.println("레코드 변경개수:" + num);
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 연결완료
		
	} //end main

}
