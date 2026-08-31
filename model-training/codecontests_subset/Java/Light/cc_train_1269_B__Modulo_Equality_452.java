import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int first[] = new int[n];
        int second[] = new int[n];


        for (int i = 0; i < n; i++) {
            first[i] = scan.nextInt();
        }
        for (int i = 0; i < n; i++) {
            second[i] = scan.nextInt();
        }

        Arrays.parallelSort(first);
        Arrays.parallelSort(second);

        Set<Integer> set = new HashSet<>();
        int max = second[n - 1];

        for (int i = 0; i < n; i++) {
            int x = max - first[i];
            if (x < 0) {
                int temp = x + m;
                set.add(temp);
            } else if (!set.contains(x)) {
                set.add(x);
            }
        }
        int answer = -1;
        for (Integer x : set) {
            int temp[] = new int[n];
            for (int i = 0; i < n; i++) {
                int h = (first[i] + x) % m;
                temp[i] = h;
            }
            Arrays.parallelSort(temp);
            boolean var = Arrays.equals(second, temp);
            if (var) {
                answer = x;
                break;
            }
        }
        System.out.println(answer);
    }
}
