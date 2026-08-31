import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long n = in.nextLong();
        long constant = 1000000007;
        long fact = 1;
        for(int i = 2; i <= n; i++)
        {
            fact *= i;
            fact %= constant;
        }
        long temp = 1;
        for(int i = 0; i < n - 1; i++)
        {
            temp *= 2;
            temp %= constant;
        }
        long ans = fact - temp;
        ans %= constant;
        if(ans < 0)
        {
            ans += constant;
        }
        out.println(ans);
        out.close();
    }
}



