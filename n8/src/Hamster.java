public class Hamster extends Animal2{
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
}
