/*
    @Author: Zhiyi Li
    @Date: 2020.01.11
*/
import java.util.*;
public class ProblemC {
    public static void main(String[] argc)
    {
        Scanner sc = new Scanner(System.in);
        long X;
        X = sc.nextLong();
        long a, b;
        a = 0;
        b = 0;
        Map<Long, long[]> map = new HashMap<>();
        long max_v = X + 1;
       for(long i = 1; i*i <= X; i++)
       {
           a = i;
           if(X % a == 0)
           {
               b = X/a;
               if(lcm(a,b) == X)
               {
                   long local_v = Math.max(a, b);
                   if(local_v < max_v)
                   {
                       max_v = local_v;
                       map.put(max_v, new long[]{a, b});
                   }
               }
           }
       }
       System.out.println(map.get(max_v)[0] + " " + map.get(max_v)[1]);
    }

    public static long gcd(long a, long b)
    {
        return a%b == 0? b: gcd(b, a%b);
    }

    public static long lcm(long a, long b)
    {
        return a*b/gcd(a, b);
    }
}
