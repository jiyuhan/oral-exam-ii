/**
 * Created by thomas on 10/28/16.
 */
public class ZooFeedTrackerTest {

    public static void main(String[] args) {
        Elephant dumbo = new Elephant("Dumbo", "cage 1");
        Lion simba = new Lion("Simba", "cage 2");
        Lion shereKhan = new Lion("Shere Khan", "cage 3");
        Dolphin flipper = new Dolphin("Flipper", "cage 4");
        Beaver chuck = new Beaver("Chuck", "cage 5");

        dumbo.getAnimalType();
        dumbo.getAnimalName();
        dumbo.getAnimalLocation();
        dumbo.getAnimalFoodType();
        flipper.getAnimalFoodType();
        simba.getAnimalFoodType();
        chuck.getAnimalFoodType();
    }
}
