
//When I wrote this code, only God & I understood what it did. Now only God knows !!


import java.util.*;
import java.io.*;
import java.math.*;


public class Main {

    static class FastReader
    {
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public FastReader() { this(System.in); }public FastReader(InputStream is) { mIs = is;}
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];}
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;}
        public String next(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();}
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;}
        public int i(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;}
        public double d() throws IOException {return Double.parseDouble(next()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; }
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; }
        public void scanIntArr(int [] arr){ for(int li=0;li<arr.length;++li){ arr[li]=i();}}
        public void scanLongArr(long [] arr){for (int i=0;i<arr.length;++i){arr[i]=l();}}
        public void shuffle(int [] arr){ for(int i=arr.length;i>0;--i) { int r=(int)(Math.random()*i); int temp=arr[i-1]; arr[i-1]=arr[r]; arr[r]=temp; } }
    }

    public static void main(String[] args) throws IOException {

        FastReader fr = new FastReader();
        PrintWriter pw = new PrintWriter(System.out);
        /*
inputCopy
3
7 7 3 5
1 2
2 3
3 4
4 5
5 6
6 7
7 5
4 5 2 3
1 2
2 3
3 4
4 1
4 2
4 3 2 1
1 2
2 3
4 1
outputCopy
4
0
1


        */
        int t=fr.i();
        for(int ti=0;ti<t;++ti)
        {
            int n=fr.i();
            int m=fr.i();
            int a=fr.i();
            int b=fr.i();
            LinkedList<Integer> adjList []=new LinkedList[n+1];
            for(int i=1;i<=n;++i)
                adjList[i]=new LinkedList<>();
            for(int mi=0;mi<m;++mi)
            {
                int source=fr.i();
                int dest=fr.i();
                adjList[source].add(dest);
                adjList[dest].add(source);
            }
            boolean [] visited1=new boolean[n+1];
            DFS(adjList,a,b,visited1,true);
            boolean [] visited2=new boolean[n+1];
            DFS(adjList,b,a,visited2,false);
            long countA=0,countB=0;
            for(int i=1;i<=n;++i)
            {
                if(visited1[i] && !visited2[i] && i!=a)
                    ++countA;
                else if(visited2[i] && !visited1[i] && i!=b)
                    ++countB;
            }
            //System.err.println(countA+" "+countB);
            long ans=countA*countB;
            pw.println(ans);
        }
        pw.flush();
        pw.close();
    }
    public static void DFS(LinkedList<Integer> [] adjList,int curr,int other,boolean[] visited,boolean flag)
    {
        if(curr==other)
            return;
        visited[curr]=true;
        for(int dest:adjList[curr])
        {
            if(!visited[dest])
                DFS(adjList,dest,other,visited,flag);
        }
    }
}
