
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.*;



public class Main {
    private static int n,R,C;
    private static String [] line;
    private static char [] [] out;
    private static int S,E;


    private static void solve(){
        Deque<Integer> dq = new ArrayDeque<>();
        int sum = 0,ctr = 0;
        int [] cnt = new int[n+1];
        boolean [] inDq = new boolean[n];
        for (int i = 0,j = 0;i < n;i++) {
            if (j < i) {
                j = i;
                sum = ctr = 0;
                dq.clear();
            }
            while (j < n && sum + line[j].length() <= C) {
                sum += line[j].length();
                ctr ++;
                dq.addLast(j);
                inDq[j] = true;
                if (sum < C) {
                    sum++;
                    dq.addLast(-1);
                }
                j++;
            }
//            System.err.println(i + ": " + dq);
            if (inDq[i]) cnt[i] = ctr;
            while (!dq.isEmpty() && (dq.getFirst() == -1 || dq.getFirst() == i)) {
                int k = dq.pollFirst();
                if (k == -1) sum--;
                else {
                    sum -= line[k].length();
                    ctr--;
                }
            }
            if (!dq.isEmpty() && dq.getLast() != -1) {
                sum++;
                dq.add(-1);
            }
        }

//        System.err.println(Arrays.toString(cnt));
        int mx = 0;
        S = E = 0;

        int [] depth = new int[n+1];
        for (int i = n-1;i >= 0;i--)
            if (cnt[i] != 0)
                depth[i] = depth[i + cnt[i]] + 1;
        int MAXLG = 18;
        int [] [] P = new int[n+1][MAXLG];
        for (int u = n;u >= 0;u--){
            int p = u + cnt[u];
            if (u == p) {
                for (int i = 0;i < MAXLG;i++)
                    P[u][i] = u;
            }
            else {
                P[u][0] = p;
                for (int i = 0;i+1 < MAXLG;i++)
                    P[u][i+1] = P[P[u][i]][i];
            }
//            System.err.printf("P[%d] = %d\n",u,p);
        }
        for (int u = 0;u < n;u++) {
            int k = depth[u];
            if (k > R )
                k = R ;
//            System.err.print(u + "^" + k + " = ");
            int v = u,i = 0;
            while (k > 0) {
                int r = k & -k;
                while (r != (1 << i)) i++;
                v = P[v][i];
                k ^= r;
            }
//            System.err.println(v);
            if (v - u > mx) {
                mx = v - u;
                S = u;
                E = v;
            }
        }
    }

    private static void build() throws Exception{
        out = new char[R][C];
        for (int r = 0;r < R;r++)
            for (int c = 0;c < C;c++)
                out[r][c] = ' ';
        for (int i = S,r = 0;r < R;r++){
            for (int c = 0;i < E && c + line[i].length() <= C;i++){
                for (char ch : line[i].toCharArray())
                    out[r][c++] = ch;
                if (c != C) out[r][c++] = ' ';
            }
        }
    }
    public static void main(String[] args) throws Exception {
        IO io ;
        try {
            io = new IO("in.in", null);
        } catch (IOException e) {
            io = new IO(null, null);
        }

        n = io.getNextInt();
        R = io.getNextInt();
        C = io.getNextInt();
        line = new String[n];
        for (int i = 0;i < n;i++)
            line[i] = io.getNext();

        solve();
        build();
        for (int r = 0;r < R;r++)
            io.println(new String(out[r]));
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