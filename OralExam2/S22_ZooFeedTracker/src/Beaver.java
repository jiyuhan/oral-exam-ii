/**
 * Created by thomas on 10/28/16.
 */
public class Beaver extends Animal {

    public enum animalFoodType{
        hay(2),
        bass(1);

        private final int amount;

        animalFoodType(int amountofFood) {
            amount = amountofFood;
        }

        public int getAmountOfFood () {
            return amount;
        }
    }

    public Beaver (String name, String animalLocation) {
        super(name, animalLocation);
    }

    public void getAnimalType() {
        System.out.println("This is a beaver.");
    }

    public String getAnimalName() {
        System.out.format("This beaver's name is %s", super.getAnimalName());
        return super.getAnimalName();
    }

    public String getAnimalLocation() {
        System.out.format("This beaver's current location is: %s%n", super.getAnimalLocation());
        return super.getAnimalLocation();
    }

    public void getAnimalFoodType () {
        System.out.print("For a beaver, you need: ");
        for (animalFoodType food: animalFoodType.values()) {
            System.out.format("%d lbs of %s ", food.getAmountOfFood(), food);
        }
        System.out.print("\n");
    }
}
