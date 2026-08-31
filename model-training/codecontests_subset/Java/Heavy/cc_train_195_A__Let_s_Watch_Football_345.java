import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;


public class A {
    
    public static void main(String[] args) throws Exception {
        int a = nextInt(), b = nextInt(), c = nextInt();
        
        if(b >= a)
            exit(0);
        
        int need = a*c;
        int take = (need+b-1)/b;
        
        int m = Math.max(take - c, 0);
        println(m);
    }
    
    /////////////////////////////////////////////////////////////////
    // IO
    /////////////////////////////////////////////////////////////////
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static BufferedReader inB;
    
    private static boolean FILE=false;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        try {
            out = new PrintWriter(FILE ? (new FileOutputStream("output.txt")) : System.out);
            inB = new BufferedReader(new InputStreamReader(FILE ? new FileInputStream("input.txt") : System.in));
        } catch(Exception e) {e.printStackTrace();}
        in = new StreamTokenizer(inB);
    }
    /////////////////////////////////////////////////////////////////
    
    /////////////////////////////////////////////////////////////////
    // pre - written
    /////////////////////////////////////////////////////////////////
    private static void println(Object o) throws Exception {
        out.println(o);
        out.flush();
    }
    private static void exit(Object o) throws Exception {
        println(o);
        exit();
    }
    private static void exit() {
        System.exit(0);
    }
    private static final int  INF = Integer.MAX_VALUE;
    private static final int MINF = Integer.MIN_VALUE;
    //////////////////////////////////////////////////////////////////
}
