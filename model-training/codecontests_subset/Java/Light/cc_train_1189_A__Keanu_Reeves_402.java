// https://codeforces.com/problemset/problem/1189/A
import java.util.Scanner;

public class p_52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();
        
        String t = sc.next();

        int ans = s / 2;
        int o = 0;
        int z = 0;
        for (int i = 0; i < s; i++) {
            if (t.charAt(i) == '0') {
                z++;
            } else {
                o++;
            }
        }

        if (z != o) {
            System.out.println(1);
            System.out.println(t);
            System.exit(0);
        }

        if (s == 1) {
            System.out.println(1);
            System.out.println(t);
            System.exit(0);
        }

        if (s % 2 != 0) {
            System.out.println(1);
            System.out.println(t);
        } else {
            System.out.println(2);
            System.out.println(t.substring(0, s-1) + " " + t.charAt(s-1));
            
        }        
    }    
}
