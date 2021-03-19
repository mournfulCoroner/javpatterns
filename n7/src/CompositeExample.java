public class CompositeExample {
    public static void main(String[] args) {
        Cat c1 = new Cat();
        Cat c2 = new Cat();
        Cat c3 = new Cat();

        CompositeAnimal com1 = new CompositeAnimal();
        CompositeAnimal com2 = new CompositeAnimal();
        CompositeAnimal allCom = new CompositeAnimal();

        com1.add(c1);
        com1.add(c2);

        com2.add(c3);

        allCom.add(com1);
        allCom.add(com2);

        allCom.voice();
    }
}
