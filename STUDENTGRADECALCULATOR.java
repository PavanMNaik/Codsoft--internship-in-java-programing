import java.util.Scanner;

public class STUDENTGRADECALCULATOR
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();

        int totalMarks = 0;
        int[] marks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
            
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                i--; // To repeat the input for this subject
                continue;
            }
            
            totalMarks += marks[i];
        }

        double averagePercentage = (double) totalMarks / numberOfSubjects;
        
        String grade = getGrade(averagePercentage);

        System.out.println("\nTotal Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    private static String getGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
