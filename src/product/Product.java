package src.product;


public class Product {
    private String name;
    private float price;
    private int quantity;
    private boolean isExpirable;
    private boolean isShippable;
    private float weight;
    private boolean isExpired;

    public Product(String name, float price, int quantity, boolean isExpirable, boolean isShippable, float weight, boolean isExpired) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.isExpirable = isExpirable;
        this.isShippable = isShippable;
        this.weight = weight;
        this.isExpired = isExpirable ? isExpired : false; // to prevent non-expirable products from being marked as expired
    }

    public String getName() { return name; }
    public float getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public boolean isExpirable() { return isExpirable; }
    public boolean requireShipping() { return isShippable; }
    public float getWeight() { return weight; }
    public boolean isExpired() { return isExpired; }

    public void reduceQuantity(int amount) {
        this.quantity -= amount;
    }
}
