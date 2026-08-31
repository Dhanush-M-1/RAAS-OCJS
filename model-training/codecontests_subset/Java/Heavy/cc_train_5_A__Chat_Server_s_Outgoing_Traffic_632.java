
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Built using CHelper plug-in 
 * Actual solution is at the top
 * @author bolbol
 */
public class P_A5 {
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
    // static fields
    
    // solve
    // ********************
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        // START    Solution...

        ArrayList<String> inChat = new ArrayList<String>(0);
        
        int traffic = 0;
        String line = "";
        while (true) {          
            
            line = in.nextLine();
            
            if (line == null || line.length() == 0) {
                break;
            }
            if (line.startsWith("+")) {
                String name = line.substring(1);
                inChat.add(name);
                
            }else if (line.startsWith("-")){
                String name = line.substring(1);
                inChat.remove(name);
            }else {
                int indexOfDot = line.indexOf(":");
                String message = line.substring(indexOfDot+1,line.length());
                int lenghtOfMessage = message.length();
                traffic = traffic + (lenghtOfMessage*inChat.size());
                
            }
            
            
        }
        
        System.out.println(traffic);
        
        
        
        // END      Solution...
    }
    // ********************

    // ----------------
    // Methods
    // ----------------
    
    // ----------------

}

// I/O class
// Separators : ' ', '\r', '\n'
// ++++++++++++++++++++++++++++++++++++++++
class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    // nextToken
    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
    
    // nextLine
    public String nextLine() {
        String line = null;     
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }       
        return line;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }
    
    public long nextLong() {
        return Long.parseLong(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }   

}
// ++++++++++++++++++++++++++++++++++++++++