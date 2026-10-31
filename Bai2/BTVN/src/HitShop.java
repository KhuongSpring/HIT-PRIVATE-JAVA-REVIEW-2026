import java.util.ArrayList;
import java.util.Scanner;

public class HitShop {
    static ArrayList<String> names = new ArrayList<>();
    static ArrayList<Double> prices = new ArrayList<>();
    static ArrayList<Integer> quantities = new ArrayList();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        addItem("Áo thun",150000,1);
        addItem("Bình nước",50000,1);
        int choice;
        do{
            printMenu();
            System.out.print("Chọn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.print("Tên hàng: "); String name = sc.nextLine();
                    System.out.print("Đơn giá: "); Double price = Double.parseDouble(sc.nextLine());
                    System.out.print("Số lượng: "); Integer quantity = Integer.parseInt(sc.nextLine());
                    addItem(name,price,quantity);
                    printItems();
                    break;
                case 2:
                    System.out.print("Xoa STT: ");
                    int index = Integer.parseInt(sc.nextLine());
                    removeItem(index);
                    printItems();
                    break;
                case 3:
                    printItems();
                    break;
                case 4:
                    System.out.println("Tong tien: " + calculateTotal());
                    break;
                case 0:
                    System.out.print("Kết thúc");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while(choice != 0);

        System.out.println();
        searchItem(sc);
    }
    
    static void printMenu(){
        System.out.println("\n========== Menu ==========\n");
        System.out.println("1. Thêm mặt hàng");
        System.out.println("2. Xóa mặt hàng");
        System.out.println("3. Xem giỏ");
        System.out.println("4. Xem tổng tiền");
        System.out.println("0. Thoát");
    }

    static void addItem(String name, double price, int quantity){
        names.add(name);
        prices.add(price);
        quantities.add(quantity);
    }
    static void removeItem(int index){
        if(index < 1 || index > names.size()){
            System.out.print("Danh sách rỗng");
            return;
        }
        names.remove(index-1 );
        prices.remove(index-1);
        quantities.remove(index-1);
        System.out.print("Xóa thành công");
    }
    static void printItems(){
        if(names.isEmpty()){
            System.out.print("Danh sách trống");
            return;
        }
        System.out.print("\n========== GIỎ HÀNG ==========\n");
        for(int i = 0; i < names.size() ; i++){
            double lineTotal = prices.get(i) * quantities.get(i);
            System.out.printf( "%d . %s | ĐG: %.1f | SL: %d | Thành tiền: %.1f %n ",
            i + 1,
            names.get(i),
            prices.get(i),
            quantities.get(i),
            lineTotal
            );
        }
    }

    static double calculateTotal(){
        double total = 0;
        if(names.isEmpty()){
            total = 0;
            }
        for ( int i = 0; i < names.size(); i++){
            total += prices.get(i) * quantities.get(i);
        }
        final double VAT_FEE = 0.1 * total;
        final double SHIPPING_FEE = names.isEmpty() ? 0 : 20000;
        double sum = total + VAT_FEE + SHIPPING_FEE;
        System.out.printf("Tien hang: %.1f%n", total);
        System.out.printf("VAT (10%%): %.1f%n",VAT_FEE);
        System.out.printf("Phi van chuyen: %.1f%n", SHIPPING_FEE);
        System.out.printf("Tong thanh toan: %.1f%n",sum);
        return sum ;
    }

    static void searchItem(Scanner sc){
        int count = 0 ;
        System.out.print("Nhap tên hàng cần tìm: ");
        String search = sc.nextLine();
       for (int i = 0; i < names.size(); i++){
           if(names.get(i).equalsIgnoreCase(search)){
            count += 1;
            double total = prices.get(i) * quantities.get(i);
            System.out.printf( "%d . %s | ĐG: %.1f | SL: %d | Thành tiền: %.1f %n ",
            i + 1,
            names.get(i),
            prices.get(i),
            quantities.get(i),
            total
           );
       }
    }
       if (count == 0){
            System.out.print("Không timg thấy mặt hàng");
        }
    }
}

