public abstract class Fabric {
    public Dishes getDish(DishType type){
        switch (type) {
            case PLATE:
                return new Plate();
            case GLASS:
                return new Glass();
            case PIALA:
                return new Piala();
            default:
                return null;
        }
    };
}
