import java.util.*;
import java.lang.*;
import java.io.*;
public  class Solution{
    static ArrayList<Integer> al;
    public static void main(String[] args) {
        InputReader fi=new InputReader(System.in);
        int i,j,k,t,n,m;
        al=new ArrayList<>();
        n=fi.nextInt();
        m=fi.nextInt();
        Graph g=new Graph(n,m);
        for (i=0;i<m;i++){
            g.addEdge(fi.nextInt(),fi.nextInt());
        }
        g.calcComponents();
        Collections.sort(al);
        System.out.println(al.size());
        Iterator<Integer> it=al.iterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }


    }
    static class Graph{
        int n,m;
        HashSet<Integer> adj[];
       static TreeSet<Integer> ts;
        Graph(int n,int m){
            this.n=n;
            this.m=m;
            adj=new HashSet[n+1];
            ts=new TreeSet<>();
            for (int i=0;i<=n ;i++ ) {
                adj[i]=new HashSet<>();
                adj[i].add(i);
                if (i>=1)
                ts.add(i);
            }

        }

        void addEdge(int i,int j){
            adj[i].add(j);
            adj[j].add(i);
        }

        void calcComponents(){
            int i,j;
            while (!ts.isEmpty()){
                int size=dfs(ts.pollFirst());
                al.add(size);
            }
        }
        int  dfs(int start){
            int size=1;
            int j;

            LinkedList<Integer> l=new LinkedList<>();
            for ( int  i : ts) {
                if (!adj[start].contains(i))
                    l.add(i);
            }

            for (int v : l) {
                ts.remove(v);
            }
            for (int v : l){
                size=size+dfs(v);
            }

            return size;
        }
    }

}


class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int snext() {
        if (snumChars == -1)
            throw new InputMismatchException();
        if (curChar >= snumChars) {
            curChar = 0;
            try {
                snumChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (snumChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = snext();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = snext();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = snext();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public int[] nextIntArray(int n) {
        int a[] = new int[n+1];
        for (int i = 1; i <= n; i++)
            a[i] = nextInt();
        return a;
    }

    public String readString() {
        int c = snext();
        while (isSpaceChar(c))
            c = snext();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = snext();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}


