package csc305.courseregistration;

public class StudentEntityModel {
    private int studentId;
    private int scholarshipRate;
    private boolean hasScholarShip;

    public StudentEntityModel(int studentId, boolean hasScholarShip, int scholarshipRate) {
        this.studentId = studentId;
        this.hasScholarShip = hasScholarShip;
        this.scholarshipRate = scholarshipRate;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getScholarshipRate() {
        return scholarshipRate;
    }

    public void setScholarshipRate(int scholarshipRate) {
        this.scholarshipRate = scholarshipRate;
    }

    public boolean isHasScholarShip() {
        return hasScholarShip;
    }

    public void setHasScholarShip(boolean hasScholarShip) {
        this.hasScholarShip = hasScholarShip;
    }

    @Override
    public String toString() {
        return "StudentEntityModel{" +
                "studentId=" + studentId +
                ", scholarshipRate=" + scholarshipRate +
                ", hasScholarShip=" + hasScholarShip +
                '}';
    }
}
