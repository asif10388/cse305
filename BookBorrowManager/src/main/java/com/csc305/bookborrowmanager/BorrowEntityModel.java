package com.csc305.bookborrowmanager;

import java.time.LocalDate;

public class BorrowEntityModel {
    private String bookTitle;
    private String studentName;
    private LocalDate issueDate;
    private LocalDate returnDate;

    @Override
    public String toString() {
        return "BorrowEntityModel{" +
                "bookName='" + bookTitle + '\'' +
                ", studentName='" + studentName + '\'' +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }

    public String getBookName() {
        return bookTitle;
    }

    public void setBookName(String bookName) {
        this.bookTitle = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BorrowEntityModel(String studentName, String bookName, LocalDate issueDate, LocalDate returnDate) {
        this.studentName = studentName;
        this.bookTitle = bookName;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }
}
