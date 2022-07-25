package Main;

import AcademicManagement.*;
import AcademicManagement.VO.*;

import java.io.PrintStream;
import java.sql.ResultSet;
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
        int cnt = 0;
        int i = 0;
        float avg_grade = 0.0f;
        StudentsVO studentsVO = new StudentsVO();
        ProfessorVO professorVO = new ProfessorVO();
        Class_listVO class_listVO = new Class_listVO();
        GradeVO gradeVO = new GradeVO();
        SugangVO sugangVO = new SugangVO();
        ResultSet rs;
        ResultSet rs2;
        ArrayList<Integer> sugang_to = new ArrayList<Integer>();

        while(true) {
            out.println("================메뉴 선택======================");
            out.println("0. 프로그램 종료");
            out.println("1. 학생 추가"); // add_xxxxx
            out.println("2. 교수 추가"); // add_xxxxx
            out.println("3. 강좌 개설"); // add_xxxxx
            out.println("4. 강좌 폐설"); //  delete class_list 이때 grade, sugang 조회해서 먼저 지워야함.
            out.println("5. 성적 기입 또는 변경"); // update
            out.println("6. 학생별 성적 조회"); //select grade
            out.println("7. 휴학/복학 처리"); // update
            out.println("8. 휴직/복직 처리"); // update
            out.println("9. 수강신청"); // insert grade, sugang => 성적은 안넣고.
            out.println("10. 수강정정"); // alter로 변환
            out.println("=============================================");
            input_num = in.nextInt();
            if (input_num == 0) {
                break;
            }
            switch (input_num) {
                case 1:
                    /*
                    학생 추가
                     */
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
                     /*
                    교수 추가
                     */
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
                    /*
                    강좌 개설
                    */
                    out.print("강좌 번호: ");
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
                    /*
                    강좌 폐설
                    */
                    out.print("강좌 번호: ");
                    class_listVO.setId(in.nextInt());
                    class_listVO.setState("폐강");
                    management.update_classClosed(class_listVO);
                    break;
                case 5:
                    /*
                    성적 기입 */
                    out.print("수업 번호: ");
                    gradeVO.setClass_id(in.nextInt());
                    out.print("학번: ");
                    gradeVO.setStudent_id(in.nextInt());
                    out.print("성적: ");
                    gradeVO.setGrade(in.nextFloat());
                    management.update_grade(gradeVO);
                    break;
                case 6:
                    /*
                    성적 조회
                     */
                    out.print("학번: ");
                    gradeVO.setStudent_id(in.nextInt());
                    rs = management.select_grade(gradeVO.getStudent_id());


                    i = 0;
                    avg_grade = 0.0f;
                    while(rs.next()){
                        ++i;
                        out.println("강좌 번호: " +rs.getInt("class_id")+" 점수: "+rs.getFloat("grade"));
                        avg_grade += rs.getFloat("grade");
                    }
                    management.closeDB();
                    studentsVO.setId(gradeVO.getStudent_id());
                    avg_grade = (float) (Math.round(avg_grade/i*100)/100.0);
                    studentsVO.setAvg_grade(avg_grade);
                    management.update_avgGrade(studentsVO);
                    out.println("평균 학점: "+avg_grade);

                    break;
                case 7:
                    /*
                    휴/복학
                     */
                    out.print("학번: ");
                    studentsVO.setId(in.nextInt());
                    in.nextLine();
                    out.print("휴학일 경우 '휴학'을 복학일 경우 '재학'을 입력해주세요 : ");
                    studentsVO.setState(in.nextLine());
                    management.update_studentState(studentsVO);
                    break;
                case 8:
                    /*
                    휴/복직
                     */
                    out.print("교번: ");
                    professorVO.setId(in.nextInt());
                    in.nextLine();
                    out.print("휴직일 경우 '휴직'을 복직일 경우 '재직'을 입력해주세요 : ");
                    professorVO.setState(in.nextLine());
                    management.update_professorState(professorVO);
                    break;
                case 9:
                    /*
                    수강 신청
                     */
                    rs = management.select_classList();
                    out.println("============강좌 목록=============");
                    i = 0;
                    sugang_to.clear();
                    sugang_to.add(0,0);
                    while(rs.next()){
                        ++i;
                        sugang_to.add(i, 0);
                        class_listVO.setId(rs.getInt("id"));
                        class_listVO.setName(rs.getString("name"));
                        class_listVO.setDate(rs.getString("time"));
                        class_listVO.setProfessor_id(rs.getInt("professor_id"));
                        class_listVO.setClass_to(rs.getInt("class_to"));
                        class_listVO.setExtra(rs.getString("extra"));

                        professorVO.setId(class_listVO.getProfessor_id());
                        rs2 = management.select_classProfessor(professorVO.getId());
                        if(rs2.next()){
                            class_listVO.setProfessor_name(rs2.getString("name"));
                        }
                        rs2.close();
                        cnt = 0;
                        rs2 = management.select_sugangTo(class_listVO.getId());
                        while(rs2.next()){
                            cnt++;
                        }
                        rs2.close();
                        class_listVO.setSugang_to(cnt);
                        sugang_to.set(i, class_listVO.getClass_to()-cnt);
                        out.println(class_listVO.toString());
                    }
                    out.println("================================");
                    management.closeDB();
                    out.print("학번: ");
                    in.nextLine();
                    sugangVO.setStudent_id(in.nextInt());
                    out.print("강좌 번호: ");
                    sugangVO.setClass_id(in.nextInt());
                    if(sugang_to.get(sugangVO.getClass_id()-200) > 0){
                        management.insert_sugangGo(sugangVO);
                    }else{
                        out.println("정원이 꽉 찼습니다!");
                    }
                    break;
                case 10:
                    out.print("학번: ");
                    in.nextLine();
                    sugangVO.setStudent_id(in.nextInt());
                    out.print("강좌 번호: ");
                    sugangVO.setClass_id(in.nextInt());
                    management.delete_sugang(sugangVO);
                    break;
                default:
                    break;
            }
        }

    }

}
