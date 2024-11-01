package csc305.internshipproject;

public class InternModel {
    private int id;
    String internName;
    private String uniName;
    private String paymentStatus;

    public InternModel(int id, String internName, String uniName, String paymentStatus) {
        this.id = id;
        this.internName = internName;
        this.uniName = uniName;
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInternName() {
        return internName;
    }

    public void setInternName(String internName) {
        this.internName = internName;
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

    @Override
    public String toString() {
        return "Intern{" +
                "id=" + id +
                ", internName='" + internName + '\'' +
                ", uniName='" + uniName + '\'' +
                ", paymentStatus='" + paymentStatus + '\'' +
                '}';
    }
}
