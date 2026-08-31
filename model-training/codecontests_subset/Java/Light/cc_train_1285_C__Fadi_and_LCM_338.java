import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();

        for (long i = (int)Math.floor(Math.sqrt(x)); i > 0; i--) {
            if(x % i != 0) {
                continue;
            }
            long ggt = getGGT(i, x/i);
            if(ggt == 1) {
                System.out.println(i + " " + x/i);
                return;
            }
        }
    }

    private static long getGGT(long a, long b) {
        while(a % b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }

        return b;
    }

}