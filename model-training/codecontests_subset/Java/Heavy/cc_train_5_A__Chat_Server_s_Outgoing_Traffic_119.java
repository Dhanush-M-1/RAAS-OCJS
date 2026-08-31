import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author c0der
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
    HashSet< String > db = new HashSet<String>();
    public void solve(int testNumber, InputReader in, PrintWriter out){
        int ans = 0;
        while ( true )
        {
            String s = in.nextLine();
            if ( s == null ) break;
            if ( s.charAt(0) == '+' )
            {
                db.add( s.substring(1) );
            }
            else if ( s.charAt(0) == '-' )
            {
                db.remove( s.substring(1) );
            }
            else
            {
                for (int i=0; i<s.length(); i++)
                {
                    if ( s.charAt(i) == ':' )
                    {
                        //out.println( s.substring(i+1) );
                        ans += db.size() * ( s.length() - (i+1) );
                        break;
                    }
                }
            }
        }
        out.println( ans );
    }
}

class InputReader {
    BufferedReader br;
    StringTokenizer st;

    public InputReader(InputStream in)
    {
        br = new BufferedReader(new InputStreamReader(in));
        st = null;
    }

    public String nextLine()
    {
        String ret = "";
        try{
            ret = br.readLine();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return ret;
    }

    }
