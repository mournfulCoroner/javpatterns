import java.util.ArrayList;
import java.util.List;

public class CompositeAnimal implements Animal{

    private List<Animal> childAnimals = new ArrayList<Animal>();

    public void voice(){
        for (Animal anima : childAnimals){
            anima.voice();
        }
    }

    public void add(Animal anima) {
        childAnimals.add(anima);
    }

    public void remove(Animal anima) {
        childAnimals.remove(anima);
    }
}
