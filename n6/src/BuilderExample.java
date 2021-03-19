public class BuilderExample {
    public static void main(String[] args) {
        Director consultant = new Director();
        DishBuilder db = new ModernPlateBuilder();
        consultant.setDishBuilder(db);
        consultant.constructPlate();
        Plate plate = consultant.getPlate();
        System.out.println(plate);
    }
}
