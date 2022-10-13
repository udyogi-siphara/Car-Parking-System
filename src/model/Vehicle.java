package model;

abstract public class Vehicle {
    private String num;
    private String type;
    private int weight;
    private int passenger;

    public Vehicle() {
    }

    public Vehicle(String num, String type, int weight, int passenger) {
        this.num = num;
        this.type = type;
        this.weight = weight;
        this.passenger = passenger;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPassenger() {
        return passenger;
    }

    public void setPassenger(int passenger) {
        this.passenger = passenger;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "num='" + num + '\'' +
                ", type='" + type + '\'' +
                ", weight=" + weight +
                ", passenger=" + passenger +
                '}';
    }
}
