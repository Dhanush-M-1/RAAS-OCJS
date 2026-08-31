import java.util.Scanner;

public class A_Stones {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int s = 0;

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int minB = Math.min(b, c/2);

            b -= minB;
            s += minB;

            int minA = Math.min(a, b/2);

            s += minA;

            System.out.println(s * 3);
        }
    }
}
