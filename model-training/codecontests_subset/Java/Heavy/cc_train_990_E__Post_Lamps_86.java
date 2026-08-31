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
        for (int i = 0; i < m; i++)
        {
            int j = Integer.parseInt(sc.next());
            back[j + 1] = back[j] - 1;
        }

        long min = Long.MAX_VALUE;
        next_power:
        for (int p = 1; p <= k; p++)
        {
            int a = Integer.parseInt(sc.next());
            int count = 0;
            int last = -1;
            int light = 0;
            while (light < n)
            {
                int next = back[light + 1] + light;
                if (next <= last)
                    continue next_power;
                light = next + p;
                count++;
                last = next;
            }
            min = Math.min((long) a * count, min);
        }
        if (min == Long.MAX_VALUE)
            min = -1;
        System.out.println(min);
    }
}
