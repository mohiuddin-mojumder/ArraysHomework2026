import java.util.Scanner;

public class Task2ResidentsOnStreet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] residents = new int[n];

        for (int i = 0; i < n; i++) {
            residents[i] = sc.nextInt();
        }

        int total = 0;
        int left = 0;
        int right = 0;
        int leftHouses = 0;
        int rightHouses = 0;

        for (int i = 0; i < n; i++) {
            total += residents[i];

            if ((i + 1) % 2 == 1) {
                left += residents[i];
                leftHouses++;
            } else {
                right += residents[i];
                rightHouses++;
            }
        }

        System.out.println("Total residents: " + total);
        System.out.println("Residents on the left: " + left);
        System.out.println("Residents on the right: " + right);

        if (leftHouses > 0) {
            double avg = (double) left / leftHouses;
            System.out.println(
                    "Average per house on the left: " +
                            (avg == Math.floor(avg)
                                    ? String.valueOf((long) avg)
                                    : String.valueOf(avg))
            );
        } else {
            System.out.println(
                    "Average per house on the left: N/A");
        }

        if (rightHouses > 0) {
            double avg = (double) right / rightHouses;
            System.out.println(
                    "Average per house on the right: " +
                            (avg == Math.floor(avg)
                                    ? String.valueOf((long) avg)
                                    : String.valueOf(avg))
            );
        } else {
            System.out.println(
                    "Average per house on the right: N/A");
        }

        sc.close();
    }
}