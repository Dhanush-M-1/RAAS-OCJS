import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n, m;
        n = in.nextInt();
        m = in.nextInt();
        int l[] = new int[m];
        int r[] = new int[m];
        int f[] = new int[m];
        int d[] = new int[m];
        long first[] = new long[n];
        long second[] = new long[n];
        for (int i = 0; i < n; ++i)
            first[i] = 10000000000000L;   
        for (int i = 0; i < m; ++i) {
            f[i] = in.nextInt();
            l[i] = in.nextInt();
            r[i] = in.nextInt();
            d[i] = in.nextInt();
            --l[i];
            --r[i];
        }
        for (int i = m - 1; i >= 0; --i) {
            if (f[i] == 2) {
                for (int j = l[i]; j <= r[i]; ++j)
                    if (first[j] > d[i]) first[j] = d[i];
            }
            else {
                for (int k = l[i]; k <= r[i]; ++k)
                    first[k] -= d[i];  
            }
        }
        boolean flag = false;
        for (int i = 0; i < n; ++i)
            if (first[i] > 1000000000)
                first[i] = 1000000000;
        for (int i = 0; i < n; ++i)
            second[i] = first[i];
        for (int i = 0; i < m; ++i) {
            if (f[i] == 2) {
                long max = second[l[i]];
                for (int j = l[i] + 1; j <= r[i]; ++j)
                    if (max < second[j]) 
                        max = second[j];
                if (max != d[i]) {                        
                    flag = true;
                    break;
                }
            } else
                for (int j = l[i]; j <= r[i]; ++j)
                    second[j] += d[i];              
        }
        if (flag)
                System.out.println("NO");
        else {
                System.out.println("YES");
                for (int i = 0; i < n; ++i)
                    System.out.print(first[i] + " ");
        }
    }
}
