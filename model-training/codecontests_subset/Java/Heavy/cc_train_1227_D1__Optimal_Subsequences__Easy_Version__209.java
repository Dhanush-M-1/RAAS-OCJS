import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

public class TaskD {
    public static String doMain(Reader reader) throws IOException {
        MyReader in = new MyReader(reader);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int m = in.nextInt();
        while (m > 100) m = in.nextInt();
        int[] k = new int[m];
        int[] pos = new int[m];
        Integer[] order = new Integer[m];
        for (int i = 0; i < m; i++) {
            k[i] = in.nextInt();
            pos[i] = in.nextInt();
            order[i] = i;
        }
        Arrays.sort(order, Comparator.comparingInt(o -> k[o]));
        Map<Integer, List<Integer>> map = new TreeMap<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(a[i])) map.put(a[i], new ArrayList<>());
            map.get(a[i]).add(i);
        }
        int[] newOrder = new int[n];
        int last = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            for (int i : entry.getValue()) {
                newOrder[last++] = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int[] ints = Arrays.copyOf(newOrder, k[i]);
            Arrays.sort(ints);
            sb.append(a[ints[pos[i] - 1]]);
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        String result = doMain(new InputStreamReader(System.in));
        System.out.println(result);
    }

    static class MyReader {
        BufferedReader bf;

        StringTokenizer st;

        String last;

        MyReader(Reader reader) throws IOException {
            bf = new BufferedReader(reader);
            readNextLine();
        }

        String nextToken() throws IOException {
            while (!st.hasMoreTokens()) {
                readNextLine();
            }
            return st.nextToken();
        }

        void readNextLine() throws IOException {
            last = bf.readLine();
            if (last == null) last = "";
            st = new StringTokenizer(last);
        }

        String nextLine() throws IOException {
            String s = last;
            readNextLine();
            return s;
        }

        long nextLong() throws IOException {
            return Long.parseLong(nextToken());
        }

        int nextInt() throws IOException {
            return Integer.parseInt(nextToken());
        }

        double nextDouble() throws IOException {
            return Double.parseDouble(nextToken());
        }

        int[] readIntArray(int n) throws IOException {
            int[] answer = new int[n];
            for (int i = 0; i < n; ++i) {
                answer[i] = nextInt();
            }
            return answer;
        }

        long[] readLongArray(int n) throws IOException {
            long[] answer = new long[n];
            for (int i = 0; i < n; ++i) {
                answer[i] = nextLong();
            }
            return answer;
        }

        double[] readDoubleArray(int n) throws IOException {
            double[] answer = new double[n];
            for (int i = 0; i < n; ++i) {
                answer[i] = nextDouble();
            }
            return answer;
        }
    }
}
