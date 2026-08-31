import java.io.*;
import java.util.*;
import java.lang.*;

public class P1 {
    
    static class Solver {
	
		InputReader readerstream; 
		//PrintWriter writerstream; // uncomment this
		PrintStream writerstream;  // comment out this line

		Solver(InputReader r, PrintWriter wr) { 
		    this.readerstream = r;
		    //this.writerstream = wr;   // uncomment this line
		    this.writerstream = System.out; // comment out this line

		}
		/************************************************/
		
		final double eps = 1e-7;			

		double x,y,z;

		public void run() {
		    String[] S = {"x^y^z","x^z^y","(x^y)^z","(x^z)^y",
								"y^x^z","y^z^x","(y^x)^z","(y^z)^x",
		    							"z^x^y","z^y^x","(z^x)^y","(z^y)^x"};


		    x = gd(); y = gd(); z = gd();
		    int pos = 0;

		    Tower[] T = { gett(x,y,z), gett(x,z,y), gett(x,y*z,1), gett(x,z*y,1),
		    				gett(y,x,z), gett(y,z,x), gett(y,x*z,1), gett(y,z*x,1),
		    				gett(z,x,y), gett(z,y,x), gett(z,x*y,1), gett(z,y*x,1) };

		    for (int i = 0; i < 12; i++) {
		    	boolean ok = true;
		    	for	(int j = 0; j < 12; j++) {
		    		if (i == j) continue;
		    		//prn(S[i] + " >= " + S[j] + " "+towerComp(T[i],T[j]));
		    		ok &= (towerComp(T[i],T[j]) >= 1);
		    	}
		    	if (ok) { prn(S[i]); return; }
		    }

		}
		

		Tower gett(double a,double b,double c) { return new Tower(a,b,c); }
		
		boolean eq(double a, double b) { if (Math.abs(a-b) < eps) return true; return false; }

		public int towerComp(Tower A, Tower B) {
			if ((log(A.a) < 0 && log(B.a) >= 0) || (log(A.a) <= 0 && log(B.a) > 0)) return 0;
			if ((log(B.a) < 0 && log(A.a) >= 0) || (log(B.a) <= 0 && log(A.a) > 0)) return 2;
			if (eq(log(A.a),0) && eq(log(A.b),0)) { return 1; }

			if (log(A.a) < 0 && log(B.a) < 0) {
				return 2 - towerComp(new Tower(1/A.a,A.b,A.c), new Tower(1/B.a,B.b,B.c));
			}

			//prn(A.a + " ^ " + A.b + " ^ " + A.c);

			double x = A.c * log(A.b) + log(log(A.a));
			double y = B.c * log(B.b) + log(log(B.a));
			//prn(A.a + " ^ " + A.b + " ^ " + A.c + "; " + x + ", " + y);

			if (eq(x,y)) return 1;
			if (x < y) return 0;
			return 2;
		}
		

		class Tower {
			public double a,b,c; // a^b^c
			Tower(double a, double b, double c) { this.a = a; this.b = b; this.c = c; }
		}

		/***********************************************/
		double log(double x) { return Math.log(x); }
		int gi() { return readerstream.gi(); }
		long gl() { return readerstream.gl(); }
		double gd() { return readerstream.gd(); }
		String gs() { return readerstream.gs(); }
		String gline() { return readerstream.gline(); }
		void endc() { writerstream.println(); }
		void pr(Object x) { writerstream.print(x); }
		void prn(Object x) { writerstream.println(x); }
    }


    static class Pair {
		public int first,second;
		
		Pair(int first,int second) { this.first = first; this.second = second; }
		
		boolean equals(Pair b) {
		    if (this.first == b.first && this.second == b.second) { return true; }
		    return false;
		}
			
    }

    static class InputReader {
		BufferedReader br; StringTokenizer t;

		InputReader(InputStream s) {
		    br = new BufferedReader(new InputStreamReader(s));
		    t = null;
		}

		String next() {
		    while (t == null || !t.hasMoreTokens()) {
			try {
			    t = new StringTokenizer(br.readLine());
			} catch (Exception e) {
			    e.printStackTrace();
			}
		    }
		    return t.nextToken();
		}

	 	int gi() {
		    return Integer.parseInt(next());
		}

		long gl() {
		    return Long.parseLong(next());
		}

		double gd() {
		    return Double.parseDouble(next());
		}

		String gs() {
		    return next();
		}

		String gline() {
		    try { 
				return br.readLine();
		    } catch (Exception e) {
				e.printStackTrace();
			return "";
		    }
		}
    }


    // drivers
    
    public static void main(String[] args) {
		InputReader r = new InputReader(System.in);
		PrintWriter w = new PrintWriter(System.out);
		Solver s = new Solver(r,w);
		s.run();
		w.close();
    }

}
