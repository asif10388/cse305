package com.csc305.midterm_2110182_7;

import java.time.LocalDate;

public class TableInfo {
    private int testId;
    private int patientId;
    private int doctorId;
    private LocalDate testDate;

    public TableInfo(int testId, int patientId, int doctorId, LocalDate testDate) {
        this.testId = testId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.testDate = testDate;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    @Override
    public String toString() {
        return "TableInfo{" +
                "testId=" + testId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", testDate=" + testDate +
                '}';
    }
}
