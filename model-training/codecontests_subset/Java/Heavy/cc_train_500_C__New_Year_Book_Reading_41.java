import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Problems problems = new Problems();
        problems.solve();
    }
}

class Problems {

    Parser parser = new Parser();

    void solve() {
        int t = 1;
        for (int i = 0; i < t; i++) {
            Problem problem = new Problem();
            problem.solve(i);
        }
    }

    class Problem {

        int n;
        int m;

        int[] w;
        int[] b;
        int[] prev;

        void solve(int testcase) {
            n = parser.parseInt();
            m = parser.parseInt();

            prev = new int[n + 1];

            w = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                w[i] = parser.parseInt();
            }

            b = new int[m + 1];
            for (int i = 1; i <= m; i++) {
                b[i] = parser.parseInt();
            }

            long ans = 0;
            for (int i = 1; i <= m; i++) {
                int v = b[i];
                ans += calcCost(v);
                prev[v] = i;
            }

            System.out.println(ans);
        }

        int calcCost(int v) {
            int result = 0;
            for(int i = 1; i <= n; i++) {
                if(prev[i] <= prev[v]) {
                    continue;
                }
                result += w[i];
            }
            return result;
        }
    }
}

class Parser {
    private final Iterator<String> stringIterator;
    private final Deque<String> inputs;

    Parser() {
        this(System.in);
    }

    Parser(InputStream in) {
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        stringIterator = br.lines().iterator();
        inputs = new ArrayDeque<>();
    }

    void fill() {
        while (inputs.isEmpty()) {
            if (!stringIterator.hasNext()) throw new NoSuchElementException();
            inputs.addAll(Arrays.asList(stringIterator.next().split(" ")));
            while (!inputs.isEmpty() && inputs.getFirst().isEmpty()) {
                inputs.removeFirst();
            }
        }
    }

    Integer parseInt() {
        fill();
        if (!inputs.isEmpty()) {
            return Integer.parseInt(inputs.pollFirst());
        }
        throw new NoSuchElementException();
    }

    Long parseLong() {
        fill();
        if (!inputs.isEmpty()) {
            return Long.parseLong(inputs.pollFirst());
        }
        throw new NoSuchElementException();
    }

    Double parseDouble() {
        fill();
        if (!inputs.isEmpty()) {
            return Double.parseDouble(inputs.pollFirst());
        }
        throw new NoSuchElementException();
    }

    String parseString() {
        fill();
        return inputs.removeFirst();
    }
}