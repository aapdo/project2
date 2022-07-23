package AcademicManagement;

import AcademicManagement.Query.InsertQuery;
import AcademicManagement.Query.SelectQuery;
import AcademicManagement.Query.UpdateQuery;
import AcademicManagement.VO.Class_listVO;
import AcademicManagement.VO.GradeVO;
import AcademicManagement.VO.ProfessorVO;
import AcademicManagement.VO.StudentsVO;

import java.sql.*;

public class Management{

    //public DBconnector dbConnector = new DBconnector();
    //public Connection dbConn;
    InsertQuery insert_query = new InsertQuery();
    SelectQuery select_query = new SelectQuery();
    UpdateQuery update_query = new UpdateQuery();
    public Connection dbConn;

    /* insert into를 이용하여 DB에 정보 저장 */
    public void insert_student(StudentsVO studentsVO) throws SQLException{
        dbConn = DBconnector.getConnection();
        insert_query.insert_student(dbConn, studentsVO);
        DBconnector.close();
    }
    public void insert_student(int id, String name, String gender, String major, int grade, float avg_grade, String state, String extra) throws SQLException{
        dbConn = DBconnector.getConnection();
        insert_query.insert_student(dbConn, id, name, gender, major, grade, avg_grade, state, extra);
        DBconnector.close();
    }
    public void insert_professor(ProfessorVO professorVO){
        dbConn = DBconnector.getConnection();
        insert_query.insert_professor(dbConn, professorVO);
        DBconnector.close();
    }
    public void insert_classList(Class_listVO class_listVO){
        dbConn = DBconnector.getConnection();
        insert_query.insert_classList(dbConn, class_listVO);
        DBconnector.close();
    }
    public void insert_grade(GradeVO gradeVO){
        dbConn = DBconnector.getConnection();
        insert_query.insert_grade(dbConn, gradeVO);
        DBconnector.close();
    }
    /* insert into를 이용하여 DB에 정보 저장 */

    /* update를 이용하여 DB에 정보 수정 */
    public void update_grade(GradeVO gradeVO){
        dbConn = DBconnector.getConnection();
        update_query.update_grade(dbConn, gradeVO);
        DBconnector.close();
    }


    /* test
    public void test(StudentsVO studentsVO) throws SQLException{
        dbConn = DBconnector.getConnection();
        insert_query.test(dbConn, studentsVO);
        DBconnector.close();
    }
     */

    public Management() throws SQLException {
    }
    /*
    public void add_student(int id, String name, String gender, String major, int grade, float avg_grade, String state, String extra) throws SQLException{
        dbConn =  dbConnector.getConnection();
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
        dbConnector.close();
    }

     */

    /*
    public void test() throws SQLException {
        dbConn = getConnection();
        sql= "insert into students(id, name, gender, major, grade, avg_grade, state, extra) values(?,?,?,?,?,?,?,?)";
        try {

            ps = dbConn.prepareStatement(sql);
            ps.setInt(1, 2);
            ps.setString(2, "임준영");
            ps.setString(3, "male");
            ps.setString(4, "computer science");
            ps.setInt(5, 1);
            ps.setFloat(6, 4.00f);
            ps.setString(7, "재학");
            ps.setString(8, "");
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        close();

    }

     */


}
