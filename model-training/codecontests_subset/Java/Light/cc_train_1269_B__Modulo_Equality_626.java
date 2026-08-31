import java.util.*;

public class ModuloEquality {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long m = in.nextLong();
        Map<Long, Integer> amtA = new HashMap<>();
        Map<Long, Integer> amtB = new HashMap<>();
        for (int j = n; j > 0; j--) {
            long a = in.nextLong();
            amtA.merge(a, 1, Integer::sum);
        }
        for (int j = n; j > 0; j--) {
            long b = in.nextLong();
            amtB.merge(b, 1, Integer::sum);
        }
        TreeSet<Long> answers = new TreeSet<>();
        boolean isFirst = true;
        for (Map.Entry<Long, Integer> entryA : amtA.entrySet()) {
            long a = entryA.getKey();
            int alpha = entryA.getValue();
            if (isFirst) {
                for (Map.Entry<Long, Integer> entryB : amtB.entrySet()) {
                    long b = entryB.getKey();
                    int beta = entryB.getValue();
                    if (alpha == beta) {
                        answers.add((b - a + m) % m);
                    }
                }
            } else {
                for (long x : new ArrayList<>(answers)) {
                    if (!amtB.containsKey((a + x) % m) || amtB.get((a + x) % m) != alpha) {
                        answers.remove(x);
                    }
                }
            }
            isFirst = false;
        }
        System.out.println(answers.first());
    }
}
