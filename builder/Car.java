package builder;

public class Car {
    private String engine;
    private int seats;
    private String gps;
    private int airbags;

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setGps(String gps) {
        this.gps = gps;
    }

    public void setAirbags(int airbags) {
        this.airbags = airbags;
    }
}

interface CarBuilder{
    void buildEngine();
    void buildSeats();
    void buildGps();
    void buildAirbags();
    Car getResult();
}

class SportsCarBuilder implements CarBuilder{
    private Car car;
    public SportsCarBuilder(){
        this.car=new Car();
    }

    public void buildEngine(){
        this.car.setEngine("v8 engine");
    }

    public void buildAirbags(){
        this.car.setAirbags(4);
    }
    public void buildGps(){
        this.car.setGps("high quality gps");
    }
    public void buildSeats(){
        this.car.setSeats(2);
    }
    public Car getResult(){
        return this.car;
    }
}
class SuvCarBuilder implements CarBuilder {

    private Car car;

    public SuvCarBuilder() {
        this.car = new Car();
    }

    public void buildEngine() {
        this.car.setEngine("v6 engine");
    }

    public void buildSeats() {
        this.car.setSeats(7);
    }

    public void buildGps() {
        this.car.setGps("standard gps");
    }

    public void buildAirbags() {
        this.car.setAirbags(6);
    }

    public Car getResult() {
        return this.car;
    }
}



class Director{
    private CarBuilder builder;

    public void setBuilder(CarBuilder carBuilder){
        this.builder=carBuilder;
    }

    public Car construct(){
        builder.buildAirbags();
        builder.buildEngine();
        builder.buildGps();
        builder.buildSeats();
        return builder.getResult();
    }
}
class Demo {
    public static void main(String[] args) {
        Director director = new Director();

        CarBuilder sportsCarBuilder = new SportsCarBuilder();
        director.setBuilder(sportsCarBuilder);
        Car sportsCar = director.construct();
        System.out.println("Sports Car built with: " + sportsCar);

        CarBuilder suvCarBuilder = new SuvCarBuilder();
        director.setBuilder(suvCarBuilder);
        Car suvCar = director.construct();
        System.out.println("SUV Car built with: " + suvCar);
    }
}