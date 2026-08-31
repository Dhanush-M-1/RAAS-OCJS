import java.util.*;
import java.io.*;

public class Main {
    private static HashMap<Integer, ArrayList<Pair>> paths = new HashMap<>();
    private static Pair xy0;
    private static Pair xy1;

    private static int[] iDiffs = {1, -1, 1, -1, -1, 0, 1, 0};
    private static int[] jDiffs = {-1, -1, 1, 1, 0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        xy0 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        xy1 = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (!paths.containsKey(r)) {
                paths.put(r, new ArrayList<>());
            }
            paths.get(r).add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        pw.println(bfs());
        pw.close();
    }

    private static int bfs() {
        LinkedList<Pair> q = new LinkedList<>();
        q.add(xy0);

        HashMap<String, Integer> distance = new HashMap<>();
        distance.put(hash(xy0), 0);

        boolean reached = false;
        while (!q.isEmpty() && !reached) {
            Pair head = q.poll();

            for (int k = 0; k < iDiffs.length; k++) {
                Pair newHead = new Pair(head.a + iDiffs[k], head.b + jDiffs[k]);

                if (inBounds(newHead) && !distance.containsKey(hash(newHead)) && allowed(newHead)) {
                    distance.put(hash(newHead), distance.get(hash(head)) + 1);

                    if (newHead.a == xy1.a && newHead.b == xy1.b) {
                        reached = true;
                        break;
                    }

                    q.addLast(newHead);
                }
            }
        }

        if (!distance.containsKey(hash(xy1))) {
            return -1;
        }

        return distance.get(hash(xy1));
    }

    private static boolean allowed(Pair cor) {
        if (!paths.containsKey(cor.a)) return false;

        for (Pair p : paths.get(cor.a)) {
            if (p.a <= cor.b && cor.b <= p.b) {
                return true;
            }
        }

        return false;
    }

    private static boolean inBounds(Pair p) {
        if (p.a < 1 || p.b < 1) return false;
        if (p.a > 1000000000 || p.b > 1000000000) return false;
        return true;
    }

    private static String hash(Pair xy) {
        return xy.a + ":" + xy.b;
    }

    static class Pair {
        int a, b;

        public Pair(int x, int y) {
            a = x;
            b = y;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "a=" + a +
                    ", b=" + b +
                    '}';
        }
    }
}
