package AcademicManagement.Query;

import AcademicManagement.VO.GradeVO;

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
   //update grade set grade = ? where student_id = ? AND class_id = ?
}
