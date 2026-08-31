import java.util.Map;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
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
		TaskB solver = new TaskB();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskB {
    int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    boolean validText(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if ( i==2 || i==5 )
            {
                if ( s.charAt(i) != '-' ) return false;
            }
            else
            {
                if ( Character.isDigit( s.charAt(i) ) == false ) return false;
            }
        }
        StringTokenizer st = new StringTokenizer(s, "-");
        int d = Integer.parseInt( st.nextToken() );
        int m = Integer.parseInt( st.nextToken() );
        int y = Integer.parseInt( st.nextToken() );
        return y >= 2013 && y <= 2015 && m >= 1 && m <= 12 && d >= 1 && d <= days[ m-1 ];
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String str = in.next();
        HashMap< String, Integer > mp = new HashMap<String, Integer>();
        for (int i=0; i<=str.length()-10; i++)
        {
            String s = str.substring( i, i+10 );
            if ( validText(s) )
            {
                if ( mp.containsKey( s ) ) mp.put( s, mp.get(s)+1 );
                else mp.put( s, 1 );
            }
        }

        String ans = "";
        int count = 0;
        for (Map.Entry<String, Integer> e : mp.entrySet())
        {
            if ( e.getValue() > count )
            {
                ans = e.getKey();
                count = e.getValue();
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

    public String next()
    {
        while (st==null || !st.hasMoreTokens())
        {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return st.nextToken();
    }

    }
