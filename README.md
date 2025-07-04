# E-commerce System

## Project Overview

This is a Java-based e-commerce system that simulates online shopping functionality. The system handles product management, shopping cart operations, customer checkout, and shipping services. It demonstrates object-oriented programming principles with a clean separation of concerns across different packages.

## Features

- **Product Management**: Support for different product types (Expirable/non-Expirable, shippable/non-shippable)
- **Shopping Cart**: Add items to cart with quantity validation
- **Customer Management**: Customer balance tracking and transaction processing
- **Checkout System**: Complete checkout process with receipt generation
- **Shipping Service**: Automated shipping calculations and shipment notices for shippable items
- **Error Handling**: Comprehensive validation for stock, expiration, and balance checks

## Project Structure

```
src/
│── cart/
│   ├── Cart.java             # Shopping cart management
│   └── CartItem.java         # Individual cart item representation
├── customer/
│   └── Customer.java         # Customer entity and checkout logic
├── main/
│   └── Main.java          # Entry point with test cases
├── product/
│   └── Product.java          # Product entity with attributes and methods
└── services/
    └── ShippingService.java  # Shipping functionality and receipt printing
```

## How to Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line interface (Terminal/Command Prompt)

### Compilation and Execution

1. **Navigate to the project root directory:**

   ```bash
   cd path/to/Ecommerce-system
   ```

2. **Compile all Java files:**

   ```bash
   javac -d out src/**/*.java
   ```

3. **Run the application:**
   ```bash
   java -cp out src.Main
   ```

## Expected Output

When you run the application, you should see output similar to:

```
Test 1: Successful Checkout
** Shipment notice **
1x TV         10000g
2x Cheese       200g
Total package weight 10.4kg

** Checkout receipt **
1x TV           1000
2x Cheese        200
1x Biscuits      150
----------------------
Subtotal        1350
Shipping          30
Amount          1380
Remaining        620

-----------------------------

Test 2: Cart is Empty
Error: Cart is empty.

-----------------------------

Test 3: Expired Product
Error: Product expired.

-----------------------------

Test 4: Not Enough Stock
Error: Not enough stock for product.

-----------------------------

Test 5: Insufficient Balance
Error: Insufficient balance.

-----------------------------

Test 6: Only Non-Shippable Items
Error: Insufficient balance.

-----------------------------

Test 7: Successful Checkout then failed Checkout
** Shipment notice **
1x TV         10000g
Total package weight 10.0kg

** Checkout receipt **
1x TV           1000
2x Mobile Scratch Card  100
----------------------
Subtotal        1100
Shipping          10
Amount          1110
Remaining        590
-----------------------------
Error: Insufficient balance.

All tests complete :)
Thanks Fawry team for this great task :)
```

_This project demonstrates fundamental e-commerce functionality using core Java concepts and object-oriented programming principles._
