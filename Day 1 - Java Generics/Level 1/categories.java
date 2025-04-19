import java.util.ArrayList;
import java.util.List;

interface Category {}

enum BookCategory implements Category {
    FICTION, NON_FICTION, SCIENCE_FICTION, ROMANCE
}

enum ClothingCategory implements Category {
    SHIRTS, PANTS, DRESSES, OUTERWEAR
}

enum GadgetCategory implements Category {
    ELECTRONICS, APPLIANCES, TOOLS
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " + name + ", Price: $" + price + ", Category: " + category;
    }
}

class Catalog<T extends Product<?>> {
    private List<T> products;

    public Catalog() {
        this.products = new ArrayList<>();
    }

    public void addProduct(T product) {
        products.add(product);
    }

    public List<T> getProducts() {
        return products;
    }

    public <U extends Product<?>> void applyDiscount(U product, double percentage) {
        if (percentage > 0 && percentage < 1) {
            double newPrice = product.getPrice() * (1 - percentage);
            product.setPrice(newPrice);
        }
    }
}

public class categories {
    public static void main(String[] args) {
        Catalog<Product<BookCategory>> bookCatalog = new Catalog<>();
        Catalog<Product<ClothingCategory>> clothingCatalog = new Catalog<>();
        Catalog<Product<GadgetCategory>> gadgetCatalog = new Catalog<>();

        Product<BookCategory> book1 = new Product<>("The Lord of the Rings", 25.99, BookCategory.FICTION);
        Product<BookCategory> book2 = new Product<>("Sapiens", 20.50, BookCategory.NON_FICTION);
        Product<ClothingCategory> shirt1 = new Product<>("T-Shirt", 15.99, ClothingCategory.SHIRTS);
        Product<ClothingCategory> pants1 = new Product<>("Jeans", 49.99, ClothingCategory.PANTS);
        Product<GadgetCategory> gadget1 = new Product<>("Laptop", 1200.00, GadgetCategory.ELECTRONICS);
        Product<GadgetCategory> gadget2 = new Product<>("Refrigerator", 800.00, GadgetCategory.APPLIANCES);

        bookCatalog.addProduct(book1);
        bookCatalog.addProduct(book2);
        clothingCatalog.addProduct(shirt1);
        clothingCatalog.addProduct(pants1);
        gadgetCatalog.addProduct(gadget1);
        gadgetCatalog.addProduct(gadget2);

        System.out.println("Book Catalog:");
        for (Product<BookCategory> book : bookCatalog.getProducts()) {
            System.out.println(book);
        }

        System.out.println("\nClothing Catalog:");
        for (Product<ClothingCategory> clothing : clothingCatalog.getProducts()) {
            System.out.println(clothing);
        }

        System.out.println("\nGadget Catalog:");
        for (Product<GadgetCategory> gadget : gadgetCatalog.getProducts()) {
            System.out.println(gadget);
        }

        bookCatalog.applyDiscount(book1, 0.10);
        clothingCatalog.applyDiscount(shirt1, 0.20);
        gadgetCatalog.applyDiscount(gadget1, 0.05);

        System.out.println("\nDiscounted Book Catalog:");
        for (Product<BookCategory> book : bookCatalog.getProducts()) {
            System.out.println(book);
        }

        System.out.println("\nDiscounted Clothing Catalog:");
        for (Product<ClothingCategory> clothing : clothingCatalog.getProducts()) {
            System.out.println(clothing);
        }

        System.out.println("\nDiscounted Gadget Catalog:");
        for (Product<GadgetCategory> gadget : gadgetCatalog.getProducts()) {
            System.out.println(gadget);
        }
    }
}
