import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int help(int k, int l, int r){
        return (int)Math.floor((r - k) / 3.0) - (int)Math.ceil((l - k) / 3.0) + 1;
    }

    public static void main(String[] args) throws IOException {
        /*Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int l1, r1, l2, r2;
            l1 = scanner.nextInt();
            r1 = scanner.nextInt();
            l2 = scanner.nextInt();
            r2 = scanner.nextInt();
            int left = Math.min(l1, l2);
            int right = Math.max(r1, r2);
            System.out.println(left + " " + right);
        }*/

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        for(int i = 0; i < q; i++){
            int l, r, d;
            l =  scanner.nextInt();
            r =  scanner.nextInt();
            d =  scanner.nextInt();
            int ans = (int)(Math.ceil((r + 1) * 1.0 / d) * d);
            if(d < l)ans = Math.min(ans, d);
            System.out.println(ans);
        }
    }
}
