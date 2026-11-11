package KhoaHoc;

public class Course{
    private String name;
    private String code;
    private int fee;

    Course(String name, String code, int fee){
        this.name = name;
        this.code = code;
        this.fee = fee;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getFee() {
        return fee;
    }


    public String toString(){
        return code + "|" + name + "|" + fee ;
    }
}