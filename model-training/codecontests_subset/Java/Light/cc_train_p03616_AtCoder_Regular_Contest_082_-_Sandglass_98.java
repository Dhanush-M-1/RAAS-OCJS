import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int n = sc.nextInt();
        int[] delta = new int[n + 1];
        int f = 0;
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            delta[i] = p - f;
            f = p;
        }
        delta[n] = 1_000_000_000 - f;
        n++;
        int q = sc.nextInt();
        int[][] qs = new int[q][];
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            int a = sc.nextInt();
            qs[i] = new int[]{a, t, i, -1};
        }
        Arrays.sort(qs, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[1] - t2[1];
            }
        });
        int curTime = 0;
        int curIdx = 0;
        List<Integer>[] times = new List[n];
        for (int i = 0; i < n; i++) {
            times[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int nextTime = curTime + delta[i];
            while (curIdx < q && nextTime >= qs[curIdx][1]) {
                qs[curIdx][1] -= curTime;
                times[i].add(qs[curIdx][2]);
                curIdx++;
            }
            curTime = nextTime;
        }
        Arrays.sort(qs, new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] - t2[0];
            }
        });
        int[] mapIdx = new int[q];
        for (int i = 0; i < q; i++) {
            mapIdx[qs[i][2]] = i;
        }
        for (List<Integer> l: times) {
            for (int i = 0; i < l.size(); i++) {
                int t = l.get(i);
                l.set(i, mapIdx[t]);
            }
        }
        boolean useMax = true;
        int front = 0, frontVal = 0;
        int back = q, backVal = X;
        int change = 0;
        for (int i = 0; i < n; i++) {
            for (int idx: times[i]) {
                int curVal;
                if (idx < front) {
                    curVal = frontVal;
                } else if (idx >= back) {
                    curVal = backVal;
                } else {
                    curVal = qs[idx][0] + change;
                }
                if (useMax) {
                    qs[idx][3] = Math.max(0, curVal - qs[idx][1]);
                } else {
                    qs[idx][3] = Math.min(X, curVal + qs[idx][1]);
                }
            }
            if (useMax) {
                frontVal = Math.max(0, frontVal - delta[i]);
                backVal = Math.max(0, backVal - delta[i]);
                int lo = front, hi = back;
                while (lo < hi) {
                    int mid = (lo + hi) >> 1;
                    if (qs[mid][0] + change - delta[i] < 0) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                front = lo;
                change -= delta[i];
            } else {
                frontVal = Math.min(X, frontVal + delta[i]);
                backVal = Math.min(X, backVal + delta[i]);
                int lo = front, hi = back;
                while (lo < hi) {
                    int mid = (lo + hi) >> 1;
                    if (qs[mid][0] + change + delta[i] > X) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                back = hi;
                change += delta[i];
            }
            useMax = !useMax;
        }
        int[] ret = new int[q];
        for (int i = 0; i < q; i++) {
            ret[qs[i][2]] = qs[i][3];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(ret[i]).append('\n');
        }
        System.out.println(sb.toString());
    }

    public static class Scanner {
        StringTokenizer st;
        BufferedReader br;
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }
        public int nextInt() throws IOException{
            return Integer.parseInt(next());
        }
    }
}