import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EasyReading {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        int cases = scanner.nextInt();

//        for (int i = 0; i < cases; i++) {
        solve();
//        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        long[] all = new long[n];
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> both = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            all[i] = scanner.nextInt();

            int isA = scanner.nextInt();
            int isB = scanner.nextInt();


            if (isA == 1 && isB == 1) {
                both.add(i);
            } else {
                if (isA == 1) {
                    a.add(i);
                }
                if (isB == 1) {
                    b.add(i);
                }
            }
        }

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (int) (all[o1] - all[o2]);
            }
        };

        a.sort(comparator);
        b.sort(comparator);
        both.sort(comparator);

        int i = 0;
        int j = 0;

        long time = 0;

        while (i + j < k && (i < a.size() && i < b.size() || j < both.size())) {

            if (i < a.size() && i < b.size()) {
                long tmp = all[a.get(i)] + all[b.get(i)];

                if (j < both.size() && tmp > all[both.get(j)]) {
                    time += all[both.get(j)];
                    j++;
                } else {
                    time += tmp;
                    i++;
                }
            } else {
                time += all[both.get(j)];
                j++;
            }
        }

        if (i + j == k)
            System.out.println(time);
        else
            System.out.println(-1);
    }
}