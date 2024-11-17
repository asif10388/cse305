package com.csc305.midterm_2110182_7;

import java.time.LocalDate;
import java.util.ArrayList;

public class PathologyBill {
    private int billId;
    private int patientId;
    private int doctorId;
    private LocalDate testDate;

    private ArrayList<Integer> testIdList = new ArrayList<>();
    private ArrayList<Float> testPriceList = new ArrayList<>();

    public PathologyBill(int billId, int patientId, int doctorId, LocalDate testDate, ArrayList<Integer> testIdList, ArrayList<Float> testPriceList) {
        this.billId = billId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.testDate = testDate;
        this.testIdList = testIdList;
        this.testPriceList = testPriceList;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
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

    public ArrayList<Integer> getTestIdList() {
        return testIdList;
    }

    public void setTestIdList(ArrayList<Integer> testIdList) {
        this.testIdList = testIdList;
    }

    public ArrayList<Float> getTestPriceList() {
        return testPriceList;
    }

    public void setTestPriceList(ArrayList<Float> testPriceList) {
        this.testPriceList = testPriceList;
    }

    public float getTotalBillCost(){
        float sum = 0;

        for(Float testPrice : testPriceList){
            sum += testPrice;
        }

        return sum;
    }

    @Override
    public String toString() {
        return "PathologyBill{" +
                "billId=" + billId +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", testDate=" + testDate +
                ", testIdList=" + testIdList.toString() +
                ", testPriceList=" + testPriceList.toString() +
                '}';
    }
}
