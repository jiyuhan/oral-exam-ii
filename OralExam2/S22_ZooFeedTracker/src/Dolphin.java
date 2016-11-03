/**
 * Created by thomas on 10/28/16.
 */
public class Dolphin extends Animal {


    public enum animalFoodType{
        bass(2),
        shrimp(3);


        private final int amount;

        animalFoodType(int amountofFood) {
            amount = amountofFood;
        }

        public int getAmountOfFood () {
            return amount;
        }
    }

    public Dolphin (String name, String animalLocation) {
        super(name, animalLocation);
    }

    public void getAnimalType() {
        System.out.println("This is a dolphin.");
    }

    public String getAnimalName() {
        System.out.format("This dolphin's name is %s", super.getAnimalName());
        return super.getAnimalName();
    }

    public String getAnimalLocation() {
        System.out.format("This dolphin's current location is: %s%n", super.getAnimalLocation());
        return super.getAnimalLocation();
    }

    public void getAnimalFoodType () {
        System.out.print("For a dolphin, you need: ");
        for (animalFoodType food: animalFoodType.values()) {
            System.out.format("%d lbs of %s, ", food.getAmountOfFood(), food);
        }
        System.out.print("\n");
    }
}
