
import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.text.DecimalFormat;
import java.util.*;




public class Main {
    private static int n,m;
    private static HashSet [] G ;
    private static ArrayList<Integer> ans = new ArrayList<>();
    private static TreeSet<Integer> TS = new TreeSet<>();

    private static int dfs(int u) {
        int ret = 1;
        LinkedList<Integer> T = new LinkedList<>();
        for (int v : TS) if (!G[u].contains(v))T.add(v);

        for (int v : T) TS.remove(v);

//        System.err.println(u + ": " + T);

        for (int v : T) ret += dfs(v);

        return ret;
    }

    public static void main(String[] args) throws Exception{
        IO io = new IO(null,null);
        n = io.getNextInt();
        m = io.getNextInt();
        G = new HashSet[n+1];
        for (int i = 1;i <= n;i++) {
            G[i] = new HashSet();
            TS.add(i);
        }
        for (int i = 0;i < m;i++) {
            int a = io.getNextInt(),b = io.getNextInt();
            G[a].add(b);
            G[b].add(a);
        }
        while (!TS.isEmpty()) ans.add(dfs(TS.pollFirst()));
        io.println(ans.size());
        Collections.sort(ans);
        for (int x : ans) io.print(x + " ");

        io.close();
    }
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


