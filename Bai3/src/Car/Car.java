package Car;

public class Car {
    private String carId;
    private String brand;
    private String licensePlate;

    public Car(String carId, String brand, String licensePlate){
        this.carId = carId;
        this.brand = brand;
        this.licensePlate = licensePlate;
    }
    public String getCarId(){
        return carId;
    }

    public String getBrand() {
        return brand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setCarId(String carld) {
        this.carId = carld;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
