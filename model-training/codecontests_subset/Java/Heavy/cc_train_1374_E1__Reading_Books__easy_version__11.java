import java.io.*;
import java.util.*;

public final class ReadingBooksEasy {

    private static final FastReader fr = new FastReader();

    public static void main(String[] args) {
        final int n = fr.nextInt(), k = fr.nextInt();
        final Triple[] triples = new Triple[n];
        for (int i = 0; i < n; i++) {
            triples[i] = new Triple(fr.nextInt(), fr.nextInt() == 1, fr.nextInt() == 1);
        }

        int ans = new ReadingBooksEasy(triples, k).solve();
        System.out.println(ans);
    }

    private final Triple[] triples;
    private final int k;

    public ReadingBooksEasy(final Triple[] triples, final int k) {
        this.triples = triples;
        this.k = k;
    }

    private int solve() {
        int[] bothCumulative, aliceCumulative, bobCumulative;
        {
            final List<Integer> both = new LinkedList<>(), alice = new LinkedList<>(), bob = new LinkedList<>();
            for (Triple triple : triples) {
                if (triple.alice && triple.bob) both.add(triple.time);
                else if (triple.alice) alice.add(triple.time);
                else if (triple.bob) bob.add(triple.time);
            }

            final int[] bothArr = both.stream().mapToInt(Integer::intValue).toArray(),
                    aliceArr = alice.stream().mapToInt(Integer::intValue).toArray(),
                    bobArr = bob.stream().mapToInt(Integer::intValue).toArray();

            Arrays.sort(bothArr);
            Arrays.sort(aliceArr);
            Arrays.sort(bobArr);

            bothCumulative = new int[both.size() + 1];
            aliceCumulative = new int[alice.size() + 1];
            bobCumulative = new int[bob.size() + 1];

            System.arraycopy(bothArr, 0, bothCumulative, 1, bothArr.length);
            System.arraycopy(aliceArr, 0, aliceCumulative, 1, aliceArr.length);
            System.arraycopy(bobArr, 0, bobCumulative, 1, bobArr.length);

            cumulative(bothCumulative);
            cumulative(aliceCumulative);
            cumulative(bobCumulative);
        }

        final List<Integer> answers = new ArrayList<>(k);
        for (int common = k; common >= 0; common--) {
            if (bothCumulative.length - 1 < common || aliceCumulative.length - 1 < k - common || bobCumulative.length - 1 < k - common)
                continue;

            int time = bothCumulative[common]
                    + aliceCumulative[k - common]
                    + bobCumulative[k - common];

            answers.add(time);
        }

        return answers.stream().min(Integer::compare).orElse(-1);
    }

    private static void cumulative(final int[] arr) {
        if (arr.length == 0) return;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i];
        }
    }

    private static final class Triple {
        public final int time;
        public final boolean alice, bob;

        public Triple(int time, boolean alice, boolean bob) {
            this.time = time;
            this.alice = alice;
            this.bob = bob;
        }
    }

    private static final class FastReader {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(nextLine());
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }

}