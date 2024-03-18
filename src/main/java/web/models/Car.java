package web.models;

public class Car {
    private String model;
    private String series;
    private int numberOfDoors;

    public Car(String model, String series, int numberOfDoors) {
        this.model = model;
        this.series = series;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", series='" + series + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}
