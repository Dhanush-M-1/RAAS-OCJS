import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

public class TaskD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer nmt = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(nmt.nextToken());
        int m = Integer.parseInt(nmt.nextToken());
        int p[] = new int[n];
        StringTokenizer pt = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(pt.nextToken());
        }
        Set<Pair> swappable = new HashSet<>();
        for (int j = 0; j < m; j++) {
            StringTokenizer uv = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(uv.nextToken());
            int v = Integer.parseInt(uv.nextToken());
            swappable.add(Pair.of(u, v));
        }
        int unswappableCount = 0;
        int nastyaPos = n - 1;
        int shifts = 0;
        while (unswappableCount < nastyaPos) {
            int curPos = nastyaPos - unswappableCount - 1;
            while (curPos < nastyaPos && swappable.contains(Pair.of(p[curPos], p[curPos + 1]))) {
                int t = p[curPos]; p[curPos] = p[curPos + 1]; p[curPos + 1] = t;
                curPos += 1;
                if (curPos == nastyaPos) {
                    nastyaPos -= 1;
                }
            }
            if (curPos < nastyaPos) {
                unswappableCount += 1;
            } else {
                shifts += 1;
            }
        }
        System.out.println(shifts);

        br.close();
    }

    private static class Pair {
        private final int a;
        private final int b;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public static Pair of(int a, int b) {
            return new Pair(a, b);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
