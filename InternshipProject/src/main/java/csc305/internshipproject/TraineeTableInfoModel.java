package csc305.internshipproject;

public class TraineeTableInfoModel {
    private int id;
    private String uniName;
    private String paymentStatus;
    private String trainingTitles;
    private int numberOfTrainings;

    public TraineeTableInfoModel(int id, String uniName, String paymentStatus, String trainingTitles, int numberOfTrainings) {
        this.id = id;
        this.uniName = uniName;
        this.paymentStatus = paymentStatus;
        this.trainingTitles = trainingTitles;
        this.numberOfTrainings = numberOfTrainings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTrainingTitles() {
        return trainingTitles;
    }

    public void setTrainingTitles(String trainingTitles) {
        this.trainingTitles = trainingTitles;
    }

    public int getNumberOfTrainings() {
        return numberOfTrainings;
    }

    public void setNumberOfTrainings(int numberOfTrainings) {
        this.numberOfTrainings = numberOfTrainings;
    }

    @Override
    public String toString() {
        return "TraineeTableInfoModel{" +
                "id=" + id +
                ", uniName='" + uniName + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", trainingTitles='" + trainingTitles + '\'' +
                ", numberOfTrainings=" + numberOfTrainings +
                '}';
    }
}
