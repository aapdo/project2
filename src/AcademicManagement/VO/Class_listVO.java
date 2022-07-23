package AcademicManagement.VO;

public class Class_listVO {
    private int id;
    private String name;
    private String date;
    private int class_to;
    private int professor_id;
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

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "class_listVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", class_to=" + class_to +
                ", professor_id=" + professor_id +
                ", extra='" + extra + '\'' +
                '}';
    }
}
