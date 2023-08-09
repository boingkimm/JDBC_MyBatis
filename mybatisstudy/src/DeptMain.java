import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DeptMain {

	public static void main(String[] args) throws Exception {
		// Configuration.xml 파일 읽기
		
		String resource = "Configuration.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession session = sqlSessionFactory.openSession();
		
		// 원래는 여러개 한번에 호출X. 실습용
		
		//findbyDept 호출
		DeptDTO dto = session.selectOne("DeptMapper.findByDeptno", 10); //deptno = 10을 찾기
		System.out.println(dto);
		System.out.println("#####################################");
		
		//findAll 호출
		List<DeptDTO> list = session.selectList("DeptMapper.findAll");
		for (DeptDTO xxx : list) {
			System.out.println(xxx);
		}
		System.out.println("#####################################");

		// findByDeptnoAndDname 호출 - 결과여러개, list로 받기
		DeptDTO dto2 = new DeptDTO();
		dto2.setDeptno(10);  //dto에 담아서 전달
		dto2.setDname("인사");		
		List<DeptDTO> list2 = session.selectList("DeptMapper.findByDeptnoAndDname", dto2);
		for (DeptDTO xxx : list2) {
			System.out.println(xxx);
		}
		System.out.println("#####################################");
		
		// findByDeptnoAndDnameMap - hashmap으로 받아보기
		HashMap<String, Object> map = new HashMap<>();  //deptno는 int, dname은 string이니까 object로 둘 다 받기
		map.put("xxx", 10); //hashmap에 담아서 전달
		map.put("yyy", "인사");
		
		List<DeptDTO> list3 = session.selectList("DeptMapper.findByDeptnoAndDnameMap", map);
		for (DeptDTO xxx : list3) {
			System.out.println(xxx);
		}
		System.out.println("#####################################");

		//샵블럭은 파라미터 있을 떄
		// findAllPage 호출 - RowBounds
		RowBounds bounds = new RowBounds(1, 3);
		
		List<DeptDTO> list4 = session.selectList("DeptMapper.findAllPage", null, bounds);
		for (DeptDTO xxx : list4) {
			System.out.println(xxx);
		}
		
		System.out.println("#####################################");
		session.close();
		
		
	}

}
