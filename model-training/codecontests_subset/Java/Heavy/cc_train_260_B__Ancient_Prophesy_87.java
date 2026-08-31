import java.io.*;
import java.net.URL;
import java.util.*;

public class Template implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    void init() throws FileNotFoundException {
        try {
            in = new BufferedReader(new FileReader("input.txt"));
            out = new PrintWriter("output.txt");
        } catch (Exception e) {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            try {
                tok = new StringTokenizer(in.readLine(), " :");
            } catch (Exception e) {
                return null;
            }
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    int[] readIntArray(int size) throws IOException {
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = readInt();
        }
        return res;
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    <T> List<T>[] createGraphList(int size) {
        List<T>[] list = new List[size];
        for (int i = 0; i < size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    public static void main(String[] args) {
        new Template().run();
        // new Thread(null, new Template(), "", 1l * 200 * 1024 * 1024).start();
    }

    long timeBegin, timeEnd;

    void time() {
        timeEnd = System.currentTimeMillis();
        System.err.println("Time = " + (timeEnd - timeBegin));
    }

    long memoryTotal, memoryFree;

    void memory() {
        memoryFree = Runtime.getRuntime().freeMemory();
        System.err.println("Memory = " + ((memoryTotal - memoryFree) >> 10)
                + " KB");
    }

    public void run() {
        try {
            timeBegin = System.currentTimeMillis();
            memoryTotal = Runtime.getRuntime().freeMemory();
            init();
            solve();
            out.close();
            if (System.getProperty("ONLINE_JUDGE") == null) {
                time();
                memory();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    int[] convert(List<Integer> list) {
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    boolean ok(char[] a, int from) {
        try {
            if (a[from + 2] != '-') return false;
            if (a[from + 5] != '-') return false;

            int year = getInt(a, from + 6, 4);
            if (year < 2013) return false;
            if (year > 2015) return false;
            int mongth = getInt(a, from + 3, 2);
            if (mongth < 1) return false;
            if (mongth > 12) return false;
            int day = getInt(a, from, 2);
            if (day < 1) return false;
            if (day > days[mongth - 1]) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    int getInt(char[] a, int from, int len) {
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (a[from + i] == '-') return -1;
            res = res * 10 + a[from + i] - '0';
        }
        return res;
    }

    void solve() throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        String input = readString();
        char[] a = input.toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (ok(a, i)) {
                String s = input.substring(i, i + 10);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int max = -1;
        String res = null;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                res = e.getKey();
            }
        }
        out.println(res);
    }


}