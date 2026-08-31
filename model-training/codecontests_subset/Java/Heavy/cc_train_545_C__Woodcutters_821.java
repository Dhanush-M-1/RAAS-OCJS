import java.util.*;
import java.io.*;

public  class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int h[] = new int[n + 1];
        int x[] = new int[n + 1];
        int f[] = new int[n + 1];
        
        for (int i = 0; i < n; ++i) {
            x[i] = input.nextInt();
            h[i] = input.nextInt();
        }

        x[n] = Integer.MAX_VALUE;
        f[0] = 1;
        int res = 1;
        
        for (int i = 1; i < n; ++i) {
            if (f[i - 1] == 2 && h[i] + h[i - 1] < x[i] - x[i - 1]) {
                f[i] = 1;
                ++res;
            }
            else if (f[i - 1] != 2 && x[i] - h[i] > x[i-1]) {
                f[i] = 1;
                ++res;
            }
            else if (x[i] + h[i] < x[i + 1]) {
                f[i] = 2;
                ++res;
            }
        }

        System.out.println(res);
    }
}