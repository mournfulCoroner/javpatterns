//без ленивой инициализации, с использованием статического инициализатора
public class Singleton1 {
    public static Singleton1 instance;

    static {
        instance = new Singleton1();
    }

    private Singleton1() {}

    public static Singleton1 getInstance(){
        return instance;
    }
}
