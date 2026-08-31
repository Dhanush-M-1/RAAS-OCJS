import java.io.*;
import java.util.*;

import org.omg.CORBA.FREE_MEM;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }
    StreamTokenizer in; PrintWriter out; boolean oj;
    BufferedReader br; Reader reader; Writer writer;

    void init() throws IOException {
        Locale.setDefault(Locale.US);
        oj = System.getProperty("ONLINE_JUDGE") != null;
        reader = oj ? new InputStreamReader(System.in) : new FileReader("input.txt");
        writer = oj ? new OutputStreamWriter(System.out) : new FileWriter("output.txt");
        br = new BufferedReader(reader);
        in = new StreamTokenizer(br);
        out = new PrintWriter(writer);
    }

    void run() throws IOException {
        long beginTime = System.currentTimeMillis();
        init();
        solve();
        if(!oj){
            long endTime = System.currentTimeMillis();
            if (!oj) {
                System.out.println("Memory used = " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
                System.out.println("Running time = " + (endTime - beginTime));
            }
        }
        out.flush();
    }
    
    void solve() throws IOException {
        int n=nI(), a=nI(), b=nI(), c=nI(), r=0, t;
        for(int i=0; i<=b; i++)
            for(int j=0; j<=c; j++){
                t=2*(n-i-2*j);
                if(t<=a&&t>=0)r++;
            }
        out.println(r);
    }
    
    int min(int x, int y){
        if(x<y)return x; else return y;
    }
    
    int nI() throws IOException {
        in.nextToken();
        return (int) in.nval;
    }

    long nL() throws IOException {
        in.nextToken();
        return (long) in.nval;
    }

    String nS() throws IOException {
        in.nextToken();
        return in.sval;
    }

    double nD() throws IOException {
        in.nextToken();
        return in.nval;
    }
}