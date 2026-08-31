import java.util.*;

public class KLCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        HashMap<String, Integer> hash_map = new HashMap<>();
        for (int i = 0; i < n-1; i++) {
            String sub = s.substring(i, i+2);
            if (hash_map.containsKey(sub)) {
                hash_map.put(sub, hash_map.get(sub)+1);
            } else {
                hash_map.put(sub, 1);
            }
        }
        String res = "";
        int max = 0;
        for (String ss : hash_map.keySet()) {
            if (hash_map.get(ss) > max) {
                max = hash_map.get(ss);
                res = ss;
            }
        }
        System.out.println(res);
        sc.close();
    }
}
