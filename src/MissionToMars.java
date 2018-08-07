import java.util.ArrayList;

public class MissionToMars {

    public static void main(String [] args) throws Exception {

        int costU1 = 0;
        int costU2 = 0;

        Simulation simulation = new Simulation();
        // U1
        ArrayList<Rocket> rocketsU1Phase1 = simulation.loadU1("Phase1");
        System.out.println("Rockets U1 Ph 1 size " + rocketsU1Phase1.size());
        ArrayList<Rocket> rocketsU1Phase2 = simulation.loadU1("Phase2");
        System.out.println("Rockets U1 Ph 2 size " + rocketsU1Phase2.size());
        System.out.println("Run U1 Ph 1 start cost: " + costU1);
        costU1 += simulation.run(rocketsU1Phase1);
        System.out.println("Run U1 Ph 2 start cost: " + costU1);
        costU1 += simulation.run(rocketsU1Phase2);

        //U2
        ArrayList<Rocket> rocketsU2Phase1 = simulation.loadU2("Phase1");
        System.out.println("Rockets U2 Ph 1 size " + rocketsU2Phase1.size());
        ArrayList<Rocket> rocketsU2Phase2 = simulation.loadU2("Phase2");
        System.out.println("Rockets U2 Ph 2 size " + rocketsU2Phase2.size());
        System.out.println("Run U2 Ph 1 start cost: " + costU2);
        costU2 += simulation.run(rocketsU2Phase1);
        System.out.println("Run U2 Ph 2 start cost: " + costU2);
        costU2 += simulation.run(rocketsU2Phase2);

        System.out.println("U1 Cost: " + costU1);
        System.out.println("U2 Cost: " + costU2);

        String winner = costU1 > costU2 ? "U2 WINS" : "U1 WINS";
        System.out.println(winner);
    }

}
