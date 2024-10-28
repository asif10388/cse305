package csc305.courseregistration;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;

public class CourseRegistrationController
{
    @javafx.fxml.FXML
    private TextField studentIdInput;
    @javafx.fxml.FXML
    private RadioButton labRadioBtn;
    @javafx.fxml.FXML
    private ComboBox<String> searchSectionDropdown;
    @javafx.fxml.FXML
    private ComboBox<String> registerSectionDropdown;
    @javafx.fxml.FXML
    private Label regInfoTextArea;
    @javafx.fxml.FXML
    private RadioButton theoryRadioBtn;
    @javafx.fxml.FXML
    private ComboBox<String> courseDropdown;
    @javafx.fxml.FXML
    private ToggleGroup courseTypeToggleGroup;
    @javafx.fxml.FXML
    private Label sectionInfoTextArea;
    @javafx.fxml.FXML
    private CheckBox hasScholarshipCheckbox;

    private ArrayList<RegisteredCourseEntityModel> registeredCourses;
    private StudentEntityModel tempStudent;

    @javafx.fxml.FXML
    private Label noOfCreditsLabel;
    @javafx.fxml.FXML
    private TextField scholarshipRateInput;

    @javafx.fxml.FXML
    public void initialize() {
        this.registeredCourses = new ArrayList<>();
        this.registerSectionDropdown.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        this.searchSectionDropdown.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        this.courseDropdown.getItems().addAll("CSE101", "CSE101L", "CSE103", "CSE103L", "CSE105", "CSE105L");

        if(!hasScholarshipCheckbox.isSelected()){
            scholarshipRateInput.setDisable(true);
        }
    }

    @javafx.fxml.FXML
    public void onAddCourseToRegisterButtonClick(ActionEvent actionEvent) {
        int studentId = Integer.parseInt(studentIdInput.getText());
        String courseCode = courseDropdown.getValue();
        int courseCredits = Integer.parseInt(noOfCreditsLabel.getText());
        boolean hasScholarship = hasScholarshipCheckbox.isSelected();
        String scholarshipRate = scholarshipRateInput.getText();
        int courseSection = Integer.parseInt(registerSectionDropdown.getValue());



        if(hasScholarship){
            if(scholarshipRate.isEmpty()){
                System.out.println("Scholarship rate cannot be empty!");
                return;
            }
        }

        if(!hasScholarship){
            this.tempStudent = new StudentEntityModel(
                    studentId,
                    false,
                    0
            );
        }else{
            this.tempStudent = new StudentEntityModel(
                    studentId,
                    true,
                    Integer.parseInt(scholarshipRate)
            );
        }


        for (RegisteredCourseEntityModel registeredCourseEntityModel : this.registeredCourses) {
            if(registeredCourseEntityModel.getCourseCode().equals(courseCode)){
                System.out.println("Already registered course");
                return;
            }
        }

        RegisteredCourseEntityModel registeredCourse = new RegisteredCourseEntityModel(
                courseCode,
                courseCredits,
                courseSection
        );

        this.registeredCourses.add(registeredCourse);

        System.out.println("Registered course " + registeredCourse.toString());
    }

    @javafx.fxml.FXML
    public void onShowSelectecCourseTypeHavingSameSectionNumberButtonClick(ActionEvent actionEvent) {
        String resultString = "";
        int numOfSection = 0;
        int searchSection = Integer.parseInt(searchSectionDropdown.getValue());
        boolean isTheoryRadioSelected = theoryRadioBtn.isSelected();
        boolean isLabRadioSelected = labRadioBtn.isSelected();

        if(isTheoryRadioSelected){
            for (RegisteredCourseEntityModel registeredCourse : this.registeredCourses) {
                if(registeredCourse.getCourseSection() == searchSection && !registeredCourse.getCourseCode().endsWith("L")){
                    numOfSection++;
                }
            }

            resultString = "Number of theory courses having section is: " + searchSection+ Integer.toString(numOfSection) + " section(s)";
            sectionInfoTextArea.setText(resultString);
        }

        if(isLabRadioSelected){
            for (RegisteredCourseEntityModel registeredCourse : this.registeredCourses) {
                if(registeredCourse.getCourseSection() == searchSection && registeredCourse.getCourseCode().endsWith("L")){
                    numOfSection++;
                }
            }

            resultString = "Number of lab courses having section is: " + searchSection+ Integer.toString(numOfSection) + " section(s)";
            sectionInfoTextArea.setText(resultString);
        }


    }

    @javafx.fxml.FXML
    public void onProceedToRegisterButtonClick(ActionEvent actionEvent) {
        String resultString = "";

        for (RegisteredCourseEntityModel registeredCourseEntityModel : this.registeredCourses) {
            resultString += registeredCourseEntityModel.toString();
        }

        regInfoTextArea.setText(tempStudent.toString() + "\n" + resultString);
    }

    @javafx.fxml.FXML
    public void onSelectCourseButtonClick(ActionEvent actionEvent) {
        String courseCode = courseDropdown.getValue();

        System.out.println(courseCode);

        switch (courseCode) {
            case "CSE101":
                noOfCreditsLabel.setText("3");
                break;
            case "CSE101L":
                noOfCreditsLabel.setText("1");
                break;
            case "CSE103":
                noOfCreditsLabel.setText("3");
                break;
            case "CSE103L":
                noOfCreditsLabel.setText("1");
                break;
            case "CSE105":
                noOfCreditsLabel.setText("3");
                break;
            case "CSE105L":
                noOfCreditsLabel.setText("1");
                break;
            default:
                break;
        }
    }

    @javafx.fxml.FXML
    public void onHasScholarshipCheckbocSelect(ActionEvent actionEvent) {
        boolean hasScholarship = hasScholarshipCheckbox.isSelected();

        if(hasScholarship){
            scholarshipRateInput.setDisable(false);
        }else{
            scholarshipRateInput.setDisable(true);
        }
    }
}