import java.util.Scanner;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Task3StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int subjects = sc.nextInt();
        int students = sc.nextInt();

        int[][] grades = new int[students][subjects];

        for (int i = 0; i < students; i++) {
            for (int j = 0; j < subjects; j++) {
                grades[i][j] = sc.nextInt();
            }
        }

        int[] sums = new int[students];
        double total = 0;
        int highestSum = Integer.MIN_VALUE;
        boolean[] belowFive = new boolean[students];

        for (int i = 0; i < students; i++) {
            for (int grade : grades[i]) {
                sums[i] += grade;

                if (grade < 5) {
                    belowFive[i] = true;
                }
            }

            total += sums[i];

            if (sums[i] > highestSum) {
                highestSum = sums[i];
            }
        }

        DecimalFormat df = new DecimalFormat(
                "0.##########",
                DecimalFormatSymbols.getInstance(Locale.US)
        );

        System.out.println("Student averages:");
        for (int i = 0; i < students; i++) {
            System.out.println(
                    df.format((double) sums[i] / subjects)
            );
        }

        System.out.println();
        System.out.println("Group average:");
        System.out.println(
                df.format(total / (students * subjects))
        );

        System.out.println();
        System.out.println("Highest-performing student:");
        for (int i = 0; i < students; i++) {
            if (sums[i] == highestSum) {
                System.out.println(i + 1);
            }
        }

        System.out.println();
        System.out.println(
                "Students with at least one grade below 5:"
        );

        boolean found = false;

        for (int i = 0; i < students; i++) {
            if (belowFive[i]) {
                System.out.println(i + 1);
                found = true;
            }
        }

        if (!found) {
            System.out.println("None");
        }

        sc.close();
    }
}