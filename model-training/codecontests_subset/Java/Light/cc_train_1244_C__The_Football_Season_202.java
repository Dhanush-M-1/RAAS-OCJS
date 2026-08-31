import java.util.Scanner;

public class Z1244CodeForces {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);

        long n = in.nextLong();
        long ps = in.nextLong();
        long w = in.nextLong();
        long d =in.nextLong();

        long p = ps % w;
        long g = gcd(d,w);

        if(p%g != 0) {
            System.out.println(-1);
            return;
        }

        long d1 = d/g;
        long w1 = w/g;
        long p1 = p/g;

        long y1 = (p1 * opposite(d1,w1))%w1;

        if(ps < y1 * d){
            System.out.println(-1);
            return;
        }

        long x = (ps-y1*d)/w;

        if (x + y1 > n) {
            System.out.println(-1);
            return;
        }
        System.out.print(x + " " + y1 + " " + (n - x - y1));
      // 100 148 52 12
    }
    public static long gcd(long a,long b) {
        while (b !=0) {
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
    public static long opposite(long d, long w){
        long A1 = w;
        long B1 = d;
        long A2 = 0l;
        long B2 = 1l;
        while (B1>1){
            long k = A1 / B1;
            long C1 = A1 - k*B1;
            A1 = B1;
            B1 = C1;

            long C2 = A2-k*B2;
            A2 = B2;
            B2 = C2;
        }
        if (B2 < 0) B2 = (B2%w + w)%w;
        return B2;
    }
}
