package AcademicManagement;

import java.sql.*;

public class DBconnector {
    // 변수 선언
    public static Connection dbConn;

    //-- 자동으로 초기화 지원 -> null

    // 메소드 정의
    public static Connection getConnection() // throws ClassNotFoundException, SQLException
    {
        // 한 번 연결된 객체를 계속 사용...
        // 즉, 연결되지 않은 경우에만 연결을 시도하겠다는 의미
        // -> singleton(디자인 패턴)
        if (dbConn == null)
        {
            try
            {
                String url = "jdbc:mysql://localhost:3306/academic_management";
                String userName = "root";
                String password = "root";

                dbConn = DriverManager.getConnection(url, userName, password);
                //-- OracleDriver 클래스에 대한 객체 생성
                //   드라이버 로딩 -> JVM에 전달
                // forName은 예외가 throw 되기 때문에 try catch나 throw해줘야 한다.
                // ClassNotFoundException

                //-- 오라클 서버 실제 연결
                //   위 (line 32 ~ 41)는... 연결을 위한 환경을 설정하는 과정
                //   갖고 있는 인자값(매개변수)은 오라클 주소, 계정명, 패스워드
                //   SQLException
                //ps.setString(", name);
                //ps.setString("male", gender);
                //ps.setString("");
            } catch(Exception e) // (ClassNotFoundException, SQLException)
            {
                System.out.println(e.toString());
                //-- 오라클 서버 연결 실패 시... 오류 메세지 출력 부분
            }
        }
        return dbConn;


    }//end getConnection()


    // 메소드 정의 -> 연결 종료 메소드
    public static void close() {
        // dbConn 변수(멤버 변수)는
        // Database 가 연결된 상태일 경우 Connection 을 갖는다.
        // 연결되지 않은 상태라면 null 인 상태가 된다.
        if (dbConn != null) {
            try {
                // 연결 객체의 isClosed() 메소드를 통해 연결상태 확인
                //-- 연결이 닫혀있는 경우 true 반환
                //   연결이 닫히지 않은 경우 false 반환
                // 닫혀 있는 상황이 맞는게 아니라면 -> 열려있다면
                if (!dbConn.isClosed()) {
                    dbConn.close();
                    //-- 연결 객체의 close() 메소드 호출을 통해 연결 종료
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        // 핵심
        // dbConn을 null로
        dbConn = null;
    }


    /*
    String url = "jdbc:mysql://localhost:3306/academic_management";
    String userName = "root";
    String password = "root";
    Connection connection = DriverManager.getConnection(url, userName, password);
    Statement statement = connection.createStatement();

    public Management() throws SQLException {

    }
    public void add_student(int id, String name, String gender, String major, int grade, float avg_grade, String state, String extra) throws SQLException{
        //String sql = "insert into students values ("+id+", '"+name+"' , '"+gender+"', '"+major+"', '"+grade+"', '"+avg_grade+"', '"+state+"' , '"+extra+"');";
        String sql = "insert into students values (id, name, gender, major, grade, avg_grade, state, extra)";
        statement.execute(sql);
        statement.close();
        connection.close();
    }
    public void add_professor() throws SQLException{
        //String sql = "insert into professors values (id, )";
        //statement.execute(sql);
        //statement.execute("insert into students values (3, '임준영', 'male', 'computer science', 1, 4.2, '재학', '');");
        statement.close();
        connection.close();
    }


    //ResultSet resultSet = statement.executeQuery("ALTER TABLE students ADD email VARCHAR(25) NOT NULL");


    //resultSet.next();
    //String name = resultSet.getString("name");
    //int number = resultSet.getInt("id");
    //System.out.println(name);
    //System.out.println(number);


    //resultSet.close();

     */

}