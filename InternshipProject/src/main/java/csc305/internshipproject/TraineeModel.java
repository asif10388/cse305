package csc305.internshipproject;

import java.util.ArrayList;

public class TraineeModel {
    private int id;
    private ArrayList<String> trainingTitles;

    public TraineeModel(int id, ArrayList<String> trainingTitles) {
        this.id = id;
        this.trainingTitles = trainingTitles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getTrainingTitles() {
        return trainingTitles;
    }

    public void setTrainingTitles(ArrayList<String> trainingTitles) {
        this.trainingTitles = trainingTitles;
    }

    @Override
    public String toString() {
        return "Trainee{" +
                "id=" + id +
                ", trainingTitles=" + trainingTitles +
                '}';
    }
}
