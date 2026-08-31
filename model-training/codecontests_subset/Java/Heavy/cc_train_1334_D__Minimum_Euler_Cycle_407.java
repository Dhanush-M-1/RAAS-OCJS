import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < t; i++) {
            solve(scanner, i + 1);
        }
    }

    public static void solve(Scanner in, int id) {
        int n = in.nextInt();
        long l = in.nextLong();
        long r = in.nextLong();

        long visits = 0;

        for(int i = 1; i <= n-1; i++) {
            //Calculate visits
            long visits_i = 2*(n - i);
            if(visits + visits_i < l) {
                visits += visits_i;
                continue;
            }

            print(++visits, l, r, i);
            for(int j = i+1; j <= n-1; j++) {
                print(++visits, l, r, j);
                print(++visits, l, r, i);
            }
            print(++visits, l, r, n);

            if(visits > r) {
                System.out.println();
                return;
            }
        }
        print(++visits, l, r, 1);
        System.out.println();
    }

    private static void print(long next_id, long l, long r, int num) {
        if(next_id >= l && next_id <= r) {
            System.out.print(num + " ");
        }
    }
}