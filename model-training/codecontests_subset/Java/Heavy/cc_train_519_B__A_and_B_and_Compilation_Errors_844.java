import java.util.*;

public class Test {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        HashMap<Integer, Integer> e1 = new HashMap<>();
        HashMap<Integer, Integer> e2 = new HashMap<>();
        HashMap<Integer, Integer> e3 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int e = sc.nextInt();
            if (!e1.containsKey(e)) {
                e1.put(e, 1);
            } else {
                e1.put(e, e1.get(e) + 1);
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int e = sc.nextInt();
            if (!e2.containsKey(e)) {
                e2.put(e, 1);
            } else {
                e2.put(e, e2.get(e) + 1);
            }
        }
        for (int i = 0; i < n - 2; i++) {
            int e = sc.nextInt();
            if (!e3.containsKey(e)) {
                e3.put(e, 1);
            } else {
                e3.put(e, e3.get(e) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: e1.entrySet()) {
            if (!(e2.containsKey(entry.getKey())) || Math.abs(e2.get(entry.getKey()) - entry.getValue()) == 1) {
                System.out.println(entry.getKey());
            }
        }
        for (Map.Entry<Integer, Integer> entry: e2.entrySet()) {
            if (!(e3.containsKey(entry.getKey())) || Math.abs(e3.get(entry.getKey()) - entry.getValue()) == 1) {
                System.out.println(entry.getKey());
            }
        }
    }
}
