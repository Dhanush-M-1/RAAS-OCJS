import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int twos = 0;
            int threes = 0;
            while (n % 2 == 0) {
                twos++;
                n /= 2;
            }
            while (n % 3 == 0) {
                threes++;
                n /= 3;
            }

            if (n != 1) {
                System.out.println(-1);
            }
            else if (twos > threes) {
                System.out.println(-1);
            }
            else {
                System.out.println(threes + (threes - twos));
            }
        }
    }
}