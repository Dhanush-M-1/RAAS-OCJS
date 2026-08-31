import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st = new StringTokenizer("");
    
    void run() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(System.out);
        
        int n = nextInt();
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (j > 1) out.print(' ');
                out.print(Integer.toString(i * j, n));
            }
            out.println();
        }
        
        out.close();
    }
    
    
    /*************************************************************** 
     * Input 
     **************************************************************/
    String nextToken() throws IOException {
        while (!st.hasMoreTokens())
            st = new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    
    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }
}
