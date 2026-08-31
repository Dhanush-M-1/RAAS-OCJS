import java.util.Scanner;

public class A235 {

    static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a%b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long N = in.nextLong();
        long answer;
        if (N <= 2) {
            answer = N;
        } else if (N%2 == 1) {
            answer = N*(N-1)*(N-2);
        } else {
            answer = (N-1)*(N-2)*(N-3);
            for (long b=N-1; N*b*(b-1) > answer; b--) {
                if (gcd(N, b) != 1) continue;
                long ab = N*b;
                for (long c=b-1; N*b*c > answer; c--) {
                    if (gcd(ab,c) != 1) continue;
                    answer = N*b*c;
                }
            }
        }
        System.out.println(answer);
    }

}
