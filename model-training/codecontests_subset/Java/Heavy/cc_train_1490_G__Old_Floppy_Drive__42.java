import java.util.*;
import java.io.*;

public class Main {

    private static final FastIO fastIO = new FastIO();
    private static final String yes = "YES";
    private static final String no = "NO";

    public static void main(String[] args) {
        int t = fastIO.nextInt();

        while(t-- > 0){
            int n = fastIO.nextInt();
            int m = fastIO.nextInt();
            List<Node> a = new ArrayList<>();
            Set<Long> used = new HashSet<>();
            long sum = 0;
            long max = Integer.MIN_VALUE;

            for(int i = 0; i < n; i++) {
                long val = fastIO.nextLong();
                sum += val;
                max = Math.max(max, sum);

                if(!used.contains(max)){
                    used.add(max);
                    a.add(new Node(max, i + 1));
                }
            }

            Collections.sort(a);
            for(int i = 0; i < m; i++){
                long x = fastIO.nextLong();
                long ans = -1;

                if(max >= x || sum > 0){
                    if(max < x) {
                        long c = (x - max + sum - 1) / sum;
                        x -= c * sum;
                        ans += c * n;
                    }

                    ans += getTime(a, x, 0, a.size() - 1);
                }

                fastIO.append(ans, " ");
            }

            fastIO.appendln();
        }

        fastIO.printAll();
    }

    public static long getTime(List<Node> a, long val, int l, int r){
        while(l <= r){
            int mid = (l + r) / 2;

            if(a.get(mid).val >= val)
                r = mid - 1;
            else
                l = mid + 1;
        }

        return a.get(l).time;
    }

    public static class Node implements Comparable<Node> {

        long val;
        long time;

        public Node(long val, long time) {
            this.val = val;
            this.time = time;
        }

        @Override
        public int compareTo(Node node) {
            return (int)(val - node.val);
        }
    }

    private static class FastIO {

        private final BufferedReader in;
        private final StringBuilder out;
        private final char LINE_BREAK = '\n';

        private StringTokenizer tokens;

        public FastIO() {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new StringBuilder();
        }

        public String next() {
            while (tokens == null || !tokens.hasMoreElements()) {
                try {
                    tokens = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return tokens.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";

            try {
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return str;
        }

        public FastIO append(Object... objects){
            for(Object o: objects)
                out.append(o);
            return this;
        }

        public FastIO appendln(Object... objects){
            return append(objects).append(LINE_BREAK);
        }

        public void printAll(){
            System.out.println(out.toString());
        }
    }
}
/*
1
3 3
2 -1 0
2 3 4*/