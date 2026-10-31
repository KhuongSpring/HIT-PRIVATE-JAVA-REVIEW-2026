
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList<>();

    public static void printMenu() {
        System.out.println("\n===== MENU QUAN LY MAT HANG =====");
        System.out.println("1. Them mat hang");
        System.out.println("2. Xoa mat hang");
        System.out.println("3. In danh sach mat hang");
        System.out.println("4. Tinh tong tien");
        System.out.println("0. Thoat");
        System.out.print("Nhap lua chon: ");
    }

    public static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }

    public static void readAndAddItem(Scanner scanner) {
        System.out.print("Nhap ten mat hang: ");
        String name = scanner.nextLine();

        System.out.print("Nhap gia: ");
        double price = Double.parseDouble(scanner.nextLine());

        System.out.print("Nhap so luong: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        addItem(name, price, quantity);
        System.out.println("Them mat hang thanh cong!");
    }

    public static void removeItem(int index) {
        names.remove(index);
        prices.remove(index);
        quantities.remove(index);
    }

    public static void readAndRemoveItem(Scanner scanner) {
        if (names.isEmpty()) {
            System.out.println("Danh sach mat hang dang rong!");
            return;
        }

        printItems();

        System.out.print("Nhap so thu tu mat hang can xoa: ");
        int displayNumber = Integer.parseInt(scanner.nextLine());

        int index = displayNumber - 1;

        if (index >= 0 && index < names.size()) {
            removeItem(index);
            System.out.println("Xoa mat hang thanh cong!");
        } else {
            System.out.println("So thu tu khong hop le!");
        }
    }

    public static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Danh sach mat hang dang rong!");
            return;
        }

        System.out.println("\n===== DANH SACH MAT HANG =====");

        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);

            System.out.printf(
                    "%d. %s | Gia: %.1f | SL: %d | Thanh tien: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal
            );
        }
    }

    public static double calculateTotal() {
        double total = 0;

        for (int i = 0; i < names.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addItem("So tay", 25000, 3);
        addItem("But", 10000, 2);

        int choice;

        do {
            printMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> readAndAddItem(scanner);
                case 2 -> readAndRemoveItem(scanner);
                case 3 -> printItems();
                case 4 -> System.out.println("Tong tien: " + calculateTotal());
                case 0 -> System.out.println("Ket thuc.");
                default -> System.out.println("Lua chon khong hop le!");
            }
        } while (choice != 0);

        scanner.close();
    }
}

