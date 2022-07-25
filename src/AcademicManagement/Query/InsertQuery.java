package AcademicManagement.Query;

import AcademicManagement.VO.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQuery {
    private String sql;
    private PreparedStatement ps;
    public InsertQuery() {
    }
    public void insert_student(Connection dbConn,int id, String name, String gender, String major, int grade, float avg_grade, String state, String extra ){
        sql= "insert into students(id, name, gender, major, grade, avg_grade, state, extra) values(?,?,?,?,?,?,?,?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, gender);
            ps.setString(4, major);
            ps.setInt(5, grade);
            ps.setFloat(6, avg_grade);
            ps.setString(7, state);
            ps.setString(8, extra);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("insert!");
    }

    public void insert_student(Connection dbConn, StudentsVO studentsVO ){
        sql= "insert into students(id, name, gender, major, grade, avg_grade, state, extra) values(?,?,?,?,?,?,?,?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, studentsVO.getId());
            ps.setString(2, studentsVO.getName());
            ps.setString(3, studentsVO.getGender());
            ps.setString(4, studentsVO.getMajor());
            ps.setInt(5, studentsVO.getGrade());
            ps.setFloat(6, studentsVO.getAvg_grade());
            ps.setString(7, studentsVO.getState());
            ps.setString(8, studentsVO.getExtra());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert_professor(Connection dbConn, ProfessorVO professorVO){
        sql= "insert into professors(id, name, major, grade, state, extra) values(?,?,?,?,?,?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, professorVO.getId());
            ps.setString(2, professorVO.getName());
            ps.setString(3, professorVO.getMajor());
            ps.setString(4, professorVO.getGrade());
            ps.setString(5, professorVO.getState());
            ps.setString(6, professorVO.getExtra());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert_classList(Connection dbConn, Class_listVO class_listVO){
        sql= "insert into class_list(id, name, time, class_to, professor_id, state, extra) values(?,?,?,?,?, '개강',?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, class_listVO.getId());
            ps.setString(2, class_listVO.getName());
            ps.setString(3, class_listVO.getDate());
            ps.setInt(4, class_listVO.getClass_to());
            ps.setInt(5, class_listVO.getProfessor_id());
            ps.setString(6, class_listVO.getExtra());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert_grade(Connection dbConn, GradeVO gradeVO){
        sql= "insert into grade(id, class_id, professor_id, student_id, grade, extra) values(?,?,?,?,?,?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, gradeVO.getId());
            ps.setInt(2, gradeVO.getClass_id());
            ps.setInt(3, gradeVO.getProfessor_id());
            ps.setInt(4, gradeVO.getStudent_id());
            ps.setFloat(5, gradeVO.getGrade());
            ps.setString(6, gradeVO.getExtra());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void sugang_go(Connection dbConn, SugangVO sugangVO){
        try {
            sql = "insert into sugang (id, class_id, professor_id, student_id, state, extra) value " +
                    "( ( select MAX(a.id) + 1 from sugang a) , ?, (select professor_id from class_list where id = ?), ?, '확정', '')";
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, sugangVO.getClass_id());
            ps.setInt(2, sugangVO.getClass_id());
            ps.setInt(3, sugangVO.getStudent_id());
            ps.execute();
            ps.close();

            sql = "insert into grade (id, class_id, professor_id, student_id, grade, extra) value " +
                    "( ( select MAX(a.id) + 1 from grade a) , ?, (select professor_id from class_list where id = ?), ?, 0.00, '')";

            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, sugangVO.getClass_id());
            ps.setInt(2, sugangVO.getClass_id());
            ps.setInt(3, sugangVO.getStudent_id());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
