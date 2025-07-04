package src;
import src.product.Product;
import src.customer.Customer;
import src.cart.Cart;


public class Main {
    public static void main(String[] args) {
        // products
        Product tv = new Product("TV", 1000.0f, 2, false, true, 10.0f, false);
        Product cheese = new Product("Cheese", 100.0f, 10, true, true, 0.2f, false);
        Product biscuits = new Product("Biscuits", 150.0f, 5, true, false, 0.1f, false);
        Product mobile = new Product("Mobile", 300.0f, 5, false, true, 0.5f, false);
        Product mobileScratchCard = new Product("Mobile Scratch Card", 50.0f, 10, false, false, 0.001f, true); 

        // Test 1: Successful Checkout
        System.out.println("Test 1: Successful Checkout");
        Customer customer1 = new Customer(2000.0f);
        Cart cart1 = new Cart();
        cart1.addItem(tv, 1);
        cart1.addItem(cheese, 2);
        cart1.addItem(biscuits, 1);
        customer1.checkout(cart1);
        System.out.println("\n-----------------------------\n");

        // Test 2: Cart is Empty
        System.out.println("Test 2: Cart is Empty");
        Customer customer2 = new Customer(1000.0f);
        Cart cart2 = new Cart();
        customer2.checkout(cart2);
        System.out.println("\n-----------------------------\n");

        // Test 3: Expired Product
        System.out.println("Test 3: Expired Product");
        Product expiredCheese = new Product("Cheese", 100.0f, 5, true, true, 0.2f, true); // Expired
        Customer customer3 = new Customer(1000.0f);
        Cart cart3 = new Cart();
        cart3.addItem(expiredCheese, 1);
        customer3.checkout(cart3);
        System.out.println("\n-----------------------------\n");

        // Test 4: Not Enough Stock
        System.out.println("Test 4: Not Enough Stock");
        Customer customer4 = new Customer(3000.0f);
        Cart cart4 = new Cart();
        cart4.addItem(tv, 3); // Only 2 in stock
        customer4.checkout(cart4);
        System.out.println("\n-----------------------------\n");

        // Test 5: Insufficient Balance
        System.out.println("Test 5: Insufficient Balance");
        Customer customer5 = new Customer(100.0f); // Not enough balance
        Cart cart5 = new Cart();
        cart5.addItem(mobile, 1);
        customer5.checkout(cart5);
        System.out.println("\n-----------------------------\n");

        // Test 6: Only Non-Shippable Item
        System.out.println("Test 6: Only Non-Shippable Items");
        Customer customer6 = new Customer(500.0f);
        Cart cart6 = new Cart();
        cart6.addItem(mobileScratchCard, 2);
        cart6.addItem(biscuits, 3);
        customer6.checkout(cart6);
        System.out.println("\n-----------------------------\n");

        // Test 7: Successful Checkout then failed Checkout
        System.out.println("Test 7: Successful Checkout then failed Checkout");
        Customer customer7 = new Customer(1700.0f);
        Cart cart7 = new Cart();
        cart7.addItem(tv, 1);
        cart7.addItem(mobileScratchCard, 2);
        customer7.checkout(cart7);
        System.out.println("-----------------------------");
        cart7.addItem(mobile, 5);
        cart7.addItem(cheese, 6);
        customer7.checkout(cart7);

        System.out.println("\nAll tests complete :)");
        System.out.println("Thanks Fawry team for this great task :)");
    }
}