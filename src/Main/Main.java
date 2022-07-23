package Main;

import AcademicManagement.*;
import AcademicManagement.VO.*;

import java.io.PrintStream;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Management management = new Management();
        //management.insert_student(3, "jy", "male", "computer science", 1, 4.00f, "재학", "");
        //management.insert_professor(202, "jy", "computer science", "",  "재직", "");


        Scanner in = new Scanner(System.in);
        PrintStream out = System.out;
        int input_num = 0;
        int stuIdx = 0;
        int proIdx = 0;
        int clsIdx = 0;
        StudentsVO studentsVO = new StudentsVO();
        ProfessorVO professorVO = new ProfessorVO();
        Class_listVO class_listVO = new Class_listVO();
        GradeVO gradeVO = new GradeVO();
        SugangVO sugangVO = new SugangVO();

        while(true) {
            out.println("================메뉴 선택======================");
            out.println("0. 프로그램 종료");
            out.println("1. 학생 추가"); // add_xxxxx
            out.println("2. 교수 추가"); // add_xxxxx
            out.println("3. 수업 추가"); // add_xxxxx
            out.println("4. 성적 기입 또는 변경"); // update
            out.println("5. 학생별 성적 조회"); //select grade
            out.println("6. 휴학/휴직 처리"); // update
            out.println("7. 복학/복직 처리"); // update
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
                    out.print("교번: ");
                    professorVO.setId(in.nextInt());
                    in.nextLine();
                    out.print("이름: ");
                    professorVO.setName(in.nextLine());
                    out.print("전공: ");
                    professorVO.setMajor(in.nextLine());
                    out.print("등급: ");
                    professorVO.setGrade(in.nextLine());
                    out.print("상태: ");
                    professorVO.setState(in.nextLine());
                    out.print("기타: ");
                    professorVO.setExtra(in.nextLine());

                    management.insert_professor(professorVO);
                    out.println("추가 완료!");
                    break;
                case 3:
                    out.print("수업 번호: ");
                    class_listVO.setId(in.nextInt());
                    in.nextLine();
                    out.print("강의 제목: ");
                    class_listVO.setName(in.nextLine());
                    out.print("날짜(0000-00-00): ");
                    class_listVO.setDate(in.nextLine());
                    out.print("정원: ");
                    class_listVO.setClass_to(in.nextInt());
                    out.print("담당교수 교번: ");
                    class_listVO.setProfessor_id(in.nextInt());
                    out.print("기타: ");
                    in.nextLine();
                    class_listVO.setExtra(in.nextLine());
                    management.insert_classList(class_listVO);
                    out.println("추가 완료!");
                    break;
                case 4:
                    out.print("수업 번호: ");
                    gradeVO.setClass_id(in.nextInt());
                    out.print("학번: ");
                    gradeVO.setStudent_id(in.nextInt());
                    out.print("성적: ");
                    gradeVO.setGrade(in.nextFloat());

                    management.update_grade(gradeVO);

                    break;
                default:
                    break;
            }
        }

    }

}
