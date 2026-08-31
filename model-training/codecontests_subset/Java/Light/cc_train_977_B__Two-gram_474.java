import java.util.*;

public class CF0977b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        HashMap<String, Integer> mp = new HashMap<>();
        int mx = 0;
        String ans = "";
        for (int i = 0; i < n - 1; i++) {
            String t = s.substring(i, i + 2);
            int num = mp.getOrDefault(t, 0) + 1;
            mp.put(t, num + 1);

            if (num > mx) {
                mx = num;
                ans = t;
            }
        }
        System.out.println(ans);
    }
}
