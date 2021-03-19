public class ModernPlateBuilder extends DishBuilder{
    @Override
    public void buildOrnament() {
        plate.setOrnament("Dots");
    }

    @Override
    public void buildForm() {
        plate.setForm("Square");
    }
}
