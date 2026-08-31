import java.util.*;
import java.io.*;
public final class Codechef {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            int n = sc.nextInt();
            int x = 0;
            int y = Integer.MAX_VALUE;
            for(int i = 0; i<n; i++) {
                x = Math.max(x, sc.nextInt());
                y = Math.min(y, sc.nextInt());
            }
            System.out.println(Math.max(x-y, 0));
        }
    }
}