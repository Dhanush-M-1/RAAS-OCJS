import java.util.*;

public class Main {

    public static long GCD(long a, long b) {
        if (b % a == 0)
            return a;
        return GCD(b, a % b);
    }

    public static long LCM(long a, long b) {
        return (a * b) / GCD(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long x = scanner.nextLong();
        long pembagi = 0;

        for (long i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                if (LCM(i, x / i) == x) {
                    pembagi = i;
                }
            }
        }

        System.out.println(pembagi + " " + x / pembagi);
    }
}

					 		 	 	 	    			 			 	 		