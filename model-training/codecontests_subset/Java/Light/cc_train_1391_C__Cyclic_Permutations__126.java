import java.util.*;

public class file {

    private static final Scanner scn = new Scanner(System.in);
    private static ArrayList<Integer>[] G;
    private static boolean[] marked;
    private static final int MOD = 1000000007;

    public static void foo(int cas){
        int n = scn.nextInt();
        long res = 1;
        long fact = 1;
        for (int i = 1; i <= n-1; i++) {
                fact *= i;
                res *= 2;
                fact %= MOD;
                res %= MOD;
        }
        fact *= n;
        fact %= MOD;
        fact -= res;
        fact %= MOD;
        if (fact < 0) fact += MOD;
        System.out.println(fact);
    }
        
    
  
    public static void main(String[] args) {
        //int t = scn.nextInt();
        int t = 1;
        for (int i = 0; i < t; i++) foo(i);
    }


}
