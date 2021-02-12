import java.util.ArrayList;
import java.util.List;

public  class Products  {

    private double price;

    private String productID;

    public int quantity;

    public Products(double price, String productID, int quantity) {
        this.price = price;
        this.productID = productID;
        this.quantity = quantity;
    }

    public Products() {

    }

    public double getPrice() {
        return price;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public Products(double price, String productID) {
        this.price = price;
        this.productID = productID;
    }


}