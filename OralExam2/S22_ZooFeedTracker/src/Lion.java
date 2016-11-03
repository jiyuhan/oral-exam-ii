/**
 * Created by thomas on 10/28/16.
 */
public class Lion extends Animal {

    public enum animalFoodType{
        zebrameat(20);

        private final int amount;

        animalFoodType(int amountofFood) {
            amount = amountofFood;
        }

        public int getAmountOfFood () {
            return amount;
        }
    }

    public Lion (String name, String animalLocation) {
        super(name, animalLocation);
    }

    public void getAnimalType() {
        System.out.println("This is a lion.");
    }

    public String getAnimalName() {
        System.out.format("This lion's name is %s", super.getAnimalName());
        return super.getAnimalName();
    }

    public String getAnimalLocation() {
        System.out.format("This lion's current location is: %s%n", super.getAnimalLocation());
        return super.getAnimalLocation();
    }

    public void getAnimalFoodType () {
        System.out.print("For a lion, you need: ");
        for (animalFoodType food: animalFoodType.values()) {
            System.out.format("%d lbs of %s ", food.getAmountOfFood(), food);
        }
        System.out.print("\n");
    }

}
