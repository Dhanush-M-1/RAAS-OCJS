import java.util.*;
import java.io.*;
import static java.lang.Math.*;
public class Main {
    static final long MOD = 1_000_000_007, INF = 1_000_000_000_000_000L;
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
    static int n, lazy[], tree[], arr[], pref[];
    static void magic() throws IOException {
        reader = new FastReader();
        writer = new PrintWriter(System.out, true);
        n = reader.nextInt();
        int d = reader.nextInt(), max_pref_sum = Integer.MIN_VALUE, pref_sum = 0;
        arr = new int[n];
        pref = new int[n];
        for(int i=0;i<n;++i) {
            arr[i] = reader.nextInt();
            pref_sum+=arr[i];
            pref[i] = pref_sum;
            max_pref_sum = max(max_pref_sum, pref_sum);
        }
        if(max_pref_sum>d) {
            writer.println(-1);
            System.exit(0);
        }
        int sz = (int)pow(2, ceil(log(n)/log(2))+1);
        tree = new int[sz];
        lazy = new int[sz];
        build(1, 0, n-1);
        int ans = 0;
        for(int i=0;i<n;++i) {
            if(arr[i]==0) {
                //writer.println("i: "+i);
                if(i>0) {
                    int prev_pref_sum = query(i-1, i-1);
                    //writer.println("Prev pref sum: "+prev_pref_sum);
                    if(prev_pref_sum<0) {
                        if(i<n-1) {
                            int max_that_can_be_added = d-query(i, n-1);
                            //writer.println("max added: "+max_that_can_be_added);
                            if(prev_pref_sum+max_that_can_be_added>=0) {
                                rangeUpdate(i, n-1, max_that_can_be_added);
                            }
                            else {
                                writer.println(-1);
                                System.exit(0);
                            }
                        }
                        ans++;
                    }
                }
            }
        }
        writer.println(ans);
    }
    static void build(int treein, int low, int high) {
        if(low==high) {
            tree[treein] = pref[low];
            return;
        }
        int mid = (low+high)>>1;
        build(2*treein, low, mid);
        build(2*treein+1, mid+1, high);
        tree[treein] = max(tree[2*treein], tree[2*treein+1]);
    }
    static void rangeUpdate(int l,int r,int val)
    {
        rangeUpdate(1,0,n-1,l,r,val);
    }
    static int query(int l,int r)
    {
        return query(1,0,n-1,l,r);
    }
    static void rangeUpdate(int treein,int low,int high,int l,int r,int val)
    {
        if(lazy[treein]!=0)
        {
            tree[treein]+=lazy[treein];
            if(low!=high)
            {
                lazy[2*treein]+=lazy[treein];
                lazy[2*treein+1]+=lazy[treein];
            }
            lazy[treein] = 0;
        }
        if(l<=low && high<=r)
        {
            tree[treein]+=val;
            if(low!=high)
            {
                lazy[2*treein]+=val;
                lazy[2*treein+1]+=val;
            }
            return;
        }
        if(low>r || high<l)
            return;
        int mid = (low+high)>>1;
        rangeUpdate(2*treein,low,mid,l,r,val);
        rangeUpdate(2*treein+1,mid+1,high,l,r,val);
        tree[treein] = max(tree[2*treein], tree[2*treein+1]);
    }
    static int query(int treein,int low,int high,int l,int r)
    {
        if(lazy[treein]!=0)
        {
            tree[treein]+=lazy[treein];
            if(low!=high)
            {
                lazy[2*treein]+=lazy[treein];
                lazy[2*treein+1]+=lazy[treein];
            }
            lazy[treein] = 0;
        }
        if(l<=low && high<=r)
            return tree[treein];
        if(low>r || high<l)
            return Integer.MIN_VALUE;
        int mid = (low+high)>>1;
        return max(query(2*treein+1,mid+1,high,l,r), query(2*treein,low,mid,l,r));
    }
}