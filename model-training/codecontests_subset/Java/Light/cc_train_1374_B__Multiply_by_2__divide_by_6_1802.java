import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {

            long n = sc.nextLong();

            int twos = 0;
            int threes = 0;

            if (n == 1) {
                System.out.println(0);
            } else if (n == 2) {
                System.out.println(-1);
            } else {
                while (n % 2 == 0) {
                    twos++;
                    n = n / 2;
                }
                while (n % 3 == 0) {
                    threes++;
                    n = n / 3;
                }

                if (n != 1 || threes < twos) {
                    System.out.println(-1);
                } else {
                    if (threes == twos) {
                        System.out.println(threes);
                    } else {
                        System.out.println(threes + (threes - twos));
                    }
                }
            }
        }
    }

}
