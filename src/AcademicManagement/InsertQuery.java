package AcademicManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQuery {
    String sql;

    public PreparedStatement ps;
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
    public void insert_professor(Connection dbConn, int id, String name, String major, String grade, String state, String extra ){
        sql= "insert into professors(id, name, major, grade, state, extra) values(?,?,?,?,?,?)";
        try {
            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, major);
            ps.setString(4, grade);
            ps.setString(5, state);
            ps.setString(6, extra);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("insert!");
    }

}
