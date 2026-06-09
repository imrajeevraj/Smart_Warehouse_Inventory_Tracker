// WarehouseInventoryTracker.java - Main Application Class
// ===================================
// CONTROL FLOW: This is the entry point of the application
// Uses Scanner for user input and InventoryManager for business logic
// Demonstrates separation of concerns - UI logic in main, business logic in manager


import java.util.Scanner;

public class WarehouseInventoryTracker {

    // ===== STATIC VARIABLES (Class Variables) =====
    // Static means these variables belong to the CLASS, not to individual objects
    // Scanner for reading user input
    private static Scanner scanner = new Scanner(System.in);

    // InventoryManager for managing products
    private static InventoryManager manager = new InventoryManager();

    // ===== MAIN METHOD =====
    // Entry point of the application
    // public static void main() is the standard signature for Java entry point
    public static void main(String[] args) {
        
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            
        }
        
        // Display welcome banner
        displayWelcome();

        // Variable to control menu loop
        boolean running = true;

        // CONTROL FLOW: Keep showing menu until user chooses to exit
        while (running) {
            displayMenu();
            int choice = getUserChoice();

            // SWITCH STATEMENT: Execute different code based on user choice
            switch (choice) {
                case 1:
                    handleAddProduct();
                    break;
                case 2:
                    manager.displayInventory();
                    break;
                case 3:
                    handleSearchProduct();
                    break;
                case 4:
                    handleSellProduct();
                    break;
                case 5:
                    handleRestockProduct();
                    break;
                case 6:
                    handleRemoveProduct();
                    break;
                case 7:
                    manager.checkLowStock();
                    break;
                case 8:
                    manager.displayDashboard();
                    break;
                case 9:
                    handleSortProducts();
                    break;
                case 10:
                    manager.exportReport();
                    break;
                case 11:
                    System.out.println("\n[SUCCESS] Thank you for using Smart Warehouse Inventory Tracker!");
                    System.out.println("[EXIT] Goodbye!\n");
                    running = false;  // Exit the loop
                    break;
                default:
                    System.out.println("[ERROR] Invalid choice! Please try again.\n");
            }
        }

