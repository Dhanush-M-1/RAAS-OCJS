import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

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
    
    public static void main(String[] args)throws Exception{
        int count = 0;
        long l = 0;
        while(inB.ready()) {
            String s = inB.readLine();
            if(s.charAt(0) == '+') {count++; continue; };
            if(s.charAt(0) == '-') {count--; continue; }
            
            if(s.charAt(s.length() - 1) == ':')continue;
            
            s = s.split(":")[1];
            
            l += s.length()*count;
            
        }
        
        System.out.println(l);
    
    }
}
