//package Ladder_A.eesaa;
/**
 * Created by CompuShop on 7/17/2017 at 10:36 AM.
 */

import java.util.*;

public class A_830 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int people[] = new int[n];
        int keys[] = new int[k];

        for(int i = 0; i < n; i++) {
            people[i] = sc.nextInt();
        }
        Arrays.sort(people);

        for(int i = 0; i < k; i++) {
            keys[i] = sc.nextInt();
        }
        Arrays.sort(keys);

        int total = Integer.MAX_VALUE;
        for(int i = 0; i < k - n + 1; i++) {
            int temp = 0;
            for(int j = 0; j < n; j++)
                temp = Math.max(temp, Math.abs(people[j] - keys[i + j]) + Math.abs(keys[i + j] - p));
            total = Math.min(temp, total);
        }

        System.out.println(total);
    }
}
