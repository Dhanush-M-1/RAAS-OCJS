import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

class Data{
    int k;
    int l;
    int r;
    int dif;
    int rk;
    public Data(int k, int l, int r, int n){
        this.k = k;
        this.l = l;
        this.r = r;
        dif = Math.abs(l - r);
        rk = n - k;
    }
}

public class Main {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int tcnum = sc.nextInt();
        PriorityQueue<Data> ldata = new PriorityQueue<Data>((a, b) -> a.k - b.k);
        PriorityQueue<Data> lque = new PriorityQueue<Data>((a, b) -> a.dif - b.dif);
        PriorityQueue<Data> rdata = new PriorityQueue<Data>((a, b) -> a.rk - b.rk);
        PriorityQueue<Data> rque = new PriorityQueue<Data>((a, b) -> a.dif - b.dif);
        for (int tc = 0; tc < tcnum; tc++) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int mk = sc.nextInt();
                int ml = sc.nextInt();
                int mr = sc.nextInt();
                Data mdata = new Data(mk, ml , mr, n);
                if(ml > mr){
                    ldata.add(mdata);
                }else{
                    rdata.add(mdata);
                }
            }

            long ans = 0;
            while(!ldata.isEmpty()){
                Data mdata = ldata.poll();
                if(mdata.k > lque.size()){
                    ans += mdata.l;
                    lque.add(mdata);
                }else{
                    Data top = lque.peek();
                    if(mdata.dif > top.dif){
                        ans += mdata.l;
                        ans -= top.l;
                        ans += top.r;
                        lque.poll();
                        lque.add(mdata);
                    }else{
                        ans += mdata.r;
                    }
                }
            }

            while(!rdata.isEmpty()){
                Data mdata = rdata.poll();
                if(mdata.rk > rque.size()){
                    ans += mdata.r;
                    rque.add(mdata);
                }else if(mdata.rk == 0){
                    ans += mdata.l;
                }else{
                    Data top = rque.peek();
                    if(mdata.dif > top.dif){
                        ans += mdata.r;
                        ans -= top.r;
                        ans += top.l;
                        rque.poll();
                        rque.add(mdata);
                    }else{
                        ans += mdata.l;
                    }
                }
            }

            ldata.clear();
            lque.clear();
            rdata.clear();
            rque.clear();
            System.out.println(ans);
        }
    }

    private static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;

        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            } else {
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }

        private int readByte() {
            if (hasNextByte())
                return buffer[ptr++];
            else
                return -1;
        }

        private static boolean isPrintableChar(int c) {
            return 33 <= c && c <= 126;
        }

        public boolean hasNext() {
            while (hasNextByte() && !isPrintableChar(buffer[ptr]))
                ptr++;
            return hasNextByte();
        }

        public String next() {
            if (!hasNext())
                throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while (isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public long nextLong() {
            if (!hasNext())
                throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while (true) {
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                } else if (b == -1 || !isPrintableChar(b)) {
                    return minus ? -n : n;
                } else {
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }

        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE)
                throw new NumberFormatException();
            return (int) nl;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
