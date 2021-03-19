import java.util.Scanner;

public class AnimalManager {
    public static void main(String[] args) {
        Animal animal;
        Scanner sn = new Scanner(System.in);
        while (true) {
            String an = sn.nextLine();
            switch (an) {
                case "cat":
                    animal = new Cat();
                    break;
                case "dog":
                    animal = new Dog();
                    break;
                default:
                    animal = new Cat();
            }
            animal.exist(1);
        }
    }
}
