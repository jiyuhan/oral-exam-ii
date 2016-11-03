/**
 * Created by thomas on 10/28/16.
 */


public class Elephant extends Animal {

    private enum animalFoodType{
        zebra_meat(10);

        private final int amount;

        animalFoodType(int amountofFood) {
            amount = amountofFood;
        }

        public int getAmountOfFood () {
            return amount;
        }
    }

    /*Constructor*/
    public Elephant (String name, String animalLocation) {
        super(name, animalLocation);
    }
    public void getAnimalType() {
        System.out.println("This is an elephant.");
    }

    public String getAnimalName() {
        System.out.format("This elephant's name is %s%n", super.getAnimalName());
        return super.getAnimalName();
    }

    public String getAnimalLocation() {
        System.out.format("This elephant's current location is: %s%n", super.getAnimalLocation());
        return super.getAnimalLocation();
    }

    public void getAnimalFoodType () {
        System.out.print("For an elephant, you need: ");
        for (animalFoodType food: animalFoodType.values()) {
            System.out.format("%d lbs of %s ", food.getAmountOfFood(), food);
        }
        System.out.print("\n");
    }
}