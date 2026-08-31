import java.util.*;
import java.io.*;
//import static java.lang.Math.*;
import java.lang.*;

public class Main {
    public static void main(String [] args) throws Exception{
        Main mainClass = new Main();
    }
    
    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;

    
    public String next() throws Exception{
        if (st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    
    public int nextInt() throws Exception{
        return Integer.parseInt(next());
    }
    
    public double nextDouble() throws Exception{
        return Double.parseDouble(next());
    }
    
    public long nextLong() throws Exception{
        return Long.parseLong(next());
    }
    
    
    public Main() throws Exception{
        
        in = new BufferedReader(new InputStreamReader(System.in));
        
        //in = new BufferedReader(new FileReader("in.txt"));
        
        out = new PrintWriter(new OutputStreamWriter(System.out));
        //out = new PrintWriter(new FileWriter("out.txt"));
        solve();
        out.close();
    }
    
public void solve() throws Exception
{
    double n = nextDouble();
    double x = nextDouble();
    double y = nextDouble();
    double k = y*n/100;
    double j = 0;

        j = k - x;
//      System.out.println(k);
        if (j<0) System.out.println(0);
        else
        System.out.println((int)Math.ceil(j));
    
    
    
}
    
    
}