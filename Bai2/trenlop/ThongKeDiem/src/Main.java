
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Double> scores = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void addScore() {
        for (int i = 1; i <= 5; i++) {
            System.out.print("Nhap diem thu " + i + ": ");
            double score = Double.parseDouble(sc.nextLine());

            if (score < 0 || score > 10) {
                System.out.println("Diem khong hop le!");
                i--;
                continue;
            }
            scores.add(score);
        }
    }

    public static void printScores() {
        if (scores.isEmpty()) {
            System.out.println("Danh sach rong!");
        } else {
            System.out.println("Danh sach diem: " + scores);
        }
    }

    public static double calculateAverage() {
        double sum = 0;
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i);
        }
        return sum / scores.size();
    }

    public static int countPassed() {
        int count = 0;

        for (int i = 0; i < scores.size(); i++) {
            if (scores.get(i) >= 5) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        addScore();
        printScores();

        if (!scores.isEmpty()) {
            System.out.println("Diem trung binh: " + calculateAverage());
            System.out.println("So diem dat: " + countPassed());
        }

        sc.close();
    }
}
