package com.csc305.bookborrowmanager;

import java.util.ArrayList;

public class BookEntityModel {
    private String isbn;
    private String title;
    private String genre;
    private double price;
    private String accnNumber;
    private ArrayList<String> authors = new ArrayList<>();

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public BookEntityModel(String isbn, String title, String genre, double price, String accnNumber, ArrayList<String> authors) {
        this.isbn = isbn;
        this.title = title;
        this.genre = genre;
        this.price = price;
        this.authors = authors;
        this.accnNumber = accnNumber;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAccnNumber() {
        return accnNumber;
    }

    public void setAccnNumber(String accnNumber) {
        this.accnNumber = accnNumber;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "\n" + "BookEntityModel{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", accnNumber=" + accnNumber +
                ", authors=" + authors +
                '}' + "\n";
    }
}
