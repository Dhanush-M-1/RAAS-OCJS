import java.io.BufferedWriter;
import java.util.*;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.IOException;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        TaskB solver = new TaskB();
        solver.solve(1, in, out);
        out.close();
    }
}

class TaskB {

    int[] parent,maxLength,dist;
    List<Integer>[] graph;
    List<Integer>aux;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n=in.readInt(),m=in.readInt(), q=in.readInt();
        parent=new int[n];
        maxLength=new int[n];
        graph=new List[n];
        dist=new int[n];
        Arrays.fill(dist,-1);
        aux=new ArrayList<>();
        for(int i=0; i<n;i++) graph[i]=new ArrayList<>();
        for (int i=0; i<n; i++) parent[i]=i;
        while(m-->0){
            int a=in.readInt()-1,b=in.readInt()-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i=0; i<n; i++) if(dist[i]==-1){
            dist[i]=0;
            dfs(i, -1);
            int max=-1, id=-1;
            for (int j:aux) {if (dist[j]>max) {
                max=dist[j];
                id=j;
            }dist[j]=0;}
            aux.clear();
            dfs(id,-1);
            max=-1;
            for(int j:aux){
                max=Math.max(max,dist[j]);
                parent[j]=i;
            }
            aux.clear();
            maxLength[i]=max;
        }
        while(q-->0){
            int t=in.readInt(),x=in.readInt()-1;
            if(t==1)out.printLine(maxLength[get(x)]);
            else {
                int y=in.readInt()-1;
                x=get(x);
                y=get(y);
                if(x==y)continue;
                parent[y]=x;
                maxLength[x]=Math.max(Math.max(maxLength[x], maxLength[y]),(maxLength[x]+1)/2+(maxLength[y]+1)/2+1);
            }
        }
    }
    
    int get(int x){
        return x==parent[x]?x:(parent[x]=get(parent[x]));
    }
    
    void dfs(int u, int p){
        aux.add(u);
        for(int i:graph[u])if(i!=p){
            dist[i]=dist[u]+1;
            dfs(i, u);
        }
    }
}

class InputReader {

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int readInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String readString() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c))
                res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

class OutputWriter {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public void print(Object...objects) {
        for (int i = 0; i < objects.length; i++) {
            if (i != 0)
                writer.print(' ');
            writer.print(objects[i]);
        }
    }

    public void printLine(Object...objects) {
        print(objects);
        writer.println();
    }

    public void close() {
        writer.close();
    }

}
