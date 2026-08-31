import java.util.Scanner;

public class C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long p = sc.nextLong();
        int w = sc.nextInt();
        int d = sc.nextInt();

        if (p == 0) {
            System.out.println(0 + " " + 0 + " " + n);
            System.exit(0);
        }

        long high = p / w;
        if(high > n){
            System.out.println(-1);
            System.exit(0);
        }

        long low = (p - n*d)/w;
        if(low < 0)
            low = 0;
        long i = 0;
        long mod = p%w;
        while(i <= w){
            long temp = w * i + mod;
            if(temp % d == 0){
                long dr = temp/d;
                long win = (p - temp)/w;
                long l = n - dr - win;
                if(l >= 0 && win >= low && win <= high){
                    System.out.println(win + " " + dr + " " + l);
                    System.exit(0);
                }
            }
            ++i;
        }
        System.out.println(-1);
    }
}

