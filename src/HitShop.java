import java.util.Scanner;

public class HitShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hang;
        double gia;
        int sl;
        final double VAT_RATE = 0.10;
        final double HIPPING_FEE = 2000;

        do {
            System.out.print("Ten mat hang: ");
            hang = sc.nextLine();
        } while (hang.trim().isEmpty());
        do {
            System.out.print("Don gia: ");
            gia = sc.nextDouble();
        } while (gia <= 0);
        do {
            System.out.print("So luong: ");
            sl = sc.nextInt();
        } while (sl <= 0);
        double tien = sl * gia;
        double tong = tien + tien * VAT_RATE + HIPPING_FEE ;
        System.out.println();
        System.out.println("PHIEU IN MAT HANG:");
        System.out.println("Ten mat hang: " + hang);
        System.out.println("Don gia : " + gia);
        System.out.println("So luong: " + sl);
        System.out.println("Thanh tien : " + tien);
        System.out.println("Tong thanh toan : " + tong);



    }
}

