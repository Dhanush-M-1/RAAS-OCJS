import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A526 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        char[] levels = in.next().toCharArray();
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (levels[i] == '*') {
                pos.add(i);
            }
        }
        int limit = pos.size() - 4;
        for (int i = 0; i < limit; ++i) {
            for (int j = i + 1; j <= limit; ++j) {
                int diff = pos.get(j) - pos.get(i);
                if (pos.get(j) + 3 * diff >= n) {
                    break;
                }
                if (levels[pos.get(j) + 2 * diff] == '*'
                        && levels[pos.get(j) + diff] == '*'
                        && levels[pos.get(j) + 3 * diff] == '*') {
                    System.out.println("YES");
                    return;
                }
            }
        }
        System.out.println("NO");

    }
}
