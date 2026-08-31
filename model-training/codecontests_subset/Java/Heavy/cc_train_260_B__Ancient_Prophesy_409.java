import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Code implements Runnable {

    public static void main(String[] args) throws IOException {
        new Thread(new Code()).start();
    }

    private void solve() throws IOException {
        String date = nextToken();

        int len = 10;

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        Map<String, Integer> dates = new HashMap<String, Integer>();
        for (int i = 0; i + len - 1 < date.length(); ++i) {
            String local = date.substring(i, i + len);

            if (local.charAt(2) == '-' && local.charAt(5) == '-'
                    && local.charAt(0) >= '0' && local.charAt(0) <= '9'
                    && local.charAt(1) >= '0' && local.charAt(1) <= '9'
                    && local.charAt(3) >= '0' && local.charAt(3) <= '9'
                    && local.charAt(4) >= '0' && local.charAt(4) <= '9'
                    && local.charAt(6) >= '0' && local.charAt(6) <= '9'
                    && local.charAt(7) >= '0' && local.charAt(7) <= '9'
                    && local.charAt(8) >= '0' && local.charAt(8) <= '9'
                    && local.charAt(9) >= '0' && local.charAt(9) <= '9') {
                int day = Integer.parseInt(local.substring(0, 2));
                int month = Integer.parseInt(local.substring(3, 5));
                int year = Integer.parseInt(local.substring(6, 10));

                if (month > 0 && month < 13 && day > 0 && day <= months[month] && year >= 2013 && year <= 2015) {
                    if (dates.containsKey(local))
                        dates.put(local, dates.get(local) + 1);
                    else
                        dates.put(local, 1);
                }
            }
        }

        int max = 0;
        String ans = "";
        for (Map.Entry<String, Integer> entry : dates.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                ans = entry.getKey();
            }
        }

        writer.println(ans);
    }

    private class Pair<E, V> implements Comparable<Pair<E, V>> {
        public Pair(E first, V second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair<E, V> obj) {
            if (first.equals(obj.first)) return ((Comparable) second).compareTo(obj.second);
            return ((Comparable) first).compareTo(obj.first);
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;
            return first.equals(other.first) && second.equals(other.second);
        }

        @Override
        public String toString() {
            return first + " " + second;
        }

        public E first;
        public V second;
    }

    @Override
    public void run() {
        try {
            if (in.equals(""))
                reader = new BufferedReader(new InputStreamReader(System.in));
            else
                reader = new BufferedReader(new FileReader(in));

            if (out.equals(""))
                writer = new PrintWriter(new OutputStreamWriter(System.out), false);
            else
                writer = new PrintWriter(new FileWriter(out), false);

            solve();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //writer.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024 + " KB");

            try {
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    private float nextFloat() throws IOException {
        return Float.parseFloat(nextToken());
    }

    private String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(reader.readLine());

        return st.nextToken();
    }

    private String in = "", out = "";
    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer st;
}