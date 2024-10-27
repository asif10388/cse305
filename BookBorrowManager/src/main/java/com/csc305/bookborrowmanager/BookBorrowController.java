package com.csc305.bookborrowmanager;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class BookBorrowController
{
    @javafx.fxml.FXML
    private TextField studentIdInput;

    @javafx.fxml.FXML
    private TextField studentNameInput;

    @javafx.fxml.FXML
    private TextField studentCgpaInput;

    @javafx.fxml.FXML
    private DatePicker studentDoBPicker;

    @javafx.fxml.FXML
    private ToggleGroup genderToggleGroup;

    @javafx.fxml.FXML
    private RadioButton maleRadioBtn;

    @javafx.fxml.FXML
    private ComboBox<String> studentMajorDropdown;

    @javafx.fxml.FXML
    private RadioButton femaleRadioBtn;

    private ArrayList<BorrowEntityModel> borrowTransactions;
    private ArrayList<StudentEntityModel> students;
    private ArrayList<BookEntityModel> books;
    private ArrayList<String> authors;

    @javafx.fxml.FXML
    private TextField bookTitleInput;
    @javafx.fxml.FXML
    private TextField bookISBNInput;
    @javafx.fxml.FXML
    private TextField bookACCNInput;
    @javafx.fxml.FXML
    private TextField bookAuthorInput;
    @javafx.fxml.FXML
    private TextField bookPriceInput;
    @javafx.fxml.FXML
    private ComboBox<String> bookGenreDropdown;
    @javafx.fxml.FXML
    private DatePicker returnDatePicker;
    @javafx.fxml.FXML
    private ComboBox<String> bookDropdown;
    @javafx.fxml.FXML
    private ComboBox<String> studentDropdown;
    @javafx.fxml.FXML
    private DatePicker issueDatePicker;

    @javafx.fxml.FXML
    private TableView<BorrowedBookTableInfo> borrowedBookTable;
    @javafx.fxml.FXML
    private TableColumn<BorrowedBookTableInfo, String> bookTitleColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowedBookTableInfo, String> studentIdColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowedBookTableInfo, String> studentNameColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowedBookTableInfo, LocalDate> borrowDateColumn;
    @javafx.fxml.FXML
    private TableColumn<BorrowedBookTableInfo, Integer> bookAccnNumberColumn;

    @javafx.fxml.FXML
    public void initialize() {
        genderToggleGroup = new ToggleGroup();

        maleRadioBtn.setUserData("Male");
        maleRadioBtn.setToggleGroup(genderToggleGroup);

        femaleRadioBtn.setUserData("Female");
        femaleRadioBtn.setToggleGroup(genderToggleGroup);

        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.students = new ArrayList<>();
        this.borrowTransactions = new ArrayList<>();

        StudentEntityModel sampleStudent1 = new StudentEntityModel(
                "2110183",
                LocalDate.of(2023, 5, 14),
                "Arif",
                3.67,
                "ECE",
                "Male"
        );

        StudentEntityModel sampleStudent2 = new StudentEntityModel(
                "2110184",
                LocalDate.of(2022, 11, 22),
                "Sadia",
                3.80,
                "CSE",
                "Female"
        );

        StudentEntityModel sampleStudent3 = new StudentEntityModel(
                "2110185",
                LocalDate.of(2021, 8, 30),
                "Rafi",
                3.25,
                "EEE",
                "Male"
        );

        StudentEntityModel sampleStudent4 = new StudentEntityModel(
                "2110186",
                LocalDate.of(2024, 2, 5),
                "Nadia",
                3.90,
                "ME",
                "Female"
        );

        StudentEntityModel sampleStudent5 = new StudentEntityModel(
                "2110187",
                LocalDate.of(2023, 1, 10),
                "Tariq",
                3.55,
                "CE",
                "Male"
        );


        this.students.add(sampleStudent1);
        this.students.add(sampleStudent2);
        this.students.add(sampleStudent3);
        this.students.add(sampleStudent4);
        this.students.add(sampleStudent5);

        studentDropdown.getItems().addAll(
                sampleStudent1.getName(),
                sampleStudent2.getName(),
                sampleStudent3.getName(),
                sampleStudent4.getName(),
                sampleStudent5.getName()
        );

        BookEntityModel newBook1 = new BookEntityModel(
                "978-3-16-148410-0",
                "The Great Gatsby",
                "Fiction",
                15.99,
                "A12345",
                new ArrayList<>(Arrays.asList("F. Scott Fitzgerald"))
        );

        BookEntityModel newBook2 = new BookEntityModel(
                "978-0-14-044913-6",
                "Crime and Punishment",
                "Classic",
                12.50,
                "B54321",
                new ArrayList<>(Arrays.asList("Fyodor Dostoevsky"))
        );

        BookEntityModel newBook3 = new BookEntityModel(
                "978-0-06-112008-4",
                "To Kill a Mockingbird",
                "Drama",
                18.00,
                "C67890",
                new ArrayList<>(Arrays.asList("Harper Lee"))
        );

        BookEntityModel newBook4 = new BookEntityModel(
                "978-0-7432-7356-5",
                "Angels and Demons",
                "Thriller",
                20.00,
                "D09876",
                new ArrayList<>(Arrays.asList("Dan Brown"))
        );

        BookEntityModel newBook5 = new BookEntityModel(
                "978-1-5011-3474-1",
                "The Silent Patient",
                "Psychological Thriller",
                22.50,
                "E11223",
                new ArrayList<>(Arrays.asList("Alex Michaelides"))
        );

        this.books.add(newBook1);
        this.books.add(newBook2);
        this.books.add(newBook3);
        this.books.add(newBook4);
        this.books.add(newBook5);

        bookDropdown.getItems().addAll(
                newBook1.getTitle(),
                newBook2.getTitle(),
                newBook3.getTitle(),
                newBook4.getTitle(),
                newBook5.getTitle()
        );

        studentMajorDropdown.getItems().addAll("CSE", "EEE", "BBA", "LAW");
        bookGenreDropdown.getItems().addAll("Sci-fi", "Action", "Thriller", "Romance");

        studentIdColumn.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        bookTitleColumn.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
        borrowDateColumn.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
        studentNameColumn.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        bookAccnNumberColumn.setCellValueFactory(new PropertyValueFactory<>("bookAccnNumber"));
    }

    @javafx.fxml.FXML
    public void onAddStudentButtonClick(ActionEvent actionEvent) {
        String studentId = studentIdInput.getText();
        String studentName = studentNameInput.getText();
        LocalDate studentDoB = studentDoBPicker.getValue();
        String studentMajor = studentMajorDropdown.getValue();
        double studentCgpa = Double.parseDouble(studentCgpaInput.getText());
        String studentGender = genderToggleGroup.getSelectedToggle().getUserData().toString();

        StudentEntityModel newStudent = new StudentEntityModel(
                studentId,
                studentDoB,
                studentName,
                studentCgpa,
                studentMajor,
                studentGender
        );

        this.students.add(newStudent);
        studentDropdown.getItems().add(studentName);

        studentIdInput.clear();
        studentNameInput.clear();
        studentCgpaInput.clear();
        studentDoBPicker.setValue(null);
        studentMajorDropdown.setValue(null);
        genderToggleGroup.selectToggle(null);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Added");
        alert.setHeaderText(null);

        alert.setContentText("New student record successfully added");
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onShowStudentRecordsButtonClick(ActionEvent actionEvent) {
        StringBuilder recordString = new StringBuilder();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Student Records");
        alert.setHeaderText(null);

        for (StudentEntityModel student : this.students) {
            recordString.append(student.toString()).append("\n");
        }

        alert.setContentText(recordString.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onCreateBookButtonClick(ActionEvent actionEvent) {
        String bookIsbn = bookISBNInput.getText();
        String bookTitle = bookTitleInput.getText();
        String bookGenre = bookGenreDropdown.getValue();
        String bookAccnNumber = bookACCNInput.getText();
        ArrayList<String> myAuthors = new ArrayList<>(this.authors);
        double bookPrice = Double.parseDouble(bookPriceInput.getText());

        BookEntityModel newBook = new BookEntityModel(
            bookIsbn,
            bookTitle,
            bookGenre,
            bookPrice,
            bookAccnNumber,
            myAuthors
        );

        this.books.add(newBook);
        bookDropdown.getItems().add(bookTitle);

        this.authors.clear();
        bookISBNInput.clear();
        bookACCNInput.clear();
        bookPriceInput.clear();
        bookTitleInput.clear();
        bookGenreDropdown.setValue(null);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Book Added");
        alert.setHeaderText(null);

        alert.setContentText("New book record successfully added" + newBook.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onAddAuthorButtonClick(ActionEvent actionEvent) {
        String authorName = bookAuthorInput.getText();
        this.authors.add(authorName);

        bookAuthorInput.clear();

        System.out.println(this.authors);
    }

    @javafx.fxml.FXML
    public void onShowBookRecordsButtonClick(ActionEvent actionEvent) {
        StringBuilder recordString = new StringBuilder();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Book Records");
        alert.setHeaderText(null);

        for (BookEntityModel book : this.books) {
            recordString.append(book.toString()).append("\n");
        }

        alert.setContentText(recordString.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onBorrowBookButtonClick(ActionEvent actionEvent) {
        String bookTitle = bookDropdown.getValue();
        String studentName = studentDropdown.getValue();
        LocalDate issueDate = issueDatePicker.getValue();
        LocalDate returnDate = returnDatePicker.getValue();

        BorrowEntityModel newBorrowTransaction = new BorrowEntityModel(
                studentName,
                bookTitle,
                issueDate,
                returnDate
        );

        this.borrowTransactions.add(newBorrowTransaction);

        bookDropdown.setValue(null);
        issueDatePicker.setValue(null);
        studentDropdown.setValue(null);
        returnDatePicker.setValue(null);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Borrow Successful");
        alert.setHeaderText(null);

        alert.setContentText("New book borrow transaction successfully executed" + newBorrowTransaction.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onBorrowedBookSummaryButtonClick(ActionEvent actionEvent) {
        ObservableList<BorrowedBookTableInfo> tableList = FXCollections.observableArrayList();

        for (BorrowEntityModel borrowedTransaction : borrowTransactions) {
            String studentId = "";
            String bookAccnNumber = "";
            String bookTitle = borrowedTransaction.getBookName();
            LocalDate borrowDate = borrowedTransaction.getIssueDate();
            String studentName = borrowedTransaction.getStudentName();

            for (StudentEntityModel student : this.students) {
                if (student.getName().equals(studentName)) {
                    studentId = student.getId();
                }
            }

            for (BookEntityModel book : this.books) {
                if (book.getTitle().equals(bookTitle)) {
                    bookAccnNumber = book.getAccnNumber();
                }
            }

            BorrowedBookTableInfo borrowedBookTableInfo = new BorrowedBookTableInfo(
                    studentId,
                    bookTitle,
                    studentName,
                    borrowDate,
                    bookAccnNumber
            );

            tableList.add(borrowedBookTableInfo);

            System.out.println(borrowedBookTableInfo.toString());
        }

        borrowedBookTable.setItems(tableList);
    }
}