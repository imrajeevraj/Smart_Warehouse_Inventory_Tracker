// Product.java - Entity Class
// ===================================
// ENCAPSULATION: This class represents a single product in the warehouse
// It encapsulates product data (attributes) and related business logic (methods)
// All attributes are private - external access is only through public methods

public class Product {
    // ===== ATTRIBUTES (Data Members) =====
    // Using private for ENCAPSULATION - controls how data is accessed
    
    private String productId;        // Unique ID (e.g., P101, P102)
    private String productName;      // Name of the product
    private int quantity;            // Current stock quantity
    private int threshold;           // Low stock alert threshold
    private double price;            // Price per unit (Feature 4)
    private int totalSold;           // Total units sold (Feature 6)

    // ===== CONSTRUCTOR =====
    // Constructor name MUST match class name
    // Constructor is called when creating a new Product object
    // This demonstrates CONSTRUCTOR OVERLOADING - multiple constructors with different parameters
    
    public Product(String productId, String productName, int quantity, int threshold, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.threshold = threshold;
        this.price = price;
        this.totalSold = 0;  // Initialize sales tracking
    }

    // ===== GETTER METHODS =====
    // ENCAPSULATION: These methods allow READ-ONLY access to private attributes
    // Other classes cannot modify attributes directly
    
    public String getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getThreshold() {
        return this.threshold;
    }

    public double getPrice() {
        return this.price;
    }

    public int getTotalSold() {
        return this.totalSold;
    }

    // ===== SETTER METHODS =====
    // ENCAPSULATION: These methods control how attributes are modified
    // We can add validation logic before allowing modification
    
    public void setQuantity(int newQuantity) {
        // VALIDATION: Prevent invalid data
        if (newQuantity >= 0) {
            this.quantity = newQuantity;
        } else {
            System.out.println("[ERROR] Error: Quantity cannot be negative!");
        }
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            this.price = newPrice;
        } else {
            System.out.println("[ERROR] Error: Price cannot be negative!");
        }
    }

    // ===== BUSINESS LOGIC METHODS =====
    
    // Get stock status as emoji (Feature 8)
    public String getStockStatus() {
        if (this.quantity == 0) {
            return "[OUT OF STOCK]";
        } else if (isLowStock()) {
            return "[LOW STOCK]";
        } else {
            return "[HEALTHY]";
        }
    }

    // Check if product has low stock
    // Returns true if quantity is LESS THAN threshold
    public boolean isLowStock() {
        return this.quantity < this.threshold;
    }

    // Calculate inventory value for this product (Feature 5)
    // Formula: quantity * price
    public double getInventoryValue() {
        return this.quantity * this.price;
    }

    // Track sales when product is sold (Feature 6)
    public void recordSale(int quantitySold) {
        this.totalSold += quantitySold;
    }

    // Get reorder suggestion (Feature 9)
    // Formula: (threshold * 2) - quantity
    // Minimum suggestion should never be negative
    public int getReorderSuggestion() {
        int suggestion = (this.threshold * 2) - this.quantity;
        return Math.max(suggestion, 0);  // Never return negative
    }

    // Helper method to format currency with comma separator
    private String formatCurrency(double amount) {
        return String.format("%,d", (long) amount);
    }

    // ===== OVERRIDE toString() METHOD =====
    // METHOD OVERRIDING: Provides custom string representation of Product
    // Called when printing a Product object
    @Override
    public String toString() {
        return String.format(
            "%-5s | %-15s | %6d | %12s | %12s | %s",
            this.productId, this.productName, this.quantity, 
            formatCurrency(this.price), formatCurrency(getInventoryValue()), 
            getStockStatus()
        );
    }

    // Compact toString for dashboard display
    public String toDashboardString() {
        return String.format(
            "%-5s %-20s Qty: %5d  Value: Rs.%-10s  %s",
            this.productId, this.productName, this.quantity,
            formatCurrency(getInventoryValue()), getStockStatus()
        );
    }
}
