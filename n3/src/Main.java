import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeList<Integer> sl = new SafeList<>(5);
        SafeSet<Integer> ss = new SafeSet<>(5);
        ArrayList<Integer> arrayList = new ArrayList<>();

        Runnable runnable = () -> {
            for(int i = 0; i < 6000; i++){
                sl.add(i);
                ss.add(i);
                arrayList.add(i);
            }
        };
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        t3.start();
        t4.start();
        Thread.sleep(1000);
        System.out.println(sl.size() + " " + ss.size() + " " + arrayList.size());
    }
}
