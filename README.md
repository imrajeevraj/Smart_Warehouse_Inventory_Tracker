# 🏢 Smart Warehouse Inventory Tracker

[![Java](https://img.shields.io/badge/Java-8+-orange.svg)](https://www.oracle.com/java/)
[![License](https://img.shields.io/badge/License-MIT-green.svg)](LICENSE)
[![GitHub](https://img.shields.io/badge/GitHub-imrajeevraj-blue.svg)](https://github.com/imrajeevraj)

**Repository:** [Smart_Warehouse_Inventory_Tracker](https://github.com/imrajeevraj/Smart_Warehouse_Inventory_Tracker)

A **console-based Inventory Management System** designed as an educational Object-Oriented Programming (OOP) project in Java. Perfect for learning core programming concepts through a practical, real-world application.

## 📚 Project Overview

This project demonstrates professional-grade Java development with automated warehouse inventory tracking, real-time alerts for low-stock conditions, and comprehensive reporting capabilities.

**Key Features:**
- ✅ Add products to inventory
- ✅ Display all products with status
- ✅ Sell products (reduce stock)
- ✅ Restock products (increase stock)
- ✅ Remove products from inventory
- ✅ Automated low-stock alert generation
- ✅ Comprehensive inventory reports
- ✅ Encapsulation and data hiding
- ✅ Dynamic collection management

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
- Follow the menu options
- Enter choices 1-7 to interact
- Select option 7 to exit

---

## 📊 Sample Output & Session

### **Output:**
```
================================================================================
     🏢 WAREHOUSE INVENTORY TRACKER - BEGINNER PROJECT
================================================================================

================================================================================
                            MAIN MENU
================================================================================
1. ➕ Add Product
2. 📋 Display Inventory
3. 🛒 Sell Product
4. 📦 Restock Product
5. 🗑️  Remove Product
6. ⚠️  Check Low Stock
7. ❌ Exit
================================================================================
Enter your choice (1-7): 1

--- Add New Product ---
Enter product name: Laptop
Enter quantity: 50
Enter low stock threshold: 10
✅ Product added: Laptop
```

### **Continue Session:**
```
Enter your choice (1-7): 1

--- Add New Product ---
Enter product name: Mouse
Enter quantity: 5
Enter low stock threshold: 20
✅ Product added: Mouse

Enter your choice (1-7): 2

================================================================================
                        WAREHOUSE INVENTORY
================================================================================
1. Laptop              | Qty:    50 | Threshold:    10 | ✅ OK
2. Mouse               | Qty:     5 | Threshold:    20 | ⚠️  LOW STOCK
================================================================================
Total Products: 2
================================================================================

Enter your choice (1-7): 6

================================================================================
                      LOW STOCK ALERT CHECK
================================================================================
⚠️  ALERT: Mouse | Current: 5 | Minimum: 20

🚨 Total low-stock items: 1
================================================================================

Enter your choice (1-7): 7

✅ Thank you for using Warehouse Inventory Tracker!
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
| **Constructor** | Initialize object | `Product(name, qty, threshold)` |
| **Loop** | Repeat code | Display all products, menu loop |
| **Conditional** | If-else, switch | Check stock, menu choices |
| **Scanner** | Read user input | Get product name, quantity |

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

1. **Modify the code:** Try adding new features like:
   - Update product price
   - Search by product name
   - Show total inventory value

2. **Experiment:** Change threshold values and test low stock alerts

3. **Debug:** Add print statements to see what's happening:
   ```java
   System.out.println("DEBUG: quantity = " + quantity);
   ```

4. **Test edge cases:**
   - What if someone tries to add negative quantity?
   - What if they sell more than available?
   - What if inventory is empty?

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
