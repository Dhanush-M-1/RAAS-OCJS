import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
       // int sum = 0;
        int C100 = 0, C200 = 0;

        for (int i = 0; i < n; i++) {

            int[] a = new int[n];

            a[i] = in.nextInt();

            if (a[i] == 100) {

                C100++;

            }
            if (a[i] == 200) {

                C200++;

            }
            // sum += a[i];

        }

        if (n % 2 != 0 && C100 == n) {

            System.out.println("NO");

        } else if (n % 2 != 0 && C200 == n) {

            System.out.println("NO");

        } else if (n % 2 == 0 && C100 == n || C200 == n) {

            System.out.println("YES");

        } else if (n % 2 != 0 && (n - C100) % 2 != 0 || (n - C200) % 2 == 0) {

            System.out.println("YES");

        } else if (n % 2 == 0 && (n - C100) % 2 == 0 || (n - C200) % 2 == 0) {

            System.out.println("YES");

        } else {

            System.out.println("NO");
        }
    }

}
