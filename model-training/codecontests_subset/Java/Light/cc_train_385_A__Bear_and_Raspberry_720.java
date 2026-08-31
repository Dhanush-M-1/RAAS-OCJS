import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int ans = 0;
        for(int i=0;i<n;i++)
            a[i] = in.nextInt();
        for(int i=0;i<n-1;i++)
            ans = Math.max(ans,a[i] - a[i+1] - k);
        System.out.println(ans);
    }
}
