package com.csc305.employeerecords;

import java.time.LocalDate;

public class EmployeeEntityModel {
    private String employeeId;
    private String employeeName;
    private double employeeSalary;

    private String employeeDesignation;
    private LocalDate employeeDoB;
    private LocalDate employeeDoJ;

    public EmployeeEntityModel(String employeeId, String employeeName, double employeeSalary, String employeeDesignation, LocalDate employeeDoB, LocalDate employeeDoJ) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeDesignation = employeeDesignation;
        this.employeeDoB = employeeDoB;
        this.employeeDoJ = employeeDoJ;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    public LocalDate getEmployeeDoB() {
        return employeeDoB;
    }

    public void setEmployeeDoB(LocalDate employeeDoB) {
        this.employeeDoB = employeeDoB;
    }

    public LocalDate getEmployeeDoJ() {
        return employeeDoJ;
    }

    public void setEmployeeDoJ(LocalDate employeeDoJ) {
        this.employeeDoJ = employeeDoJ;
    }

    @Override
    public String toString() {
        return "EmployeeEntityModel{" +
                "employeeId='" + employeeId + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                ", employeeDoB=" + employeeDoB +
                ", employeeDoJ=" + employeeDoJ +
                '}';
    }
}
