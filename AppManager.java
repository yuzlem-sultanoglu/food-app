package food.app;

import java.util.Scanner;

public class AppManager {

    private Customer customer;
    private Menu menu;
    private Order order;

    public AppManager() {
        customer = new Customer("Lily", 25);
        menu = new Menu();
        order = new Order(customer);

        menu.addFood(new Food("Pizza", 17));
        menu.addFood(new Food("Cheese Burger", 15));
        menu.addFood(new Food("Spaghetti", 12));
        menu.addFood(new Food("Hot Wings", 7));
        menu.addFood(new Food("Friet", 5));

        menu.addDesert(new Desert("Apple Pie",10));
        menu.addDesert(new Desert("Cheesecake",12));
        menu.addDesert(new Desert("Chocolade Mousse",9));
        menu.addDesert(new Desert("Waffels",10));
        menu.addDesert(new Desert("Ice Cream", 5));

        menu.addDrink(new Drink("Coffee",5));
        menu.addDrink(new Drink("Tea",3));
        menu.addDrink(new Drink("Milkshake",12));
        menu.addDrink(new Drink("Ice Coffee",6));
        menu.addDrink(new Drink("Water", 2));
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n== FOOD APP ==");
            System.out.println("1. Show Menu");
            System.out.println("2. Place an order");
            System.out.println("3. Balance Top Up");
            System.out.println("4. Complete the Order");
            System.out.println("5. Exit");
            System.out.print("Choice : ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    menu.printMenu();
                    break;
                case 2:
                    menu.printMenu();
                    System.out.print("Enter product number: ");
                    int productNumber = scanner.nextInt();
                    scanner.nextLine(); // buffer temizle
                    Categories item = menu.getItemByNumber(productNumber);
                    if (item != null) {
                        order.addItem(item);
                        System.out.println(item.getName() + " added.");
                    } else {
                        System.out.println("Invalid product number.");
                    }
                    break;
                case 3:
                    System.out.print("Amount to top up: ");
                    double amount = scanner.nextDouble();
                    customer.topUpBalance(amount);
                    break;
                case 4:
                    order.printOrder();
                    order.checkout();
                    order = new Order(customer);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }

    // Main sadece çalıştırıcı
    public static void main(String[] args) {
        AppManager app = new AppManager();
        app.run(); // Uygulamayı başlat
    }
}
