// InventoryManager.java - Manager Class
// ===================================
// COLLECTION MANAGEMENT: This class manages ALL products in the inventory
// Uses ArrayList to store multiple Product objects dynamically
// ArrayList is like a dynamic array - size grows automatically as needed

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InventoryManager {
    // ===== ATTRIBUTE =====
    // ArrayList to store Product objects
    // POLYMORPHISM: ArrayList can hold any type that extends Object
    private ArrayList<Product> products;
    
    // Track next product ID
    private int nextProductIdNumber = 101;

    // ===== CONSTRUCTOR =====
    public InventoryManager() {
        this.products = new ArrayList<Product>();
        System.out.println("[SUCCESS] Inventory Manager initialized!");
    }

    // ===== PRODUCT MANAGEMENT METHODS =====

    // Method 1: Add a new product to inventory (Feature 1 - Auto ID generation)
    public void addProduct(String productName, int quantity, int threshold, double price) {
        // VALIDATION: Check if product name is empty
        if (productName == null || productName.trim().isEmpty()) {
            System.out.println("[ERROR] Product name cannot be empty!");
            return;
        }

        // VALIDATION: Check if product already exists
        if (findProductByName(productName) != null) {
            System.out.println("[ERROR] Product already exists!");
            return;
        }

        // VALIDATION: Check negative values
        if (quantity < 0 || threshold < 0 || price < 0) {
            System.out.println("[ERROR] Quantity, threshold, and price cannot be negative!");
            return;
        }

        // Generate unique Product ID (P101, P102, etc.)
        String productId = "P" + nextProductIdNumber;
        nextProductIdNumber++;

        // ENCAPSULATION: Create new Product object with all parameters
        Product newProduct = new Product(productId, productName, quantity, threshold, price);

        // Add to ArrayList
        this.products.add(newProduct);
        System.out.println("[SUCCESS] Product added successfully!");
        System.out.println("   ID: " + productId + " | Name: " + productName);
    }

    // Method 2: Display all products in inventory (Feature 8 - Emojis added)
    public void displayInventory() {
        // Check if inventory is empty
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty!");
            return;
        }

        System.out.println("\n" + "=".repeat(90));
        System.out.println("                        WAREHOUSE INVENTORY");
        System.out.println("=".repeat(90));
        System.out.println(String.format("%-5s | %-15s | %6s | %12s | %12s | %s",
            "ID", "Product", "Qty", "Price (Rs.)", "Value (Rs.)", "Status"));
        System.out.println("=".repeat(90));

        // ITERATION: Loop through all products using enhanced for loop
        for (Product product : this.products) {
            System.out.println(product);
        }

        System.out.println("=".repeat(90));
        System.out.println("Total Products: " + this.products.size());
        System.out.println("=".repeat(90) + "\n");
    }

    // Method 3: Sell product (Feature 6 - Track sales)
    public void sellProduct(String identifier, int quantitySold) {
        // VALIDATION: Check input
        if (quantitySold < 0) {
            System.out.println("[ERROR] Invalid quantity.");
            return;
        }

        // Search by ID or Name (Feature 3)
        Product product = findProductByIdOrName(identifier);

        if (product == null) {
            System.out.println("[ERROR] Product not found!");
            return;
        }

        // Check if we have enough stock
        if (product.getQuantity() < quantitySold) {
            System.out.println("[ERROR] Insufficient stock! Available: " + product.getQuantity());
            return;
        }

        // Reduce quantity
        int newQuantity = product.getQuantity() - quantitySold;
        product.setQuantity(newQuantity);
        
        // FEATURE 6: Record the sale
        product.recordSale(quantitySold);
        
        System.out.println("[SUCCESS] Sold " + quantitySold + " units of " + product.getProductName());
    }

    // Method 4: Restock product
    public void restockProduct(String identifier, int quantityToAdd) {
        // VALIDATION: Check input
        if (quantityToAdd < 0) {
            System.out.println("[ERROR] Invalid quantity.");
            return;
        }

        // Search by ID or Name
        Product product = findProductByIdOrName(identifier);

        if (product == null) {
            System.out.println("[ERROR] Product not found!");
            return;
        }

        // Increase quantity
        int newQuantity = product.getQuantity() + quantityToAdd;
        product.setQuantity(newQuantity);
        System.out.println("[SUCCESS] Restocked " + quantityToAdd + " units of " + product.getProductName());
    }

    // Method 5: Remove product from inventory
    public void removeProduct(String identifier) {
        // Search by ID or Name
        Product product = findProductByIdOrName(identifier);

        if (product == null) {
            System.out.println("[ERROR] Product not found!");
            return;
        }

        this.products.remove(product);
        System.out.println("[SUCCESS] Product removed: " + product.getProductName());
    }

    // ===== FEATURE 2: INVENTORY DASHBOARD =====
    public void displayDashboard() {
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty!");
            return;
        }

        // Calculate statistics
        int totalUnits = 0;
        int lowStockCount = 0;
        int outOfStockCount = 0;
        double totalValue = 0;

        for (Product product : this.products) {
            totalUnits += product.getQuantity();
            totalValue += product.getInventoryValue();
            
            if (product.getQuantity() == 0) {
                outOfStockCount++;
            } else if (product.isLowStock()) {
                lowStockCount++;
            }
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("                  INVENTORY DASHBOARD");
        System.out.println("=".repeat(50));
        System.out.println(String.format("Total Products       : %d", this.products.size()));
        System.out.println(String.format("Total Units          : %d", totalUnits));
        System.out.println(String.format("Low Stock Items      : %d", lowStockCount));
        System.out.println(String.format("Out of Stock Items   : %d", outOfStockCount));
        System.out.println(String.format("Total Inventory Value: Rs.%.2f", totalValue));
        System.out.println("=".repeat(50));
        
        // FEATURE 7: Top Selling Product
        displayTopSellingProduct();
        System.out.println("=".repeat(50) + "\n");
    }

    // ===== FEATURE 3: PRODUCT SEARCH =====
    public void searchProduct(String identifier) {
        // Search by ID or Name
        Product product = findProductByIdOrName(identifier);

        if (product == null) {
            System.out.println("[ERROR] Product not found!");
            return;
        }

        System.out.println("\n" + "=".repeat(60));
        System.out.println("                    [SUCCESS] PRODUCT FOUND");
        System.out.println("=".repeat(60));
        System.out.println("ID                : " + product.getProductId());
        System.out.println("Name              : " + product.getProductName());
        System.out.println("Quantity          : " + product.getQuantity());
        System.out.println("Price (per unit)  : Rs." + product.getPrice());
        System.out.println("Total Value       : Rs." + product.getInventoryValue());
        System.out.println("Status            : " + product.getStockStatus());
        System.out.println("Units Sold        : " + product.getTotalSold());
        System.out.println("=".repeat(60) + "\n");
    }

    // ===== FEATURE 7: TOP SELLING PRODUCT =====
    private void displayTopSellingProduct() {
        if (this.products.isEmpty()) {
            return;
        }

        // Find product with maximum sales using Comparator
        Product topProduct = null;
        int maxSold = 0;

        for (Product product : this.products) {
            if (product.getTotalSold() > maxSold) {
                maxSold = product.getTotalSold();
                topProduct = product;
            }
        }

        System.out.println("\nTOP SELLING PRODUCT:");
        if (topProduct != null && maxSold > 0) {
            System.out.println("   Product: " + topProduct.getProductName());
            System.out.println("   Units Sold: " + maxSold);
        } else {
            System.out.println("   No sales recorded yet.");
        }
    }

    // ===== FEATURE 8: LOW STOCK ALERT CHECK =====
    public void checkLowStock() {
        // Check if inventory is empty
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty!");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("                      LOW STOCK ALERT CHECK");
        System.out.println("=".repeat(80));

        int lowStockCount = 0;

        // Loop through all products
        for (Product product : this.products) {
            if (product.isLowStock()) {
                System.out.println("[ALERT] " + product.getProductId() + " | " + 
                                 product.getProductName() +
                                 " | Current: " + product.getQuantity() +
                                 " | Minimum: " + product.getThreshold());
                
                // FEATURE 9: Show reorder suggestion
                int suggestion = product.getReorderSuggestion();
                System.out.println("   -> Suggested Restock: " + suggestion + " units");
                lowStockCount++;
            }
        }

        if (lowStockCount == 0) {
            System.out.println("[SUCCESS] All products have healthy stock levels!");
        } else {
            System.out.println("\nTotal low-stock items: " + lowStockCount);
        }

        System.out.println("=".repeat(80) + "\n");
    }

    // ===== FEATURE 9: SMART REORDER SUGGESTIONS =====
    public void displayReorderSuggestions() {
        if (this.products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        System.out.println("\n" + "=".repeat(80));
        System.out.println("                   SMART REORDER SUGGESTIONS");
        System.out.println("=".repeat(80));
        System.out.println(String.format("%-5s %-20s Current Stock  Suggested Restock  Status",
            "ID", "Product"));
        System.out.println("=".repeat(80));

        boolean hasLowStock = false;
        for (Product product : this.products) {
            if (product.isLowStock() || product.getQuantity() == 0) {
                int suggestion = product.getReorderSuggestion();
                System.out.println(String.format("%-5s %-20s %-14d %-17d %s",
                    product.getProductId(), product.getProductName(),
                    product.getQuantity(), suggestion, product.getStockStatus()));
                hasLowStock = true;
            }
        }

        if (!hasLowStock) {
            System.out.println("No reordering needed - all products have healthy stock!");
        }

        System.out.println("=".repeat(80) + "\n");
    }

    // ===== FEATURE 10: SORTING PRODUCTS =====
    
    // Sort by Name (A-Z)
    public void sortByName() {
        if (this.products.isEmpty()) {
            System.out.println("Inventory is empty!");
            return;
        }

        // COLLECTIONS SORTING: Using Comparator for custom sorting
        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                // Compare product names (case-insensitive)
                return p1.getProductName().compareToIgnoreCase(p2.getProductName());
            }
        });

        System.out.println("Products sorted by Name (A-Z)\n");
        displayInventory();
    }

    // Sort by Quantity (ascending)
    public void sortByQuantity() {
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty!");
            return;
        }

        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Integer.compare(p1.getQuantity(), p2.getQuantity());
            }
        });

        System.out.println("[SUCCESS] Products sorted by Quantity (Low to High)\n");
        displayInventory();
    }

    // Sort by Stock Status
    public void sortByStatus() {
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty!");
            return;
        }

        Collections.sort(this.products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                // Priority: Out of Stock -> Low Stock -> Healthy
                int priority1 = getStatusPriority(p1);
                int priority2 = getStatusPriority(p2);
                return Integer.compare(priority1, priority2);
            }
            
            private int getStatusPriority(Product p) {
                if (p.getQuantity() == 0) return 1;  // Out of stock - highest priority
                if (p.isLowStock()) return 2;        // Low stock
                return 3;                             // Healthy
            }
        });

        System.out.println("[SUCCESS] Products sorted by Status (Critical -> Low -> Healthy)\n");
        displayInventory();
    }

    // ===== FEATURE 11: EXPORT INVENTORY REPORT =====
    public void exportReport() {
        if (this.products.isEmpty()) {
            System.out.println("[ERROR] Inventory is empty! Nothing to export.");
            return;
        }

        try {
            // Create FileWriter to write to file
            FileWriter writer = new FileWriter("inventory_report.txt");

            // Write header
            writer.write("=" .repeat(80) + "\n");
            writer.write("           WAREHOUSE INVENTORY TRACKER - EXPORT REPORT\n");
            writer.write("=" .repeat(80) + "\n\n");

            // Write date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            writer.write("Generated on: " + now.format(formatter) + "\n\n");

            // Write inventory summary
            writer.write("INVENTORY SUMMARY\n");
            writer.write("-" .repeat(80) + "\n");
            
            int totalUnits = 0;
            double totalValue = 0;
            int lowStockCount = 0;

            for (Product product : this.products) {
                totalUnits += product.getQuantity();
                totalValue += product.getInventoryValue();
                if (product.isLowStock()) {
                    lowStockCount++;
                }
            }

            writer.write("Total Products: " + this.products.size() + "\n");
            writer.write("Total Units: " + totalUnits + "\n");
            writer.write("Total Inventory Value: ₹" + String.format("%.2f", totalValue) + "\n");
            writer.write("Low Stock Items: " + lowStockCount + "\n\n");

            // Write detailed product list
            writer.write("DETAILED PRODUCT LIST\n");
            writer.write("-" .repeat(80) + "\n");
            writer.write(String.format("%-5s | %-15s | %-6s | %-10s | %-10s | %s\n",
                "ID", "Product", "Qty", "Price", "Value", "Status"));
            writer.write("-" .repeat(80) + "\n");

            for (Product product : this.products) {
                writer.write(String.format("%-5s | %-15s | %-6d | ₹%-8.0f | ₹%-8.0f | %s\n",
                    product.getProductId(), product.getProductName(), product.getQuantity(),
                    product.getPrice(), product.getInventoryValue(), product.getStockStatus()));
            }

            // Write low stock products
            writer.write("\n" + "=".repeat(80) + "\n");
            writer.write("LOW STOCK PRODUCTS\n");
            writer.write("=".repeat(80) + "\n");
            
            boolean hasLowStock = false;
            for (Product product : this.products) {
                if (product.isLowStock() || product.getQuantity() == 0) {
                    writer.write(product.getProductId() + " | " + product.getProductName() +
                               " | Current: " + product.getQuantity() +
                               " | Threshold: " + product.getThreshold() + "\n");
                    hasLowStock = true;
                }
            }

            if (!hasLowStock) {
                writer.write("No low stock products.\n");
            }

            // Close the writer
            writer.close();

            System.out.println("[SUCCESS] Report exported successfully!");
            System.out.println("[FILE] inventory_report.txt");

        } catch (IOException e) {
            System.out.println("[ERROR] Error writing report: " + e.getMessage());
        }
    }

    // ===== HELPER METHODS =====

    // Find product by Name (case-insensitive)
    private Product findProductByName(String productName) {
        for (Product product : this.products) {
            if (product.getProductName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        return null;
    }

    // Find product by ID
    private Product findProductById(String productId) {
        for (Product product : this.products) {
            if (product.getProductId().equalsIgnoreCase(productId)) {
                return product;
            }
        }
        return null;
    }

    // Find product by ID or Name (Feature 3)
    private Product findProductByIdOrName(String identifier) {
        // First try to find by ID
        Product product = findProductById(identifier);
        if (product != null) {
            return product;
        }

        // Then try to find by Name
        return findProductByName(identifier);
    }

    // Get total product count
    public int getProductCount() {
        return this.products.size();
    }
}

