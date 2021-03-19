//через метод getInstance() с ленивой инициализацией
public class Singleton2 {
    private Singleton2 instance;
    public synchronized Singleton2 getInstance(){
        if(instance == null){
            instance = new Singleton2();
            return instance;
        }
        return instance;
    }
}
