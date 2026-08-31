import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        new Solution().solve();
    }

    public void solve() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        HashMap<String, Integer> map = new HashMap<>();
        int max = 0, count = 0;
        String res = "";
        for (int i = 0; i < n - 1; i++) {
            String subs = s.substring(i, i + 2);
            if (map.containsKey(subs)) {
                count = map.get(subs) + 1;
                map.put(subs, count);
            } else {
                map.put(subs, 1);
                count = 1;
            }
            if (count > max) {
                res = subs;
                max = count;
            }
        }
        System.out.println(res);

    }
}