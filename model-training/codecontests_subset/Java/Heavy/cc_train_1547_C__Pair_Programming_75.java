import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.PrintWriter;
// import java.util.HashMap;
// import java.util.Arrays;
import java.util.ArrayList;
 
public class test {
	public static void  main(String[] args) throws IOException {
	//	 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		FastReader in = new FastReader();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.ni();
		while (t-- > 0 )
		{   int k = in.ni(), n = in.ni(), m = in.ni();
	        boolean result = true;
			StringBuilder s = new StringBuilder();
		int[] arr = new int[n+m];
		for ( int i = 0; i < n+m; i++ ) arr[i] = in.ni();
		int a = 0, b = n;
		int curr = a;
	    for ( ; a < n || b < m+n ; )
		{ while ( a < n && arr[a] <= k ) 
			{   if ( arr[a] == 0 ) k++;
     		s.append(arr[a] + " "); a++;
			}
			while ( b < (n+m) && arr[b] <= k ) 
			{  if ( arr[b] == 0 ) k++;
			 s.append(arr[b] + " "); b++;
			}
		   if (!(a < n && arr[a] <= k ) ) { if ( a >= n && b >= (n+m) ) continue;
		                                           else {result = false; break;} }
		}
		if ( result ) out.println(s.toString());
		else out.println(-1);
		}
		out.flush();
	}
		
	
	static ArrayList<Integer> factors(int n)
	 { ArrayList<Integer> list = new ArrayList<Integer>();
	  list.add(n);
	  if ( n != 1) list.add(1);
	   int sq = (int)Math.sqrt(n);
	   if ( n%sq == 0 && sq != 1 ) list.add(sq);
	  for ( int i = 2; i < sq; i++ )
	      if ( n%i == 0){ list.add(i); list.add(n/i); }
	  return list;
	 }
	
	static class Pair implements Comparable<Pair>{
		int a, b;
		
	public Pair(int a, int b ){
	this.a = a; this.b = b; }
	
	public int compareTo(Pair p){
		if (this.a > p.a ) return 2;
		else if (this.a < p.a) return -2;
		else return 0;
	}
}
		
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader()
        {
			br = new BufferedReader( new InputStreamReader(System.in));
        }
     
       public String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int ni(){ return Integer.parseInt(next()); }
 
        long nl() { return Long.parseLong(next()); }
 
        double nd() {  return Double.parseDouble(next());  }
 
       public  String readLine()
        {                                                          // readLine method skips to next line
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}