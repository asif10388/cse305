package com.csc305.bookborrowmanager;

import java.time.LocalDate;

public class BorrowedBookTableInfo {
    private String studentId;
    private String bookTitle;
    private String studentName;
    private String bookAccnNumber;
    private LocalDate borrowDate;

    public BorrowedBookTableInfo(String studentId, String bookTitle, String studentName, LocalDate borrowDate, String bookAccnNumber) {
        this.studentId = studentId;
        this.bookTitle = bookTitle;
        this.studentName = studentName;
        this.borrowDate = borrowDate;
        this.bookAccnNumber = bookAccnNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getBookAccnNumber() {
        return bookAccnNumber;
    }

    public void setBookAccnNumber(String bookAccnNumber) {
        this.bookAccnNumber = bookAccnNumber;
    }

    @Override
    public String toString() {
        return "BorrowedBookTableInfo{" +
                "studentId='" + studentId + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", borrowDate=" + borrowDate +
                ", bookAccnNumber='" + bookAccnNumber + '\'' +
                '}';
    }
}
