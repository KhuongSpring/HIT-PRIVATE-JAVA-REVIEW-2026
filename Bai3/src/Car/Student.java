package Car;

public class Student {
    private String studentId;
    private String name;
    private int age;
    private Car car;

    public Student(String studentId, String name, int age, Car car) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Car getCar() {
        return car;
    }

    public String introduce(){
        return "Minh ten la " + name + ", " + age +
                ", di xe " + car.getBrand() + ", bien so " + car.getCarId();
    }

}
