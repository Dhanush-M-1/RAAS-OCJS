import java.util.*;

public class div {
    private static Scanner sc = new Scanner(System.in);
    private static Map<Integer, Integer> m = new TreeMap<>();
    private static long sum = 0;


    public static void main(String[] args) {
        int n = sc.nextInt(), o = 0, t = 0, tr = 0;

        for (int i = 0; i < n; i++) {
            o += sc.nextInt();
        }
        for (int i = 0; i < n - 1; i++) {
            t += sc.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            tr += sc.nextInt();
        }
        System.out.println(o - t);
        System.out.println(t - tr);
    }
}