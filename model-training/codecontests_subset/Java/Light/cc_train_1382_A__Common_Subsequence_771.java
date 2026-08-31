import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; ++i) {
                a[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; ++i) {
                b[i] = scanner.nextInt();
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i=0;i<n;++i)
            {
                set.add(a[i]);
            }
            boolean flag=false;
            for (int i=0;i<m;++i)
            {
                if (set.contains(b[i]))
                {
                    System.out.println("YES");
                    System.out.println(1+" "+b[i]);
                    flag=true;
                    break;
                }
            }
            if (!flag)
                System.out.println("NO");
        }
    }
}

