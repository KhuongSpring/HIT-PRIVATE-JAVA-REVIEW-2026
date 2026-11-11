package KhoaHoc;

public class Enrollment {
    private Course course;
    private String studentName;

    public Enrollment(Course course, String studentName) {
        this.course = course;
        this.studentName = studentName;
    }

    public Course getCourse() {
        return course;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getSummary() {
        return studentName + " đăng ký khóa học: "
                + course.getCode() + " - "
                + course.getName() + " - "
                + course.getFee();
    }
}