import java.util.*; 
import java.io.*; 
public class Main {


	public static void main(String[] args) throws IOException {

		BufferedReader  jk =  new BufferedReader(new InputStreamReader( System.in))  ; 
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out)) ; 
		StringTokenizer ana = new StringTokenizer(jk.readLine()) ; 
		
		int t = Integer.parseInt(ana.nextToken()) ; 
	    for(int i=0 ; i<t ;i++)
	    {
	    	ana = new StringTokenizer(jk.readLine()) ; 
	    	long a = Long.parseLong(ana.nextToken()) ; 
	    	long b =Long.parseLong(ana.nextToken())  ;
	    	long te[] = {a,b,(a^b) } ; 
	    	long n =Long.parseLong(ana.nextToken())  ;
	    	int u = (int) (n%3) ; 
	    	out.println(te[u]);
	    	
	    }
		



		out.flush(); 

	}

}
