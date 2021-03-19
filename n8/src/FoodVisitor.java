public class FoodVisitor implements Visitor{
    @Override
    public void visit(Snake s) {
        s.setFood("Hamster");
    }

    @Override
    public void visit(Hamster h) {
        h.setFood("Apple");
    }
}
