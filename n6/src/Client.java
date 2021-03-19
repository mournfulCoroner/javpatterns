public class Client {
    public static void main(String[] args) {
        AbstractFabric fabric;
        fabric = new PlateFabric2();
        fabric.createDish(); //создает тарелку
    }
}
