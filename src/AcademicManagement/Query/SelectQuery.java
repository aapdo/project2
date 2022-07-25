package AcademicManagement.Query;

import java.net.ConnectException;
import java.sql.*;

public class SelectQuery {
    String sql;
    public static PreparedStatement ps;
    public static Statement st;
    public static ResultSet rs;

    public SelectQuery() {
    }
    public ResultSet select_classList(Connection dbConn){
        try {
            st = dbConn.createStatement();
            sql= "select * from class_list where state = '개강'";
            rs = st.executeQuery(sql);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;
    }
    public ResultSet select_classProfessor(Connection dbConn, int professor_id){

        sql= "select name from professors where id = ?";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, professor_id);
            rs = ps.executeQuery();
            return rs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet select_sugangTo(Connection dbConn, int class_id){
        sql= "select class_id from sugang where class_id = ?";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, class_id);
            rs = ps.executeQuery();
            return rs;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet select_grade(Connection dbConn, int student_id){
        sql= "select class_id, grade from grade where student_id = ?";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, student_id);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
