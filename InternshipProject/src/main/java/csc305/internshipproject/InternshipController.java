package csc305.internshipproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Optional;

public class InternshipController
{
    @javafx.fxml.FXML
    private Label traineeCountResultLabel;
    @javafx.fxml.FXML
    private CheckBox communicationSkillCheckbox;
    @javafx.fxml.FXML
    private TableColumn<TraineeTableInfoModel, String> traineePaymentStatusColumn;
    @javafx.fxml.FXML
    private TableColumn<TraineeTableInfoModel, Integer> traineeIDColumn;
    @javafx.fxml.FXML
    private ComboBox<String> selectPaymentStatusCombobox;
    @javafx.fxml.FXML
    private Label paymentStatusLabel;
    @javafx.fxml.FXML
    private ComboBox<String> internIDCombobox;
    @javafx.fxml.FXML
    private TableView<TraineeTableInfoModel> traineeInfoTable;
    @javafx.fxml.FXML
    private TableColumn<TraineeTableInfoModel, String> trainingSelectedForColumn;
    @javafx.fxml.FXML
    private CheckBox springBootCheckBox;
    @javafx.fxml.FXML
    private TableColumn<TraineeTableInfoModel, Integer> numberOfTrainingColumn;
    @javafx.fxml.FXML
    private Label internNameLabel;
    @javafx.fxml.FXML
    private TableColumn<TraineeTableInfoModel, String> traineeUniNameColumn;
    @javafx.fxml.FXML
    private ComboBox<String> selectUniveristySearchCombobox;
    @javafx.fxml.FXML
    private CheckBox cudaCheckbox;
    @javafx.fxml.FXML
    private Label universityNameLabel;
    @javafx.fxml.FXML
    private CheckBox blockChainCheckbox;

    private ArrayList<InternModel> internArr;
    private ArrayList<TraineeModel> traineeList;

    @javafx.fxml.FXML
    public void initialize() {
        internArr = new ArrayList<>();
        traineeList = new ArrayList<>();

        traineeIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        traineeUniNameColumn.setCellValueFactory(new PropertyValueFactory<>("uniName"));
        traineePaymentStatusColumn.setCellValueFactory(new PropertyValueFactory<>("paymentStatus"));
        numberOfTrainingColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfTrainings"));
        trainingSelectedForColumn.setCellValueFactory(new PropertyValueFactory<>("trainingTitles"));

        InternModel intern1 = new InternModel(
                12345,
                "Alex",
                "IUB",
                "Paid"
        );

        InternModel intern2 = new InternModel(
                12346,
                "Jones",
                "NSU",
                "Unpaid"
        );

        InternModel intern3 = new InternModel(
                12347,
                "Darky",
                "AIUB",
                "Paid"
        );

        InternModel intern4 = new InternModel(
                12348,
                "Petra",
                "IUB",
                "Unpaid"
        );

        InternModel intern5 = new InternModel(
                12349,
                "Cleveland",
                "IUB",
                "Paid"
        );

        InternModel intern6 = new InternModel(
                12350,
                "Beijing",
                "BRAC",
                "Paid"
        );

        InternModel intern7 = new InternModel(
                12355,
                "Brenda",
                "UIU",
                "Unpaid"
        );

        InternModel intern8 = new InternModel(
                12356,
                "Nicholas",
                "BUBT",
                "Unpaid"
        );
        InternModel intern9 = new InternModel(
                12357,
                "Carlos",
                "IUB",
                "Paid"
        );

        InternModel intern10 = new InternModel(
                12358,
                "Thomas",
                "NSU",
                "Paid"
        );

        internArr.add(intern1);
        internArr.add(intern2);
        internArr.add(intern3);
        internArr.add(intern4);
        internArr.add(intern5);
        internArr.add(intern6);
        internArr.add(intern7);
        internArr.add(intern8);
        internArr.add(intern9);
        internArr.add(intern10);

        for(InternModel intern : internArr) {
            internIDCombobox.getItems().add(String.valueOf(intern.getId()));
        }

        selectUniveristySearchCombobox.getItems().addAll("NSU", "Brac", "IUB", "AIUB", "BUBT", "UIU");
        selectPaymentStatusCombobox.getItems().addAll("Paid", "Unpaid");

    }

    @javafx.fxml.FXML
    public void onAddTraineeInstanceButtonClick(ActionEvent actionEvent) {
        int interID = Integer.parseInt(internIDCombobox.getValue());

        ArrayList<String> tempCheckboxArray = new ArrayList<>();

        if(springBootCheckBox.isSelected()) {
            tempCheckboxArray.add("Spring Boot");
        }

        if(communicationSkillCheckbox.isSelected()) {
            tempCheckboxArray.add("Communication Skill");
        }

        if(blockChainCheckbox.isSelected()) {
            tempCheckboxArray.add("Block Chain");
        }

        if(cudaCheckbox.isSelected()) {
            tempCheckboxArray.add("Cuda Multicore Programming");
        }

        TraineeModel trainee = new TraineeModel(
                interID,
                tempCheckboxArray
        );

        traineeList.add(trainee);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText(trainee.toString());
        alert.showAndWait();
    }

    @javafx.fxml.FXML
    public void onShowTraineeCountButtonClick(ActionEvent actionEvent) {
        int selectedForTraining = 0;
        String uniName = selectUniveristySearchCombobox.getValue();
        String paymentStatus = selectPaymentStatusCombobox.getValue();

        for(TraineeModel traineeModel : traineeList) {
            for(InternModel internModel : internArr) {
                if(internModel.getId() == traineeModel.getId()) {
                    if(internModel.getUniName().equals(uniName) && internModel.getPaymentStatus().equals(paymentStatus)) {
                        selectedForTraining++;
                    }
                }
            }
        }

        traineeCountResultLabel.setText("No of " + paymentStatus + " interns from " + uniName + " selected for training is: " +String.valueOf(selectedForTraining));
    }

    @javafx.fxml.FXML
    public void onShowTrainingInfoButtonClick(ActionEvent actionEvent) {
        ObservableList<TraineeTableInfoModel> observableList = FXCollections.observableArrayList();

        System.out.println(traineeList);

        for(TraineeModel traineeModel: traineeList) {
            int interID = traineeModel.getId();
            String uniName = "";
            String paymentStatus = "";
            int noOfTrainings = traineeModel.getTrainingTitles().size();
            String trainingTitles = traineeModel.getTrainingTitles().toString();

            System.out.println(interID);

            for(InternModel internModel: internArr) {
                if(internModel.getId() == interID) {
                    uniName = internModel.getUniName();
                    paymentStatus = internModel.getPaymentStatus();
                }
            }

            TraineeTableInfoModel trainee = new TraineeTableInfoModel(
                    interID,
                    uniName,
                    paymentStatus,
                    trainingTitles,
                    noOfTrainings
            );

            System.out.println(trainee.toString());
            observableList.add(trainee);
        }

        traineeInfoTable.setItems(observableList);
    }

    @javafx.fxml.FXML
    public void onSelectInternID(ActionEvent actionEvent) {
        int internID = Integer.parseInt(internIDCombobox.getValue());

        for (InternModel intern : internArr) {
            if (intern.getId() == internID) {
                internNameLabel.setText(intern.getInternName());
                universityNameLabel.setText(intern.getUniName());
                paymentStatusLabel.setText(intern.getPaymentStatus());
            }
        }
    }
}