public class PlateFabric2 implements AbstractFabric{
    @Override
    public Dishes createDish() {
        return new Plate();
    }
}
