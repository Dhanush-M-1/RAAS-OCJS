import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solver {

    StringTokenizer st;
    BufferedReader in;
    PrintWriter out;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Solver solver = new Solver();
        solver.open();
        long time = System.currentTimeMillis();
        solver.solve();
        if (!"true".equals(System.getProperty("ONLINE_JUDGE"))) {
            System.out.println("Spent time: " + (System.currentTimeMillis() - time));
        }
        solver.close();
    }

    public void open() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
    }

    public String nextToken() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws NumberFormatException, IOException {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws NumberFormatException, IOException {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws NumberFormatException, IOException {
        return Double.parseDouble(nextToken());
    }
    

    String encrypt(String s){
        String result = "";
        for(int i=0;i<s.length();i++){
            result += (char)(s.charAt(i)=='Z' ? 'A' : s.charAt(i)+1);
        }
        return result;
    }
    
    boolean check(int[][] ar, int r1, int r2, int c1, int c2, int d1, int d2){
        return ar[0][0]+ar[0][1]==r1 &&
                ar[1][0]+ar[1][1]==r2 &&
                ar[0][0]+ar[1][0]==c1 &&
                ar[0][1]+ar[1][1]==c2 &&
                ar[0][0]+ar[1][1]==d1 &&
                ar[0][1]+ar[1][0]==d2;
    }
    
    public void solve() throws NumberFormatException, IOException {
        int r1 = nextInt();
        int r2 = nextInt();
        int c1 = nextInt();
        int c2 = nextInt();
        int d1 = nextInt();
        int d2 = nextInt();
        
        int[][] ar = new int[2][2];
        
        for(int i=1;i<=9;i++)
            for(int j=1;j<=9;j++)
                if(i!=j)
                    for(int k=1;k<=9;k++)
                        if(k!=i && k!=j)
                            for(int l=1;l<=9;l++)
                                if(l!=i && l!=j && l!=k)
                                    if(check(new int[][]{{i,j},{k,l}}, r1, r2, c1, c2, d1, d2)){
                                        out.println(i+" "+j+"\n"+k+" "+l);
                                        return;
                                    }
        out.println(-1);
    }

    public void close() {
        out.flush();
        out.close();
    }

}