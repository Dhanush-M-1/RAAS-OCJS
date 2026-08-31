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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    
	public static void main( String[] args ) throws FileNotFoundException {
    	new CodeForces_39H().doit();
    }
}
class CodeForces_39H {
	InputReader ir;
	Scanner sc;
	PrintStream ps;
	public void doit() throws FileNotFoundException {
		ir = new InputReader( System.in );
		//Scan sn = new Scan( System.in );
		//Scan sn = new Scan( new FileInputStream("1006.in") );
		//sc = new Scanner( System.in );
		ps = System.out;
		//ps = new PrintStream(new FileOutputStream(new File("test")));
		int n = ir.nextInt();
		for ( int i = 1; i < n; i++ ) {
			ps.print( i );
			for ( int j = 2; j < n; j++ ) {
				ps.printf( "%3d", Integer.parseInt( Integer.toString( i*j, n) ) );
			}
			ps.println();
		}
	}
}
class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;
	
	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
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