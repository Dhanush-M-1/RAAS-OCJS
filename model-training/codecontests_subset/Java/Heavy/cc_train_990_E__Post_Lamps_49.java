import java.util.Arrays;
import java.util.Scanner;

public class E
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] back = new int[n + 1];
        int minback= 0;
        for (int i = 0; i < m; i++)
        {
            int j = Integer.parseInt(sc.next());
            minback = Math.min(
                    back[j + 1] = back[j] - 1,
                    minback
            );
        }

        long min = Long.MAX_VALUE;
        int p = 1-minback;
        while(minback++ < 0)
            sc.next();
        next_power:
        for ( ; p <= k; p++)
        {
//            System.out.println();
            int a = Integer.parseInt(sc.next());
            int count = 0;
            int last = -1;
            int light = 0;
            while (light < n)
            {
//                light = last + p;
//                System.out.println(light);
                int next = back[light+1] + light;
                if(next <= last)
                    continue next_power;
                light = next + p;
                count++;
                last = next;
            }
//            System.out.println(count);
            min = Math.min((long) a * count, min);
        }
        if (min == Long.MAX_VALUE)
            min = -1;
        System.out.println(min);
    }
}
