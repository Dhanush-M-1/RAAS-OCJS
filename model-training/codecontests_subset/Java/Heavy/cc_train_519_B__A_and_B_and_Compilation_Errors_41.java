
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.StringTokenizer;


public class sol {
	//...................... Global Variables .......................//
	static BitSet prime;             // used in seive generation
	// true = not prime     and false = prime
	int prev_avg = 0;
	int n = 0;
	//...................... Global Variables .......................//
	
	
	
	
	
	//===================  PROBLEM SOLVING COMES HERE ===== START  ====================//
	
    void solve() throws IOException, Exception {
      
    	int n= in.nextInt();
    	int sum1=0;
    	int sum2=0;
    //	ArrayList<Integer> al1 = new ArrayList<Integer>();
    //	ArrayList<Integer> al2 = new ArrayList<Integer>();
    	
    	for(int i =0;i<n;i++){
    		int temp =in.nextInt();
    		sum1+=temp;
    	//	al1.add(temp);
    	//	al2.add(temp);
    	}
    	//al2 = al1;
   // int store =0;
    	
    	for(int i =0;i<n-1;i++){
    		int temp =in.nextInt();
    		sum2+=temp;
    		//if(al2.contains(temp))
    			//al2.remove(Integer.valueOf(temp));
    	}
    	//for(int m:al2){
    	//	store = m;
    	//}
    	
    	//al1.remove(Integer.valueOf(store));
    	  int sum3=0;
    	for(int i =0;i<n-2;i++){
    		int temp =in.nextInt();
    		sum3+=temp;
    		//System.out.println(temp);
    		//if(al1.contains(temp))
    			//al1.remove(Integer.valueOf(temp));
    	}
    	
    //	al2.addAll(al1);
    	
    //	for(int m:al2){
    //		out.println(m);
    //	}

    	out.println(sum1-sum2);
    	out.print(sum2-sum3);
    }
    

    //===================  PROBLEM SOLVING COMES HERE ===== END ======================//
    
    
    
    
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
    	
    	//--------------------------------- Console I/O ------------------------------//
    	   in = new FastScanner(new BufferedReader(new InputStreamReader(System.in)));
           out = new PrintWriter(System.out);
    	//--------------------------------- Console I/O ------------------------------//
    	
    	
    	//--------------------------------- File I/O ---------------------------------//
        //   in = new FastScanner(new BufferedReader(new FileReader("input.txt")));
        //   out = new PrintWriter(new FileWriter("output.txt"));
        //--------------------------------- File I/O ---------------------------------//
        new sol().solve();
        out.close();
    }
    
    
    

		 
		 
    static FastScanner in;
    static PrintWriter out;

    static class FastScanner {
        BufferedReader in;
        StringTokenizer st;

        public FastScanner(BufferedReader in) {
            this.in = in;
        }

        public String nextToken() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(in.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() { return Integer.parseInt(nextToken()); }
        public long nextLong() { return Long.parseLong(nextToken()); }
        public double nextDouble() { return Double.parseDouble(nextToken()); }
        public BigInteger BigInteger()throws Exception { return new BigInteger(nextToken()); }
        public String next() throws IOException { return nextToken(); }
        public String nextLine() throws IOException { return in.readLine(); }
        
        public int[] readIntArray(int n) {
            int[] ret = new int[n];
            for (int i = 0; i < n; i++) {
                ret[i] = nextInt();
            }
            return ret;
        }
        
        public void printIntArray(int ar[],int n) {
            for (int i = 0; i < n; i++) {
                System.out.print(ar[i] +" ");
            }System.out.println();
        }
        
    }
}