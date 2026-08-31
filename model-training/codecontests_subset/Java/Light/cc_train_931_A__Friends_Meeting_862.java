import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class apples{
	public static void main (String[] args) throws IOException  {
		Scanner sc=new Scanner(System.in);
		
		 int x=sc.nextInt();
		 int y=sc.nextInt();
		 int diff=Math.abs(y-x);
		 int rem=diff/2;
		 int i=0;
		 int z=0;
		 int total=0;
		 while (rem<(diff)){
			 z++;
			 total=total+z;
					 
					 diff--;
		 }
		 while(diff!=0) {
			 i++;
			 total=total+i;
			 diff--;
		 }
		 System.out.println(total);
	
		
		
		 }
		 

	
	
			
	
		
	
    
	static class Scanner {
		StringTokenizer st;BufferedReader br;
		public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}
		public String next() throws IOException 
		{while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());return st.nextToken();}
		public long nextLong() throws IOException {return Long.parseLong(next());}
		public int nextInt() throws IOException {return Integer.parseInt(next());}
		public String nextLine() throws IOException {return br.readLine();}
		public double nextDouble() throws IOException {return Double.parseDouble(next());}
		public boolean ready() throws IOException {return br.ready();}
	}
		
}
		
	
	
	
			
				
				

				
		
			
	
		



			
			
			
		
		
		
				
	
	
	
	
	
	
	
	

			
	