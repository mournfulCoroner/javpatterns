public class VisitorExample {
    public static void main(String[] args) {
        Animal2 snake = new Snake();
        Animal2 hamster = new Hamster();
        Visitor v = new FoodVisitor();
        snake.accept(v);
        hamster.accept(v);
        System.out.println(snake.getFood());
        System.out.println(hamster.getFood());
    }
}
