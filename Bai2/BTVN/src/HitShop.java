import model.Product;
import model.Customer;
import model.CartItem;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {
    private static final Customer currentCustomer = new Customer("C01", "Linh Nguyễn", "0900000001");
    private static final List<CartItem> cart = new ArrayList<>();
    private static final Product p1 = new Product("P01", "Áo thun", 150000, 20);
    private static final Product p2 = new Product("P02", "Bình nước", 50000, 10);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            printMenu();
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Danh sách sản phẩm:");
                    System.out.println(p1);
                    System.out.println(p2);
                    System.out.print("Mã sản phẩm: ");
                    String id = sc.nextLine();
                    Product product = null;
                    if (id.equalsIgnoreCase("P01")) {
                        product = p1;
                    } else if (id.equalsIgnoreCase("P02")) {
                        product = p2;
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                        break;
                    }
                    System.out.print("Số lượng: ");
                    int quantity = Integer.parseInt(sc.nextLine());

                    if (quantity <= 0) {
                        System.out.println("Số lượng phải lớn hơn 0.");
                        break;
                    }
                    addItem(product, quantity);
                    break;
                case 2:
                    printItems();
                    if (cart.isEmpty()) {
                        break;
                    }
                    System.out.print("Xóa STT: ");
                    int index = Integer.parseInt(sc.nextLine());
                    removeItem(index - 1);
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tổng tiền: " + calculateTotal());
                    break;

                case 0:
                    System.out.println("Kết thúc chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);

        sc.close();
    }

    static void printMenu() {
        System.out.println("\n========== MENU ==========");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    static void addItem(Product product, int quantity) {
        CartItem item = new CartItem(product, quantity);
        cart.add(item);
    }

    static void removeItem(int index) {
        if (index < 0 || index >= cart.size()) {
            System.out.println("Không tìm thấy mặt hàng.");
            return;
        }
        cart.remove(index);
    }

    static void printItems() {
        System.out.println("Khách hàng: " + currentCustomer);
        if (cart.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }

        for (int i = 0; i < cart.size(); i++) {
            CartItem item = cart.get(i);
            Product product = item.getProduct();
            System.out.printf("%d. %s | %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    item.getQuantity(),
                    item.getTotal());
        }
    }
    static double calculateTotal() {
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            total += cart.get(i).getTotal();
        }
        return total;
    }
}
