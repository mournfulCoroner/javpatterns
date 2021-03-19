import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        OwnExecutorService serv = new OwnExecutorService(3);
        serv.execute(() -> {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Кря");
        });
        Future future = serv.submit(new Callable() {
            public Object call() {
                System.out.println("Гаф");
                return "Серединка";
            }
        });
        serv.execute(() -> System.out.println("Мяу"));
        System.out.println(future.get());
    }
}
