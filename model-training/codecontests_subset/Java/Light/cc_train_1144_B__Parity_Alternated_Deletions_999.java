import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class DelGame {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int cur = Integer.parseInt(tokenizer.nextToken());
            sum += cur;
            if (cur % 2 == 1) odd.add(cur);
            if (cur % 2 == 0) even.add(cur);
        }
        odd.sort(Comparator.comparingInt(a -> -a));
        even.sort(Comparator.comparingInt(a -> -a));
        int len = Math.min(odd.size(), even.size());
        for (int i = 0; i < Math.min(len +1, odd.size()); i++) {
            sum -= odd.get(i);
        }
        for (int i = 0; i < Math.min(len + 1, even.size()); i++) {
            sum -= even.get(i);
        }
        System.out.println(sum);
    }
}
