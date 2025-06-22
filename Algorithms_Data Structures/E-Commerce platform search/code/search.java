import java.util.Arrays;
import java.util.Comparator;

public class search {

    // Product class
    static class Product {
        public int productId;
        public String productName;
        public String category;

        public Product(int productId, String productName, String category) {
            this.productId = productId;
            this.productName = productName;
            this.category = category;
        }

        @Override
        public String toString() {
            return productId + " - " + productName + " [" + category + "]";
        }
    }

    // Linear Search
    public static Product linearSearch(Product[] products, int targetId) {
        for (Product product : products) {
            if (product.productId == targetId) {
                return product;
            }
        }
        return null;
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (products[mid].productId == targetId) {
                return products[mid];
            } else if (products[mid].productId < targetId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(102, "Laptop", "Electronics"),
            new Product(305, "Shoes", "Footwear"),
            new Product(501, "Refrigerator", "Appliances"),
            new Product(204, "Smartphone", "Electronics"),
            new Product(123, "Backpack", "Bags")
        };

        // Linear search (unsorted)
        System.out.println("Linear Search for ID 204:");
        Product resultLinear = linearSearch(products, 204);
        System.out.println(resultLinear != null ? resultLinear : "Product not found");

        // Binary search (sorted by productId)
        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        System.out.println("\nBinary Search for ID 204:");
        Product resultBinary = binarySearch(products, 204);
        System.out.println(resultBinary != null ? resultBinary : "Product not found");
    }
}
