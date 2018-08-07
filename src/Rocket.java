import java.util.ArrayList;

public class Rocket implements SpaceShip {

    int cost;
    double rocketWeight;
    double maxWeight;
    double cargoWeight = 0;
    double maxCargoWeight;
    ArrayList<Item> cargoList = new ArrayList();

    public double getMaxCargoWeight() {
        if (this.maxCargoWeight < 1) {
            this.maxCargoWeight = this.maxWeight - this.rocketWeight;
        }
        return this.maxCargoWeight;
    }

    public double crashPercentage(double chance) {
        double crashChance = chance * (this.cargoWeight / this.getMaxCargoWeight());
        return crashChance;
    }

    public boolean willCrash(double crashChance) { return crashChance >= Math.random() ? true : false; }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        if ((item.getWeight() + this.cargoWeight) <= this.getMaxCargoWeight()) {
            return true;
        } else {
            return false;
        }
    }

    public void carry(Item item) {
        cargoList.add(item);
        int itemWeight = item.getWeight();
        this.cargoWeight += itemWeight;
    }
}
