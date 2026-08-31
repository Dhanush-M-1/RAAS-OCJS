import java.util.Scanner;


public class C {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int min_n = Math.max(1, n - 100);
        
        long max_lcm = 0;
        for (int i = n; i >= min_n; --i)
            for (int j = n; j >= min_n; --j){
                long t = lcm(i, j);
                for (int k = n; k >= min_n; --k){
                    long t2 = lcm(t, k);
                    if (max_lcm < t2) max_lcm = t2;
                }
        }
        
        System.out.println(max_lcm);
    }
    
    static long gcd(long a, long b){
        if (b==0) return a; else return gcd(b, a % b);
    }
    
    static long lcm(long a, long b){
        return a / gcd(a,b) * b;
    }
}