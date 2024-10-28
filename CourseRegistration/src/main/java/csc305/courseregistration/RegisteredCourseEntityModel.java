package csc305.courseregistration;

public class RegisteredCourseEntityModel {
    private int courseCredits;
    private String courseName;
    private String courseCode;
    private int courseSection;

    public RegisteredCourseEntityModel(String courseCode, int courseCredit, int courseSection) {
        this.courseCode = courseCode;
        this.courseCredits = courseCredit;
        this.courseSection = courseSection;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredit() {
        return courseCredits;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredits = courseCredit;
    }

    public int getCourseSection() {
        return courseSection;
    }

    public void setCourseSection(int courseSection) {
        this.courseSection = courseSection;
    }

    @Override
    public String toString() {
        return "\n" +
                ", courseCode='" + courseCode + '\'' +
                ", courseCredit=" + courseCredits +
                ", courseSection=" + courseSection +
                "\n";
    }
}
