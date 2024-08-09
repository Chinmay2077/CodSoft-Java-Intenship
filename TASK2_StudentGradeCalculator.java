import java.util.Scanner;

public class TASK2_StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = sc.nextInt();

       StudentGradeCalculator(numOfSubjects,sc);
       sc.close();
    }

    private static void StudentGradeCalculator(int numOfSubjects, Scanner sc) {
        int TotalMarks = 0;
        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + ": ");
            int marks = sc.nextInt();
            TotalMarks += marks;
        }

        double AvgPercentage = (double) TotalMarks / numOfSubjects;

        char grade;
        if (AvgPercentage >= 90) {
            grade = 'A';
        } else if (AvgPercentage >= 80) {
            grade = 'B';
        } else if (AvgPercentage >= 70) {
            grade = 'C';
        } else if (AvgPercentage >= 60) {
            grade = 'D';
        } else if (AvgPercentage >= 50) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        System.out.println("\nTotal Marks: " + TotalMarks);
        System.out.println("Aggregate Percentage: " + AvgPercentage + "%");
        System.out.println("Grade: " + grade);


    }
}