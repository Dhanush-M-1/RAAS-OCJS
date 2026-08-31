import java.util.*;
import java.io.*;
import java.math.*;

public class Main {

    static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int n = input.nextInt();
        int k = input.nextInt();
        int p = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = input.nextInt();
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = input.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int minActs = Integer.MAX_VALUE;
        for (int i = 0; i <= k - n; i++) {
            int maxActs = 0;
            int acts;
            for (int j = 0; j < n; j++) {
                acts = Math.abs(b[i + j] - a[j]) + Math.abs(b[i + j] - p);
                if (acts > maxActs) {
                    maxActs = acts;
                }
            }
            if (minActs > maxActs) {
                minActs = maxActs;
            }
        }
        System.out.println(minActs);
    }
}