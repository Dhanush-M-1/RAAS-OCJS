import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    public void solve() {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = scan.nextInt();
        char[] candidates = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
        Set<String> set = new HashSet<>();
        StringBuilder init = new StringBuilder();
        set.add("a");
        for (int i = 1; i < N; i++) {
            Set<String> next_set = new HashSet<>();
            for (String s : set) {
                char[] data = s.toCharArray();
                Set<Character> count = new HashSet<>();
                for (int j = 0; j < data.length; j++) {
                    count.add(data[j]);
                }
                for (int j = 0; j <= count.size(); j++) {
                    next_set.add(s + candidates[j]);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j <= i; j++) {
                sb.append(candidates[j]);
            }
            next_set.add(sb.toString());
            set = next_set;
        }
        List<String> ans = new ArrayList<>();
        for (String x : set) {
            ans.add(x);
        }
        ans.sort(Comparator.naturalOrder());
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i));
        }
    }
}
