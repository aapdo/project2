package Main;

import AcademicManagement.Management;
import AcademicManagement.StudentsVO;

import java.io.PrintStream;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Management management = new Management();
        //management.insert_student(3, "jy", "male", "computer science", 1, 4.00f, "재학", "");
        //management.insert_professor(202, "jy", "computer science", "",  "재직", "");


        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        int input_num = 0;
        StudentsVO studentsVO = new StudentsVO();



        while(true) {
            out.println("================메뉴 선택======================");
            out.println("0. 프로그램 종료");
            out.println("1. 학생 추가"); // add_xxxxx
            out.println("2. 교수 추가"); // add_xxxxx
            out.println("3. 수업 추가"); // add_xxxxx
            out.println("4. 성적 기입"); // add_grade insert
            out.println("5. 학생별 성적 조회"); //select grade
            out.println("6. 휴학/휴직 처리"); // alter_xx
            out.println("7. 복학/복직 처리"); // alter_xx
            out.println("8. 강좌 개설/폐설"); // add_ delete class_list 이때 select로 grade 조회.
            out.println("9. 수강신청"); // insert grade, sugang => 성적은 안넣고.
            out.println("10. 수강정정"); // alter로 변환
            out.println("=============================================");
            input_num = in.nextInt();
            if (input_num == 0) {
                break;
            }
            switch (input_num) {
                case 1:
                    out.print("학번: ");
                    studentsVO.setId(in.nextInt());
                    in.nextLine();
                    out.print("이름: ");
                    studentsVO.setName(in.nextLine());
                    out.print("성별: ");
                    studentsVO.setGender(in.nextLine());
                    out.print("전공: ");
                    studentsVO.setMajor(in.nextLine());
                    out.print("학년: ");
                    studentsVO.setGrade(in.nextInt());
                    out.print("평균학점: ");
                    studentsVO.setAvg_grade(in.nextFloat());
                    in.nextLine();
                    out.print("상태: ");
                    studentsVO.setState(in.nextLine());
                    out.print("기타: ");
                    studentsVO.setExtra(in.nextLine());

                    management.insert_student(studentsVO);
                    out.println("추가 완료!");
                    break;
                case 2:

                    out.println("추가 완료!");
                    break;
                default:
                    break;
            }
        }

    }

}
