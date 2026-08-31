import java.util.*;

public class Codeforces243C {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            v.add(in.nextInt());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int val = maxf(v, i, j, k);
                if (val > max) {
                    max = val;
                }
            }
        }
        System.out.println(max);
    }

    private static int maxf(List<Integer> v, int l, int r, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>(v.subList(l, r + 1)),
                               max = new PriorityQueue<>(1, Comparator.<Integer>reverseOrder());
        max.addAll(v.subList(0, l));
        max.addAll(v.subList(r + 1, v.size()));

        while (k > 0 && min.size() > 0 && max.size() > 0 && min.peek() < max.peek()) {
            min.add(max.poll());
            min.poll();
            k--;
        }

        return min.stream().reduce(0, (Integer acc, Integer n) -> acc + n);
    }
}