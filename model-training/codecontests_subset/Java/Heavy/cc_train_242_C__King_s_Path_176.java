import java.util.*;
import java.io.*;

public class KingsPath {
    public static void main(String[] args) throws IOException {
        Scanner f = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        int x0 = f.nextInt();
        int y0 = f.nextInt();
        int x1 = f.nextInt();
        int y1 = f.nextInt();
        List<Integer> init = Arrays.asList(x0, y0);
        List<Integer> end = Arrays.asList(x1, y1);
        int n = f.nextInt();
        HashSet<List<Integer>> path = new HashSet<>();
        while (n-- > 0) {
            int r = f.nextInt();
            int a = f.nextInt();
            int b = f.nextInt();
            for (int i=a; i<=b; ++i) {
                path.add(Arrays.asList(r, i));
            }
        }

        Set<List<Integer>> visited = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        HashMap<List<Integer>, Integer> hm = new HashMap<>();
        q.add(init);
        hm.put(init, 0);
        visited.add(init);
        while (!q.isEmpty()) {
            List<Integer> temp = q.poll();
            int c = hm.get(temp);
            int row = temp.get(0);
            int col = temp.get(1);
            if (temp.equals(end)) {
                out.println(c);
                out.close();
                break;
            }

            List<Integer> down = Arrays.asList(row + 1, col);
            List<Integer> up = Arrays.asList(row - 1, col);
            List<Integer> right = Arrays.asList(row, col + 1);
            List<Integer> left = Arrays.asList(row, col - 1);
            List<Integer> dr = Arrays.asList(row + 1, col + 1);
            List<Integer> dl = Arrays.asList(row + 1, col - 1);
            List<Integer> ur = Arrays.asList(row - 1, col + 1);
            List<Integer> ul = Arrays.asList(row - 1, col - 1);
            Set<List<Integer>> setTemp = new HashSet<List<Integer>>() {{
                add(down);
                add(up);
                add(right);
                add(left);
                add(dr);
                add(dl);
                add(ur);
                add(ul);
            }};
            for (List<Integer> l: setTemp) {
                if (path.contains(l) && !visited.contains(l)) {
                    q.add(l);
                    hm.put(l, c + 1);
                    visited.add(l);
                }
            }
        }
        out.println(-1);
        out.close();
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(s));
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
