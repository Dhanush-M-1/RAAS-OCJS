import java.util.Scanner;

public class Matches {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] homeForms = new int[n], guestForms = new int[n];

        for (int index = 0; index < n; index++) {
            homeForms[index] = scanner.nextInt();
            guestForms[index] = scanner.nextInt();
        }

        int result = 0;

        for (int homeIndex = 0; homeIndex < n; homeIndex++) {
            int homeForm = homeForms[homeIndex];

            for (int guestIndex = 0; guestIndex < n; guestIndex++) {
                if (homeIndex != guestIndex && homeForm == guestForms[guestIndex]) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }

}