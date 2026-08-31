import java.util.*;
public class hello {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int l, r, d;
            l = sc.nextInt();
            r = sc.nextInt();
            d = sc.nextInt();
            if (d < l)
                System.out.println(d);
            else
                System.out.println((r / d + 1) * d);
        }
    }
    }