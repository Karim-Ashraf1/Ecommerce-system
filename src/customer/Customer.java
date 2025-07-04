package src.customer;
import src.cart.Cart;
import src.cart.CartItem;
import src.product.Product;
import src.services.ShippingService;
import java.util.ArrayList;
import java.util.List;


public class Customer {
    private float balance;

    public Customer(float balance) {
        this.balance = balance;
    }

    public float getBalance() { return balance; }

    // deducting the paid amount from the balance
    private float deductBalance(float amount) { return this.balance -= amount; }

    // logger for more maintainable code
    public void logError(int logType) {
        switch (logType) {
            case 1: System.out.println("Error: Cart is empty."); break;
            case 2: System.out.println("Error: Product expired."); break;
            case 3: System.out.println("Error: Not enough stock for product."); break;
            case 4: System.out.println("Error: Insufficient balance."); break;
            default:System.out.println("Unknown error.");
        }
    }

    public void checkout(Cart cart) {
        if (cart.isEmpty()) { logError(1); return; }

        List<ShippingService> shippingList = new ArrayList<>();

        // check each cart item if it is valid or not and add shipping items to the shipping list
        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();

            if (product.isExpired()) { logError(2); return; }
            if (product.getQuantity() < item.getQuantity()) { logError(3); return; }
            if (product.requireShipping()) {
                for (int i = 0; i < item.getQuantity(); i++) 
                    shippingList.add(new ShippingService(product.getName(), product.getWeight()));
            }
        }

        // calculating total price and shipping fees
        int shippingTax = 10;
        float shippingFees = shippingList.size() * shippingTax;
        float paidAmount = cart.calculateTotalPrice() + shippingFees;

        if (paidAmount > balance) { logError(4); return; }

        // shipping the shipped items if exists
        if (!shippingList.isEmpty()) { 
            ShippingService.ship(shippingList); 
        }
        
        // deducting paid amount from the balance
        deductBalance(paidAmount);

        printReceipt(cart, shippingFees, paidAmount);

        cart.clearCart();
    }

    private void printReceipt(Cart cart, float shippingFees, float paidAmount) {  // the receipt layout is AI generated
        System.out.println("\n** Checkout receipt **");

        // printing each cart item with its quantity and total price
        for (CartItem item : cart.getCartItems()) {
            Product product = item.getProduct();
            System.out.printf("%-15s %4.0f\n", item.getQuantity() + "x " + product.getName(), item.getTotalPrice());
            product.reduceQuantity(item.getQuantity());
        }

        System.out.println("----------------------");
        System.out.printf("%-15s %4.0f\n", "Subtotal", cart.calculateTotalPrice());
        System.out.printf("%-15s %4.0f\n", "Shipping", shippingFees);
        System.out.printf("%-15s %4.0f\n", "Amount", paidAmount);
        System.out.printf("%-15s %4.0f\n", "Remaining", balance);
    }
}
