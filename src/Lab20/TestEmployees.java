package Lab20;

public class TestEmployees {
    public static void main(String[] args) {
        Employee Sam = new Employee("Sam", 111, 30000);
        PartTimer Ray = new PartTimer("Ray", 222, 30, 300);
        NewPartTimer June = new NewPartTimer("June", 333, 40, 100, 5.0);
        NewPartTimer May = new NewPartTimer("May", 444, 100, 100, 5.0);

        System.out.println(Sam);
        System.out.println(Ray);
        System.out.println(June);
        System.out.println(May);
    }
}