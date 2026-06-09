# 🏢 Smart Warehouse Inventory Tracker

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![GitHub](https://img.shields.io/badge/GitHub-imrajeevraj-blue.svg)](https://github.com/imrajeevraj)

**Repository:** [Smart_Warehouse_Inventory_Tracker](https://github.com/imrajeevraj/Smart_Warehouse_Inventory_Tracker)

A **console-based Inventory Management System** designed as an educational Object-Oriented Programming (OOP) project in Java. Perfect for learning core programming concepts through a practical, real-world application.

## 📚 Project Overview

This project demonstrates professional-grade Java development with automated warehouse inventory tracking, real-time alerts for low-stock conditions, and comprehensive reporting capabilities.

**Key Features:**
- ✅ Add products with unique product IDs
- ✅ Display inventory with detailed product information
- ✅ Search products by name or ID
- ✅ Sell products (reduce stock with transaction tracking)
- ✅ Restock products (increase stock efficiently)
- ✅ Remove products from inventory
- ✅ Automated low-stock alert generation with restock suggestions
- ✅ Inventory Dashboard with comprehensive metrics
- ✅ Sort products by name, quantity, or price
- ✅ Export inventory reports
- ✅ Encapsulation and data hiding
- ✅ Dynamic collection management with ArrayList
- ✅ Price tracking and inventory valuation

---

## 🏗️ Project Structure

```
Smart_Warehouse_Inventory_Tracker/
│
├── README.md                               # Project documentation
├── .gitignore                              # Git ignore rules
├── Project.pdf                             # Detailed project report
├── Smart_Warehouse_Inventory_Tracker.pptx  # Presentation slides
└── src/
    ├── Product.java                        # Product entity class
    ├── InventoryManager.java               # Inventory manager class
    ├── WarehouseInventoryTracker.java      # Main application entry point
    └── inventory_report.txt                # Sample output
```

---

## � Getting Started with GitHub

### **Clone the Repository**

```bash
# Clone from GitHub
git clone https://github.com/imrajeevraj/Smart_Warehouse_Inventory_Tracker.git

# Navigate to project directory
cd Smart_Warehouse_Inventory_Tracker
```

### **System Requirements**
- **Java:** JDK 8 or higher
- **OS:** Windows, Linux, or macOS
- **RAM:** 2 GB minimum
- **Storage:** 100 MB

---

## �📝 Class Descriptions

### 1️⃣ **Product.java** (Entity Class)

Represents a single product in the warehouse.

**Attributes (Data Members):**
```java
private String productName;    // Name of product
private int quantity;          // Current stock
private int threshold;         // Low stock alert level
```

**Key Methods:**

| Method | Purpose |
|--------|---------|
| `Product()` | Constructor - initialize product |
| `getProductName()` | Get product name |
| `getQuantity()` | Get current quantity |
| `getThreshold()` | Get threshold value |
| `setQuantity()` | Update quantity |
| `isLowStock()` | Check if stock is low |
| `toString()` | Display product info |

**Explanation for Viva:**
```
The Product class uses ENCAPSULATION - 
private attributes with public getter/setter methods.
This prevents direct access to data and ensures validation.

The isLowStock() method contains BUSINESS LOGIC:
- Returns true if quantity < threshold
- Used for alert generation
```

---

### 2️⃣ **InventoryManager.java** (Manager Class)

Manages all products in the inventory using ArrayList.

**Key Attribute:**
```java
private ArrayList<Product> products;  // List of all products
```

**Key Methods:**

| Method | Purpose |
|--------|---------|
| `addProduct()` | Add new product to inventory |
| `displayInventory()` | Show all products |
| `sellProduct()` | Reduce stock (sell) |
| `restockProduct()` | Increase stock |
| `removeProduct()` | Delete product |
| `checkLowStock()` | Show low stock alerts |
| `findProduct()` | Search for product (helper) |

**Explanation for Viva:**
```
InventoryManager uses COMPOSITION - 
it contains multiple Product objects.

Uses ArrayList instead of fixed-size array 
because ArrayList grows dynamically.

Methods iterate through all products 
using for-each loop:
    for (Product product : products) { ... }
```

---

### 3️⃣ **WarehouseInventoryTracker.java** (Main Class)

The main entry point - provides menu and user interaction.

**Key Features:**
- Menu-driven interface
- Takes user input via Scanner
- Calls manager methods based on user choice
- Error handling for invalid input
- Infinite loop until user exits

**Main Flow:**
```
1. displayWelcome()
   ↓
2. Loop:
   - displayMenu()
   - Get user choice
   - Switch statement calls appropriate method
   - Continue until exit
   ↓
3. Close scanner and exit
```

---

## 🔑 OOP Concepts Used

### ✅ **Encapsulation**
```java
// In Product class:
private String productName;        // Private attribute
public String getProductName() {   // Public getter
    return this.productName;
}
```
**Benefit:** Data is protected. Other classes can't directly modify it.

---

### ✅ **Classes and Objects**
```java
// Create objects of Product class
Product p1 = new Product("Laptop", 50, 10);
Product p2 = new Product("Mouse", 5, 20);
```
**Benefit:** Each product is an independent object with its own data.

---

### ✅ **`this` Keyword**
```java
public Product(String productName, int quantity, int threshold) {
    this.productName = productName;  // this refers to object's variable
}
```
**Benefit:** Distinguishes object variables from local parameters.

---

### ✅ **ArrayList (Dynamic Array)**
```java
private ArrayList<Product> products;
products.add(newProduct);    // Add item
products.remove(product);    // Remove item
products.size();             // Get size
```
**Benefit:** Size grows automatically. No fixed capacity.

---

### ✅ **Methods**
- **public**: Can be called from other classes
- **private**: Only called within the same class
- **return type**: What the method gives back

```java
public String getProductName() {    // public method
    return this.productName;         // returns String
}

private Product findProduct(...) {   // private helper method
    return foundProduct;             // returns Product or null
}
```

---

### ✅ **Loops**
```java
// For-each loop (easiest for beginners)
for (Product product : products) {
    System.out.println(product);
}

// While loop (for menu)
while (running) {
    displayMenu();
    // ...
}
```

---

### ✅ **Conditional Statements**
```java
// If-else
if (quantity >= 0) {
    // valid
} else {
    // invalid
}

// Switch statement (for menu)
switch (choice) {
    case 1:
        handleAddProduct();
        break;
    // ...
}
```

---

## 🚀 How to Run

### **Option 1: Simple Compilation (Recommended for Beginners)**

**Step 1: Open Terminal/Command Prompt**
```bash
# Navigate to src directory
cd path/to/Smart_Warehouse_Inventory_Tracker/src
```

**Step 2: Compile All Java Files**
```bash
javac *.java
```

**Step 3: Run the Main Class**
```bash
java WarehouseInventoryTracker
```

### **Option 2: Compile to Output Directory**

```bash
# From project root, compile to bin directory
javac src/*.java -d bin/

# Run from bin directory
java -cp bin WarehouseInventoryTracker
```

### **Step 4: Interact with the Program**
- Follow the menu options (1-11)
- Enter your choice to execute operations
- Select option 11 to exit the application

---

## 📊 Sample Output & Session

### **Main Menu**
```
================================================================================
     SMART WAREHOUSE INVENTORY TRACKER – JAVA PROJECT
================================================================================
================================================================================
                     MAIN MENU – SELECT AN OPTION
================================================================================
1.  Add Product
2.  Display Inventory
3.  Search Product
4.  Sell Product
5.  Restock Product
6.  Remove Product
7.  Low Stock Alert
8.  Dashboard
9.  Sort Products
10. Export Report
11. Exit
================================================================================
Enter your choice (1-11): 
```

### **Add New Product**
```
========================================================
                  ADD NEW PRODUCT
========================================================
Enter product name: Notebook
Enter quantity: 50
Enter low stock threshold: 5
Enter price per unit (Rs.): 100
[SUCCESS] Product added successfully!
ID: P101 | Name: Notebook
========================================================
```

### **Inventory Dashboard**
```
========================================================
                 INVENTORY DASHBOARD
========================================================
Total Products        : 6
Total Units           : 300
Low Stock Items       : 0
Out of Stock Items    : 0
Total Inventory Value : Rs.2698000.00
========================================================

TOP SELLING PRODUCT:
     No sales recorded yet.
========================================================
```

### **Low Stock Alert Check**
```
========================================================================
                      LOW STOCK ALERT CHECK
========================================================================
[ALERT] P107 | Ballpen | Current: 4 | Minimum: 5
   -> Suggested Restock: 6 units
========================================================================

Total low-stock items: 1
========================================================================
```

### **Complete Session Example**
```
Enter your choice (1-11): 1

========================================================
                  ADD NEW PRODUCT
========================================================
Enter product name: Laptop
Enter quantity: 50
Enter low stock threshold: 10
Enter price per unit (Rs.): 50000
[SUCCESS] Product added successfully!
ID: P101 | Name: Laptop
========================================================

Enter your choice (1-11): 2

========================================================
              WAREHOUSE INVENTORY DISPLAY
========================================================
ID    | Product Name    | Qty  | Threshold | Price    | Status
------|-----------------|------|-----------|----------|--------
P101  | Laptop          |  50  |    10     | 50000    | ✅ OK
P102  | Mouse           |   5  |    20     |   500    | ⚠️ LOW
P103  | Keyboard        |  30  |    15     |  1500    | ✅ OK
P104  | Monitor         |   3  |    10     | 15000    | ⚠️ LOW
========================================================
Total Products: 4
========================================================

Enter your choice (1-11): 7

========================================================================
                      LOW STOCK ALERT CHECK
========================================================================
[ALERT] P102 | Mouse | Current: 5 | Minimum: 20
   -> Suggested Restock: 15 units

[ALERT] P104 | Monitor | Current: 3 | Minimum: 10
   -> Suggested Restock: 7 units
========================================================================

Total low-stock items: 2
========================================================================

Enter your choice (1-11): 8

========================================================
                 INVENTORY DASHBOARD
========================================================
Total Products        : 4
Total Units           : 88
Low Stock Items       : 2
Out of Stock Items    : 0
Total Inventory Value : Rs.2828500.00
========================================================

TOP SELLING PRODUCT:
     No sales recorded yet.
========================================================

Enter your choice (1-11): 11

✅ Thank you for using Smart Warehouse Inventory Tracker!
Goodbye!
```

---

## 🎯 Key Takeaways

| Concept | What It Does | Where Used |
|---------|-------------|-----------|
| **Class** | Blueprint for objects | Product, InventoryManager |
| **Object** | Instance of a class | Each product, the manager |
| **Encapsulation** | Hide data, expose methods | private attributes, public getters |
| **ArrayList** | Dynamic list of objects | Store multiple products |
| **Method** | Action/function | addProduct(), sellProduct() |
| **Constructor** | Initialize object | `Product(name, qty, threshold, price)` |
| **Loop** | Repeat code | Display all products, menu loop |
| **Conditional** | If-else, switch | Check stock, menu choices |
| **Scanner** | Read user input | Get product details |

---

## 🐛 Troubleshooting

| Problem | Solution |
|---------|----------|
| **"command not found"** | Make sure you're in `src` folder |
| **"cannot find symbol"** | Compile all files: `javac *.java` |
| **Input not working** | Use `scanner.nextLine()` after `nextInt()` |
| **Program won't exit** | Choose option 7 or press Ctrl+C |

---

## 💡 Extra Learning Tips

1. **Explore All Features:** Try each menu option:
   - Add multiple products with varying prices
   - Use Dashboard to see total inventory value
   - Sort products by different criteria
   - Export reports and view data

2. **Modify the code:** Try adding new features like:
   - Filter products by price range
   - Calculate profit margins
   - Track customer purchase history
   - Generate sales reports

3. **Experiment with data:** Test with:
   - Different product categories
   - Bulk product additions
   - Various threshold levels
   - Price adjustments

4. **Debug:** Add print statements to see what's happening:
   ```java
   System.out.println("DEBUG: Product ID = " + productId);
   System.out.println("DEBUG: Total Value = " + totalValue);
   ```

5. **Test edge cases:**
   - What if someone tries to add negative price?
   - What if they sell more than available stock?
   - What if inventory is empty?
   - What happens with duplicate product names?

---

## 📖 Project Completed! 

This project demonstrates all essential OOP concepts needed for first-year learning:
- ✅ Classes and Objects
- ✅ Encapsulation
- ✅ Methods and Constructors
- ✅ Collections (ArrayList)
- ✅ Control Flow (loops, conditionals)
- ✅ User Input (Scanner)
- ✅ Error Handling (try-catch)

**Good luck with your viva! 🎉**

---

## 🌐 GitHub Repository & Collaboration

### **Repository Link**
👉 **https://github.com/imrajeevraj/Smart_Warehouse_Inventory_Tracker**

### **Contributing**

Want to contribute improvements? Here's how:

1. **Fork** the repository on GitHub
2. **Clone** your fork:
   ```bash
   git clone https://github.com/YOUR-USERNAME/Smart_Warehouse_Inventory_Tracker.git
   ```

3. **Create** a feature branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```

4. **Make changes** and test thoroughly

5. **Commit** your changes:
   ```bash
   git commit -m "feat: Add your feature description"
   ```

6. **Push** to your fork:
   ```bash
   git push origin feature/your-feature-name
   ```

7. **Create** a Pull Request on GitHub

### **Commit Message Guidelines**
- `feat:` for new features
- `fix:` for bug fixes
- `docs:` for documentation updates
- `test:` for test additions

Example:
```bash
git commit -m "feat: Add product sorting functionality"
git commit -m "fix: Fix low stock calculation bug"
git commit -m "docs: Update README with new features"
```

---

## 📝 Version History

| Version | Date | Changes |
|---------|------|---------|
| v1.0.0 | June 2026 | Initial release with core features |
| v1.1.0 | - | Planned: Add search functionality |
| v2.0.0 | - | Planned: Database integration |

---

## ✍️ Author & Contact

**Rajeev Raj**
- 🔗 GitHub: [@imrajeevraj](https://github.com/imrajeevraj)
- 📧 Email: rajeev.ranjan948@hotmail.com
- 💼 LinkedIn: https://www.linkedin.com/in/rajeev-ranjan-1046291a4/

---

## 📄 License

This project is licensed under the **MIT License** - see LICENSE file for details.

---

## ⭐ Show Your Support

If this project helped you learn OOP concepts, please:
- ⭐ **Star** the repository on GitHub
- 🍴 **Fork** the project
- 💬 **Share** your feedback in Issues

---

## 🙏 Acknowledgments

- Java documentation and tutorials
- GeeksforGeeks for OOP concepts
- All contributors and users

---

<div align="center">

### Made with ❤️ for Java learners everywhere

**Happy Coding! 🚀**

</div>

---

**Last Updated:** June 2026  
**Status:** ✅ Active & Maintained  
**Repository:** [GitHub](https://github.com/imrajeevraj/Smart_Warehouse_Inventory_Tracker)
