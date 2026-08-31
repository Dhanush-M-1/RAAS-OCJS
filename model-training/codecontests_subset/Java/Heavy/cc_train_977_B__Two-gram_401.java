import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] l = new char[n];
        String w = sc.next();
        for (int i = 0; i < n; i++) {
            l[i] = w.charAt(i);
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < n-1; i++) {
            String twoGram = w.substring(i,i+2);
            if (map.containsKey(twoGram)) {
                map.put(twoGram, map.get(twoGram) + 1);
            } else {
                map.put(twoGram, 1);
            }
        }
        int max = 0;
        String maxStr = "";
        for (String k : map.keySet()) {
            int tmp = map.get(k);
            if (tmp > max) {
                max = tmp;
                maxStr = k;
            }
        }
        System.out.println(maxStr);
    }
}
