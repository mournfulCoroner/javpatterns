public class Cat extends Animal{
    @Override
    protected void voice() {
        System.out.println("Мявк");
    }

    @Override
    protected void move() {
        System.out.println("Крадь-крадь");
    }
}
