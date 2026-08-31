
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class CF168A {
    
    private StreamTokenizer in;
    private PrintWriter out;
    
    public static void main (String[] args) throws IOException {
        new CF168A().soilve();
    }
    
    int nextInt () throws IOException {
        in.nextToken();
        return (int)in.nval;
    }
    
    void soilve () throws IOException {
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        out = new PrintWriter(new OutputStreamWriter(System.out));
        
        int n = nextInt();
        int x = nextInt();
        int y = nextInt();
        
        int mult = (n * y);
        out.print( Math.max(0, mult / 100 + (mult % 100 != 0 ? 1 : 0) - x));
        
        out.flush();        
    }

}
