
import java.io.*;
import java.util.*;

public class Main {
    private static final fast sc = new fast();
    private static final BufferedWriter sout = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int OO = (int) 1e9 + 7;
    private static final double PI = Math.acos(-1);
    //right,down,left,up
    private static final int[] dx4 = {0, 1, 0, -1}, dx = {0, 0, 1, -1, 1, -1, 1, -1};
    private static final int[] dy4 = {1, 0, -1, 0}, dy = {1, -1, 0, 0, 1, -1, -1, 1};
    //static void print6P{ System.out.printf("%8.6f\n"); }
    static long one = 1L;
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //Start from here.
        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt(), zer = 0;
            int[] ns = new int[n], ms = new int[m];
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ns[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                ms[i] = sc.nextInt();
            }
            int x = 0, y = 0, b = 0;
            for (int i = 0; i < n + m; i++) {
                int curN = (x < n) ? ns[x] : OO, curM = (y < m) ? ms[y] : OO;
                if ((curN <= k && curM <= k) || (curN == 0 && curM == 0)) {
                    if (curM == 0) {
                        list.add(curM);
                        y += 1;
                        k += 1;
                    } else if (curN == 0) {
                        list.add(curN);
                        x += 1;
                        k += 1;
                    } else {
                        if (n > m) {
                            list.add(curN);
                            x += 1;
                        }else{
                            list.add(curM);
                            y += 1;
                        }
                    }
                } else if (curM <= k && curN > k) {
                    list.add(curM);
                    y += 1;
                    if (curM == 0) {
                        k += 1;
                    }
                } else if (curM > k && curN <= k) {
                    list.add(curN);
                    x += 1;
                    if (curN == 0) {
                        k += 1;
                    }
                } else if (curM > k && curN > k) {
                    b = -1;
                    break;
                }
            }
            if (b == 0) {
                for (int v : list) {
                    sout.write(v + " ");
                }
            } else {
                sout.write(b + "");
            }
            sout.write("\n");
        }
        //end here
        sout.close();
    }

    static int find(String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                return i;
            }
        }
        return -1;
    }

    static class fast {
        BufferedReader br;
        StringTokenizer st;

        fast() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        boolean hasNext() {
            if (st != null && st.hasMoreTokens()) {
                return true;
            }
            String tmp;
            try {
                br.mark(1000);
                tmp = br.readLine();
                if (tmp == null) {
                    return false;
                }
                br.reset();
            } catch (IOException e) {
                return false;
            }
            return true;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        double nextFloat() {
            return Float.parseFloat(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Pair implements Comparable<Pair> {
        Long first;
        Long second;

        Pair(Long first, Long second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (o.first.equals(first)) {
                return Double.compare(first, o.first);
            }
            return Double.compare(o.first, first);
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair p = (Pair) o;
                return p.first.equals(first) && p.second.equals(second);
            }
            return false;
        }

        @Override
        public int hashCode() {
            return first.hashCode() * 31 + second.hashCode();
        }
    }

    static class Triple implements Comparable<Triple> {
        Integer f;
        Integer s;
        Integer t;


        Triple(Integer first, Integer second, Integer third) {
            this.f = first;
            this.s = second;
            this.t = third;
        }

        @Override
        public int compareTo(Triple o) {
            return Long.compare(o.f, f);
        }
    }

}