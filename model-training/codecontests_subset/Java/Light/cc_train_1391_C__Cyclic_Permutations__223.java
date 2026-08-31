import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
        
            long n = scan.nextLong();
            int mod = (int) 1e9+7;
            long fact = findFact(n);
            long pow = findPow(n - 1);
            long ans = (fact - pow + mod) % mod;
            System.out.println(ans);
    }
    
    static long findFact(long n) {
        int mod = (int) 1e9+7;
        long fact = 1;
        for(int i = 2; i <= n; i++) {
            fact = (fact*i) % mod;
        }
        
        return fact;
    }
    
    static long findPow(long n) {
        int mod = (int) 1e9+7;
        long res = 1;
        while(n != 0) {
            res = (res*2 % mod);
            n--;
        }
        
        return res;
    }
}

/*
    int n = scan.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
    
    long n = scan.nextLong();
            long[] arr = new long[n];
            for(int = 0; i < n; i++) {
                arr[i] = scan.nextLong();
            }
    
*/ 