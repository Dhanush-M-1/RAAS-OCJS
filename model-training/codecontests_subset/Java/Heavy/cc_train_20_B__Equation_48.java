import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.io.Writer;
import java.util.Locale;

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
        double a=nD(), b=nD(), c=nD(), x1, x2;
        double D = b*b-4*a*c; final double e=1e-6;
        if(a==0){
            if(b==0){
                out.printf("%d\n", c==0?-1:0);
            }else{
                out.printf("1\n%.5f\n", -1.0*c/b);
            }
        }else if(D>e){
            D = Math.sqrt(D); x1 = 0.5*(-b-D)/a; x2 = 0.5*(-b+D)/a;
            out.printf("2\n%.5f\n%.5f\n", Math.min(x1, x2), Math.max(x1, x2));
        }else if(D<-e){
            out.printf("0\n");
        }else{
            out.printf("1\n%.5f\n", 0.5*(-b)/a);
        }
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