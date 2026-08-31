/* https://codeforces.com/problemset/problem/478/A */

import java.util.Scanner;
import java.util.stream.IntStream;

public class IB {
    public static void main(String[] args) throws java.lang.Exception {
        int[] nums = new int[5];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            nums[i] = scan.nextInt();
        }
        if (IntStream.of(nums).sum() == 0)
            System.out.println(-1);
        else {
            if (IntStream.of(nums).sum() % 5 == 0)
                System.out.println(IntStream.of(nums).sum() / 5);
            else
                System.out.println(-1);
        }
    }
}