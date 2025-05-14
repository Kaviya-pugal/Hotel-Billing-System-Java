import java.util.*;

class Item {
    int itemId;
    String name;
    double price;

    Item(int itemId, String name, double price) {
        this.itemId = itemId;
        this.name = name;
        this.price = price;
    }
}

class Order {
    Item item;
    int quantity;

    Order(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    double getTotal() {
        return item.price * quantity;
    }
}

public class HotelBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Menu Items
        ArrayList<Item> menu = new ArrayList<>();
        menu.add(new Item(1, "Idli", 30));
        menu.add(new Item(2, "Dosa", 40));
        menu.add(new Item(3, "Chapati", 25));
        menu.add(new Item(4, "Meals", 100));
        menu.add(new Item(5, "Coffee", 20));

        ArrayList<Order> orders = new ArrayList<>();

        System.out.println("------ Welcome to Java Hotel ------");

        while (true) {
            System.out.println("\n----- Menu -----");
            for (Item item : menu) {
                System.out.println(item.itemId + ". " + item.name + " - Rs." + item.price);
            }

            System.out.print("Enter item number to order (0 to finish): ");
            int choice = sc.nextInt();

            if (choice == 0) {
                break;
            }

            Item selectedItem = null;
            for (Item item : menu) {
                if (item.itemId == choice) {
                    selectedItem = item;
                    break;
                }
            }

            if (selectedItem != null) {
                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();
                orders.add(new Order(selectedItem, quantity));
                System.out.println(quantity + " " + selectedItem.name + "(s) added to your order.");
            } else {
                System.out.println("Invalid item number!");
            }
        }

        // Bill Summary
        System.out.println("\n------ Bill Summary ------");
        double grandTotal = 0;
        for (Order order : orders) {
            double total = order.getTotal();
            System.out.println(order.item.name + " x " + order.quantity + " = Rs." + total);
            grandTotal += total;
        }

        System.out.println("---------------------------");
        System.out.println("Total Amount: Rs." + grandTotal);
        System.out.println("Thank you! Visit again.");

        sc.close();
    }
}
