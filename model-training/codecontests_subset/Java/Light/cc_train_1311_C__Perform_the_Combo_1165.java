import java.util.*;

public class Main {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- > 0)
        {
            int n = sc.nextInt(), m = sc.nextInt();
            String s = sc.next();
            int c[] = new int[n + 3];
            int d[] = new int[300];
            for(int i = 1; i <= m; i ++)
            {
                int x = sc.nextInt();
                c[x] ++;
            }
            c[n + 1] = 1;
            for(int i = n; i >= 1; i --)
                   c[i] = c[i + 1] + c[i];
            for(int i = 0; i < n; i ++)
            {
                d[s.charAt(i) - 'a'] += c[i + 1];
            }
            for(int i = 0; i < 26; i ++)
                   System.out.print(d[i] + " ");
            System.out.println();
        }
    }
}
