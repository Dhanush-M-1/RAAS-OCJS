import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;

public class Main {
    private static StreamTokenizer in;
    private static PrintWriter out;
    private static BufferedReader inB;
    
    private static int nextInt() throws Exception{
        in.nextToken();
        return (int)in.nval;
    }
    
    private static String nextString() throws Exception{
        in.nextToken();
        return in.sval;
    }
    
    static{
        inB = new BufferedReader(new InputStreamReader(System.in));
        in = new StreamTokenizer(inB);
        out = new PrintWriter(System.out);
    }
    
    private static ArrayList<Integer>[] mas;
    
    public static void main(String[] args)throws Exception{
        
        long a = nextInt(), b = nextInt(), c = nextInt();
        
        if(a == 0 && b == 0) {
            System.out.println(c==0?-1:0);
            return;
        }
        
        if(a == 0) {
            System.out.println(1);
            System.out.println(-((double)c / (double)b));
            return;
        }
        
        long d = b*b - 4*a*c;
        
        if(d < 0) {
            System.out.println(0);
            return;
        }
        
        if(d == 0) {
            System.out.println(1);
            System.out.println(-((double)b / (double) (a * 2)));
            return;
        }
        double sd = Math.sqrt(((double)d));
        double x1 = (-b + sd) / (2*a);
        double x2 = (-b - sd) / (2*a);
        System.out.println(2);
        System.out.println(Math.min(x1, x2) + "\n" + Math.max(x1, x2));
        
    }
}
