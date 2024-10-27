package com.csc305.bookborrowmanager;

import java.time.LocalDate;
import java.util.Date;

public class StudentEntityModel {
    private String id;
    private String name;
    private double cgpa;
    private String major;
    private String gender;
    private LocalDate dob;

    public StudentEntityModel(String id, LocalDate dob, String name, double cgpa, String major, String gender) {
        this.id = id;
        this.dob = dob;
        this.name = name;
        this.cgpa = cgpa;
        this.major = major;
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "\n" +
                " dob=" + dob + '\n' +
                " id=" + id + '\n' +
                " name=" + name + '\n' +
                " cgpa=" + cgpa + '\n' +
                " major=" + major + '\n' +
                " gender=" + gender + '\n'
                + "\n" ;
    }
}
