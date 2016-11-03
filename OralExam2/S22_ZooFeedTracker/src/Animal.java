/**
 * Created by thomas on 10/28/16.
 */
public class Animal {
    private String name;
    private String animalLocation;

    private int feedingTotal;

    /**
     * This is the constructor. It "builds" a new animal type's database.
     * @param name
     * @param animalLocation
     */
    /*Constructor*/
    public Animal (String name, String animalLocation) {
        this.name = name;
        this.animalLocation = animalLocation;
    }

    public void getAnimalType () {
        System.out.println("This is an animal.");
    }

    public String getAnimalName() {
        return this.name;
    }

    public String getAnimalLocation() {
        return this.animalLocation;
    }

    public void feed1(){
        System.out.print("Feeding animal the first time...");
    }

    public void feed2(){
        System.out.print("Feeding animal the second time...");
    }

    public void feed3(){
        System.out.print("Feeding animal the thrid time...");
    }

    public void feed4(){
        System.out.print("Feeding animal the fourth time...");
    }
}
