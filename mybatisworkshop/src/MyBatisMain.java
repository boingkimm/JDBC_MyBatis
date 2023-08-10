import java.util.List;
import java.util.Scanner;

import com.dto.StudentDTO;
import com.service.MyBatisService;
import com.service.MyBatisServiceImpl;

public class MyBatisMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			printMainMenu();
			String num = scan.next();
			if("1".equals(num)) {
				//서비스 연동
				MyBatisService service = new MyBatisServiceImpl();
				List<StudentDTO> list = service.selectAllStudent();
				System.out.println("학번\t이름\t주민번호\t주소\t입학년도\t휴학여부");
				System.out.println("--------------------------------------");
				for (StudentDTO dto : list) {
					System.out.println(dto.getStuNo() + "\t" + dto.getStuName() + "\t" + dto.getStuSsn() + "\t"
							+ dto.getStuAddress() + "\t" + dto.getEntDate() + "\t" + dto.getAbsYn());
				}
				System.out.println("총 학생수:" + list.size() +" 명");
			}else {
				System.out.println("프로그램이 종료되었습니다.");
				System.exit(0);
			}
		}//end while
	}

	// 메인 출력
	public static void printMainMenu() {
		System.out.println("******************************");
		System.out.println("\t[학생 정보 관리 메뉴]");
		System.out.println("******************************");
		System.out.println("1. 전체 학생 목록");
		System.out.println("0. 종료");
		System.out.println("******************************");
		System.out.println("메뉴 입력");
	}
}

