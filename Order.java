// Dosya: Order.java
package food.app;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Categories> items;
    private double totalPrice;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addItem(Categories item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public boolean checkout() {
        if (customer.getBalance() >= totalPrice) {
            customer.setBalance(customer.getBalance() - totalPrice);
            System.out.println("Order successful! Amount paid: $" + totalPrice);
            return true;
        } else {
            System.out.println("Insufficient funds! Order invalid.");
            return false;
        }
    }

    public void printOrder() {
        System.out.println("Order summary:");
        for (Categories item : items) {
            System.out.println("- " + item.getName() + " : $" + item.getPrice());
        }
        System.out.println("Total: $" + totalPrice);
    }
}
