package csc305.mobileinventory;

import java.time.LocalDate;

public class MobileDevice {
    private String modelName;
    private String brandName;
    private String deviceType;
    private LocalDate releaseDate;
    private double manufacturingCost;
    private double sellingPrice;

    public MobileDevice(String modelName, String brandName, String deviceType, LocalDate releaseDate, double manufacturingCost, double sellingPrice) {
        this.modelName = modelName;
        this.brandName = brandName;
        this.deviceType = deviceType;
        this.releaseDate = releaseDate;
        this.manufacturingCost = manufacturingCost;
        this.sellingPrice = sellingPrice;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getManufacturingCost() {
        return manufacturingCost;
    }

    public void setManufacturingCost(double manufacturingCost) {
        this.manufacturingCost = manufacturingCost;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public String toString() {
        return "MobileDevice{" +
                "modelName='" + modelName + '\'' +
                ", brandName='" + brandName + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", releaseDate=" + releaseDate +
                ", manufacturingCost=" + manufacturingCost +
                ", sellingPrice=" + sellingPrice +
                '}';
    }
}
