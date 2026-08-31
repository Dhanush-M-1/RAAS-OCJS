import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Andrew Shmig aka SyFyKid
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		TaskA solver = new TaskA();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskA {
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.RI(), b = in.RI(), c = in.RI();
        
        for(int i=1;; i++){
            if(ok(a, b, c, i)){
                out.println(i);
                break;
            }
        }
	}
    
    boolean ok(int a, int b, int c, int waitTime){
        int curYoutube = 0, curMe = waitTime*b;
                
        for(;;){            
            curYoutube+=a;
            curMe+=b;
            
            if(curMe>=c*a || curYoutube>=c*a) break;
        }
        
        return curYoutube<=curMe;
    }
}

class InputReader {      
    private BufferedReader reader;
    private StringTokenizer tokenizer;
        
    public InputReader(InputStream stream)
    {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }
    
    public String next()
    {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    
    public int RI()
    {
        return Integer.parseInt(next());
    }
    
    }

