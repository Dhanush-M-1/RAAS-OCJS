import java.util.*;

public class d {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int l = 0;
        int r = -1;
        int max = s.charAt(0);
        for (int i = 1; i < n; i++) {
            if (max <= s.charAt(i)) {
                max = s.charAt(i);
                l = i;
            } else {
                r = i;
                break;
            }
        }
        if (r != -1) {
            System.out.println("YES");
            System.out.println((l + 1) + " " + (r + 1));
        } else {
            System.out.println("NO");
        }
    }
}
