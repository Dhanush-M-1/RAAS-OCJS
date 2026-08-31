import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        int test = s.nextInt();
//        for (int t = 0; t < test; t++) {
            long n = s.nextInt();
            long fact = 1;
            long mod = (long)(1E9 + 7);
            for (int i = 1; i <= n; i++) {
                fact *= i;
                fact %= mod;
            }
            long two = 1;
            for (int i = 1; i <= n - 1; i++) {
                two *= 2;
                two %= mod;
            }
            fact -= two;
            if (fact < 0)
                fact += mod;
            System.out.println(fact);

//        }

    }
}

