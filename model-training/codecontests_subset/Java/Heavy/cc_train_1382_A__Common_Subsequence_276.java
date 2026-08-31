
import java.util.*;
import java.io.*;
import java.math.*;

public class A {

    static Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws Exception {


       int q = sc.nextInt();
       while(q-- > 0) {

            int n = sc.nextInt();
            int m = sc.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> al = new ArrayList<>();

            for(int i = 0; i < n; ++i) {
                int x = sc.nextInt();
                a.add(x);
            } 

            for(int i = 0; i < m; ++i)
            {
                int x = sc.nextInt();
                if(a.contains(x) && al.size() == 0) 
                {
                    al.add(x);
                }
            }

            if(al.size() == 0)
                out.println("NO");
            else {
                out.print("YES\n" + al.size());
                for(int x : al)
                    out.print(" " + x);
                out.println();
            }

            

            //out.println(count);
       }

        out.flush();
        out.close();
        sc.close();
    }

    static final int MOD = (int) 1e9 + 7;
    static final double PI = 3.14159265358979323846;

    // takes array input
    public static int[] init(int n) {

        int[] arr = new int[n];

        for (int i = 0; i < n; ++i)
            arr[i] = sc.nextInt();

        return arr;
    }

    // finds GCD of two number
    public static int gcd(int a, int b) {

        if (a == 0) {
            return b;
        }

        return gcd(b % a, a);
    }

    // checks whether a number is prime or not
    public static boolean prime(int n) {

        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; ++i)
            if (n % i == 0)
                return false;

        return true;
    }
}
