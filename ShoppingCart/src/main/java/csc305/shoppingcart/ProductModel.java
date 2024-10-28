package csc305.shoppingcart;

public class ProductModel {
    private String productName;
    private double price;
    private int vatRate;

    public ProductModel(String productName, double price, int vatRate) {
        this.productName = productName;
        this.vatRate = vatRate;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", vatRate=" + vatRate +
                '}';
    }
}
