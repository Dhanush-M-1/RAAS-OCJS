import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;



public class D2 {
	public static void main(String args[]){
		FastScanner in = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int n = in.nextInt();
		int d = in.nextInt();
		int mon = 0; int bank = 0; int extra = 0;
		for(int c = 0; c < n; c++){
			int i = in.nextInt();
			
			if(i != 0){
				mon += i;	//Process transaction
				if(mon > d){	//If we are over the limit
					int over = mon-d;	
					if(over > extra){	//If we are too much over break out with -1
						bank = -1;
						break;
					}
					else{	//If we have extra then reduce
						extra -= over;
						mon = d;
					}
				}
			}
			else{	//If we need to check our money
				if(mon < 0){
					bank++;
					extra = d;
					mon = d;
				}
				else
					extra = Math.min(extra, mon);
			}
	
		}
		System.out.println(bank);
	
	}
	
	
	
	
	

	static class FastScanner{
		BufferedReader br;
		StringTokenizer st;
		public FastScanner(String s) {
			try{
				br = new BufferedReader(new FileReader(s));
			}
			catch(FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		public FastScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nextToken()	{
			while(st == null ||!st.hasMoreElements()){
				try {
				st = new StringTokenizer(br.readLine());}
				catch(IOException e) {
					e.printStackTrace();
				}			
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(nextToken());
		}
		long nextLong() {
			return Long.parseLong(nextToken());
		}
		double nextDouble() {
			return Double.parseDouble(nextToken());
		}
		String next() {
			return nextToken();
		}
		
	}

}
