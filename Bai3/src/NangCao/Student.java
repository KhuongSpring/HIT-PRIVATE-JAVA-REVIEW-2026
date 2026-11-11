package NangCao;

public class Student {
    private String name;
    private static int count;

    public Student(String name) {
        this.name = name;
        count++;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }
}
