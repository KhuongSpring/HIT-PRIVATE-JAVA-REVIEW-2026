
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static final List<String> names = new ArrayList<>();
    static final List<Double> prices = new ArrayList<>();
    static final List<Integer> quantities = new ArrayList<>();

    static void addItem(String name, double price, int quantity) {
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }
    static void removeItem(int index){
         if ( index < 0 || index >= names.size()){
             System.out.println("Khong tin thay");
             return ;
         }
         names.remove(index);
         prices.remove(index);
         quantities.remove(index);
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

    static void printItems() {
        if (names.isEmpty()) {
            System.out.println("Giỏ hàng đang trống.");
            return;
        }
        for (int i = 0; i < names.size(); i++) {
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf("%d. %s | %.1f | SL: %d | Thành tiền: %.1f%n",
                    i + 1,
                    names.get(i),
                    prices.get(i),
                    quantities.get(i),
                    lineTotal);
        }
    }

    static void readAndRemoveItem( Scanner scanner){
        if( names.isEmpty()){
            System.out.print("Danh sach rong");
            return ;
        }
        printItems();
        System.out.print("Nhap vi tri can xoa: ");
        int displayNumber = Integer.parseInt(scanner.nextLine());
        int index = displayNumber - 1;
        removeItem(index);
        printItems();
    }

    static double calculateTotal(){
        double sum = 0;
        for( int i = 0; i < names.size(); i++){
            sum = prices.get(i) * quantities.get(i);
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        addItem("So tay", 25000,3);
        addItem("But",1000,2);
        System.out.println("Nhap choice: ");
        int choice = Integer.parseInt(scanner.nextLine());
        do {
            printItems();
            switch (choice) {
                case 1 -> readAndAddItem(scanner);
                case 2 -> readAndRemoveItem(scanner);
                case 3 -> printItems();
                case 4 -> System.out.println("Tổng tiền: " + calculateTotal());
                case 0 -> System.out.println("Kết thúc.");
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }while (choice != 0) ;
    }
}