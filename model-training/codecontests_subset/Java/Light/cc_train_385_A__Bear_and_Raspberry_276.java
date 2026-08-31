import java.util.*;
public class Code {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n, c, s = 0, b = 0, m = 0;
        n = scan.nextInt();
        c = scan.nextInt();
        for (int i = 0; i < n; i++) {
            b = scan.nextInt();
            m = Math.max(m, s-b-c);
            s = b;
        }
        System.out.println(m);
    }
}