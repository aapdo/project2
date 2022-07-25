package AcademicManagement.Query;

import AcademicManagement.VO.GradeVO;
import AcademicManagement.VO.SugangVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteQuery {
    private String sql;
    private PreparedStatement ps;
    public DeleteQuery(){}

    public void delete_sugang(Connection dbConn, SugangVO sugangVO){
        try {
            sql= "delete from sugang where student_id = ? AND class_id = ?";
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, sugangVO.getStudent_id());
            ps.setInt(2, sugangVO.getClass_id());
            ps.execute();
            ps.close();

            sql= "delete from grade where student_id = ? AND class_id = ?";
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, sugangVO.getStudent_id());
            ps.setInt(2, sugangVO.getClass_id());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
