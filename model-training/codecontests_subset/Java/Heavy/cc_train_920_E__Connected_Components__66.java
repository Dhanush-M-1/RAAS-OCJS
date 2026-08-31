import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ListIterator;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.AbstractCollection;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Collections;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author cacophonix
 */
public class Main {
    public static void main(String[] args) {
        new Thread(null,new TaskE(),"Main",1<<28).start();
    }

    static class TaskE extends Thread{

        public void run(){
            InputStream inputStream = System.in;
            OutputStream outputStream = System.out;
            InputReader in = new InputReader(inputStream);
            OutputWriter out = new OutputWriter(outputStream);
            solve(1, in, out);
            out.close();
        }

        static LinkedList<Integer> ll = new LinkedList<>();
        HashSet<Integer>[] ed = new HashSet[222222];
        UF uf;

        void fun(int node) {

            ListIterator<Integer> it = ll.listIterator(0);
            LinkedList<Integer> ls=new LinkedList<>();

            while (it.hasNext()) {
                int val = it.next();
                if (!ed[node].contains(val)) {
                    uf.uni(node, val);
                    it.remove();
                    ls.addLast(val);
                }
            }

            it = ls.listIterator(0);

            while (it.hasNext()) {
                int val = it.next();
                fun(val);
            }

        }

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            int n = in.readInt();
            int m = in.readInt();
            for (int i = 0; i < n; i++) {
                ed[i] = new HashSet<>();
                ll.addLast(i);
            }
            for (int j = 0; j < m; j++) {
                int a = in.readInt();
                int b = in.readInt();
                a--;
                b--;
                ed[a].add(b);
                ed[b].add(a);
            }
            uf = new UF(n);

            while (!ll.isEmpty()) {
                ListIterator<Integer> it = ll.listIterator(0);
                int val = it.next();
                it.remove();
                fun(val);
            }

//        for(int i=0;i<n;i++){
//            //if(ed[i].)
//            int cnt=0;
//            for(int j=0;j<n;j++){
//                if(i==j)continue;
//                if(!ed[i].contains(j)){
//                    uf.uni(i,j);
//                    cnt++;
//                    if(cnt>100)break;
//                }
//            }
//        }
            ArrayList<Integer> arr = new ArrayList<>();
            boolean[] past = new boolean[n + 3];
            for (int i = 0; i < n; i++) {
                int par = uf.find(i);
                if (!past[par]) {
                    past[par] = true;
                    arr.add(uf.sz[par]);
                }
            }
            Collections.sort(arr);
            out.printLine(arr.size());
            for (int i = 0; i < arr.size(); i++) {
                out.print(arr.get(i) + " ");
            }
        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0) {
                    writer.print(' ');
                }
                writer.print(objects[i]);
            }
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
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
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class UF {
        int t;
        int[] id;
        int[] sz;

        UF(int n) {
            t = n;
            id = new int[n];
            sz = new int[n];
            for (int i = 0; i < n; i++) {
                sz[i] = 1;
                id[i] = i;
            }
        }

        int find(int p) {
            while (p != id[p]) p = id[p];
            return p;
        }

        void uni(int p, int q) {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (sz[i] < sz[j]) {
                id[i] = j;
                sz[j] += sz[i];
            } else {
                id[j] = i;
                sz[i] += sz[j];
            }
            t--;
        }

    }
}