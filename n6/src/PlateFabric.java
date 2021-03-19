public class PlateFabric extends Fabric{
    @Override
    public Dishes getDish(DishType type) {
        switch (type) {
            case PLATE:
                return new Plate();
            case PIALA:
                return new Plate();
            default:
                return null;
        }
    }
}
