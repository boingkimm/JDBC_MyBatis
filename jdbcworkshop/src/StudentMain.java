import java.util.ArrayList;
import java.util.Scanner;

import com.dto.Student;
import com.service.StudentService;

public class StudentMain {

	public static void main(String[] args) {

		while(true) {
		System.out.println("******************************");
		System.out.println("\t[학생 정보 관리 메뉴]");
		System.out.println("******************************");
		System.out.println("1. 전체 학생 목록");
		System.out.println("0. 종료");
		System.out.println("******************************");
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("메뉴 입력=> ");
		
		int n = scanner.nextInt();
		
		if(n == 1) {
			StudentService service = new StudentService();
			ArrayList<Student> list = service.selectAllStudent();  //NOTE arraylist
			
			System.out.println("=================================================================");
			System.out.println("학번\t 이름\t 주민번호\t\t 주소\t\t 입학년도\t 휴학여부");
			System.out.println("-----------------------------------------------------------------");
			
			for(Student s:list) {
				System.out.println(s.getStuNo() + "\t" + s.getStuName() + "\t" + s.getStuSsn() + "\t"
						+ s.getStuAddress() + "\t" + s.getEntDate() + "\t" + s.getAbsYn());
			}
			System.out.println("총 학생수:" + list.size() + "명");
			
		}else if(n == 0) {
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
		}
	}

}
}
