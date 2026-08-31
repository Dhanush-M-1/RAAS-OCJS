import java.util.*;
import java.io.*;
import java.math.*;
 
public class Main {
    static PrintWriter out;
    static Reader in;
    public static void main(String[] args) throws IOException {
        //out = new PrintWriter(new File("out.txt"));
        //PrintWriter out = new PrintWriter(System.out);
        //in = new Reader(new FileInputStream("in.txt"));
        //Reader in = new Reader();
        input_output();
        Main solver = new Main();
        solver.solve();
        out.flush();
        out.close();
 
    }
 
    static int INF = (int)2e9+5;
    static int maxn = (int)2e6+5;
    static int mod=(int)1e9+7 ;
    static int n, m, t, q, k;
 
    static int[] ti, a, b;
    static int cnt[], sum[], size;

    void solve() throws IOException{
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        ti = new int[n+1];
        a = new int[n+1];
        b = new int[n+1];
        ArrayList<Book> oo = new ArrayList<>(),
                        oz = new ArrayList<>(),
                        zo = new ArrayList<>(),
                        add = new ArrayList<>();
        add.add(new Book(0));
        for (int i = 1; i <= n; i++) {
            ti[i] = in.nextInt();
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            if (a[i] == 1 && b[i] == 1) oo.add(new Book(i));
            else if (a[i] == 1 && b[i] == 0) oz.add(new Book(i));
            else if (a[i] == 0 && b[i] == 1) zo.add(new Book(i));
            if (a[i] != 1 || b[i] != 1) add.add(new Book(i));
        }

        Collections.sort(oo);Collections.sort(zo);Collections.sort(oz);Collections.sort(add);
        int[] map = new int[n+1];
        for (int i = 1; i < add.size(); i++) {
            map[add.get(i).id] = i;
        }

        size = add.size();
        cnt = new int[size+5];
        sum = new int[size+5];

        for (int i = 1; i < size; i++) {
            update(cnt, i, 1);
            update(sum, i, ti[add.get(i).id]);
        }

        int curAns = 0, ans = INF, id = -1, curl = 0, curr = 0, left = 0, elmId = 0, curSize = 0, tmpAns = 0;
        for (int i = 0; i < oo.size(); i++) {
            curAns += ti[oo.get(i).id];
            curSize++;
        }

        for (int i = oo.size(); i >= 0; i--) {
            if (i > m) {
                curAns -= ti[oo.get(i-1).id];
                curSize--;
                continue;
            }
            
            left = k-i;
            if (left > 0) {
                if (left > Math.min(zo.size(), oz.size())) break;
                while (curl < left) {
                    elmId = oz.get(curl).id;
                    elmId = map[elmId];
                    update(cnt, elmId, -1);
                    update(sum, elmId, -ti[oz.get(curl).id]);
                    curAns += ti[oz.get(curl).id];
                    curl++;
                    curSize++;
                }
                while (curr < left) {
                    elmId = zo.get(curr).id;
                    elmId = map[elmId];
                    update(cnt, elmId, -1);
                    update(sum, elmId, -ti[zo.get(curr).id]);
                    curAns += ti[zo.get(curr).id];
                    curr++;
                    curSize++;
                }
            }
            
            left = m-curSize;
            if (left > 0) {
                tmpAns = bs(left);
                if (tmpAns == -1) break;
                tmpAns = curAns+tmpAns;
                if (tmpAns < ans) {
                    ans = tmpAns;
                    id = i;
                }
            } else if (left == 0) {
                tmpAns = curAns;
                if (curAns < ans) {
                    ans = curAns;
                    id = i;
                }
            } else break;

            if (i != 0) {
                curAns -= ti[oo.get(i-1).id];
                curSize--;
            }
        }

        if (id == -1) {
            out.println(-1);
            return;
        }

        out.println(ans);
        curSize = id;
        for (int i = 0; i < id; i++) out.print(oo.get(i).id+" ");
        left = k-id;
        boolean[] vis = new boolean[size+5];
        for (int i = 0; i < left; i++) {
            curSize+=2;
            out.print(oz.get(i).id+" "+zo.get(i).id+" ");
            vis[map[oz.get(i).id]] = true;
            vis[map[zo.get(i).id]] = true;
        }

        for (int i = 1; i < size && curSize < m; i++) {
            if (vis[i] == true) continue;
            curSize++;
            out.print(add.get(i).id+" ");
        }
        out.println();


    }
 
    //<>

    static int bs(int x) {
        int lo = 1, hi = size-1, mid, res = -1;

        while (lo <= hi) {
            mid = (lo+hi)/2;
            if (get(cnt, mid) >= x) {
                hi = mid-1;
                res = mid;
            } else lo = mid+1;
        }

        return (res == -1) ? -1: get(sum,res); 
    }

    static void update(int[] bit, int x, int val) {
        for (int i = x; i < size; i+=i&-i)
            bit[i]+=val;
    }

    static int get(int[] bit, int x) {
        int res = 0;
        for (int i = x; i > 0; i-=i&-i)
            res += bit[i];
        return res;
    }

    static class Book implements Comparable<Book>{
        int id;

        Book(int id) {
            this.id = id;
        }

        public int compareTo(Book o) {
            return ti[this.id] - ti[o.id];
        }
    }
    
    static class Reader {
 
        private InputStream mIs;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
    
        public Reader() {
            this(System.in);
        }
    
        public Reader(InputStream is) {
            mIs = is;
        }
    
        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
    
        }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = mIs.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }
    
        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }
    
        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }
    
        double nextDouble()
        {
            return Double.parseDouble(next());
        }
    
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }
    
        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
    
        public boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
    }
    static void input_output() throws IOException {
        File f = new File("in.txt");
        if(f.exists() && !f.isDirectory()) { 
            in = new Reader(new FileInputStream("in.txt"));
        } else in = new Reader();
        f = new File("out.txt");
        if(f.exists() && !f.isDirectory()) {
            out = new PrintWriter(new File("out.txt"));
        } else out = new PrintWriter(System.out);
    }
}