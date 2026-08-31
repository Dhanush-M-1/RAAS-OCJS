import java.util.ArrayList;
import java.util.Scanner;

public class NewYearBookReading {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            w[i] = sc.nextInt();
        }

        int[] b = new int[m];

        ArrayList<Integer> order = new ArrayList<>();
        boolean[] used = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
            if (!used[b[i]]) {
                order.add(b[i]);
                used[b[i]] = true;
            }
        }

        int totalWeight = 0;
        for (int i = 0; i < m; i++) {
            int weight = 0;
            for (int j = 0; j < order.size(); j++) {
                if (order.get(j) == b[i]) {
                    totalWeight += weight;
                    order.remove(j);
                    order.add(0, b[i]);
                    break;
                } else {
                    weight += w[order.get(j)];
                }
            }
        }
        System.out.println(totalWeight);
    }
}
