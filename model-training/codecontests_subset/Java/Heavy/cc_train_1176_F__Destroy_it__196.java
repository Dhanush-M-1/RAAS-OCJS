import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main {
    static final long MOD = 1_000_000_007 , INF = 1_000_000_000_000_000_000L;
    static final int INf = 1_000_000_000;
    static FastReader reader;
    static PrintWriter writer;
    public static void main(String[] args) {
        Thread t = new Thread(null, new O(), "Integer.MAX_VALUE", 100000000);
        t.start();
    }
    static class O implements Runnable {
        public void run() {
            try {
                magic();
            }
            catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }
    static class FastReader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000];
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (c == '.') while ((c = read()) >= '0' && c <= '9') ret += (c - '0') / (div *= 10);
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;
            din.close();
        }
    }
    static long cost[][], damage[][];
    static long dp[][];
    static int nturns;
    static ArrayList<Long> damage_at_cost[][];
    static void magic() throws IOException {
        reader = new FastReader();
        writer = new PrintWriter(System.out, true);
        nturns = reader.nextInt();
        cost = new long[nturns][];
        damage = new long[nturns][];
        damage_at_cost = new ArrayList[nturns][3];
        for(int i=0;i<nturns;++i) {
            int len = reader.nextInt();
            cost[i] = new long[len];
            damage[i] = new long[len];
            damage_at_cost[i][0] = new ArrayList<>();
            damage_at_cost[i][1] = new ArrayList<>();
            damage_at_cost[i][2] = new ArrayList<>();
            for(int j=0;j<len;++j) {
                cost[i][j] = reader.nextInt();
                damage[i][j] = reader.nextInt();
                damage_at_cost[i][(int)cost[i][j]-1].add(damage[i][j]);
            }
            Collections.sort(damage_at_cost[i][0]);
            Collections.sort(damage_at_cost[i][1]);
            Collections.sort(damage_at_cost[i][2]);
        }
        dp = new long[nturns][10];
        for(int i=0;i<nturns;++i) {
            for(int j=0;j<10;++j) {
                dp[i][j] = -1;
            }
        }
        writer.println(f(0,0));
    }
    static long f(int idx, int pos) {
        if(idx==nturns) {
            return 0;
        }
        if(dp[idx][pos]!=-1) {
            return dp[idx][pos];
        }
        long max = 0;
        long max1 = 0, max2 = 0, max3 = 0;
        if(!damage_at_cost[idx][0].isEmpty()) {
            max1 = damage_at_cost[idx][0].get(damage_at_cost[idx][0].size()-1);
        }
        if(!damage_at_cost[idx][1].isEmpty()) {
            max2 = damage_at_cost[idx][1].get(damage_at_cost[idx][1].size()-1);
        }
        if(!damage_at_cost[idx][2].isEmpty()) {
            max3 = damage_at_cost[idx][2].get(damage_at_cost[idx][2].size()-1);
        }
        //playing no card
        max = max(max, f(idx+1, pos));
        //playing one card
        long max_damage = max(max1, max(max2, max3));
        max = max(max, f(idx+1, (pos+1)%10) + (pos == 9 ? 2*max_damage : max_damage));
        //playing two cards
        if(damage_at_cost[idx][0].size()>1) {
            long max11 = damage_at_cost[idx][0].get(damage_at_cost[idx][0].size()-1);
            long max12 = damage_at_cost[idx][0].get(damage_at_cost[idx][0].size()-2);
            if(pos>=8) {
                max = max(max, f(idx+1, (pos+2)%10) + 2*max11 + max12);
            }
            else {
                max = max(max, f(idx+1, (pos+2)%10) + max11 + max12);
            }
        }
        if(max1>0 && max2>0) {
            if(pos>=8) {
                max = max(max, f(idx+1, (pos+2)%10) + 2*max(max1, max2) + min(max1, max2));
            }
            else {
                max = max(max, f(idx+1, (pos+2)%10) + max1 + max2);
            }
        }
        //playing three
        int sz = damage_at_cost[idx][0].size();
        if(sz>=3) {
            long max11 = damage_at_cost[idx][0].get(sz-1);
            long max12 = damage_at_cost[idx][0].get(sz-2);
            long max13 = damage_at_cost[idx][0].get(sz-3);
            if(pos>=7) {
                max = max(max, f(idx+1, (pos+3)%10) + 2*max11 + max12 + max13);
            }
            else {
                max = max(max, f(idx+1, (pos+3)%10) + max11 + max12 + max13);
            }
        }
        return dp[idx][pos] = max;
    }
}