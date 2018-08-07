public class U1 extends Rocket {

    double launchCrashPercentage = 0.05;
    double landCrashPercentage = 0.01;

    U1() {
        this.cost = 100;
        this.rocketWeight = 10;
        this.maxWeight = 19;
    }

    public boolean launch() { return !this.willCrash(this.crashPercentage(this.launchCrashPercentage)); }

    public boolean land() {
        return !this.willCrash(this.crashPercentage(this.landCrashPercentage));
    }
}