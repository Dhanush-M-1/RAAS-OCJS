

import java.util.*;
import java.text.*;
import java.math.*;


public class Main{
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

            int n = scan.nextInt();
            long[] fact = new long[n+1];
            fact(fact);
            long solution2n = 1;
            int solution = 1;
            for(int i=0;i<n-1;i++){
                solution *= 2;
                solution %= mod;
            }
            solution2n = fact[n];
            solution2n %= mod;
            solution %= mod;
        //System.out.println(solution2n);

            if(solution2n >= solution) {
                System.out.println(solution2n - solution);
            }
            else{
                //System.out.println(solution2n - solution);
                System.out.println( mod + (solution2n - solution));
            }

    }


    static void fact(long[] f)
    {
        f[1] = 1;
        for(int i=1;i<f.length;i++){
            f[i] = i;
        }
        for(int i=2;i<f.length;i++){
            f[i] = f[i] * f[i-1];
            f[i] %= mod;
            //System.out.print(f[i]+" ");
        }
        //System.out.println();
    }


}