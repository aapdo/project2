package AcademicManagement.VO;

public class Class_listVO {
    private int id;
    private String name;
    private String date;
    private int class_to;
    private int sugang_to;
    private int professor_id;
    private String professor_name;
    private String state;
    private String extra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getClass_to() {
        return class_to;
    }

    public void setClass_to(int class_to) {
        this.class_to = class_to;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }

    public int getSugang_to() {
        return sugang_to;
    }

    public void setSugang_to(int sugang_to) {
        this.sugang_to = sugang_to;
    }

    @Override
    public String toString() {
        return  "강좌 번호: " + id +
                ", 강좌명: '" + name + '\'' +
                ", 시간: '" + date + '\'' +
                ", 수강인원/정원: " + sugang_to +'/'+class_to+
                ", 담당교수: " + professor_name +
                ", 비고: '" + extra + '\''
                ;
    }
}