        // Close scanner to prevent resource leak
        scanner.close();
    }

    // ===== DISPLAY METHODS =====

    // Display welcome banner
    private static void displayWelcome() {
        System.out.println("\n" + "=".repeat(70));
        System.out.println("     SMART WAREHOUSE INVENTORY TRACKER - JAVA PROJECT");
        System.out.println("=".repeat(70) + "\n");
    }

    // Display main menu with professional formatting (Feature 12)
    private static void displayMenu() {
        System.out.println("=".repeat(70));
        System.out.println("                  MAIN MENU - SELECT AN OPTION");
        System.out.println("=".repeat(70));
        System.out.println("1.  Add Product");
        System.out.println("2.  Display Inventory");
        System.out.println("3.  Search Product");
        System.out.println("4.  Sell Product");
        System.out.println("5.  Restock Product");
        System.out.println("6.  Remove Product");
        System.out.println("7.  Low Stock Alert");
        System.out.println("8.  Dashboard");
        System.out.println("9.  Sort Products");
        System.out.println("10. Export Report");
        System.out.println("11. Exit");
        System.out.println("=".repeat(70));
        System.out.print("Enter your choice (1-11): ");
    }

    // ===== INPUT HANDLING METHODS =====

    // Get choice from user with error handling
    private static int getUserChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();  // Clear the newline character from buffer
            return choice;
        } catch (Exception e) {
            scanner.nextLine();  // Clear invalid input
            return -1;  // Return invalid choice
        }
    }

    // Get positive integer from user with validation
    // Returns -1 if invalid input
    private static int getPositiveInteger() {
        try {
            int value = scanner.nextInt();
            scanner.nextLine();  // Clear newline

            // VALIDATION: Check if positive
            if (value < 0) {
                System.out.println("[ERROR] Please enter a positive number!");
                return -1;
            }

            return value;
        } catch (Exception e) {
            scanner.nextLine();  // Clear invalid input
            System.out.println("[ERROR] Invalid input! Please enter a number.");
            return -1;
        }
    }

    // Get positive double (price) from user with validation
    private static double getPositiveDouble() {
        try {
            double value = scanner.nextDouble();
            scanner.nextLine();  // Clear newline

            if (value < 0) {
                System.out.println("[ERROR] Please enter a positive number!");
                return -1;
            }

            return value;
        } catch (Exception e) {
            scanner.nextLine();
            System.out.println("[ERROR] Invalid input! Please enter a number.");
            return -1;
        }
    }

    // ===== HANDLER METHODS =====
    // Each handler manages user interaction for a specific operation

    // Handler 1: Add new product (Feature 4 - Add Price)
    private static void handleAddProduct() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 ADD NEW PRODUCT");
        System.out.println("=".repeat(50));

        // Get product name
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        // VALIDATION: Check if name is empty (Feature 13)
        if (productName == null || productName.trim().isEmpty()) {
            System.out.println("[ERROR] Product name cannot be empty!");
            return;
        }

        // Get quantity
        System.out.print("Enter quantity: ");
        int quantity = getPositiveInteger();
        if (quantity < 0) return;

        // Get threshold
        System.out.print("Enter low stock threshold: ");
        int threshold = getPositiveInteger();
        if (threshold < 0) return;

        // Get price (Feature 4)
        System.out.print("Enter price per unit (Rs.): ");
        double price = getPositiveDouble();
        if (price < 0) return;

        // Call manager to add product
        manager.addProduct(productName, quantity, threshold, price);
        System.out.println("=".repeat(50) + "\n");
    }

    // Handler 2: Search product (Feature 3)
    private static void handleSearchProduct() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 SEARCH PRODUCT");
        System.out.println("=".repeat(50));
        System.out.println("Search by Product ID (e.g., P101) or Product Name");

        System.out.print("Enter Product ID or Name: ");
        String identifier = scanner.nextLine();

        manager.searchProduct(identifier);
    }

    // Handler 3: Sell product
    private static void handleSellProduct() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 SELL PRODUCT");
        System.out.println("=".repeat(50));

        // Get product identifier
        System.out.print("Enter Product ID or Name to sell: ");
        String identifier = scanner.nextLine();

        // Get quantity to sell
        System.out.print("Enter quantity to sell: ");
        int quantity = getPositiveInteger();
        if (quantity < 0) return;

        // Call manager to sell
        manager.sellProduct(identifier, quantity);
        System.out.println("=".repeat(50) + "\n");
    }

    // Handler 4: Restock product
    private static void handleRestockProduct() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 RESTOCK PRODUCT");
        System.out.println("=".repeat(50));

        // Get product identifier
        System.out.print("Enter Product ID or Name to restock: ");
        String identifier = scanner.nextLine();

        // Get quantity to add
        System.out.print("Enter quantity to add: ");
        int quantity = getPositiveInteger();
        if (quantity < 0) return;

        // Call manager to restock
        manager.restockProduct(identifier, quantity);
        System.out.println("=".repeat(50) + "\n");
    }

    // Handler 5: Remove product
    private static void handleRemoveProduct() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 REMOVE PRODUCT");
        System.out.println("=".repeat(50));

        // Get product identifier
        System.out.print("Enter Product ID or Name to remove: ");
        String identifier = scanner.nextLine();

        // Call manager to remove
        manager.removeProduct(identifier);
        System.out.println("=".repeat(50) + "\n");
    }

    // Handler 6: Sort products (Feature 10)
    private static void handleSortProducts() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("                 SORT PRODUCTS");
        System.out.println("=".repeat(50));
        System.out.println("1. Sort by Name (A-Z)");
        System.out.println("2. Sort by Quantity (Low to High)");
        System.out.println("3. Sort by Status (Critical → Healthy)");
        System.out.println("=".repeat(50));
        System.out.print("Enter your choice (1-3): ");

        int choice = getUserChoice();

        System.out.println();
        
        // SWITCH STATEMENT: Handle different sorting options
        switch (choice) {
            case 1:
                manager.sortByName();
                break;
            case 2:
                manager.sortByQuantity();
                break;
            case 3:
                manager.sortByStatus();
                break;
            default:
                System.out.println("[ERROR] Invalid choice!\n");
        }
    }
}
