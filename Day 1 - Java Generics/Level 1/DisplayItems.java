import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    private String name;
    private int quantity;

    public WarehouseItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item: " + name + ", Quantity: " + quantity;
    }
}

class Electronics extends WarehouseItem {
    private String brand;
    private String model;

    public Electronics(String name, int quantity, String brand, String model) {
        super(name, quantity);
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return super.toString() + ", Brand: " + brand + ", Model: " + model;
    }
}

class Groceries extends WarehouseItem {
    private String category;
    private String expiryDate;

    public Groceries(String name, int quantity, String category, String expiryDate) {
        super(name, quantity);
        this.category = category;
        this.expiryDate = expiryDate;
    }

    public String getCategory() {
        return category;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Category: " + category + ", Expiry Date: " + expiryDate;
    }
}

class Furniture extends WarehouseItem {
    private String material;
    private String dimensions;

    public Furniture(String name, int quantity, String material, String dimensions) {
        super(name, quantity);
        this.material = material;
        this.dimensions = dimensions;
    }

    public String getMaterial() {
        return material;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material + ", Dimensions: " + dimensions;
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items;

    public Storage() {
        this.items = new ArrayList<>();
    }

    public void addItem(T item) {
        items.add(item);
    }

    public T getItem(String name) {
        for (T item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

     public List<T> getAllItems() {
        return items;
    }

    public void updateQuantity(String name, int newQuantity) {
        T item = getItem(name);
        if (item != null) {
            item.setQuantity(newQuantity);
        }
    }

    public void removeItem(String name) {
        T item = getItem(name);
        if (item != null) {
            items.remove(item);
        }
    }
    public int getTotalItems() {
        int total = 0;
        for(T item: items){
            total+= item.getQuantity();
        }
        return total;
    }
}

public class DisplayItems {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        electronicsStorage.addItem(new Electronics("Laptop", 5, "Dell", "XPS 15"));
        electronicsStorage.addItem(new Electronics("Smartphone", 10, "Samsung", "Galaxy S21"));
        groceriesStorage.addItem(new Groceries("Milk", 20, "Dairy", "2024-05-01"));
        groceriesStorage.addItem(new Groceries("Bread", 15, "Bakery", "2024-04-28"));
        furnitureStorage.addItem(new Furniture("Table", 3, "Wood", "60x30x28"));
        furnitureStorage.addItem(new Furniture("Chair", 6, "Metal", "18x18x36"));

        System.out.println("Electronics Storage:");
        displayAllItems(electronicsStorage.getAllItems());

        System.out.println("\nGroceries Storage:");
        displayAllItems(groceriesStorage.getAllItems());

        System.out.println("\nFurniture Storage:");
        displayAllItems(furnitureStorage.getAllItems());
        
        System.out.println("\nTotal Electronics: " + electronicsStorage.getTotalItems());
        System.out.println("Total Groceries: " + groceriesStorage.getTotalItems());
        System.out.println("Total Furniture: " + furnitureStorage.getTotalItems());

        electronicsStorage.updateQuantity("Laptop", 7);
        System.out.println("\nUpdated Electronics Storage:");
        displayAllItems(electronicsStorage.getAllItems());

        groceriesStorage.removeItem("Bread");
        System.out.println("\nUpdated Groceries Storage:");
        displayAllItems(groceriesStorage.getAllItems());
    }
}
