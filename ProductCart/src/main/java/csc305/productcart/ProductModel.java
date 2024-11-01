package csc305.productcart;

import java.time.LocalDate;

public class ProductModel {
    private int productID;
    private String productName;
    private int productQuantity;
    private String productMaterial;
    private LocalDate productDeliveryDate;

    public ProductModel(int productID, String productName, int productQuantity, String productMaterial, LocalDate productDeliveryDate) {
        this.productID = productID;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productMaterial = productMaterial;
        this.productDeliveryDate = productDeliveryDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductMaterial() {
        return productMaterial;
    }

    public void setProductMaterial(String productMaterial) {
        this.productMaterial = productMaterial;
    }

    public LocalDate getProductDeliveryDate() {
        return productDeliveryDate;
    }

    public void setProductDeliveryDate(LocalDate productDeliveryDate) {
        this.productDeliveryDate = productDeliveryDate;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productMaterial='" + productMaterial + '\'' +
                ", productDeliveryDate=" + productDeliveryDate +
                '}';
    }
}
