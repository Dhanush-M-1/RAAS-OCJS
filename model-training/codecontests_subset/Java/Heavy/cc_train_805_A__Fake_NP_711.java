import java.io.*;
import java.util.*;
import java.lang.Math;
import java.math.BigInteger;

public class Problem {

	public static void main(String[] args) throws IOException {

		new Problem().run();
	}

	BufferedReader in;
	PrintWriter out;
	StringTokenizer tok;
	static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
	Problem() throws FileNotFoundException{

		if (ONLINE_JUDGE) {
			in = new BufferedReader(new InputStreamReader(System.in)); 
            out = new PrintWriter(System.out); 
		} else {
			in = new BufferedReader(new FileReader("input.txt"));
			out = new PrintWriter("output.txt");
		}
		tok = new StringTokenizer("");
	}

	// ======================================================

	int INF = Integer.MAX_VALUE;
	List<Integer>[] graph;
	boolean[] used;
	long[] time;
	int[] def;
	long ans;
	void solve() throws IOException {
		int l = rI();
		int r = rI();
		if(l==r){
			out.println(l);
		}else{
			out.println(2);
		}
	}

	// ======================================================
	void run() throws IOException {
		solve();
		out.close();
	}


	int sqrt(double m){
		int l = 0;
		int r = 1000000000+9;
		int i=1000;
		while(r-l>1){
			int mid = (r+l)/2;
			if(mid*mid>m){
				r = mid;
			}else{
				l = mid;
			}
		}
		return l;
	}
	int countPow(int m,int n){
		int ans = 0;
		while(m%n==0&&m>0){
			ans++;
			m/=n;
		}
		return ans;
	}
	long binPow(long a, long b){
		if(b == 0){
			return 1;
		}
		if(b%2==1){
			return a*binPow(a,b-1);
		}else{
			long c = binPow(a,b/2);
			return c*c;
		}
		
	}
	long gcd(long a, long b){
		return b==0?a:gcd(b,a%b);
	}
	
	long pow(long x, long k){
		long ans=1;
		for(int i=0;i<k;++i){
			ans*=x;
		}
		return ans;
	}
	//////////////////////////////////////////////////////////////////////


	String delimiter = " ";
	String readLine() throws IOException {
		return in.readLine();
	}
	String rS() throws IOException {
		while (!tok.hasMoreTokens()) {
			String nextLine = readLine();
			if (null == nextLine)
				return null;

			tok = new StringTokenizer(nextLine);
		}

		return tok.nextToken(delimiter);
	}
	int rI() throws IOException {
		return Integer.parseInt(rS());
	}

	long rL() throws IOException {
		return Long.parseLong(rS());
	}
	int[] rA(int b) {
		int a[] = new int[b];
		for (int i = 0; i < b; i++) {
			try {
				a[i] = rI();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return a;
	}
	
	int[] readSortedIntArray(int size) throws IOException {
	        Integer[] array = new Integer[size];

	        for (int index = 0; index < size; ++index) {
	            array[index] = rI();
	        }
	        Arrays.sort(array);

	        int[] sortedArray = new int[size];
	        for (int index = 0; index < size; ++index) {
	            sortedArray[index] = array[index];
	        }

	        return sortedArray;
	    }

}