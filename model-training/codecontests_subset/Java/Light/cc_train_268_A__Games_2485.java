import java.util.*;

public class Games {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int teams = sc.nextInt();
        int[] host = new int[101];
        int[] guest = new int[101];
        int res = 0;

        for (int i = 1; i <= teams; i++) {
            int hColor = sc.nextInt();
            int gColor = sc.nextInt();
            host[hColor]++;
            guest[gColor]++;

            if (host[gColor] > 0) res+=host[gColor];
            if (guest[hColor] > 0) res+=guest[hColor];

        }
        System.out.println(res);
    }
}
