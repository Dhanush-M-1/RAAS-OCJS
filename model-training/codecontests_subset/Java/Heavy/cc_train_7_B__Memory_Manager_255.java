import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    BufferedReader in;
    StringTokenizer st;
    PrintWriter out;

    static class Item {
        int id;
        int start;
        int length;
        boolean special;

        Item(int id, int start, int length, boolean special) {
            this.id = id;
            this.start = start;
            this.length = length;
            this.special = special;
        }
    }

    void solve() throws IOException {
        int ops = nextInt();
        int mem = nextInt();
        List<Item> list = new ArrayList<Item>();
        list.add(new Item(-1, 0, 1, true));
        list.add(new Item(-1, mem + 1, 1, true));
        int ids = 0;
        for (int op = 0; op < ops; ++op) {
            String cmd = next();
            if (cmd.equals("alloc")) {
                int length = nextInt();
                boolean ok = false;
                for (int i = 1; i < list.size(); ++i) {
                    Item prev = list.get(i - 1);
                    Item curr = list.get(i);
                    if (prev.start + prev.length + length <= curr.start) {
                        ok = true;
                        list.add(i, new Item(++ids, prev.start + prev.length, length, false));
                        break;
                    }
                }
                if (ok) {
                    out.println(ids);
                } else {
                    out.println("NULL");
                }
            } else if (cmd.equals("erase")) {
                int what = nextInt();
                boolean ok = false;
                for (int i = 0; i < list.size(); ++i) {
                    if (list.get(i).id == what && !list.get(i).special) {
                        list.remove(i);
                        ok = true;
                        break;
                    }
                }
                if (!ok) {
                    out.println("ILLEGAL_ERASE_ARGUMENT");
                }
            } else if (cmd.equals("defragment")) {
                for (int i = 0; i < list.size(); ++i) {
                    Item item = list.get(i);
                    if (!item.special) {
                        item.start = list.get(i - 1).start + list.get(i - 1).length;
                    }
                }
            } else {
                throw new AssertionError();
            }
        }
    }

    public void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        eat("");
        solve();
        out.close();
        in.close();
    }

    void eat(String s) {
        st = new StringTokenizer(s);
    }

    String next() throws IOException {
        while (!st.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                return null;
            }
            eat(line);
        }
        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        new B().run();
    }
}