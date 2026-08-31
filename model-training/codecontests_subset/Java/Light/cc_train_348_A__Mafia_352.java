import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        long max = 0, t = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i] = sc.nextInt());
            t += a[i];
        }
        if (t % (n - 1) == 0)
            System.out.println(Math.max(max, t / (n - 1)));
        else
            System.out.println(Math.max(max, t / (n - 1) + 1));
    }
}