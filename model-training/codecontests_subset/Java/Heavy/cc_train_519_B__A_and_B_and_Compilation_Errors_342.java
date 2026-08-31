
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CompilationErrors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> a = load(sc, n);
        HashMap<Integer, Integer> b = load(sc, n - 1);
        HashMap<Integer, Integer> c = load(sc, n - 2);

        remove(a, b);
        System.out.println(a.keySet().iterator().next());
        remove(b, c);
        System.out.println(b.keySet().iterator().next());
    }

    private static void remove(HashMap<Integer, Integer> a, HashMap<Integer, Integer> b) {
        for (Map.Entry<Integer, Integer> entry : b.entrySet()) {
            Integer val = a.get(entry.getKey());
            int cnt = val - entry.getValue();
            if(cnt == 0) {
                a.remove(entry.getKey());
            } else {
                a.put(entry.getKey(), cnt);
            }
        }
    }

    private static HashMap<Integer, Integer> load(Scanner sc, int n) {
        HashMap<Integer, Integer> a = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            Integer cnt = a.get(key);
            if (cnt != null) {
                cnt++;
            } else {
                cnt = 1;
            }
            a.put(key, cnt);
        }
        return a;
    }
}
