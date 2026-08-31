import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class Main {

    BufferedReader br;
    PrintWriter out;
    StringTokenizer st;
    boolean eof;
    final long MOD = 1000L * 1000L * 1000L + 7;

    void solveA() throws IOException {
        int x = nextInt();
        int t = nextInt();
        outln(Math.max(0, x - t));
    }
    void solveB() throws IOException {
        String str = nextString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (i % 2 == 0) {
                sb.append(str.charAt(i));
            }
        }

        outln(sb.toString());
    }
    void solveC() throws IOException {
        int n = nextInt();
        int[] arr = nextIntArr(n);
        Arrays.sort(arr);
        List<Integer> val = new ArrayList<>();
        List<Integer> cnt = new ArrayList<>();
        int start = 0;
        while (start < n) {
            int end = start;
            while (end < n && arr[end] == arr[start]) {
                end++;
            }

            val.add(arr[start]);
            cnt.add(end - start);

            start = end;
        }

        int res = 0;
        for (int i = 0; i < val.size(); i++) {
            res = Math.max(res, cnt.get(i));
            if (i < val.size() - 1) {
                if (val.get(i + 1) - val.get(i) <= 2) {
                    res = Math.max(res, cnt.get(i) + cnt.get(i + 1));

                    if (i < val.size() - 2) {
                        if (val.get(i + 2) - val.get(i) <= 2) {
                            res = Math.max(res, cnt.get(i) + cnt.get(i + 1) + cnt.get(i + 2));
                        }
                    }
                }
            }
        }

        outln(res);
    }
    void solveD() throws IOException {
        int n = nextInt();
        int[] arr = nextIntArr(n);
        int res = 0;
        int start = 0;
        while (start < n) {
            if (arr[start] == start + 1) {
                if (start == n - 1) {
                    res++;
                    break;
                }
                else {
                    exchange(arr, start, start + 1);
                    res++;
                    start++;
                }
            }
            else {
                start++;
            }
        }

        outln(res);
    }

    public void exchange(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }


    void shuffle(int[] a) {
        int n = a.length;
        for(int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n - i));
            int tmp = a[i];
            a[i] = a[r];
            a[r] = tmp;
        }
    }
    private void outln(Object o) {
        out.println(o);
    }
    private void out(Object o) {
        out.print(o);
    }
    public Main() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);

        solveD();

        out.close();
    }
    public static void main(String[] args) throws IOException {
        new Main();
    }

    public long[] nextLongArr(int n) throws IOException{
        long[] res = new long[n];
        for(int i = 0; i < n; i++)
            res[i] = nextLong();
        return res;
    }
    public int[] nextIntArr(int n) throws IOException {
        int[] res = new int[n];
        for(int i = 0; i < n; i++)
            res[i] = nextInt();
        return res;
    }
    public String nextToken() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (Exception e) {
                eof = true;
                return null;
            }
        }
        return st.nextToken();
    }
    public String nextString() {
        try {
            return br.readLine();
        } catch (IOException e) {
            eof = true;
            return null;
        }
    }
    public int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
    public long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }
    public double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }
}