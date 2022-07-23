package AcademicManagement.VO;

public class GradeVO {
    private int id;
    private int class_id;
    private int professor_id;
    private int student_id;
    private float grade;
    private String extra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClass_id() {
        return class_id;
    }

    public void setClass_id(int class_id) {
        this.class_id = class_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    @Override
    public String toString() {
        return "GradeVO{" +
                "id=" + id +
                ", class_id=" + class_id +
                ", professor_id=" + professor_id +
                ", student_id=" + student_id +
                ", grade=" + grade +
                ", extra='" + extra + '\'' +
                '}';
    }
}
