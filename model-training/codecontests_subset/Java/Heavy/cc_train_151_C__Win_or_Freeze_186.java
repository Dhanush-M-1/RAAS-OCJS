import java.util.Scanner;


public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong();
        int cnt = 0;
        long first = 1;
        for (long i = 2; i*i <= q; i++) {
            while (q % i==0) {
                cnt++;
                q /= i;
                if (cnt <= 2)
                    first *= i;
            }
        }
        if (q > 1) {
            cnt++;
            if (cnt <= 2)
                first *= q;
        }
        if (cnt==2)
            System.out.println(2);
        else {
            System.out.println(1);
            if (cnt<=1)
                System.out.println(0);
            else
                System.out.println(first);
        }
    }
}