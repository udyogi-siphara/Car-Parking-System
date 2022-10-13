package model;

public class Van extends Vehicle{
    public Van() {
        super();
    }

    public Van(String num, String type, int weight, int passenger) {
        super(num, type, weight, passenger);
    }

    @Override
    public String getNum() {
        return super.getNum();
    }

    @Override
    public void setNum(String num) {
        super.setNum(num);
    }

    @Override
    public String getType() {
        return super.getType();
    }

    @Override
    public void setType(String type) {
        super.setType(type);
    }

    @Override
    public int getWeight() {
        return super.getWeight();
    }

    @Override
    public void setWeight(int weight) {
        super.setWeight(weight);
    }

    @Override
    public int getPassenger() {
        return super.getPassenger();
    }

    @Override
    public void setPassenger(int passenger) {
        super.setPassenger(passenger);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
