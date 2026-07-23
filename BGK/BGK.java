import java.util.Scanner;

public class BGK {

    static Scanner bgk = new Scanner(System.in);

    static int count = 0;

    // Menu Arrays
    static String[] itemid = new String[100];
    static String[] itemname = new String[100];
    static int[] price = new int[100];

    // Order History
    static String[] orderItem = new String[100];
    static int[] orderQty = new int[100];
    static int[] orderTotal = new int[100];
    static int orderCount = 0;

    // Current Bill
    static String currentItem = "";
    static int currentQty = 0;
    static int currentTotal = 0;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n======== BGK RESTAURANT ========");
            System.out.println("1. Menu Management");
            System.out.println("2. Place Order");
            System.out.println("3. Generate Bill");
            System.out.println("4. Customer Order History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int n = bgk.nextInt();

            switch (n) {

                case 1:
                    Management();
                    break;

                case 2:
                    Order();
                    break;

                case 3:
                    generateBill();
                    break;

                case 4:
                    CustomerOrderHistory();
                    break;

                case 5:
                    System.out.println("Thank you! Visit Again.");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }

    //================ MENU MANAGEMENT ===================

    static void Management() {

        System.out.println("\n----- MENU MANAGEMENT -----");
        System.out.println("1. Add Menu Item");
        System.out.println("2. Update Menu Item");
        System.out.println("3. Delete Menu Item");
        System.out.println("4. View Menu");
        System.out.print("Enter your choice: ");

        int ch = bgk.nextInt();

        switch (ch) {

            case 1:
                addMenuItems();
                break;

            case 2:
                updateMenuItems();
                break;

            case 3:
                deleteMenuItems();
                break;

            case 4:
                viewMenuItems();
                break;

            default:
                System.out.println("Invalid Choice.");
        }
    }

    //================ ADD ===================

    static void addMenuItems() {

        System.out.print("Enter Item ID : ");
        itemid[count] = bgk.next();

        System.out.print("Enter Item Name : ");
        itemname[count] = bgk.next();

        System.out.print("Enter Price : ");
        price[count] = bgk.nextInt();

        count++;

        System.out.println("Menu Item Added Successfully.");
    }

    //================ UPDATE ===================

    static void updateMenuItems() {

        System.out.print("Enter Item ID to Update : ");
        String id = bgk.next();

        for (int i = 0; i < count; i++) {

            if (itemid[i].equals(id)) {

                System.out.print("Enter New Name : ");
                itemname[i] = bgk.next();

                System.out.print("Enter New Price : ");
                price[i] = bgk.nextInt();

                System.out.println("Item Updated Successfully.");
                return;
            }
        }

        System.out.println("Item Not Found.");
    }

    //================ DELETE ===================

    static void deleteMenuItems() {

        System.out.print("Enter Item ID to Delete : ");
        String id = bgk.next();

        for (int i = 0; i < count; i++) {

            if (itemid[i].equals(id)) {

                for (int j = i; j < count - 1; j++) {

                    itemid[j] = itemid[j + 1];
                    itemname[j] = itemname[j + 1];
                    price[j] = price[j + 1];
                }

                count--;

                System.out.println("Item Deleted Successfully.");
                return;
            }
        }

        System.out.println("Item Not Found.");
    }

    //================ VIEW ===================

    static void viewMenuItems() {

        if (count == 0) {
            System.out.println("Menu is Empty.");
            return;
        }

        System.out.println("\n----------- MENU -----------");

        for (int i = 0; i < count; i++) {

            System.out.println("Item ID   : " + itemid[i]);
            System.out.println("Item Name : " + itemname[i]);
            System.out.println("Price     : ₹" + price[i]);
            System.out.println("----------------------------");
        }
    }

    //================ ORDER ===================

    static void Order() {

        if (count == 0) {

            System.out.println("Menu is Empty.");
            return;
        }

        viewMenuItems();

        System.out.print("Enter Item ID : ");
        String id = bgk.next();

        for (int i = 0; i < count; i++) {

            if (itemid[i].equals(id)) {

                System.out.print("Enter Quantity : ");
                int qty = bgk.nextInt();

                int total = qty * price[i];

                currentItem = itemname[i];
                currentQty = qty;
                currentTotal = total;

                orderItem[orderCount] = itemname[i];
                orderQty[orderCount] = qty;
                orderTotal[orderCount] = total;
                orderCount++;

                System.out.println("Order Placed Successfully.");

                return;
            }
        }

        System.out.println("Item Not Found.");
    }

    //================ BILL ===================

    static void generateBill() {

        if (currentItem.equals("")) {

            System.out.println("No Order Placed.");
            return;
        }

        System.out.println("\n======= BGK RESTAURANT =======");
        System.out.println("Item     : " + currentItem);
        System.out.println("Quantity : " + currentQty);
        System.out.println("Total    : ₹" + currentTotal);
        System.out.println("==============================");
        System.out.println("Thank You! Visit Again.");
    }

    //================ HISTORY ===================

    static void CustomerOrderHistory() {

        if (orderCount == 0) {

            System.out.println("No Orders Yet.");
            return;
        }

        System.out.println("\n------- ORDER HISTORY -------");

        for (int i = 0; i < orderCount; i++) {

            System.out.println("Order " + (i + 1));
            System.out.println("Item     : " + orderItem[i]);
            System.out.println("Quantity : " + orderQty[i]);
            System.out.println("Total    : ₹" + orderTotal[i]);
            System.out.println("-----------------------------");
        }
    }
}
