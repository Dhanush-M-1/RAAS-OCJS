import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A implements Runnable {
    static final int MAX_S = 1000*1000 + 10;
    private void solve () throws IOException {
	int n = nextInt (); int x = nextInt (); int y = nextInt ();
	int ans = 0;
	for (int i = 0; i < MAX_S; i++) {
	    if (100 * (x + i) >= (y * n)) {
		ans = i; break;
	    }
	}
	writer.println (ans);
    }
    public static void main (String[] args) {
	new A ().run ();
    }
    BufferedReader reader;
    PrintWriter writer;
    StringTokenizer tokenizer;
    public void run () {
	try {
	    reader = new BufferedReader (new InputStreamReader (System.in));
	    writer = new PrintWriter (System.out);
	    tokenizer = null;
	    solve ();
	    reader.close ();
	    writer.close ();
	} catch (Exception e) {
	    e.printStackTrace ();
	    System.exit (1);
	}
    }
    public int nextInt () throws IOException {
	return Integer.parseInt (nextToken ());
    }
    public String nextToken () throws IOException {
	while (tokenizer == null || !tokenizer.hasMoreTokens ()) {
	    tokenizer = new StringTokenizer (reader.readLine ());
	}
	return tokenizer.nextToken ();
    }
}
