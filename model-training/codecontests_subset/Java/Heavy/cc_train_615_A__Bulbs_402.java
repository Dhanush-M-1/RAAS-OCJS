import java.util.*;
public class Bulbs {
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean good = true;
        boolean[] s = new boolean[m];
        for(int i  =0; i < n; i++) {
            int p = scan.nextInt();
            for(int k = 0; k < p; k++) {
                int g = scan.nextInt() - 1;
                s[g] = true;
            }
        }
        for(int i = 0; i < m; i++) {
            if(s[i] == false) {
                good = false;
            }
        }
        System.out.println(good == false ? "NO" : "YES");
    }
 
}