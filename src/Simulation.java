import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public static ArrayList<Item> ingestItems(File file) throws FileNotFoundException {
        ArrayList<Item> itemsToLoad = new ArrayList();
        Scanner fileScanner = new Scanner(file);

        while (fileScanner.hasNextLine()) {
            String [] itemArray = fileScanner.nextLine().split("=");
            String name = itemArray[0];
            int weight = Integer.parseInt(itemArray[1])/1000;
            Item item = new Item();
            item.setName(name);
            item.setWeight(weight);
            itemsToLoad.add(item);
        }

        return itemsToLoad;
    }

    public static File getFile (String phase) {
        if (phase == "Phase1") {
            return new File("/Users/anewman/shutterstock/training/MissionToMars/src/phase-1.txt");
        } else {
            return new File("/Users/anewman/shutterstock/training/MissionToMars/src/phase-2.txt");
        }
    }

    public static Rocket getNewRocket(String rocketType) {
        return rocketType == "U1" ? new U1() : new U2();
    }

    public static ArrayList<Rocket> loadRockets(String rocketType, String phase) throws Exception {
        ArrayList<Rocket> rockets = new ArrayList();
        ArrayList<Item> itemsToLoad = ingestItems(getFile(phase));


        Rocket currentRocket = getNewRocket(rocketType);
        rockets.add(currentRocket);

        for (Item item : itemsToLoad) {
            if (currentRocket.canCarry(item)) {
                currentRocket.carry(item);
            } else {
                rockets.add(currentRocket);
                currentRocket = getNewRocket(rocketType);
                currentRocket.carry(item);
            }
        }
        return rockets;
    }

    public static ArrayList<Rocket> loadU1(String phase) throws Exception {
        return loadRockets("U1", phase);
    }

    public static ArrayList<Rocket> loadU2(String phase) throws Exception {
        return loadRockets("U2", phase);
    }

    public static int run(ArrayList<Rocket> rockets) {
        int cost = 0;
        int failures = 0;
        for (Rocket rocket : rockets) {
            boolean success = false;
            while (success == false) {
                cost += rocket.cost;
                success = (rocket.launch() && rocket.land());
                if (!success) { failures ++; }
            }
        }
        System.out.println("Cost " + cost + ", (failures: " + failures +")");
        return cost;
    }

}
