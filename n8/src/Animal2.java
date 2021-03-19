public abstract class Animal2 {
    public abstract void accept(Visitor v);
    private String food = "";

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
