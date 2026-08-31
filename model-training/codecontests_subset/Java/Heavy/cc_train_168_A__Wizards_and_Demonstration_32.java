import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static class Parser {
        private StringTokenizer tokenizer;
        public Parser(String input) { tokenizer = new StringTokenizer(input);}
        public boolean hasNext() { return tokenizer.hasMoreTokens(); }
        public String nextString() { return tokenizer.nextToken(); }
        public int nextInteger() { return Integer.parseInt(nextString()); }
        public double nextDouble() { return Double.parseDouble(nextString()); }
    }
	
	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    Parser p = new Parser(in.readLine());
	    
	    int n = p.nextInteger();
	    int x = p.nextInteger();
	    int y = p.nextInteger();
	    
	    int r = ((int)Math.ceil(n * y / 100.0d)) - x;
	    r = r < 0 ? 0 : r;
	    System.out.println(r);
	    
//	    Integer n = p.nextInteger();
//	    Integer a = p.nextInteger();
//	    Integer d = p.nextInteger();
//	    
//	    int t[] = new int[n];
//	    int v[] = new int[n];
//	    
//	    for (int i = 0; i < n; i++) {
//	        p = new Parser(in.readLine());
//	        t[i] = p.nextInteger();
//	        v[i] = p.nextInteger();
//	    }
//	    
//	    double r[] = new double[n];
//        
//        r[0] = getT(v[0], a, d) + t[0];
//        
//        for (int i = 1; i < n; i++) {
//            r[i] = getT(v[i], a, d) + t[i];
//            if (r[i] < r[i - 1]) r[i] = r[i-1];
//        }
//        
//        for (int i = 0; i < n; i++) {
//            System.out.println(r[i]);
//        }
	}
	
	private static double getT(double vmax, double a, double d) {
	   double t1 = vmax / a;
	   double s = a * t1*t1/2;
	   
	   if (s > d) {
	       return Math.sqrt(2 * d / a);
	   } else {
	       return t1 + (d - s)/vmax;
	   }
	}
	
	
}
