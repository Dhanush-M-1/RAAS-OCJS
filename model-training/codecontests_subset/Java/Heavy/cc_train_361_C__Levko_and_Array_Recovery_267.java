import java.io.*;
import java.util.*;

public class LevkoAndArrayRecovery {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        int[][] a = new int[m][4];
        boolean[] b = new boolean[m];
        Arrays.fill(b, false);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(f.readLine());
            for (int j = 0; j < 4; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
            if (a[i][0] == 1)
                b[i] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            long x = Integer.MAX_VALUE*10000l;
            long sum = 0;
            for (int j = 0; j < m; j++) 
                if (a[j][1] <= i && i <= a[j][2])
                    if (a[j][0] == 1)
                        sum += a[j][3];
                    else 
                        if (a[j][3] - sum < x)
                            x = a[j][3] - sum;
            x = Math.min(x, 1000000000);
            sum = 0;
            for (int j = 0; j < m; j++)
                if (a[j][1] <= i && i <= a[j][2])
                    if (a[j][0] == 1)
                        sum += a[j][3];
                    else
                        if (x + sum == a[j][3])
                            b[j] = true;
            arr[i-1] = x;
        }
        
        boolean exist = true;
        for (int i = 0; i < m; i++)
            if (!b[i])
                exist = false;
        
        if (exist) {
            boolean exceed = false;
            for (int i = 0; i < n; i++)
                if (Math.abs(arr[i]) > 1000000000)
                    exceed = true;
            if (exceed)
                System.out.println("NO");
            else {
                System.out.println("YES");
                for (int i = 0; i < n; i++)
                    System.out.print(arr[i]+" ");
            }
        }
        else
            System.out.println("NO");
    }
}
