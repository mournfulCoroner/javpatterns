public class Dog extends Animal{

    @Override
    protected void voice() {
        System.out.println("Гаф");
    }

    @Override
    protected void move() {
        System.out.println("Топ-топ");
    }
}
