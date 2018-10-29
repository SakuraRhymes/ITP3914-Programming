package Lab6;

import java.util.*;

public class ExamGrade {
    public static void main(String[] args) {
        double examMark;
        char grade;
        Scanner input = new Scanner(System.in);

        System.out.print("Exam mark? ");
        examMark = input.nextDouble();

        if (examMark < 60)
            grade = 'F';
        else if (examMark < 70)
            grade = 'D';
        else if (examMark < 80)
            grade = 'C';
        else if (examMark < 90)
            grade = 'B';
        else
            grade = 'A';

        System.out.print("Grade = " + grade);
    }
}