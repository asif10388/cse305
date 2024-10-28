package csc305.shoppingcart;

public class CartItemModel {
    private String productName;
    private double price;
    private int quantity;
    private int vatRate;

    public CartItemModel(String productName, double price, int quantity, int vatRate) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.vatRate = vatRate;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    @Override
    public String toString() {
        return "CartItemModel{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", vatRate=" + vatRate +
                '}';
    }
}
