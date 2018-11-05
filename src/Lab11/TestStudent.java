package Lab11;

public class TestStudent {
    public static void main(String[] args) {
        Student stud1 = new Student();
        Student stud2 = new Student();
        Student stud3 = new Student();

        stud1.setName("Cheung Siu Ming");
        stud1.setId(310567);
        stud1.setScore(87.1);

        stud2.setName("Ng Wai Man");
        stud2.setId(451267);
        stud2.setScore(77.5);

        stud3.setName("Wong Sui Kai");
        stud3.setId(789014);
        stud3.setScore(83.4);

        System.out.println("Student1: name=" + stud1.getName() + " id=" + stud1.getId() + " score=" + stud1.getScore());
        System.out.println("Student2: name=" + stud2.getName() + " id=" + stud2.getId() + " score=" + stud2.getScore());
        System.out.println("Student3: name=" + stud3.getName() + " id=" + stud3.getId() + " score=" + stud3.getScore());
        System.out.println("\nAverage Score = " + ((stud1.getScore() + stud2.getScore() + stud3.getScore()) / 3));
    }
}