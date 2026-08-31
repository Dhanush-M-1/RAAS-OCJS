import java.util.*;
import java.io.*;
import java.awt.*;

public class ModuloEquality {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] b = new int[n];
        st = new StringTokenizer(f.readLine());
        for (int i=0; i<n; i++)
        {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(f.readLine());
        for (int i=0; i<n; i++)
        {
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        Arrays.sort(b);
        for (int i=0; i<n; i++)
        {
            int x = b[0]-a[i];
            boolean y = false;
            for (int j=0; j<n; j++)
            {
                if ((a[(j+i)%n]+x+m)%m!=b[j])
                {
                    y = true;
                }
            }
            if (!y)
            {
                System.out.println((x+m)%m);
                System.exit(0);
            }
        }
    }
}
