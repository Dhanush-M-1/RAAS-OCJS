import java.io.ByteArrayInputStream;
import java.util.*;

/**
 * ctrl+D if no nr of testcases - read input if hasNext - to terminate and see answer ctrl+D.
 */

public class A {
    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static String solve() {
        List<List<int[]>> numbers = readInput();

        StringBuilder sb = new StringBuilder();

        for (List<int[]> nums : numbers) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.get(0).length; i++) {
                set.add(nums.get(0)[i]);
            }
            boolean no = true;
            for (int x: nums.get(1)) {
                if (set.contains(x)) {
                    sb.append("YES\n1 " + x + " \n");
                    no = false;
                    break;
                }
            }
            if (no) {
                sb.append("NO\n");
            }
        }

        return sb.toString();
    }


    private static List<List<int[]>> readInput() {
        Scanner sc = new Scanner(System.in);
        List<List<int[]>> nums = new ArrayList<>();
        int n = sc.nextInt();
        while (n > 0) {
            int k = sc.nextInt();
            int m = sc.nextInt();
            List<int[]> tmp = new ArrayList<>();
            int[] tmp1 = new int[k];
            for (int i = 0; i < k; i++) {
                tmp1[i] = sc.nextInt();
            }
            int[] tmp2 = new int[m];
            for (int i = 0; i < m; i++) {
                tmp2[i] = sc.nextInt();
            }
            tmp.add(tmp1);
            tmp.add(tmp2);
            nums.add(tmp);
            n--;
        }
        return nums;
    }

}