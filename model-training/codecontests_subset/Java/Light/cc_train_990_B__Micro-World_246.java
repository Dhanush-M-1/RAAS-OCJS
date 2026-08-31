import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        TreeMap<Integer, Integer> bacteria = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int key = scanner.nextInt();
            bacteria.put(key, bacteria.getOrDefault(key, 0) + 1);
        }

        int eaten = 0;
        int current = bacteria.firstKey();
        for (Integer bacterium : bacteria.keySet()) {
            if (bacterium > current && bacterium <= current + K) {
                eaten += bacteria.get(current);
            }
            current = bacterium;
        }
        System.out.println(n - eaten);
    }
}