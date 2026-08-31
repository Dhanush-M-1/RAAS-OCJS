import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    
	public static void main( String[] args ) throws FileNotFoundException {
    	new CodeForces_5A().doit();
    }
}
class CodeForces_5A {
	InputReader ir;
	PrintStream ps;
	public void doit() throws FileNotFoundException {
		//ir = new InputReader( new FileInputStream("in") );
		//Scan sn = new Scan( System.in );
		//Scan sn = new Scan( new FileInputStream("1006.in") );
		Scanner sc = new Scanner( System.in );
		ps = System.out;
		//ps = new PrintStream(new FileOutputStream(new File("test")));
		int num = 0, ans = 0;
		while ( sc.hasNext() ) {
			String cmd = sc.nextLine();
			if ( cmd.startsWith("+") ) {
				num++;
			} else if ( cmd.startsWith("-") ) {
				num--;
			} else {
				ans += num * cmd.substring( cmd.indexOf(':')+1 ).length();
			}
		}
		ps.println( ans );
	}
}
class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}
	public boolean hasNext() {
		if (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (Exception e) {
				return false;
			}
		}
		return tokenizer.hasMoreTokens();
	}
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
	public int nextInt() {
		return Integer.parseInt(next());
	}
	public long nextLong() {
		return Long.parseLong( next() );
	}
	public double nextDouble() {
		return Double.parseDouble( next() );
	}
}
class Scan {
	InputStream inp;
	public Scan(InputStream in) {
		inp = in;
	}
	public String next() {
		StringBuffer res = new StringBuffer();
		try {
			int t = inp.read();
			while ( (t < 'a' || t > 'z') && (t < 'A' || t > 'Z') && ( t < '1' || t < '9') ) t = inp.read();
			while ( ('a' <= t && t <= 'z') || ('A' <= t && t <= 'Z') || ('1' <= t && t <= '9') ) {
				res.append( ((char)t) );
				t = inp.read();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res.toString();
	}
	public int nextInt() {
		boolean isN = false;
		int res = 0;
		int t;
		try {
			t = inp.read();
			if (t == -1) return -1;
			while (t != -1 && t != '-' && (t > '9' || t < '0')) t = inp.read();
			if ( t == '-' ) {
				isN = true;
				t = inp.read();
			}
			while (t != -1 && t >= '0' && t <= '9') {
				res = res * 10 + (t - '0');
				t = inp.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ( isN ) res = -res;
		return res;
	}
	public double nextDouble() {
		double res = 0, Dec = 0.1;
		boolean isN = false, isD = false;
    	int t;
    	try {
    		t = inp.read();
			if ( t == -1 ) return -1;
			while ( t != '-' && t != '.' && (t < '0' || t > '9') ) t = inp.read();
			if ( t == '-' ) {
				isN = true;
				res = 0;
			} else if ( t == '.' ) {
				isD = true;
				res = 0;
			} else res = (double) t - '0';
			if ( !isD ) {
				t = inp.read();
				while ( t >= '0' && t <= '9' ) {
					res = res * 10 + (t - '0');
					t = inp.read();
				}
			}
			if ( t != '.' ) {
				if ( isN ) res = -res;
				return res;
			} else {
				t = inp.read();
				while ( t >= '0' && t <= '9' ) {
					res += Dec * (t - '0');
					Dec *= 0.1;
					t= inp.read();
				}
			}
			if ( isN ) res = -res;
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return res;
    }
}