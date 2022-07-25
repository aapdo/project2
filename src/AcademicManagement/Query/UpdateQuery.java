package AcademicManagement.Query;

import AcademicManagement.VO.Class_listVO;
import AcademicManagement.VO.GradeVO;
import AcademicManagement.VO.ProfessorVO;
import AcademicManagement.VO.StudentsVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateQuery {
    private String sql;
    private PreparedStatement ps;
    public UpdateQuery(){}

    public void update_grade(Connection dbConn, GradeVO gradeVO){
        sql= "update grade set grade = ? where student_id = ? AND class_id = ?";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setFloat(1, gradeVO.getGrade());
            ps.setInt(2, gradeVO.getStudent_id());
            ps.setInt(3, gradeVO.getClass_id());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_studentState(Connection dbConn, StudentsVO studentsVO){
        try {
            sql= "update students set state = ? where id =?";
            ps = dbConn.prepareStatement(sql);
            ps.setString(1, studentsVO.getState());
            ps.setInt(2, studentsVO.getId());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_professorState(Connection dbConn, ProfessorVO professorVO){
        try {
            sql= "update professors set state = ? where id =?";
            ps = dbConn.prepareStatement(sql);
            ps.setString(1, professorVO.getState());
            ps.setInt(2, professorVO.getId());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void update_classClosed(Connection dbConn, Class_listVO class_listVO){
        try {
            sql= "update class_list set state = ? where id =?";
            ps = dbConn.prepareStatement(sql);
            ps.setString(1, class_listVO.getState());
            ps.setInt(2, class_listVO.getId());
            ps.execute();
            ps.close();

            sql= "update sugang set state = ? where class_id =?";
            ps = dbConn.prepareStatement(sql);
            ps.setString(1, class_listVO.getState());
            ps.setInt(2, class_listVO.getId());
            ps.execute();
            ps.close();

            sql= "delete from grade where class_id = ?";
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, class_listVO.getId());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update_avgGrade(Connection dbConn, StudentsVO studentsVO){
        try {
            sql= "update students set avg_grade = ? where id =?";
            ps = dbConn.prepareStatement(sql);
            ps.setFloat(1, studentsVO.getAvg_grade());
            ps.setInt(2, studentsVO.getId());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

   //update grade set grade = ? where student_id = ? AND class_id = ?
}
