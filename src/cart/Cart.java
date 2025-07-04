package src.cart;
import src.cart.CartItem;
import src.product.Product;
import java.util.ArrayList;
import java.util.List;


public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        cartItems.add(new CartItem(product, quantity));
    }

    // calculate cart total price
    public float calculateTotalPrice() {
        float total = 0;
        for (CartItem item : cartItems) {
            total += item.getTotalPrice();
        }
        return total;
    }
    public List<CartItem> getCartItems() { return cartItems; }
    public boolean isEmpty() { return cartItems.isEmpty(); }
    public void clearCart() { cartItems.clear(); }
}