import model.Product;
import model.Book;
import model.Customer;
import model.CartItem;
import model.Order;

import java.util.ArrayList;
import java.util.List;

public class HitShop {
    public static void main(String[] args) {
        Product p1 = new Product("P01", "Ao thun", 150000, 20);
        Product p2 = new Product("P02", "Binh nuoc", 50000, 10);
        Book p3 = new Book("P03", "Java co ban", 120000, 5, "An Nguyen");

        List<Product> products = new ArrayList<>();
        products.add(p1);
        products.add(p2);
        products.add(p3);
        System.out.println("=== DANH SACH SAN PHAM ===");
        for (Product p : products) {
            System.out.println(p.getDescription());
        }

        Customer customer = new Customer("C01", "Linh Nguyen", "0900000001");
        Order order = new Order("O01", customer);

        System.out.println("\n=== DON HANG ===");
        System.out.println("Ma don: " + order.getId());
        System.out.println("Khach hang: " + order.getCustomer().getName());
        System.out.println("Trang thai: " + order.getStatus());
        System.out.println("Tong tien: " + order.getTotal());

        order.addItem(new CartItem(p1, 2));
        order.addItem(new CartItem(p2, 1));

        System.out.println("\n=== CHI TIET DON HANG ===");
        for (CartItem item : order.getItems()) {
            System.out.println(item.getProduct().getName() + " x " + item.getQuantity() + " = " + item.getTotal());
        }
        System.out.println("Tong tien: " + order.getTotal());

        order.confirm();
        System.out.println("Trang thai sau confirm: " + order.getStatus());

        order.cancel();
        System.out.println("Trang thai sau cancel: " + order.getStatus());

        p1.setPrice(160000);
        try {
            p1.setPrice(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Gia P01: " + p1.getPrice());
        p1.decreaseStock(2);
        try {
            p1.decreaseStock(0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Stock P01: " + p1.getStock());
    }
}
