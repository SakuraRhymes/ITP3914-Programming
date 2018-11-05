package Lab12;

public class TestEmployee {
    public static void main(String[] args) {
        Employee emp1 = new Employee("CHAN Tai Man", 12000);
        Employee emp2 = new Employee("TAM Ping Shing", 13500);

        System.out.print("Employee 1: ");
        emp1.displayDetails();
        System.out.print("Employee 2: ");
        emp2.displayDetails();

        emp1.raiseSalary(0.05);
        emp2.raiseSalary(0.1);

        System.out.print("Employee 1: ");
        emp1.displayDetails();
        System.out.print("Employee 2: ");
        emp2.displayDetails();
    }
}