import java.io.*;
import java.util.*;

public class FoxDividingCheese {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = {2,3,5};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int c1 = 0;
            while (a % arr[i] == 0) {
                a /= arr[i];
                c1++;
            }
            int c2 = 0;
            while (b % arr[i] == 0) {
                b /= arr[i];
                c2++;
            }
            sum += Math.max(c1,c2) - Math.min(c1,c2);
        }
        if (a == b)
            System.out.println(sum);
        else
            System.out.println(-1);
    }
}
