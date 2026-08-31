import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }

    public static class pair {
        int l;
        int r;

        pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { -1, 1 },
            { 1, -1 } };

    public static boolean isAllowed(int r, int c, HashMap<Integer, ArrayList<Integer>> map) {
        if (map.containsKey(r)) {
            ArrayList<Integer> list = map.get(r);
            for (int ele : list)
                if (ele == c)
                    return true;
        }
        return false;
    }

    public static long bfs(int sr, int sc, int er, int ec, HashMap<Integer, ArrayList<Integer>> map) {
        Queue<Long> qu = new LinkedList<>();
        HashSet<Long> isVis = new HashSet<>();

        long num = (sr * (long) 1e9 + sc);
        qu.add(num);
        isVis.add(num);

        long level = 0;

        while (!qu.isEmpty()) {
            long size = qu.size();

            while (size-- > 0) {
                long rvtx = qu.remove();

                long cr = rvtx / (long) 1e9;
                long cc = rvtx % (long) 1e9;

                if ((int) cr == er && (int) cc == ec)
                    return level;

                for (int d = 0; d < 8; d++) {
                    long nr = cr + dir[d][0];
                    long nc = cc + dir[d][1];

                    long num2 = nr * (long) 1e9 + nc;

                    if (nr >= 1 && nc >= 1 && nr <= (long) 1e9 && nc <= (long) 1e9 && !isVis.contains(num2)
                            && isAllowed((int) nr, (int) nc, map)) {
                        qu.add(num2);
                        isVis.add(num2);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        Reader scn = new Reader();
        StringBuilder res = new StringBuilder();
        int x_i = scn.nextInt();
        int y_i = scn.nextInt();
        int x_f = scn.nextInt();
        int y_f = scn.nextInt();

        int n = scn.nextInt();
        // HashSet<pair> set = new HashSet<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        while (n-- > 0) {
            int r = scn.nextInt();
            int left = scn.nextInt();
            int right = scn.nextInt();

            ArrayList<Integer> list;
            if (map.containsKey(r)) {
                list = map.get(r);
            } else {
                list = new ArrayList<>();
            }

            for (int i = left; i <= right; i++)
                list.add(i);

            map.put(r, list);
        }
        res.append(bfs(x_i, y_i, x_f, y_f, map));
        System.out.print(res);
    }
}