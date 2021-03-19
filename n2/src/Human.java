import java.time.LocalDate;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int weight;

    public Human(int age, String firstName, String lastName, LocalDate birthDate, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getWeight() {
        return weight;
    }

    public int getAgeWeightSum(){
        return age+weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", weight=" + weight +
                "}\n";
    }
}
