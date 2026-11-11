package KhoaHoc;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Course c1 = new Course("C01", "Java", 500000);
        Course c2 = new Course("C02", "Python", 600000);

        Enrollment e1 = new Enrollment(c1, "Nguyen Van A");
        Enrollment e2 = new Enrollment(c2, "Tran Thi B");
        ArrayList<Enrollment> enrollments = new ArrayList<>();
        enrollments.add(e1);
        enrollments.add(e2);
        System.out.println("DANH SACH DANG KY KHOA HOC");
        double sum = 0;
        for(Enrollment e : enrollments){
            System.out.println(e.getSummary());
            sum += e.getCourse().getFee();
        }
        System.out.println("Tong hoc phi: " + sum);
    }
}