public abstract class DishBuilder {
    protected Plate plate;
    public void createNewDish(){
        plate = new Plate();
    }
    public Plate getPlate(){ return plate; }

    public abstract void buildOrnament();
    public abstract void buildForm();
}
