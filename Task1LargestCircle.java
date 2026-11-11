import java.util.Scanner;

public class Task1LargestCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] radius = new int[n];

        for (int i = 0; i < n; i++) {
            radius[i] = sc.nextInt();
        }

        int largest = radius[0];
        int count = 0;

        for (int r : radius) {
            if (r > largest) {
                largest = r;
            }
        }

        for (int r : radius) {
            if (r == largest) {
                count++;
            }
        }

        System.out.println(largest + " - " + count);

        sc.close();
    }
}