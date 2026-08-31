import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class nD {

    public class Pair implements Comparable<Pair> {
        int f;
        int s;

        public Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }


        @Override
        public int compareTo(Pair o) {
            if (o.f == f) {
                return o.s - s;
            }
            return f - o.f;
        }
    }

    public class Tri extends Pair {
        int t;

        public Tri(int f, int s, int t) {
            super(f, s);
            this.t = t;
        }
    }

    public void run() throws NumberFormatException, IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        pw = new PrintWriter(System.out);
        final int n = nextInt();
        Pair[] arr = new Pair[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Pair(nextInt(), i);
        }
        Arrays.sort(arr);
        final int m = nextInt();
        Tri[] kp = new Tri[m];
        for (int i = 0; i < m; i++) {
            kp[i] = new Tri(nextInt(), nextInt(), i);
        }
        Arrays.sort(kp);
        ArrayList<Pair> array = new ArrayList<>();
        int ind = 0;
        int[] res = new int[m];
        for (int i = 0; i < arr.length; i++) {
            add(array, arr[arr.length - i - 1]);
            while (ind < kp.length && kp[ind].f == i + 1) {
                res[kp[ind].t] = array.get(kp[ind].s - 1).f;
                ind++;
            }
        }
        for (int x : res) {
            pw.println(x);
        }
        pw.close();
    }

    public void add(ArrayList<Pair> arr, Pair p) {
        int ind = bin(0, arr.size(), arr, p);
        arr.add(ind, p);
    }

    public int bin(int l, int r, ArrayList<Pair> arr, Pair p) {
        if (r - l <= 1) {
            if (l < arr.size()) {
                if (p.s > arr.get(l).s) {
                    return l + 1;
                }
            }
            return l;
        }
        int c = (r + l) / 2;
        if (c >= arr.size() || p.s < arr.get(c).s) {
            return bin(l, c, arr, p);
        } else {
            return bin(c, r, arr, p);
        }
    }

    StringTokenizer st;
    BufferedReader br;
    PrintWriter pw;

    public static void main(String[] args) throws IOException {
        new nD().run();
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }


    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }
}
