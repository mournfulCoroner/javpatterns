
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*Сортировка по сумме веса и возраста, фильтрация по весу кратно 5,
        выбор первых четырёх элементов, конкатенация имён через пробел.*/
public class Main {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human(15, "Fay", "Lennon", LocalDate.of(1998, 4, 23), 45));
        list.add(new Human(23, "Elis", "McCyor", LocalDate.now(), 54));
        list.add(new Human(45, "Leroy", "Mell", LocalDate.of(1800, 12, 3), 68));
        list.add(new Human(13, "Molly", "cheesecake", LocalDate.of(2566, 8, 7), 5));
        list.add(new Human(16, "Dolly", "cheesecake", LocalDate.of(2561, 1, 6), 15));
        list.add(new Human(13, "Polly", "cheesecake", LocalDate.of(2124, 12, 8), 15));
        list.add(new Human(6, "Leo", "Cheesecake", LocalDate.of(1234, 7, 15), 35));
        Stream<Human> stream = list.stream();

//        Вывод списка после каждого этапа

        Supplier<Stream<Human>> sup = () -> list.stream().sorted(Comparator.comparingInt(Human::getAgeWeightSum));
        System.out.println("After sorted:");
        sup.get().forEach(System.out::print);
        System.out.println("After filter:");
        sup.get().filter(w->w.getWeight()%5==0)
                .forEach(System.out::print);
        System.out.println("After limit:");
        sup.get().limit(4)
                .forEach(System.out::print);

//        Обычный порядок работы с потоком
        System.out.println("Result:");
        String res = stream.sorted(Comparator.comparingInt(Human::getAgeWeightSum))
                .filter(w->w.getWeight()%5==0)
                .limit(4)
                .reduce("", (x, y) -> y.getFirstName() + " " + y.getLastName() + " " + x, (x, y)->x+" "+y);
        System.out.println(res);
    }
}
