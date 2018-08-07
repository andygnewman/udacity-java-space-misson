import javax.swing.plaf.synth.SynthEditorPaneUI;

public class U2 extends Rocket {

    double launchCrashPercentage = 0.04;
    double landCrashPercentage = 0.08;

    U2() {
        this.cost = 120;
        this.rocketWeight = 18;
        this.maxWeight = 29;
    }

    public boolean launch() { return !this.willCrash(this.crashPercentage(this.launchCrashPercentage)); }

    public boolean land() { return !this.willCrash(this.crashPercentage(this.landCrashPercentage)); }
}