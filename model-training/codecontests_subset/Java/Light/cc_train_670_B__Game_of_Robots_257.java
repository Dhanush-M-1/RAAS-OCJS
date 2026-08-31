import java.util.Scanner;

/**
 * Created by yuu on 9/4/17.
 */
public class Problem670B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        int[] ids = new int[n+1];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            ids[i] = sc.nextInt();
            if (2 * (double)k / i > i - 1) index = i;
        }
        int value = (int)(k - (long)index * (index-1) / 2);
//        System.out.println(index);
        System.out.println(ids[value]);
    }
}
