public abstract class Animal {
    private int age;

    protected abstract void voice();
    protected abstract void move();

    public final void exist(int age){
        setAge(age);

        voice();
        move();
    }

    public void setAge(int age){
        this.age = age;
    }
}
