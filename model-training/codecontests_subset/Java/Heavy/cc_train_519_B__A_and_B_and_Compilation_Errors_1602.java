import java.util.*;
public class CE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n];
        int[] s = new int[n - 1];
        int[] t = new int[n - 2];
        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            s[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            t[i] = sc.nextInt();
        }
        Arrays.sort(f);
        Arrays.sort(s);
        Arrays.sort(t);
        boolean flag = false;
        for (int i = 0; i < n - 1; i++) {
            if (f[i] != s[i]) {
                flag = true;
                System.out.println(f[i]);
                break;
            }
        }
        if (!flag) {
            System.out.println(f[n-1]);
        }
        flag = false;
        for (int i = 0; i < n - 2; i++) {
            if (s[i] != t[i]) {
                flag = true;
                System.out.println(s[i]);
                break;
            }
        }
        if (!flag) {
            System.out.println(s[n-2]);
        }
    }
}
