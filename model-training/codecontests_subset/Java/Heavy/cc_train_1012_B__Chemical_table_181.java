import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;



public class Main {

    private static int [] W,id;
    private static int n,m,q,N;

    private static int find(int a) {
        return id[a] = (a == id[a]) ? a : find(id[a]);
    }
    private static void join(int a,int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (W[a] < W[b]) {
            int t = a;
            a = b;
            b = t;
        }
        W[a] += W[b];
        id[b] = a;
        N--;
    }

    public static void main(String[] args) throws Exception {
        IO io = null;
        try {
            io = new IO("noureldin.in", null);
        } catch (IOException e) {
            io = new IO(null, null);
        }

        n = io.getNextInt();
        m = io.getNextInt();
        q = io.getNextInt();
        int [] X = new int[q];
        int [] Y = new int[q];
        W = new int[n+m+1];
        id = new int[n+m+1];
        N = n + m;
        for (int i = 0;i <= n+m;i++) {
            id[i] = i;
            W[i] = 1;
        }
        for (int i = 0;i < q;i++) {
            X[i] = io.getNextInt();
            Y[i] = io.getNextInt();
            join(X[i],Y[i] + n);
        }
        io.println(N - 1);
        io.close();
    }
    private static final int onebillion7 = 1000000007;
}


class IO{
    private BufferedReader br;
    private StringTokenizer st;
    private PrintWriter writer;
    private String inputFile,outputFile;

    public boolean hasMore() throws IOException{
        if(st != null && st.hasMoreTokens()) return true;
        if(br != null && br.ready()) return true;
        return false;
    }

    public String getNext() throws FileNotFoundException, IOException{
        while(st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    public String getNextLine() throws FileNotFoundException, IOException{
        return br.readLine().trim();
    }

    public int getNextInt() throws FileNotFoundException, IOException{
        return Integer.parseInt(getNext());
    }
    public long getNextLong() throws FileNotFoundException, IOException{
        return Long.parseLong(getNext());
    }

    public void print(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f" ,x);
    }
    public void println(double x,int num_digits) throws  IOException{
        writer.printf("%." + num_digits + "f\n" ,x);
    }
    public void print(Object o) throws  IOException{
        writer.print(o.toString());
    }

    public void println(Object o) throws  IOException{
        writer.println(o.toString());
    }
    public IO(String x,String y) throws FileNotFoundException, IOException{
        inputFile = x;
        outputFile = y;
        if(x != null) br = new BufferedReader(new FileReader(inputFile));
        else br = new BufferedReader(new InputStreamReader(System.in));
        if(y != null) writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile)));
        else writer = new PrintWriter(new OutputStreamWriter(System.out));
    }

    protected void close() throws IOException{
        br.close();
        writer.close();
    }
    public void outputArr(Object [] A) throws IOException{
        int L = A.length;
        for (int i = 0;i < L;i++) {
            if(i > 0) writer.print(" ");
            writer.print(A[i]);
        }
        writer.print("\n");
    }
}