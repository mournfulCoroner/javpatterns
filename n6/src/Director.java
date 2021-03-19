public class Director {
    private DishBuilder dishBuilder;

    public void setDishBuilder(DishBuilder db){ dishBuilder = db; }
    public Plate getPlate() { return dishBuilder.getPlate();}
    public void constructPlate(){
        dishBuilder.createNewDish();
        dishBuilder.buildForm();
        dishBuilder.buildOrnament();
    }
}
